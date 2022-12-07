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
    <link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="assets/style.css">
</head>
<body>
    <div id="root">
        <div class="Nav_pc"></div>
        <div class="Banner_nav_order">
        </div>
        
        <!-- checkout -->
        <div class="checkout-content">
            <div class="checkout-content-left">
                <div class="checkout-banner">
                </div>
                <div class="checkout-form">
                    <div class="checkout-form-title">
                        <i class="fa-solid fa-location-dot"></i>
                        <h1>Địa chỉ nhận hàng</h1>
                    </div>

                    <div>
                        <span class="label">Người nhận</span>
                        <input class="input" type="text" value="${user.username }" />
                    </div>
                    <div>
                        <span class="label">Số điện thoại</span>
                        <input class="input" type="text" value="${user.phoneNumber }" />
                    </div>
                    <div>
                        <span class="label">Địa chỉ</span> <br>
                        <input class="input" type="text" value="${user.address }" />
                    </div>

                    <div class="checkout-form-return">
                        <a href="products"> &lt Quay về cửa hàng</a>
                    </div>
                </div>
            </div>
            <div class="checkout-content-right">
                <ul class="checkout-products">
                    <c:forEach var="bill" items="${bills }">
                    	<li class="checkout-product">
                        <div class="checkout-product-img">
                            <img src="/assets/img/<c:out value="${bill.cart.product.imageLink }"/>" alt="">
                        </div>
                        <div class="checkout-product-content">
                            <h4 class="checkout-product-name"><c:out value="${bill.cart.product.name }"/></h4>
                            <h4 class="checkout-product-amount"><c:out value="${bill.cart.quantity }"/></h4> <!--số lượng-->
                        </div>
                        <h4 class="checkout-product-price"><c:out value="${bill.cart.newPrice }"/> VNĐ</h4>
                    </li>
                    </c:forEach>
                </ul>

                <div class="checkout-detail">
                    <div class="checkout-detail-row">
                        <h4 class="checkout-detail-label">Tổng sản phẩm</h4>
                        <h4 class="checkout-detail-content"><c:out value="${total}"/> VNĐ</h4>
                    </div>
                    <div class="checkout-detail-row">
                        <h4 class="checkout-detail-label">Phí vận chuyển</h4>
                        <h4 class="checkout-detail-content">Miễn phí</h4>
                    </div>
                </div>

                <div class="checkout-total">
                    <h3 class="checkout-total-label">Tổng thanh toán</h3>
                    <h3 class="checkout-total-content"><c:out value="${total}"/> VNĐ</h3>
                </div>
                
                <div class="checkout-btn-order">
                    <button class="btn-order" type="submit"><span>Đặt Hàng</span></button>
                </div>
            </div>
        </div>

        <div class="Footer"></div>
    </div>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js"></script>
</body>
</html>