<%@page isELIgnored="false" %>
<!-- Bread Crumb STRAT -->
<div class="banner inner-banner1 ">
	<div class="container">
		<section class="banner-detail center-xs">
			<h1 class="banner-title">OTP Verification</h1>
			<div class="bread-crumb right-side float-none-xs">
				<ul>
					<li><a href="index-2.html">Home</a>/</li>
					<li><span>Register</span></li>
				</ul>
			</div>
		</section>
	</div>
</div>
<!-- Bread Crumb END -->

<!-- CONTAIN START -->
<section class="checkout-section ptb-70">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="row justify-content-center">
					<div class="col-xl-6 col-lg-8 col-md-8 ">
						<form action="${pageContext.request.contextPath}/verify-mobile-number" method="post" class="main-form full" id="mobileNumberVerificationForm">
							<div class="row">
								<div class="col-12 mb-20">
									<div class="heading-part heading-bg">
										<h2 class="heading">OTP Verification</h2>
									</div>
								</div>
								<div class="col-12">
									<div class="input-box">
										<p>Please enter the OTP we have sent to your mobile number ${mobileNumber} for verification.</p>
										<label for="otp">OTP</label> 
										<input id="otp" type="text" placeholder="OTP" name="otp">
										<span id="otp_error" class="error hidden"></span>
									</div>
								</div>

								<div class="col-12">

									<button name="submit" type="submit"
										class="btn-color right-side">Submit</button>
								</div>
								<div class="col-12">
									<a title="Forgot Password" class="forgot-password mtb-20"
										href="#">Resend OTP</a>
									<hr>
								</div>
							</div>
							<input type="hidden" name="systemUserId" value="${systemUserId}">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- CONTAINER END -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#mobileNumberVerificationForm").submit(function() {
			//$("#otp_error").toggleClass("hidden","show");
			if($("#otp").val().trim().length == 0) {
				$("#otp_error").html("OTO is empty");
				$("#otp_error").removeClass("hidden").addClass("show");
				return false;	
			}
			return true;
		});
	});
</script>







