<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<div class="col-xl-3 col-md-3 col-lgmd-20per">
	<div class="right-side float-left-xs header-right-link">
		<!--Before login start-->
		<security:authorize access="isAnonymous()">
			<ul>
				<li class="login-icon content"><a class="content-link"> <span
						class="content-icon"></span>
				</a>
					<div class="content-dropdown">
						<ul>
							<li class="login-icon"><a href="${pageContext.request.contextPath}/customer-login" title="Login"><i
									class="fa fa-user"></i> Login</a></li>
							<li class="register-icon"><a href="${pageContext.request.contextPath}/register"
								title="Register"><i class="fa fa-user-plus"></i> Register</a></li>
						</ul>
					</div></li>
			</ul>
		</security:authorize>
		<!--Before login end-->
		<!--After Login start-->
		<security:authorize access="isAuthenticated()">
			<ul>
				<li class="account-icon content"><a class="content-link"> <span
						class="content-icon"></span>
				</a>
					<div class="content-dropdown">
						<span class="user-name">${pageContext.request.userPrincipal.name}</span>
						<ul>
							<li class="logout-icon"><a href="#" title="My Account"><i
									class="fa fa-user"></i> My Account</a></li>
							<li class="logout-icon"><a href="#" title="Change Password"><i
									class="fa fa-key"></i> Change Password</a></li>
							<li class="logout-icon"><a href="${pageContext.request.contextPath}/logout" title="Logout"><i
									class="fa fa-sign-out"></i> Logout</a></li>
						</ul>
					</div></li>
				<li class="track-icon"><a href="#" title="Track your order"><span></span></a>
				</li>
				<li class="cart-icon"><a href="#"> <span> <small
							class="cart-notification">2</small>
					</span>
				</a>
					<div class="cart-dropdown header-link-dropdown">
						<ul class="cart-list link-dropdown-list">
							<li><a class="close-cart"><i class="fa fa-times-circle"></i></a>
								<div class="media">
									<a class="pull-left"> <img alt="Shopstyle"
										src="images/1.jpg"></a>
									<div class="media-body">
										<span><a href="#">Black African Print Skirt</a></span>
										<p class="cart-price">$14.99</p>
										<div class="product-qty">
											<label>Qty:</label>
											<div class="custom-qty">
												<input type="text" name="qty" maxlength="8" value="1"
													title="Qty" class="input-text qty">
											</div>
										</div>
									</div>
								</div></li>
							<li><a class="close-cart"><i class="fa fa-times-circle"></i></a>
								<div class="media">
									<a class="pull-left"> <img alt="Shopstyle"
										src="images/2.jpg"></a>
									<div class="media-body">
										<span><a href="#">Black African Print Skirt</a></span>
										<p class="cart-price">$14.99</p>
										<div class="product-qty">
											<label>Qty:</label>
											<div class="custom-qty">
												<input type="text" name="qty" maxlength="8" value="1"
													title="Qty" class="input-text qty">
											</div>
										</div>
									</div>
								</div></li>
						</ul>
						<p class="cart-sub-totle">
							<span class="pull-left">Cart Subtotal</span> <span
								class="pull-right"><strong class="price-box">$29.98</strong></span>
						</p>
						<div class="clearfix"></div>
						<div class="mt-20">
							<a href="cart.html" class="btn-color btn">Cart</a> 
							<a href="${pageContext.request.contextPath}/check-out" class="btn-color btn right-side">Checkout</a>
						</div>
					</div></li>
				<li class="side-toggle">
					<button data-target=".navbar-collapse" data-toggle="collapse"
						class="navbar-toggle" type="button">
						<i class="fa fa-bars"></i>
					</button>
				</li>
			</ul>
			<!--After login end-->
		</security:authorize>
	</div>
</div>