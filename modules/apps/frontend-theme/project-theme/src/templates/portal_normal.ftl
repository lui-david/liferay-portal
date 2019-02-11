<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<link crossorigin="anonymous" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" rel="stylesheet" >
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

				<div class="navbar navbar-classic navbar-top">

						<div class="contact">
								<#if show_phone>
									<li class="contact-info"> <i class="fa-phone-square fas"></i> </a>${phone_url}</li>
								</#if>

								<#if show_email>
									<li class="contact-info"> <i class="fa-envelope-square fas"></i> </a>${email_url}</li>
								</#if>
						</div>

						<div class="social">
							<ul>
								<#if show_instagram>
									<li class="social-icons"> <a class="fa-instagram fab" href ="${instagram_url}"></a></li>
								</#if>

								<#if show_instagram>
									<li class="social-icons"> <a class="fa-facebook fab" href ="${facebook_url}"></a></li>
								</#if>

								<#if show_instagram>
									<li class="social-icons"> <a class="fa-twitter fab" href ="${twitter_url}"></a></li>
								</#if>

								<#if show_instagram>
									<li class="social-icons"> <a class="fa-google-plus-g fab" href ="${googleplus_url}"></a></li>
								</#if>

								<#if show_instagram>
									<li class="social-icons"> <a class="fa-linkedin-in fab" href ="${linkedin_url}"></a></li>
								</#if>

								<#if show_instagram>
									<li class="social-icons"> <a class="fa-youtube fab" href ="${youtube_url}"></a></li>
								</#if>

								<#if show_instagram>
									<li class="social-icons"> <a class="fa-dribbble fab" href ="${dribbble_url}"></a></li>
								</#if>

								<#if show_instagram>
									<li class="social-icons"> <a class="fa-github fab" href ="${github_url}"></a></li>
								</#if>
							<ul>
						</div>

						<@liferay.user_personal_bar />
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

				<div class="navlogo-wrapper">
					<a class="${logo_css_class} align-items-center d-md-inline-flex d-none d-sm-none logo-md" href="${site_default_url}" title="<@liferay.language_format arguments="" key="go-to-x" />">

					<img alt="${logo_description}" class="mr-2" height="" src="${site_logo}" />

						<#if show_site_name>
							<h1 class="font-weight-bold h2 mb-0 text-dark">${site_name}</h1>
						</#if>
					</a>

					<div class="navbar navbar-expand-xl navbar-light" id="portlet-body">
						<div class="container">

							<a class="${logo_css_class} d-inline-flex d-md-none logo-xs" href="${site_default_url}" rel="nofollow">
								<img alt="${logo_description}" class="mr-2" height="" src="${site_logo}" />

								<#if show_site_name>
									<h1 class="font-weight-bold h2 mb-0 text-dark">${site_name}</h1>
								</#if>
							</a>

							<#include "${full_templates_path}/navigation.ftl" />

								<#if show_header_search>

									<div class="search-bar">

										<i class="search">
												<svg aria-hidden="true" class="lexicon-icon lexicon-icon-add-column lexicon-icon-search">
													<use xlink:href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#search" />
												</svg>
										</i>

										<div class="search-box">
												<@liferay.search_bar default_preferences="${preferences}" />
										</div>

									</div>

								</#if>
						</div>

					</div>
				</div>

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

	<#if show_footer>
		<footer id="footer" role="contentinfo">

			<div class="container">

				<#assign article_id = "FOOTER" />

				<#assign VOID = freeMarkerPortletPreferences.setValue( "articleId", article_id) />

				<@liferay_portlet["runtime"]
					defaultPreferences="${freeMarkerPortletPreferences}"
					portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
				/>

				<div class="row">

					<div class="col-md-6 col-sm-6 col-xs-12">
						<p>Copyright &copy; David Lui 2019.</p>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 footer-links fr">
						<@liferay.language key="powered-by" />

						<a class="text-white" href="http://www.liferay.com" rel="external">Liferay</a>
					</div>

				</div>

			</div>
		</footer>
	</#if>

</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>