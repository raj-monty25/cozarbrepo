<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- Bread Crumb STRAT -->
<div class="banner inner-banner1 ">
	<div class="container">
		<section class="banner-detail center-xs">
			<h1 class="banner-title">Register</h1>
			<div class="bread-crumb right-side float-none-xs">
				<ul>
					<li><a href="${pageContext.request.contextPath}/home">Home</a>/</li>
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
						<form:form modelAttribute="customerRegistrationForm" cssClass="main-form full">
							<div class="row">
								<div class="col-12 mb-20">
									<div class="heading-part heading-bg">
										<h2 class="heading">Create your account</h2>
									</div>
								</div>
								<div class="col-12">
									<div class="input-box">
										<label for="login-email">Email address</label>
										<form:input path="emailAddress" id="login-email" placeholder="Email Address"/>
										<span class="error hidden"><form:errors path="emailAddress"/></span>
									</div>
								</div>
								<div class="col-12">
									<div class="input-box">
										<label for="login-mobileNo">Mobile Number</label>
										<form:input path="mobileNumber" id="login-mobileNo" placeholder="Mobile Number"/> 
										<span class="error hidden"><form:errors path="mobileNumber"/></span>
									</div>
								</div>
								<div class="col-12">
									<div class="input-box">
										<label for="login-pass">Password</label> 
										<form:password path="password" id="login-pass" placeholder="Password"/>
										<span class="error hidden"><form:errors path="password"/></span>
									</div>
								</div>
								<div class="col-12">
									<div class="input-box">
										<label for="re-enter-pass">Re-enter Password</label>
										<form:password path="reTypePassword" id="re-enter-pass" placeholder="Re-enter Password"/>
										<span class="error hidden"><form:errors path="reTypePassword"/></span> 
									</div>
								</div>
								<div class="col-12">
									<div class="check-box left-side mb-20">
										<span> 
											<form:checkbox path="termsAndConditions" id="termsAndConditionsCheck" cssClass="checkbox" value="accepted"/>
											<label for="termsAndConditionsCheck">I accept the Terms and Conditions</label>
											<br><span class="error hidden"><form:errors path="termsAndConditions"/></span>
										</span>
									</div>
									<button name="submit" type="submit"
										class="btn-color right-side">Submit</button>
								</div>
								<div class="col-12">
									<hr>
									<div class="new-account align-center mt-20">
										<span>Already have an account with us</span> <a class="link"
											title="Register with Shopstyle" href="${pageContext.request.contextPath}/customer-login">Login
											Here</a>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- CONTAINER END -->
<script type="text/javascript">
	$(document).ready(function() {
		showErrors();
	});
</script>









