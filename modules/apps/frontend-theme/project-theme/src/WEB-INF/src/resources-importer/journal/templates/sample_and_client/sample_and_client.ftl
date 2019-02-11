<div class="container-fluid row">
	<div class="col-md-12">
		<div class="row sample-space">

			<div class="col-md-6">
				<h1 class="sample-page-title"> ${Text9tal.getData()} </h1>
				<#if SampleImage.getData()?? && SampleImage.getData() != "">
				<img alt="${SampleImage.getAttribute("alt")}" class="sample-page-img" data-fileentryid="${SampleImage.getAttribute("fileEntryId")}" src="${SampleImage.getData()}"/>
				</#if>

				<p class="sample-page-p">${SampleParagraph.getData()}</p>

				<button class="btn" type="button"><@liferay.language key="read-more" /></button>
			</div>

			<div class="col-md-6">
				<h1 class="sample-page-title">${Textgcix.getData()}</h1>

				<div class="sample-client">
					<#if Client1Photo.getData()?? && Client1Photo.getData() != "">
						<img alt="${Client1Photo.getAttribute("alt")}" class="client-photo" data-fileentryid="${Client1Photo.getAttribute("fileEntryId")}" src="${Client1Photo.getData()}"/>
					</#if>

					<p class="client-bio">${Client1Response.getData()}</p>

					<p class='client-signature'>${Client1SignatureWJobTitle.getData()}</p>
				</div>

				<div class="sample-client">
					<#if Client2Photo.getData()?? && Client2Photo.getData() != "">
						<img alt="${Client2Photo.getAttribute("alt")}" class="client-photo" data-fileentryid="${Client2Photo.getAttribute("fileEntryId")}" src="${Client2Photo.getData()}"/>
					</#if>

					<p class="client-bio">${Client2Response.getData()}</p>

					<p class='client-signature'>${Client2SignatureWJobTitle.getData()}</p>
				</div>

				<div class="sample-client">
					<#if Client3Photo.getData()?? && Client3Photo.getData() != "">
						<img alt="${Client3Photo.getAttribute("alt")}" class="client-photo" data-fileentryid="${Client3Photo.getAttribute("fileEntryId")}" src="${Client3Photo.getData()}"/>
					</#if>

					<p class="client-bio">${Client3Response.getData()}</p>

					<p class='client-signature'>${Client3SignatureWJobTitle.getData()}</p>
				</div>

			</div>
		</div>
	</div>
</div>