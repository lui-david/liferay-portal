AUI().ready(
	'liferay-sign-in-modal',
	function(A) {
		var signIn = A.one('.sign-in > a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
	}
);

$(document).ready(function() {
     
    $(".search").click(function() {
       $(".search-box").toggle();
       $("input[type='text']").focus();
    });

}
);