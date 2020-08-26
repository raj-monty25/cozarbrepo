<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Bread Crumb STRAT -->
<div class="banner inner-banner1 ">
	<div class="container">
		<section class="banner-detail center-xs">
			<h1 class="banner-title">Women</h1>
			<div class="bread-crumb right-side float-none-xs">
				<ul>
					<li><a href="index-2.html">Home</a>/</li>
					<li><span>Women</span></li>
				</ul>
			</div>
		</section>
	</div>
</div>
<!-- Bread Crumb END -->

<!-- CONTAIN START -->
<section class="pt-70">
	<div class="container">
		<div class="row">
			<div class="col-lg-9">
				<div class="row">
					<div class="col-lg-5 col-md-5 mb-xs-30">
						<div class="fotorama" data-nav="thumbs"
							data-allowfullscreen="native">
								<c:forEach items="${productDetails.productImages}" var="productImage">
									<a href="#"><img src="${pageContext.request.contextPath}/${productImage.imageId}/image" alt="Shopstyle"></a> 	
								</c:forEach>
						</div>
					</div>
					<div class="col-lg-7 col-md-7">
						<div class="row">
							<div class="col-12">
								<div class="product-detail-main">
									<div class="product-item-details">
										<h1 class="product-item-name">${productDetails.title}</h1>
										<i class="fa fa-building-o"><span class="merchant-name">&nbsp;${productDetails.merchantBusinessName}<span></i>
										<div class="rating-summary-block">
											<div title="${productDetails.rating}%" class="rating-result">
												<span style="width: ${productDetails.rating}%"></span>
											</div>
										</div>
										<div class="price-box">
											<span class="price">${productDetails.price}</span>
										</div>
										<div class="product-info-stock-sku">
											<div>
												<label>Availability: </label> <span class="info-deta">
													<c:choose>
														<c:when test="${productDetails.quantity gt 0}">In Stock</c:when>
														<c:otherwise>Sold</c:otherwise>
													</c:choose>
												</span>
											</div>
											<div>
												<label>SKU: </label> <span class="info-deta">${productDetails.productId}</span>
											</div>
										</div>
										<p>${productDetails.description}</p>
										<div class="mb-20">
											<div class="product-qty">
												<label for="qty">Qty:</label>
												<div class="custom-qty">
													<button
														onclick="var result = document.getElementById('qty'); var qty = result.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) result.value--;return false;"
														class="reduced items" type="button">
														<i class="fa fa-minus"></i>
													</button>
													<input type="text" class="input-text qty" title="Qty"
														value="1" maxlength="5" id="qty" name="qty">
													<button
														onclick="var result = document.getElementById('qty'); var qty = result.value; if( !isNaN( qty )) result.value++;return false;"
														class="increase items" type="button">
														<i class="fa fa-plus"></i>
													</button>
												</div>
											</div>
											<div class="bottom-detail cart-button">
												<ul>
													<li class="pro-cart-icon">
														<form>
															<button title="Add to Cart" class="btn-color">
																<span></span>Add to Cart
															</button>
														</form>
													</li>
													<li class="pro-cart-icon">
														<form>
															<button title="Try and Buy" class="btn-black">
																<span></span>Try and Buy
															</button>
														</form>
													</li>
												</ul>
											</div>
										</div>

										<div class="share-link">
											<label>Share This : </label>
											<div class="social-link">
												<ul class="social-icon">
													<li><a class="facebook" title="Facebook" href="#"><i
															class="fa fa-facebook"> </i></a></li>
													<li><a class="twitter" title="Twitter" href="#"><i
															class="fa fa-twitter"> </i></a></li>
													<li><a class="linkedin" title="Linkedin" href="#"><i
															class="fa fa-linkedin"> </i></a></li>
													<li><a class="rss" title="RSS" href="#"><i
															class="fa fa-rss"> </i></a></li>
													<li><a class="pinterest" title="Pinterest" href="#"><i
															class="fa fa-pinterest"> </i></a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="brand-logo-pro align-center mb-30">
					<img src="${pageContext.request.contextPath}/images/brand5.png" alt="Shopstyle">
				</div>
				<div class="sub-banner-block align-center">
					<img src="${pageContext.request.contextPath}/images/pro-banner.jpg" alt="Shopstyle">
				</div>
			</div>
		</div>
	</div>
</section>

<section class="ptb-70">
	<div class="container">
		<div class="product-detail-tab">
			<div class="row">
				<div class="col-lg-12">
					<div id="tabs">
						<ul class="nav nav-tabs">
							<li><a class="tab-Description selected" title="Description">Description</a></li>

							<li><a class="tab-Reviews" title="Reviews">Reviews</a></li>
						</ul>
					</div>
					<div id="items">
						<div class="tab_content">
							<ul>
								<li>
									<div class="items-Description selected ">
										<div class="Description">
											<strong>${productDetails.title}</strong><br />
											<p>${productDetails.description}</p>
										</div>
									</div>
								</li>
								<li>
									<div class="items-Reviews">
										<div class="comments-area">
											<h4>
												
												Comments<span>(${fn:length(productDetails.productFeedback)})</span>
											</h4>
											<ul class="comment-list mt-30">
												<c:forEach items="${productDetails.productFeedback}" var="feedback">
													<li>
														<div class="comment-user">
															<img src="${pageContext.request.contextPath}/images/comment-user.jpg" alt="Shopstyle">
														</div>
														<div class="comment-detail">
															<div class="user-name">${feedback.feedbackUserName}</div>
															<div class="post-info">
																<ul>
																	<li><fmt:formatDate value="${feedback.feedbackPostedDate}" pattern="dd-MM-yyyy"/> </li>
																	<li><a href="#"><i class="fa fa-reply"></i>Reply</a></li>
																</ul>
															</div>
															<p>${feedback.comments}</p>
														</div>
													</li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="pb-70">
	<div class="container">
		<div class="product-listing">
			<div class="row">
				<div class="col-12">
					<div class="heading-part mb-40">
						<h2 class="main_title heading">
							<span>Related Products</span>
						</h2>
					</div>
				</div>
			</div>
			<div class="pro_cat">
				<div class="row">
					<div class="owl-carousel pro-cat-slider">
						<c:forEach items="${similarProducts}" var="product">
							<div class="item">
								<div class="product-item">
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
<!-- CONTAINER END -->