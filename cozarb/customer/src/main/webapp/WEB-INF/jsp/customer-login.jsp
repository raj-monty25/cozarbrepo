<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bread Crumb STRAT -->
<div class="banner inner-banner1 ">
	<div class="container">
		<section class="banner-detail center-xs">
			<h1 class="banner-title">Login</h1>
			<div class="bread-crumb right-side float-none-xs">
				<ul>
					<li><a href="${pageContext.request.contextPath}/home">Home</a>/</li>
					<li><span>Login</span></li>
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
						<form class="main-form full" action="${pageContext.request.contextPath}/customer-login-url" method="post" id="loginForm">
							<div class="row">
								<div class="col-12 mb-20">
									<div class="heading-part heading-bg">
										<h2 class="heading">Customer Login</h2>
										<c:if test="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message ne null}">
											<div class="alert alert-danger">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</div>
										</c:if>
									</div>
								</div>
								<div class="col-12">
									<div class="input-box">
										<label for="login-email">Email address</label> 
										<input id="login-email" type="email" name="j_username" placeholder="Email address">
										<span id="email_error" class="error hidden"></span>
									</div>
								</div>
								<div class="col-12">
									<div class="input-box">
										<label for="login-pass">Password</label> 
										<input id="login-pass" type="password" name="j_password" placeholder="Enter your Password">
										<span id="password_error" class="error hidden"></span>
									</div>
								</div>
								<div class="col-12">
									<button name="submit" type="submit"
										class="btn-color right-side">Log In</button>
								</div>
								<div class="col-12">
									<a title="Forgot Password" class="forgot-password mtb-20"
										href="#">Forgot your password?</a>
									<hr>
								</div>
								<div class="col-12">
									<div class="new-account align-center mt-20">
										<span>New to Shopstyle?</span> <a class="link"
											title="Register with Shopstyle" href="${pageContext.request.contextPath}/register">Create
											New Account</a>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- CONTAINER END -->
<script type="text/javascript">
	$(document).ready(function(){
		showErrors();
		$("#loginForm").submit(function() {
			var hasErrors = false;

			if($("#login-email").val().trim().length == 0) {
				hasErrors = true;
				$("#email_error").html("Email address is blank");
				$("#email_error").removeClass("hidden").addClass("show");
			}
			if($("#login-pass").val().trim().length == 0) {
				hasErrors = true;
				$("#password_error").html("Password is blank");
				$("#password_error").removeClass("hidden").addClass("show");
			}
			return !hasErrors;
		});		
	});
</script>










