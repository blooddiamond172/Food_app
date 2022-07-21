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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="assets/style.css">
</head>
<body>
    <div id="root">
        <div class="Nav_pc "></div>
        <div  class="banner animate__animated animate__fadeIn">
            <div class="banner_about">
                <div class="about_layout"> 
                    <div class="content_hearder_banner_about animate__animated animate__fadeInRight">
                        79 FOOD
                    </div>
                    <div class="content_banner_about animate__animated animate__fadeInRight">
                       Chúng tôi sẽ ship tận giường cho bạn
                    </div>
                    <a class="buytiker " href="products" > 
                    	<div class="Oddernow"><span class="animate__animated animate__fadeInUpBig"> <i class="fas fa-cart-arrow-down"></i>Đặt ngay</span>
                    	</div>
                    </a>
               	</div>
                <div class="button_section animate__animated animate__fadeInUp"> 
                    <button class="button1"></button>
                    <button class="button2"></button>
                    <button class="button3"></button>
                </div>
            </div>
        </div>
        <div class="Footer"></div>
    </div>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js"></script>
</body>
</html>