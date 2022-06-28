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
        <div class="Banner_nav_order_resgiter"></div>
        <div class="Resgister">
            <div class="Resgister-Form">
                <div class="Resgister-banner">
                </div>

                <div class="Resgister-content">
                    <h2 class="Resgister-content-h2">REGISTER NOW! </h2>
                    <div class="Already_have_account">
                        Bạn đã có tài khoản?
                        <span> <a class="Gologin"  href="login.html"> Đăng nhập</a></span>
                    </div>

                    <form action="${pageContext.request.contextPath }/register" method="post">
                        <div class="Resgister-form-content">
                            
                            <label class="label-field" for="phoneNumber">Số điện thoại</label> <br>
                            <div class="Resgister-input">
                                <span><i class="fas fa-envelope"></i></span>
                                <input id="phoneNumber-register" class="input-field" type="phoneNumber" name="phoneNumber" placeholder="Số điện thoại" onblur="ValidatePhoneRegister()">
                            </div>

                            <label class="label-field"  for="youname" >Tên đăng nhập </label> <br>
                            <div class="Resgister-input">
                                
                                <span><i class="fas fa-user-alt"></i></span>
                                <input  id="usernameregister" class="input-field" type="text" name="username" placeholder="Tên đăng nhập" onblur="ValidateUsername()">
                            </div>

                            <label class="label-field"  for="password">Mật khẩu</label> <br>
                            <div class="Resgister-input">   
                                <span><i class="fas fa-key"></i></span>
                                <input id="passwordregister" class="input-field" type="text" name="password" placeholder="Mật khẩu"  onblur="ValidatePass()">
                            </div>

                            <label class="label-field"  for="enterthepass">Nhập lại mật khẩu</label> <br>
                            <div class="Resgister-input">
                               
                                <span><i class="fas fa-key"></i></span>
                                <input id="password2register" class="input-field" type="text" name="password2" placeholder="Nhập lại mật khẩu" onblur="ValidatePass2()">
                            </div>

                            <label class="label-field"  for="enterthepass">Địa chỉ</label> <br>
                            <div class="Resgister-input">
                                
                                <span><i class="fas fa-map-marker-alt"></i></span>
                                <input id="address" class="input-field" type="text" name="address" placeholder="Địa chỉ" onblur="ValidateDiachi()">
                            </div>
                            
                            <button class="btn-resgiter" type="submit"><span>Đăng ký</span></button>
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