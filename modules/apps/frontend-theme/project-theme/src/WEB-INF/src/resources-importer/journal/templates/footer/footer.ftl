<div class="col-md-12">
    <div class="row">

        <div class="col-md-4">
            <h5 class="footer-heading">${SiteName.getData()}</h5>

            <p class="footer-description">${SiteDescription.getData()}</p>
        </div>

        <div class="col-md-4">
                <h5 class="footer-heading">${LinkHeader1.getData()}</h5>

                <ul class="footer-details">

                    <#if LinkHeader1.LinkTextForHeader1.getSiblings()?has_content>
                        <#list LinkHeader1.LinkTextForHeader1.getSiblings() as cur_LinkTextForHeader1>
                            <li class="footer-item"><a href="${cur_LinkTextForHeader1.LinkForHeader1.getData()}">${cur_LinkTextForHeader1.getData()}</a></li>
                        </#list>
                    </#if>

                </ul>
        </div>

        <div class="col-md-4">
                <h5 class="footer-heading">${LinkHeader2.getData()}</h5>

                <ul class="footer-details">

                    <#if LinkHeader2.LinkTextForHeader2.getSiblings()?has_content>
                        <#list LinkHeader2.LinkTextForHeader2.getSiblings() as cur_LinkTextForHeader2>
                            <li class="footer-item"><a href="${cur_LinkTextForHeader2.LinkForHeader2.getData()}">${cur_LinkTextForHeader2.getData()}</a></li>
                        </#list>
                    </#if>

                </ul>
        </div>

    </div>
</div>