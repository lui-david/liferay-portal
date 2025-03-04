/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.fragment.web.internal.display.context;

import com.liferay.fragment.constants.FragmentActionKeys;
import com.liferay.fragment.constants.FragmentEntryTypeConstants;
import com.liferay.fragment.constants.FragmentPortletKeys;
import com.liferay.fragment.model.FragmentCollection;
import com.liferay.fragment.model.FragmentEntry;
import com.liferay.fragment.processor.FragmentEntryProcessorRegistry;
import com.liferay.fragment.service.FragmentCollectionLocalServiceUtil;
import com.liferay.fragment.service.FragmentEntryLocalServiceUtil;
import com.liferay.fragment.service.FragmentEntryServiceUtil;
import com.liferay.fragment.web.internal.configuration.FragmentPortletConfiguration;
import com.liferay.fragment.web.internal.constants.FragmentWebKeys;
import com.liferay.fragment.web.internal.security.permission.resource.FragmentPermission;
import com.liferay.fragment.web.internal.util.SoyContextFactoryUtil;
import com.liferay.fragment.web.util.FragmentPortletUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemList;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.upload.criterion.UploadItemSelectorCriterion;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadServletRequestConfigurationHelperUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.template.soy.utils.SoyContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class FragmentDisplayContext {

	public FragmentDisplayContext(
		RenderRequest renderRequest, RenderResponse renderResponse,
		HttpServletRequest request) {

		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_request = request;

		_fragmentEntryProcessorRegistry =
			(FragmentEntryProcessorRegistry)_request.getAttribute(
				FragmentWebKeys.FRAGMENT_ENTRY_PROCESSOR_REGISTRY);
		_fragmentPortletConfiguration =
			(FragmentPortletConfiguration)_request.getAttribute(
				FragmentPortletConfiguration.class.getName());
		_itemSelector = (ItemSelector)_request.getAttribute(
			FragmentWebKeys.ITEM_SELECTOR);
		_resolvedModuleName = (String)_request.getAttribute(
			FragmentWebKeys.RESOLVED_MODULE_NAME);
		_themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public List<DropdownItem> getActionDropdownItems() {
		return new DropdownItemList() {
			{
				add(
					dropdownItem -> {
						dropdownItem.setHref(
							_renderResponse.createRenderURL(),
							"mvcRenderCommandName",
							"/fragment/edit_fragment_collection", "redirect",
							_themeDisplay.getURLCurrent());
						dropdownItem.setLabel(
							LanguageUtil.get(_request, "collection"));
					});

				add(
					dropdownItem -> {
						dropdownItem.putData("action", "openImportView");
						dropdownItem.setLabel(
							LanguageUtil.get(_request, "import"));
					});
			}
		};
	}

	public List<DropdownItem> getCollectionsDropdownItems() {
		return new DropdownItemList() {
			{
				add(
					dropdownItem -> {
						dropdownItem.putData("action", "exportCollections");
						dropdownItem.setLabel(
							LanguageUtil.get(_request, "export"));
					});

				if (FragmentPermission.contains(
						_themeDisplay.getPermissionChecker(),
						_themeDisplay.getScopeGroupId(),
						FragmentActionKeys.MANAGE_FRAGMENT_ENTRIES)) {

					add(
						dropdownItem -> {
							dropdownItem.putData("action", "openImportView");
							dropdownItem.setLabel(
								LanguageUtil.get(_request, "import"));
						});

					add(
						dropdownItem -> {
							dropdownItem.putData("action", "deleteCollections");
							dropdownItem.setLabel(
								LanguageUtil.get(_request, "delete"));
						});
				}
			}
		};
	}

	public String getCssContent() {
		if (Validator.isNotNull(_cssContent)) {
			return _cssContent;
		}

		_cssContent = ParamUtil.getString(_request, "cssContent");

		FragmentEntry fragmentEntry = getFragmentEntry();

		if ((fragmentEntry != null) && Validator.isNull(_cssContent)) {
			_cssContent = fragmentEntry.getCss();

			if (Validator.isNull(_cssContent)) {
				StringBundler sb = new StringBundler(3);

				sb.append(".fragment_");
				sb.append(fragmentEntry.getFragmentEntryId());
				sb.append(" {\n}");

				_cssContent = sb.toString();
			}
		}

		return _cssContent;
	}

	public FragmentCollection getFragmentCollection() {
		if (_fragmentCollection != null) {
			return _fragmentCollection;
		}

		_fragmentCollection =
			FragmentCollectionLocalServiceUtil.fetchFragmentCollection(
				getFragmentCollectionId());

		return _fragmentCollection;
	}

	public long getFragmentCollectionId() {
		if (Validator.isNotNull(_fragmentCollectionId)) {
			return _fragmentCollectionId;
		}

		long defaultFragmentCollectionId = 0;

		List<FragmentCollection> fragmentCollections =
			FragmentCollectionLocalServiceUtil.getFragmentCollections(
				_themeDisplay.getScopeGroupId(), 0, 1);

		if (ListUtil.isNotEmpty(fragmentCollections)) {
			FragmentCollection fragmentCollection = fragmentCollections.get(0);

			defaultFragmentCollectionId =
				fragmentCollection.getFragmentCollectionId();
		}

		_fragmentCollectionId = ParamUtil.getLong(
			_request, "fragmentCollectionId", defaultFragmentCollectionId);

		return _fragmentCollectionId;
	}

	public SoyContext getFragmentEditorDisplayContext() throws Exception {
		SoyContext soyContext = SoyContextFactoryUtil.createSoyContext();

		SoyContext allowedStatusSoyContext =
			SoyContextFactoryUtil.createSoyContext();

		allowedStatusSoyContext.put(
			"approved", String.valueOf(WorkflowConstants.STATUS_APPROVED));
		allowedStatusSoyContext.put(
			"draft", String.valueOf(WorkflowConstants.STATUS_DRAFT));

		soyContext.put("allowedStatus", allowedStatusSoyContext);

		soyContext.put(
			"autocompleteTags",
			_fragmentEntryProcessorRegistry.getAvailableTagsJSONArray());
		soyContext.put("fragmentCollectionId", getFragmentCollectionId());
		soyContext.put("fragmentEntryId", getFragmentEntryId());
		soyContext.put("initialCSS", getCssContent());
		soyContext.put("initialHTML", getHtmlContent());
		soyContext.put("initialJS", getJsContent());
		soyContext.put("name", getName());
		soyContext.put("portletNamespace", _renderResponse.getNamespace());
		soyContext.put(
			"spritemap",
			_themeDisplay.getPathThemeImages() + "/lexicon/icons.svg");

		FragmentEntry fragmentEntry = getFragmentEntry();

		soyContext.put("status", String.valueOf(fragmentEntry.getStatus()));

		SoyContext urlsSoycontext = SoyContextFactoryUtil.createSoyContext();

		urlsSoycontext.put("current", _themeDisplay.getURLCurrent());

		PortletURL editActionURL = _renderResponse.createActionURL();

		editActionURL.setParameter(
			ActionRequest.ACTION_NAME, "/fragment/edit_fragment_entry");

		urlsSoycontext.put("edit", editActionURL.toString());

		urlsSoycontext.put(
			"preview",
			_getFragmentEntryRenderURL(
				fragmentEntry, "/fragment/preview_fragment_entry",
				LiferayWindowState.POP_UP));
		urlsSoycontext.put("redirect", getRedirect());
		urlsSoycontext.put(
			"render",
			_getFragmentEntryRenderURL(
				fragmentEntry, "/fragment/render_fragment_entry",
				LiferayWindowState.POP_UP));

		soyContext.put("urls", urlsSoycontext);

		return soyContext;
	}

	public SearchContainer getFragmentEntriesSearchContainer() {
		if (_fragmentEntriesSearchContainer != null) {
			return _fragmentEntriesSearchContainer;
		}

		SearchContainer fragmentEntriesSearchContainer = new SearchContainer(
			_renderRequest, _getPortletURL(), null, "there-are-no-fragments");

		fragmentEntriesSearchContainer.setId("fragmentEntries");

		fragmentEntriesSearchContainer.setRowChecker(
			new EmptyOnClickRowChecker(_renderResponse));

		OrderByComparator<FragmentEntry> orderByComparator =
			FragmentPortletUtil.getFragmentEntryOrderByComparator(
				_getOrderByCol(), getOrderByType());

		fragmentEntriesSearchContainer.setOrderByCol(_getOrderByCol());
		fragmentEntriesSearchContainer.setOrderByComparator(orderByComparator);
		fragmentEntriesSearchContainer.setOrderByType(getOrderByType());

		List<FragmentEntry> fragmentEntries = null;
		int fragmentEntriesCount = 0;

		if (isNavigationElements() || isNavigationSections()) {
			int type = FragmentEntryTypeConstants.TYPE_SECTION;

			if (isNavigationElements()) {
				type = FragmentEntryTypeConstants.TYPE_ELEMENT;
			}

			fragmentEntries = FragmentEntryServiceUtil.getFragmentEntriesByType(
				_themeDisplay.getScopeGroupId(), getFragmentCollectionId(),
				type, fragmentEntriesSearchContainer.getStart(),
				fragmentEntriesSearchContainer.getEnd(), orderByComparator);

			fragmentEntriesCount =
				FragmentEntryServiceUtil.getFragmentCollectionsCountByType(
					_themeDisplay.getScopeGroupId(), getFragmentCollectionId(),
					type);
		}
		else if (isSearch()) {
			fragmentEntries = FragmentEntryServiceUtil.getFragmentEntries(
				_themeDisplay.getScopeGroupId(), getFragmentCollectionId(),
				_getKeywords(), fragmentEntriesSearchContainer.getStart(),
				fragmentEntriesSearchContainer.getEnd(), orderByComparator);

			fragmentEntriesCount =
				FragmentEntryServiceUtil.getFragmentCollectionsCount(
					_themeDisplay.getScopeGroupId(), getFragmentCollectionId(),
					_getKeywords());
		}
		else {
			fragmentEntries = FragmentEntryServiceUtil.getFragmentEntries(
				_themeDisplay.getScopeGroupId(), getFragmentCollectionId(),
				fragmentEntriesSearchContainer.getStart(),
				fragmentEntriesSearchContainer.getEnd(), orderByComparator);

			fragmentEntriesCount =
				FragmentEntryServiceUtil.getFragmentCollectionsCount(
					_themeDisplay.getScopeGroupId(), getFragmentCollectionId());
		}

		fragmentEntriesSearchContainer.setResults(fragmentEntries);
		fragmentEntriesSearchContainer.setTotal(fragmentEntriesCount);

		_fragmentEntriesSearchContainer = fragmentEntriesSearchContainer;

		return _fragmentEntriesSearchContainer;
	}

	public FragmentEntry getFragmentEntry() {
		if (_fragmentEntry != null) {
			return _fragmentEntry;
		}

		_fragmentEntry = FragmentEntryLocalServiceUtil.fetchFragmentEntry(
			getFragmentEntryId());

		return _fragmentEntry;
	}

	public long getFragmentEntryId() {
		if (Validator.isNotNull(_fragmentEntryId)) {
			return _fragmentEntryId;
		}

		_fragmentEntryId = ParamUtil.getLong(_request, "fragmentEntryId");

		return _fragmentEntryId;
	}

	public String getFragmentEntryTitle() {
		FragmentEntry fragmentEntry = getFragmentEntry();

		if (fragmentEntry == null) {
			return LanguageUtil.get(_request, "add-fragment");
		}

		return fragmentEntry.getName();
	}

	public String getHtmlContent() {
		if (Validator.isNotNull(_htmlContent)) {
			return _htmlContent;
		}

		_htmlContent = ParamUtil.getString(_request, "htmlContent");

		FragmentEntry fragmentEntry = getFragmentEntry();

		if ((fragmentEntry != null) && Validator.isNull(_htmlContent)) {
			_htmlContent = fragmentEntry.getHtml();

			if (Validator.isNull(_htmlContent)) {
				StringBundler sb = new StringBundler(3);

				sb.append("<div class=\"fragment_");
				sb.append(fragmentEntry.getFragmentEntryId());
				sb.append("\">\n</div>");

				_htmlContent = sb.toString();
			}
		}

		return _htmlContent;
	}

	public PortletURL getItemSelectorURL() {
		PortletURL uploadURL = _renderResponse.createActionURL();

		uploadURL.setParameter(
			ActionRequest.ACTION_NAME,
			"/fragment/upload_fragment_entry_preview");

		ItemSelectorCriterion uploadItemSelectorCriterion =
			new UploadItemSelectorCriterion(
				FragmentPortletKeys.FRAGMENT, uploadURL.toString(),
				LanguageUtil.get(_themeDisplay.getLocale(), "fragments"),
				UploadServletRequestConfigurationHelperUtil.getMaxSize(),
				_fragmentPortletConfiguration.thumbnailExtensions());

		List<ItemSelectorReturnType> uploadDesiredItemSelectorReturnTypes =
			new ArrayList<>();

		uploadDesiredItemSelectorReturnTypes.add(
			new FileEntryItemSelectorReturnType());

		uploadItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
			uploadDesiredItemSelectorReturnTypes);

		return _itemSelector.getItemSelectorURL(
			RequestBackedPortletURLFactoryUtil.create(_request),
			_renderResponse.getNamespace() + "changePreview",
			uploadItemSelectorCriterion);
	}

	public String getJsContent() {
		if (Validator.isNotNull(_jsContent)) {
			return _jsContent;
		}

		_jsContent = ParamUtil.getString(_request, "jsContent");

		FragmentEntry fragmentEntry = getFragmentEntry();

		if ((fragmentEntry != null) && Validator.isNull(_jsContent)) {
			_jsContent = fragmentEntry.getJs();
		}

		return _jsContent;
	}

	public String getModuleName() {
		return _resolvedModuleName;
	}

	public String getName() {
		if (Validator.isNotNull(_name)) {
			return _name;
		}

		_name = ParamUtil.getString(_request, "name");

		FragmentEntry fragmentEntry = getFragmentEntry();

		if ((fragmentEntry != null) && Validator.isNull(_name)) {
			_name = fragmentEntry.getName();
		}

		return _name;
	}

	public String getNavigation() {
		if (_navigation != null) {
			return _navigation;
		}

		_navigation = ParamUtil.getString(_request, "navigation", "all");

		return _navigation;
	}

	public List<NavigationItem> getNavigationItems() {
		return new NavigationItemList() {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(
							Objects.equals(_getTabs1(), "entries"));
						navigationItem.setHref(
							_getPortletURL(), "tabs1", "entries");
						navigationItem.setLabel(
							LanguageUtil.get(_request, "entries"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(
							Objects.equals(_getTabs1(), "resources"));
						navigationItem.setHref(
							_getPortletURL(), "tabs1", "resources");
						navigationItem.setLabel(
							LanguageUtil.get(_request, "resources"));
					});
			}
		};
	}

	public String getOrderByType() {
		if (Validator.isNotNull(_orderByType)) {
			return _orderByType;
		}

		_orderByType = ParamUtil.getString(_request, "orderByType", "asc");

		return _orderByType;
	}

	public String getRedirect() {
		String redirect = ParamUtil.getString(_request, "redirect");

		if (Validator.isNull(redirect)) {
			PortletURL portletURL = _renderResponse.createRenderURL();

			portletURL.setParameter("mvcRenderCommandName", "/fragment/view");

			if (getFragmentCollectionId() > 0) {
				portletURL.setParameter(
					"fragmentCollectionId",
					String.valueOf(getFragmentCollectionId()));
			}

			redirect = portletURL.toString();
		}

		return redirect;
	}

	public boolean isNavigationElements() {
		if (Objects.equals(getNavigation(), "elements")) {
			return true;
		}

		return false;
	}

	public boolean isNavigationSections() {
		if (Objects.equals(getNavigation(), "sections")) {
			return true;
		}

		return false;
	}

	public boolean isSearch() {
		if (Validator.isNotNull(_getKeywords())) {
			return true;
		}

		return false;
	}

	public boolean isViewResources() {
		if (Objects.equals(_getTabs1(), "resources")) {
			return true;
		}

		return false;
	}

	private String _getFragmentEntryRenderURL(
			FragmentEntry fragmentEntry, String mvcRenderCommandName,
			WindowState windowState)
		throws Exception {

		PortletURL portletURL = PortletURLFactoryUtil.create(
			_request, FragmentPortletKeys.FRAGMENT,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcRenderCommandName", mvcRenderCommandName);
		portletURL.setParameter(
			"fragmentEntryId",
			String.valueOf(fragmentEntry.getFragmentEntryId()));
		portletURL.setWindowState(windowState);

		return portletURL.toString();
	}

	private String _getKeywords() {
		if (_keywords != null) {
			return _keywords;
		}

		_keywords = ParamUtil.getString(_request, "keywords");

		return _keywords;
	}

	private String _getOrderByCol() {
		if (Validator.isNotNull(_orderByCol)) {
			return _orderByCol;
		}

		_orderByCol = ParamUtil.getString(
			_request, "orderByCol", "create-date");

		return _orderByCol;
	}

	private PortletURL _getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "/fragment/view");
		portletURL.setParameter(
			"fragmentCollectionId", String.valueOf(getFragmentCollectionId()));

		String keywords = _getKeywords();

		if (Validator.isNotNull(keywords)) {
			portletURL.setParameter("keywords", keywords);
		}

		String orderByCol = _getOrderByCol();

		if (Validator.isNotNull(orderByCol)) {
			portletURL.setParameter("orderByCol", orderByCol);
		}

		String orderByType = getOrderByType();

		if (Validator.isNotNull(orderByType)) {
			portletURL.setParameter("orderByType", orderByType);
		}

		return portletURL;
	}

	private String _getTabs1() {
		if (_tabs1 != null) {
			return _tabs1;
		}

		_tabs1 = ParamUtil.getString(_request, "tabs1", "entries");

		return _tabs1;
	}

	private String _cssContent;
	private FragmentCollection _fragmentCollection;
	private Long _fragmentCollectionId;
	private SearchContainer _fragmentEntriesSearchContainer;
	private FragmentEntry _fragmentEntry;
	private Long _fragmentEntryId;
	private final FragmentEntryProcessorRegistry
		_fragmentEntryProcessorRegistry;
	private final FragmentPortletConfiguration _fragmentPortletConfiguration;
	private String _htmlContent;
	private final ItemSelector _itemSelector;
	private String _jsContent;
	private String _keywords;
	private String _name;
	private String _navigation;
	private String _orderByCol;
	private String _orderByType;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private final HttpServletRequest _request;
	private final String _resolvedModuleName;
	private String _tabs1;
	private final ThemeDisplay _themeDisplay;

}