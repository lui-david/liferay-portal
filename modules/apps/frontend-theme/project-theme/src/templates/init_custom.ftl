<#assign
	show_footer = getterUtil.getBoolean(themeDisplay.getThemeSetting("show-footer"))
	show_header = getterUtil.getBoolean(themeDisplay.getThemeSetting("show-header"))
	show_header_search = getterUtil.getBoolean(themeDisplay.getThemeSetting("show-header-search"))
	wrap_content = getterUtil.getBoolean(themeDisplay.getThemeSetting("wrap-content"))
/>

<#if wrap_content>
	<#assign portal_content_css_class = "container" />
<#else>
	<#assign portal_content_css_class = "" />
</#if>

<#assign show_instagram =
getterUtil.getBoolean(themeDisplay.getThemeSetting("show-instagram"))/>
<#assign show_facebook =
getterUtil.getBoolean(themeDisplay.getThemeSetting("show-facebook"))/>
<#assign show_twitter =
getterUtil.getBoolean(themeDisplay.getThemeSetting("show-twitter"))/>
<#assign show_googleplus =
getterUtil.getBoolean(themeDisplay.getThemeSetting("show-googleplus"))/>
<#assign show_linkedin =
getterUtil.getBoolean(themeDisplay.getThemeSetting("show-linkedin"))/>
<#assign show_youtube =
getterUtil.getBoolean(themeDisplay.getThemeSetting("show-youtube"))/>
<#assign show_dribbble =
getterUtil.getBoolean(themeDisplay.getThemeSetting("show-dribbble"))/>
<#assign show_github =
getterUtil.getBoolean(themeDisplay.getThemeSetting("show-github"))/>
<#assign show_phone =
getterUtil.getBoolean(themeDisplay.getThemeSetting("show-phone"))/>
<#assign show_email =
getterUtil.getBoolean(themeDisplay.getThemeSetting("show-email"))/>


<#assign instagram_url =
getterUtil.getString(themeDisplay.getThemeSetting("instagram-url"))/>
<#assign facebook_url =
getterUtil.getString(themeDisplay.getThemeSetting("facebook-url"))/>
<#assign twitter_url =
getterUtil.getString(themeDisplay.getThemeSetting("twitter-url"))/>
<#assign googleplus_url =
getterUtil.getString(themeDisplay.getThemeSetting("googleplus-url"))/>
<#assign linkedin_url =
getterUtil.getString(themeDisplay.getThemeSetting("linkedin-url"))/>
<#assign youtube_url =
getterUtil.getString(themeDisplay.getThemeSetting("youtube-url"))/>
<#assign dribbble_url =
getterUtil.getString(themeDisplay.getThemeSetting("dribbble-url"))/>
<#assign github_url =
getterUtil.getString(themeDisplay.getThemeSetting("github-url"))/>
<#assign phone_url =
getterUtil.getString(themeDisplay.getThemeSetting("phone-url"))/>
<#assign email_url =
getterUtil.getString(themeDisplay.getThemeSetting("email-url"))/>
