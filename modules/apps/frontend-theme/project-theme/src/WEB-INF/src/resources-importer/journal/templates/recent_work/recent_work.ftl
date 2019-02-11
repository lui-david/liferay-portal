<div class="recent-work row" id="myTooltipDelegate">
	<div class="col-md-12 container-fluid">
		<h1 class="recent-title">${HeadingText.getData()}</h1>
		<div class="recent-work row">

			<div class="col-md-3 recent-work-text">
				<#if ProjectImage1.getData()?? && ProjectImage1.getData() != "">
					<img alt="${ProjectImage1.getAttribute("alt")}" class="recent-img" data-fileentryid="${ProjectImage1.getAttribute("fileEntryId")}" src="${ProjectImage1.getData()}" title="${Project1Description.getData()}" />
				</#if>

				<h5 class="recent-work-title"><a title="${TitleOfProject11.getData()}" href="">${TitleOfProject11.getData()}</a><h5>

				<p class="recent-work-text">${Project1Description.getData()}</p>
			</div>

			<div class="col-md-3 recent-work-text">
				<#if ProjectImage2.getData()?? && ProjectImage2.getData() != "">
					<img alt="${ProjectImage2.getAttribute("alt")}" class="reent-img" data-fileentryid="${ProjectImage2.getAttribute("fileEntryId")}" src="${ProjectImage2.getData()}" title="${Project2Description.getData()}" />
				</#if>

				<h5 class="recent-work-title"><a title="${TitleOfProject2.getData()}" href="">${TitleOfProject2.getData()}</a><h5>

				<p class="recent-work-text">${Project2Description.getData()}</p>
			</div>

			<div class="col-md-3 recent-work-text">
				<#if ProjectImage3.getData()?? && ProjectImage3.getData() != "">
					<img alt="${ProjectImage3.getAttribute("alt")}" class="recent-img" data-fileentryid="${ProjectImage3.getAttribute("fileEntryId")}" src="${ProjectImage3.getData()}" title="${Project3Description.getData()}" />
				</#if>

				<h5 class="recent-work-title"><a title="${TitleOfProject3.getData()}" href="">${TitleOfProject3.getData()}</a><h5>

				<p class="recent-work-text">${Project3Description.getData()}</p>
			</div>

			<div class="col-md-3 recent-work-text">
				<#if ProjectImage4.getData()?? && ProjectImage4.getData() != "">
					<img alt="${ProjectImage4.getAttribute("alt")}" class="recent-img" data-fileentryid="${ProjectImage4.getAttribute("fileEntryId")}" src="${ProjectImage4.getData()}" title="${Project4Description.getData()}" />
				</#if>

				<h5 class="recent-work-title"><a title="${TitleOfProject4.getData()}" href="">${TitleOfProject4.getData()}</a><h5>

				<p class="recent-work-text">${Project4Description.getData()}</p>
			</div>

		</div>
	</div>
</div>