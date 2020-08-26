<!-- CONTAIN START -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Top Categories Start-->
<section class=" pt-70">
	<div class="top-cate-bg ptb-70">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="heading-part mb-30 mb-xs-15">
						<h2 class="main_title heading">
							<span>Top Categories</span>
						</h2>
					</div>
				</div>
			</div>
			<div class="pro_cat">
				<div class="row">
					<div id="top-cat-pro" class="owl-carousel sell-pro align-center">
						<!-- Top Categories iteration -->
						<c:forEach items="${topCategories}" var="category">
							<div class="item ">
								<a href="shop.html">
									<div class="item-inner">
										<img src="${pageContext.request.contextPath}/${category.categoryImage.imageId}/image" style="height: 255px; width: 255px;" alt="Shopstyle">
										<div class="cate-detail">
											<span>${category.categoryName}</span>
										</div>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="top-cate-bg ptb-70">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="heading-part mb-30 mb-xs-15">
						<h2 class="main_title heading">
							<span>Top Stores</span>
						</h2>
					</div>
				</div>
			</div>
			<div class="pro_cat">
				<div class="row">
					<div id="top-stores" class="owl-carousel top-stores  align-center">
						<!-- Top Stores -->
						<c:forEach items="${recentMerchantStores}" var="store">
							<div class="item ">
								<a href="shop.html">
									<div class="item-inner">
										<img src="${pageContext.request.contextPath}/${store.merchantStoreImages[0].imageId}/image" width="210" height="210"
											alt="Shopstyle">
									</div> <span>${store.businessName}</span>
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Top Categories End-->

<!--  New arrivals Products Slider Block Start  -->
<section class="pt-70">
	<div class="container">
		<div class="product-listing">
			<div class="row">
				<div class="col-12">
					<div class="heading-part mb-30 mb-xs-15">
						<h2 class="main_title heading">
							<span>New Arrivals</span>
						</h2>
					</div>
				</div>
			</div>
			<div class="pro_cat">
				<div class="row">
					<div class="owl-carousel pro-cat-slider ">
						<!-- Recent Products -->
						<c:forEach items="${recentProducts}" var="product">
							<div class="item">
								<div class="product-item mb-30">
									<div class="main-label new-label">
										<span>New</span>
									</div>
									<div class="product-image">
										<a href="${pageContext.request.contextPath}/${product.productId}/product-details"> <img src="${pageContext.request.contextPath}/${product.productImages[0].imageId}/image"
											alt="Shopstyle">
										</a>
										<div class="product-detail-inner">
											<div class="detail-inner-left align-center">
												<ul>
													<li class="pro-cart-icon">
														<form>
															<button title="Add to Cart">
																<span></span>Add to Cart
															</button>
														</form>
													</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="product-item-details">
										<div class="product-item-name">
											<a href="${pageContext.request.contextPath}/${product.productId}/product-details">${product.productName}</a>
										</div>
										<div class="price-box">
											<span class="price">${product.price}</span>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--  New arrivals Products Slider Block End  -->

<!-- Daily Deals Start -->
<section class=" ptb-70">
	<div class="container">
		<div class="daily-deals">
			<div class="row m-0">
				<div class="col-12 p-0">
					<div class="heading-part mb-30 mb-xs-15">
						<h2 class="main_title heading">
							<span>Top Hawkers</span>
						</h2>
					</div>
				</div>
			</div>
			<div class="pro_cat">
				<div class="row">
					<div id="daily_deals" class="owl-carousel ">
						<!-- Hawkers -->
						<c:forEach items="${hawkers}" var="hawker">
							<div class="item">
								<div class="product-item">
									<div class="row ">
										<div class="col-md-6 col-12 deals-img ">
											<div class="product-image">
												<a href="product-page.html"> <img
													src="${pageContext.request.contextPath}/${hawker.hawkerImage.imageId}/image" alt="Shopstyle">
												</a>
											</div>
										</div>
										<div class="col-md-6 col-12 mt-xs-30">
											<div class="product-item-details">
												<div class="product-item-name">
													<a href="hawker-page.html">${hawker.hawkerName}</a>
												</div>
	
												<p>${hawker.description}.</p>
											</div>
											<div class="product-detail-inner">
												<div class="detail-inner-left">
													<ul>
														<li class="pro-cart-icon">
															<form>
																<button title="Add to Cart">
																	<span></span>Request
																</button>
															</form>
														</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Daily Deals End -->

<!--  Site Services Features Block Start  -->
<div class="ser-feature-block">
	<div class="container">
		<div class="center-xs">
			<div class="row">
				<div class="col-xl-3 col-md-6 service-box">
					<div class="feature-box ">
						<div class="feature-icon feature1"></div>
						<div class="feature-detail">
							<div class="ser-title">Free Delivery</div>
							<div class="ser-subtitle">From $59.89</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6 service-box">
					<div class="feature-box">
						<div class="feature-icon feature2"></div>
						<div class="feature-detail">
							<div class="ser-title">Support 24/7</div>
							<div class="ser-subtitle">Online 24 hours</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6 service-box">
					<div class="feature-box ">
						<div class="feature-icon feature3"></div>
						<div class="feature-detail">
							<div class="ser-title">Free return</div>
							<div class="ser-subtitle">365 a day</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-md-6 service-box">
					<div class="feature-box ">
						<div class="feature-icon feature4"></div>
						<div class="feature-detail">
							<div class="ser-title">Big Saving</div>
							<div class="ser-subtitle">Weeken Sales</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--  Site Services Features Block End  -->

<!-- CONTAINER END -->