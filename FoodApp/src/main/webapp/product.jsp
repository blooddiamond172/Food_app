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
    <link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="assets/style.css">
</head>
<body>
    <div id="root">
        <div class="Nav_pc"></div>
        <div class="Banner_nav_order"></div>
        
        <div class="product">
            <div  class="product-img">
                <figure class="zoom" style="background: url(${pageContext.request.contextPath }/assets/img/<c:out value="${product.imageLink }"/>) no-repeat left top;">
                    <img src="${pageContext.request.contextPath }/assets/img/<c:out value="${product.imageLink }"/>">
                </figure>   
            </div>
            <div class="product-content">
                <h2 class="detail-content__title"><c:out value="${product.name }"></c:out></h2>
                <div class="detail-content__rate">
                    <div class="detail-content__stars">
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true"><path d="M12 17.27L18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z"></path></svg>
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true"><path d="M12 17.27L18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z"></path></svg>
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true"><path d="M12 17.27L18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z"></path></svg>
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true"><path d="M12 17.27L18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z"></path></svg>
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true"><path d="M22 9.24l-7.19-.62L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21 12 17.27 18.18 21l-1.63-7.03L22 9.24zM12 15.4l-3.76 2.27 1-4.28-3.32-2.88 4.38-.38L12 6.1l1.71 4.04 4.38.38-3.32 2.88 1 4.28L12 15.4z"></path></svg>
                    </div>
                    <div class="detail-content__reviews">
                            <span class="detail-content__reviews-qnt">2</span>
                            <span> Customer Reviews</span>
                    </div>  
                </div>

                <div class="detail-content__price"><strong><c:out value="${product.price }"></c:out> VNĐ</strong></div> 
                <div class="detail-content__tag"><span class="detail-content__tag-label">Address:</span><span class="detail-content__tag-detail">Ha Noi, Viet Nam</span> <br> <span  style="display:block; margin-top:8px; width:130px" class="detail-content-description-fav">Favourite</span></div> 

                <div class="detail-tab-info">
                    <p><c:out value="${product.shortDescription }"></c:out></p>
                </div>

                <div class="detail-content__commits">
                    <div class="detail-content__commit">
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true">
                            <path d="M20 8h-3V4H3c-1.1 0-2 .9-2 2v11h2c0 1.66 1.34 3 3 3s3-1.34 3-3h6c0 1.66 1.34 3 3 3s3-1.34 3-3h2v-5l-3-4zm-.5 1.5l1.96 2.5H17V9.5h2.5zM6 18c-.55 0-1-.45-1-1s.45-1 1-1 1 .45 1 1-.45 1-1 1zm2.22-3c-.55-.61-1.33-1-2.22-1s-1.67.39-2.22 1H3V6h12v9H8.22zM18 18c-.55 0-1-.45-1-1s.45-1 1-1 1 .45 1 1-.45 1-1 1z"></path>
                        </svg>
                        <span>Free global shipping on all orders</span>
                    </div>
                    <div class="detail-content__commit">
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true">
                            <path d="M19 3h-1V1h-2v2H8V1H6v2H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zm0 16H5V9h14v10zM5 7V5h14v2H5zm5.56 10.46l5.93-5.93-1.06-1.06-4.87 4.87-2.11-2.11-1.06 1.06z"></path>
                        </svg>
                        <span>2 hours easy returns if you change your mind</span>
                    </div>
                    <div class="detail-content__commit">
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true">
                            <path d="M21.41 11.58l-9-9C12.05 2.22 11.55 2 11 2H4c-1.1 0-2 .9-2 2v7c0 .55.22 1.05.59 1.42l9 9c.36.36.86.58 1.41.58s1.05-.22 1.41-.59l7-7c.37-.36.59-.86.59-1.41s-.23-1.06-.59-1.42zM13 20.01L4 11V4h7v-.01l9 9-7 7.02z"></path>
                            <circle cx="6.5" cy="6.5" r="1.5"></circle></svg>
                            <span>Order before noon for same day dispatch</span>
                    </div>
                </div>

                <div class="detail-content_addtocart">
                    <!-- <input type="number" max="5" step="1" value="1" ></button> -->
                    <button class="detail-content_addtocart_button" type="button"> 
                        <a class="detail-content_addtocart_span" style = "text-decoration: none" href="create-cart?idP=<c:out value="${product.productID }" />">Add to cart</a>
                    </button>
                </div>
            </div>
        </div>

        <div class="detail-tab">
            <div class="detail-tab-buton">
                <div class="detail-tab-h2-nhanxet" >
                    <span class="nhanxet active-button">Nhận xét</span> 
                </div>
            </div>

            <c:forEach var="comment" items="${comments }">
            	<div class="detail-tab-comment"> 
                <div class="detail-tab-comment__customer">
                    <div class="MuiAvatar-root MuiAvatar-circle detail-tab-comment__customer-avatar">
                    	<span><i class="fas fa-user-alt"></i></span>
                        </div>
                        <div class="detail-tab-comment__wrapper">
                            <div class="detail-tab-comment__row"><h4 class="detail-tab-comment__name">
                                <font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> <c:out value="${comment.username }"></c:out> </font></font></h4>
                                <time class="detail-tab-comment__date" datetime="2022-05-26T13:20:45.844Z" title="2022-05-26 13:20">
                                    <font style="vertical-align: inherit;">
                                        <font style="vertical-align: inherit;">2 phút trước</font></font>
                                    
                                </time>
                            </div>
                     <div class="detail-tab-comment__stars">
                         <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true" style="fill: rgb(253, 218, 129);">
                             <path d="M12 17.27L18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z"></path>
                        </svg>
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true" style="fill: rgb(253, 218, 129);">
                            <path d="M12 17.27L18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z"></path>
                        </svg>
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true" style="fill: rgb(253, 218, 129);">
                            <path d="M12 17.27L18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z"></path>
                        </svg>
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true" style="fill: rgb(253, 218, 129);">
                            <path d="M12 17.27L18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z"></path></svg>
                            
                        <svg class="MuiSvgIcon-root" focusable="false" viewBox="0 0 24 24" aria-hidden="true" style="fill: rgb(253, 218, 129);">
                            <path d="M12 17.27L18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z"></path>
                        </svg>
                    </div>
                    <p class="detail-tab-comment__content"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> <c:out value="${comment.comment }"></c:out> </font></font></p>
                    </div>
                </div>
            </div>
            </c:forEach>
            <div class="detail-tab-add-comment"> 
                <form class="detail-tab-user__form" action="post-comment?id=<c:out value="${product.productID }" />" method="post">
                    <textarea name="comment" class="detail-tab-user__textarea" placeholder="Viết bình luận của bạn ở đây..."></textarea>
                        <button class="MuiButtonBase-root MuiButton-root MuiButton-text primary-btn red detail-tab-user__submit" type="submit">
                            <span class="MuiButton-label">Add comment</span>
                        </button>
                </form>
            </div>
        </div>     
        <div class="Footer"></div>
    </div>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/app.js"></script>
</body>
</html>

