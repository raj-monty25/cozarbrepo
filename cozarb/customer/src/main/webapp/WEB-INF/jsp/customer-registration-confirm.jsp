<%@page isELIgnored="false" %>
<!-- Bread Crumb STRAT -->
<div class="banner inner-banner1 ">
	<div class="container">
		<section class="banner-detail center-xs">
			<h1 class="banner-title">Register</h1>
		</section>
	</div>
</div>
<!-- Bread Crumb END -->
<section class="checkout-section ptb-70">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="row justify-content-center">
					<div class="col-xl-6 col-lg-8 col-md-8 ">
						Your account has been register, we sent you an email for verifying your email address and please click <a href="${pageContext.request.contextPath}/verify-mobile-number/${systemUserId}/${mobileNumber}">here</a> to proceed for mobile number verification.
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
