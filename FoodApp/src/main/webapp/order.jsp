<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Đồ ăn Online</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
	<link rel="stylesheet" href="assets/style.css">
</head>
<body>
	<div id="root">
		<div class="Nav_pc"></div>
		<div class="Banner_nav_order"></div>
		<div class="Order">
			<div class="Nav_Order">
				<div class="Popular">
					<div class="nane_order">Popular</div>
					<div class="Popular_BanhBao Popular_content">
						<img src="/assets/img/sidebar_burger.svg" alt=""> <a style = "text-decoration: none;color:black;" href="category-burger">Burger
						</a>
					</div>
					<div class="Popular_Banhmy Popular_content">
						<img src="/assets/img/sidebar_bread.svg" alt=""> <a  style = "text-decoration: none;color:black;" href="category-bakery">Bánh mỳ
						</a>
					</div>
					<div class="Popular_Xoi Popular_content">
						<img src="/assets/img/sidebar_pizza.svg" alt=""> <a  style = "text-decoration: none;color:black;" href="category-pizza">Pizza
						</a>
					</div>
					<div class="Popular_Pho Popular_content">
						<img src="/assets/img/sidebar_chicken.svg" alt=""> <a style = "text-decoration: none;color:black;" href="category-kfc">Gà rán
						</a>
					</div>
					<div class="Popular_NuocHoaQuan Popular_content">
						<img src="/assets/img/sidebar-drinks.svg" alt=""> <a  style = "text-decoration: none;color:black;" href="category-drink">Đồ uống
						</a>
					</div>
				</div>
				<div class="Price">
					<div class="nane_order">Price</div>
					<div class="Popular_BanhBao Popular_content">
						<img src="/assets/img/money-bag-svgrepo-com.svg" alt=""> <a style = "text-decoration: none;color:black;" href="category-higher">
							Tăng dần </a>
					</div>
					<div class="Popular_Banhmy Popular_content">
						<img src="/assets/img/money-bag-svgrepo-com.svg" alt=""> <a style = "text-decoration: none;color:black;" href="category-lower">
							Giảm dần </a>
					</div>
				</div>
				<div class="Rate">
					<div class="nane_order">Rate</div>
					<div class="Popular_BanhBao Popular_content">
						<img src="/assets/img/star-solid.svg" alt=""> <span>5
							sao</span>
					</div>
					<div class="Popular_Banhmy Popular_content">
						<img src="/assets/img/star-solid.svg" alt=""> <span>4
							sao</span>
					</div>
					<div class="Popular_NuocHoaQuan Popular_content">
						<img src="/assets/img/star-solid.svg" alt=""> <span>3
							sao</span>
					</div>
				</div>
			</div>

			<div class="Product">
				<div class="Searchproduct">
					<form action="post-name-of-product" class="Search_name" method="post">
                        <input id="search-product" type="text" placeholder="Bạn muốn tìm món ăn gì ?"  name="name-product" onkeyup="Searchproduct()">
                        <input type="submit" class="Featured" value="Tìm kiếm"></input>
                    </form>
				</div>

				<div class="Shop">
					<!-- Day la tung content -->
					<c:forEach var="product" items="${products }">
						<a style="text-decoration: none;color:black;" class="shop-product" href="product?id=<c:out value="${product.productID }" />">
							<div class="shop-product-description">
								<img
									class="shop-product-description-rate-img"
									src="${pageContext.request.contextPath }/assets/img/${product.imageLink}" alt="">
							</div>
							<div class="shop-product__content">
								<div class="shop-product__name"><c:out value="${product.name }"></c:out></div>
								<p class="shop-product__description"><c:out value="${product.shortDescription }"></c:out></p>
								<div class="shop-product__row">
									<div class="shop-product__location">
										<svg class="MuiSvgIcon-root" focusable="false"
											viewBox="0 0 24 24" aria-hidden="true">
											<path
												d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z"></path></svg>
										<span >Hà Nội, Việt Nam</span>
									</div>
									<div class="shop-product__price"><c:out value="${product.price }"></c:out> VNĐ</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
		
		<div class="Footer"></div>
	</div>
	
	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
	<script type="text/javascript"
		src="${pageContexth.request.contextPath }/js/app.js"></script>
</body>
</html>