<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="assets/style.css">

</head>
<body>
    <div id="root">
        <div class="Nav_pc Nav_actice"></div>
        <div class="Banner_nav_order_login"></div>
        <div class="Login">
            <div class="Login-Form">
                <div class="Login-banner">
                </div>

                <div class="Login-content">
                    <h2 class="Login-content-h2">JOIN WITH US! </h2>
                    <div class="Login_msg">
                        Bạn chưa có tài khoản?
                        <span> <a class="Go_register"  href="register.jsp"> Đăng ký</a></span>
                    </div>

                    <form action="${pageContext.request.contextPath }/login" method="post">
                        <div class="Login-form-content">
                            
                            <label class="label-field" for="phoneNumber">Số điện thoại</label> <br>
                            <div class="Login-input">
                                <span><i class="fas fa-envelope"></i></span>
                                <input id="phoneNumber-login" class="input-field" type="phoneNumber" name="phoneNumber" placeholder="Số điện thoại" onblur="ValidatePhoneLogin()">
                            </div>

                            <label class="label-field"  for="password">Mật khẩu</label> <br>
                            <div class="Login-input">   
                                <span><i class="fas fa-key"></i></span>
                                <input id="password-login" class="input-field" type="text" name="password" placeholder="Mật khẩu"  onblur="ValidatePassLogin()">
                            </div>
                            
                            <button class="btn-login" type="submit"><span>Đăng nhập</span></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="Footer"></div>
    </div>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js"></script>
</body>
</html>