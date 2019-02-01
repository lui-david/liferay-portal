<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<#--  WRAPPER  -->
	<div id="wrapper">
		<#if show_header>
			<header id="banner">

				<div class="navbar navbar-classic navbar-top py-3">
					<div class="container user-personal-bar">
						<div class="align-items-center autofit-row">

							<#assign 
								preferences = freeMarkerPortletPreferences.getPreferences(
									{"portletSetupPortletDecoratorId": "barebone", 
									"destination": "/search"}
									)
							/>

						</div>
					</div>
				</div>

				<#--  SITE LOGO AND TITLE  -->
				<div class="navlogo-wrapper">

					<a class="${logo_css_class} align-items-center d-md-inline-flex d-sm-none d-none logo-md" href="${site_default_url}" title="<@liferay.language_format arguments="" key="go-to-x" />">
						<img alt="${logo_description}" class="mr-2" height="" src="${site_logo}" />

						<#if show_site_name>
							<h1 class="font-weight-bold h2 mb-0 text-dark">${site_name}</h1>
						</#if>
					</a>

					<#--  CLOSE SITE LOGO AND TITLE  -->

					<#--  NAVIGATION  -->
					<div id="portlet-body" class="navbar navbar-expand-lg navbar-light">
						<div class="container">

							<a class="${logo_css_class} d-inline-flex d-md-none logo-xs" href="${site_default_url}" rel="nofollow">
								<img alt="${logo_description}" class="mr-2" height="" src="${site_logo}" />

								<#if show_site_name>
									<h1 class="font-weight-bold h2 mb-0 text-dark">${site_name}</h1>
								</#if>
							</a>

							<#include "${full_templates_path}/navigation.ftl" />
								
								<#--  SEARCH  -->
								<#if show_header_search>

									<div>

									 <i class="search">
											<svg aria-hidden="true" class="lexicon-icon lexicon-icon-add-column lexicon-icon-search">
												<use xlink:href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#search" />
											</svg>
										</i> 

										<#--  <@liferay.search_bar default_preferences="${preferences}" />  -->

										<div class="search-box">
												<input type="text" placeholder=""/>
												<input type="button" value="Search"/>
										</div>

									</div>

								</#if>
											
								<#--  CLOSE SEARCH  -->

							<@liferay.user_personal_bar />
						</div>
					</div>

				</div>
				<#--  CLOSE NAVIGATION -->

			</header>
		</#if>

								

	<section class="${portal_content_css_class}" id="content">
		<h1 class="sr-only">${the_title}</h1>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

<#--  FOOTER  -->
	<#if show_footer>
		<footer id="footer" role="contentinfo">
			<div class="container">
				<div class="row">

					<div class="col-xs-12 col-md-6 col-sm-6 ">
						<p>Copyright &copy; David Lui 2019.</p>
					</div>

					<div class="col-xs-12 col-md-6 col-sm-6 fr footer-links">
						<@liferay.language key="powered-by" />

						<a class="text-white" href="http://www.liferay.com" rel="external">Liferay</a>
					</div>

				</div>
			</div>
		</footer>
	</#if>
	<#--  CLOSE FOOTER  -->

</div>
<#--  CLOSE WRAPPER  -->

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html> 