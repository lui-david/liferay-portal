<div class="clients container-fluid row">
	<div class="client-spacing col-md-8">

		<#if SponsorImage.getSiblings()?has_content>
			<#list SponsorImage.getSiblings() as cur_SponsorImage>
				<#if cur_SponsorImage.getData()?? && cur_SponsorImage.getData() != "">
					<div class="col-md-3">
						<img alt="image" class="client-item-image" src="${cur_SponsorImage.getData()}">
					</div>
				</#if>
			</#list>
		</#if>
	</div>
</div>