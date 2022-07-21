<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link rel="stylesheet" href="assets/style.css">
</head>

<body>
	<div id="root">
		<div class="Nav_pc"></div>
		<div class="Banner_nav_order"></div>
		<div class="Cart cf">

			<!-- <div class="heading cf">
        <h1>Giỏ hàng của bạn</h1>
        <a href="#" class="continue">Quay lại trang sản phẩm</a>
      </div> -->
			<div class="cart">
				<ul class="cartWrap">
					<div class="cartWrap-divcart">
						<c:forEach var="pd" items="${cart }">
							<li class="items odd">
							<div class="infoWrap">
								<div class="cartSection">
									<div class="cartSection-img">
										<img src="/assets/img/<c:out value="${pd.product.imageLink }" /> " alt=""
											class="itemImg" >
										<!-- <p class="itemNumber">#QUE-007544-002</p> -->
										<div class="cartSection-img-header">
											<h3> <c:out value="${pd.product.name }" /> </h3>
											<p> <c:out value="${pd.product.shortDescription }" /> </p>
											<p class="Price-Setup">
												<input type="number" class="qty" min="1" value="<c:out value="${pd.quantity }" />"
													name="numberOfProduct" /> <span style="color: black;">x
													<c:out value="${pd.product.price }" /></span>
											</p>
										</div>
									</div>
								</div>


								<div class="prodTotal cartSection">
									<p class="prodTotals"><c:out value="${pd.newPrice }" /> VNĐ</p>
								</div>
								<div class="cartSection removeWrap">
									<a class="remove" href="delete-product-in-cart?productIDIC=<c:out value="${pd.product.productID }" />&cartID=<c:out value="${pd.cartID }" />">x</a>
								</div>
							</div>
						</li>
						</c:forEach>
					</div>
					<div class="totalsub">
						<div class="TotalPrice">
							<div class="TotalPrice-head">Thanh toán</div>
							<!-- <div class="TotalPrice-total">$18.41</div> -->
						</div>

						<div class="payment-magiamgia">
							<p class="headline-primary">Mã giảm giá:</p>
							<input class="headline-primary-input" type="text"> <input
								class="headline-primary-submit" type="submit" value="Gửi">
						</div>
						<div class="subtotal">
							<div class="protosubtotal">
								Giảm giá:<span>-0 VNĐ</span>
							</div>
							<div class="protosubtotal">
								Tổng số tiền:<span> <c:out value="${total }"/> VNĐ</span>
							</div>

						</div>
						<div class="payment">
							<div class="ux-card">
								<img src="https://img1.wsimg.com/fos/react/sprite.svg#visa">
								<span>ADD pay gate</span>
							</div>

							<div class="ux-card">
								<img src="https://img1.wsimg.com/fos/react/sprite.svg#visa">
								<span>Zalo pay</span>
							</div>

							<div class="ux-card">
								<i class="fas fa-hand-holding-usd"></i> <span>Thanh toán
									khi nhận hàng</span>
							</div>
						</div>

						<a onclick="test(this)" type="submit"
							class="Button-TotalPrice" href="create-bill">Xác nhận</a>
					</div>
				</ul>
			</div>
		</div>
		<div class="Footer"></div>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js"></script>
</body>

</html>