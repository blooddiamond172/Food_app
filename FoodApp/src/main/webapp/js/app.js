
$(function () {
    document.querySelector(".Nav_pc").innerHTML = `
  <div class="Nav_pc_all"> 
      <div class="Nav_letf">
          <ul class="Nav_letf_ul">
              <li><img class="logo" src="/assets/img/good1.png" alt=""></li>
              <li><a href="index.jsp"><i class="fas fa-home"></i>Trang Chủ </a></li>
              <li><a href="products"><i class="fas fa-utensils"></i>Đặt Ngay</a></li>
              <li><a href="index.jsp"><i class="far fa-newspaper"></i>Bảng Tin</a></li>
              <li><a href="products"><i class="fas fa-store"></i>Cửa Hàng</a></li>
          </ul>
      </div>   
      <div class="Nav_right">
          <ul class="Nav_right_ul">
              <li><a href="Cart.html"><i class="fas fa-shopping-cart"></i></a></li>
              <li><a href="login.jsp"><i class="fas fa-user"></i>${window.localStorage.getItem('user')}</a></li>
          </ul>
      </div>
    </div> 
  `
    document.querySelector(".Footer").innerHTML = `
  <div class="footer_pc">
    <div class="footer_contact">
        <div><i class="fas fa-map-marker-alt"></i>Địa chỉ: xxxxxxxxxxxxxxxx</div>
        <div><i class="fas fa-phone"></i>Số điện thoại liên hệ: xxxxxxxxxx</div>
        <div><i class="fas fa-envelope"></i>Gmail: xxxxxxxxxxxxx@gmail.com</div>
        <div><i class="fab fa-facebook"></i>Facebook</div>
    </div>
    <div class="footer_about">Danh mục cửa hàng
        <ol>
            <li>Món ăn mới</li>
            <li>Món ăn được yêu thích nhất</li>
            <li>Đánh giá của chuyên gia</li>
        </ol>
    </div>
  </div>
`
});
// Nav
document.addEventListener("DOMContentLoaded", function () {
    var nav = document.querySelector(".Nav_pc")
    window.addEventListener("scroll", function () {
        var x = pageYOffset;
        // console.log(x)
        if (x > 4) {
            nav.classList.add('Nav_actice');
            this.document.querySelector('.logo').src = '/assets/img/good2.png'
        }
        else {
            nav.classList.remove('Nav_actice')
            this.document.querySelector('.logo').src = '/assets/img/good1.png'
        }
    })
})

// Banner 
banner = document.querySelector('.banner')
var button1 = document.querySelector('.button1')
var button2 = document.querySelector('.button2')
var button3 = document.querySelector('.button3')


// button2.onclick = function(){
// button2.style.background = 'yellow'
// button1.style.background = 'none'
// button3.style.background = 'none'
// banner.style.backgroundImage = "url(/accset/img/240633429_4270236156426721_6444271789054655609_n.jpg)";
// // banner.classList.remove('animate__fadeIn')
// // banner.classList.add('animate__fadeIn')
// }
button1.onclick = function () {
    button1.style.background = 'yellow'
    button2.style.background = 'none'
    button3.style.background = 'none'
    banner.style.backgroundImage = "url(/accset/img/banner-st.57953e4d.jpg)";
    // banner.classList.remove('animate__fadeIn')
    // banner.classList.add('animate__fadeIn')

}
button3.onclick = function () {
    button3.style.background = 'yellow'
    button1.style.background = 'none'
    button2.style.background = 'none'
    button2.style.visivi
    // banner.classList.remove('animate__fadeIn')

}
document.querySelector('.').style.visibility = "hidden"


//Check register
function ValidateUsername() {
    const username = document.querySelector('#usernameregister');
    const labelname = document.querySelector('.span-label-yourname');

    //username check
    if (username.value == '' || username.value.length < "5" || username.value.length >= "20") {
        username.style.border = "1px solid #e30000";
        username.style.backgroundColor = "#fff2f4";
        // labelname.innerHTML = 'sai rồi';
    }
    else {
        username.style.border = "1px solid #d2d2d7";
        username.style.backgroundColor = "#fff";
    }
}
function ValidatePass() {
    const password = document.querySelector('#passwordregister')
    const password2 = document.querySelector('#password2register')
    //password check
    //   console.log(password.value)
    //   console.log(password.value != password2.value)
    if (password.value.length == '' || //check rỗng
        password.value.length < "8" || //check có hơn 8 ký tự
        password.value.length > "26" || //check có ít hơn 26 ký tự
        !password.value.match(/[a-z]/g) || // check có chữ thường không
        !password.value.match(/[A-Z]/g) || // check có chữ Hoa không
        !password.value.match(/[0-9]/g)    // check có số không
    ) {
        document.querySelector("#passwordregister").style.border = "1px solid #e30000";
        document.querySelector("#passwordregister").style.backgroundColor = "#fff2f4";
    }
    else {
        ValidatePassSame(password, password2)
        ValidatePassSame2(password, password2)
    }
}

function ValidatePass2() {
    const password = document.querySelector('#passwordregister')
    const password2 = document.querySelector('#password2register')
    console.log(password2.value)
    //password check
    if (password2.value.length == '' || //check rỗng
        password2.value.length < "8" || //check có hơn 8 ký tự
        password2.value.length > "26" || //check có ít hơn 26 ký tự
        !password2.value.match(/[a-z]/g) || // check có chữ thường không
        !password2.value.match(/[A-Z]/g) || // check có chữ Hoa không
        !password2.value.match(/[0-9]/g)    // check có số không
    ) {
        document.querySelector("#password2register").style.border = "1px solid #e30000";
        document.querySelector("#password2register").style.backgroundColor = "#fff2f4";
    }
    else {
        //
        ValidatePassSame(password, password2)
        ValidatePassSame2(password, password2)
    }
}

function ValidatePassSame(pass1, pass2) {
    if (pass1.value != pass2.value) {
        document.querySelector("#password2register").style.border = "1px solid #e30000";
        document.querySelector("#password2register").style.backgroundColor = "#fff2f4";
    } else {
        document.querySelector("#password2register").style.border = "1px solid #d2d2d7";
        document.querySelector("#password2register").style.backgroundColor = "#fff";
    }
}

function ValidatePassSame2(pass1, pass2) {
    if (pass1.value != pass2.value) {
        document.querySelector("#passwordregister").style.border = "1px solid #e30000";
        document.querySelector("#passwordregister").style.backgroundColor = "#fff2f4";
    } else {
        document.querySelector("#passwordregister").style.border = "1px solid #d2d2d7";
        document.querySelector("#passwordregister").style.backgroundColor = "#fff";
    }
}

function ValidatePhoneRegister() {
    const phone = document.querySelector('#phoneNumber-register')
    //phone check
    if (phone.value == '' || phone.value.length < "8" || phone.value.length >= "15" || phone.value.match(/[a-z]/g) || phone.value.match(/[A-Z]/g)) {
        phone.style.border = "1px solid #e30000";
        phone.style.backgroundColor = "#fff2f4";
    }
    else {
        phone.style.border = "1px solid #d2d2d7";
        phone.style.backgroundColor = "#fff";
    }
}

function ValidatePhoneLogin() {
    const phone = document.querySelector('#phoneNumber-login')
    //phone check
    if (phone.value == '' || phone.value.length < "8" || phone.value.length >= "15" || phone.value.match(/[a-z]/g) || phone.value.match(/[A-Z]/g)) {
        phone.style.border = "1px solid #e30000";
        phone.style.backgroundColor = "#fff2f4";
    }
    else {
        phone.style.border = "1px solid #d2d2d7";
        phone.style.backgroundColor = "#fff";
    }
}
function ValidatePassLogin() {
    const password = document.querySelector('#password-login')
    if (password.value.length == '' || //check rỗng
        password.value.length < "8" || //check có hơn 8 ký tự
        password.value.length > "26" || //check có ít hơn 26 ký tự
        !password.value.match(/[a-z]/g) || // check có chữ thường không
        // !password.value.match(/[A-Z]/g) || // check có chữ Hoa không
        !password.value.match(/[0-9]/g)    // check có số không
    ) {
        password.style.border = "1px solid #e30000";
        password.style.backgroundColor = "#fff2f4";
    } else {
        password.style.border = "1px solid #d2d2d7";
        password.style.backgroundColor = "#fff";
    }
}
function ValidateDiachi(){
    const address = document.querySelector('#address')
    if( address.value.length == ''){
        address.style.border = "1px solid #e30000";
        address.style.backgroundColor = "#fff2f4";
    } else {
        address.style.border = "1px solid #d2d2d7";
        address.style.backgroundColor = "#fff";
    }
}
function Checkform() {
    const password = document.querySelector('#passwordregister')
    const password2 = document.querySelector('#password2register')
    const username = document.querySelector('#usernameregister');
    const phone = document.querySelector('#phoneNumber-register')
    const address = document.querySelector('#address')
    if (password.value.length == '' ||
        password.value.length < "8" ||
        password.value.length > "26" ||
        !password.value.match(/[a-z]/g) ||
        !password.value.match(/[A-Z]/g) ||
        !password.value.match(/[0-9]/g) ||

        password2.value.length == '' ||
        password2.value.length < "8" ||
        password2.value.length > "26" ||
        !password2.value.match(/[a-z]/g) ||
        !password2.value.match(/[A-Z]/g) ||
        !password.value.match(/[0-9]/g) ||

        username.value.length == '' ||
        username.value.length < "8" ||
        username.value.length > "30" ||

        phone.value.length == '' ||
        phone.value.length < "8" ||
        phone.value.length > "15" ||
        phone.value.match(/[a-z]/g) ||
        phone.value.match(/[A-Z]/g) ||

        address.value.length == ''
    ) {
        alert('No send')
        return false
    }
    else {
        alert('Success')
        return true
    }
}

function Checkformlogin() {
    const phoneNumber = document.querySelector('#phoneNumber')
    const password = document.querySelector('#password-login')
    if (password.value.length == '' ||
        password.value.length < "8" ||
        password.value.length > "26" ||
        !password.value.match(/[a-z]/g) ||
        !password.value.match(/[A-Z]/g) ||
        !password.value.match(/[0-9]/g) ||
        phoneNumber.value.length == '' ||
        phoneNumber.value.length < "10" ||
        phoneNumber.value.length > "15"
    ) {
        alert('No send')
        return false
    }
    else {
        alert('Success')
        return true
    }
}

//zoom img 

function zoom(e) {
    let zoomer = e.currentTarget;
    e.offsetX ? offsetX = e.offsetX : offsetX = e.touches[0].pageX
    e.offsetY ? offsetY = e.offsetY : offsetX = e.touches[0].pageX
    x = offsetX / zoomer.offsetWidth * 100
    y = offsetY / zoomer.offsetHeight * 100
    zoomer.style.backgroundPosition = x + '% ' + y + '%';
}



// Remove Items From Cart
// $('div.remove').onclick(function(){
//     console.log(test)
// }
// $(this).parent().parent().parent().hide(400)) 

// // Just for testing, show all items
//  $('a.btn.continue').click(function(){
//       $('li.items').show(400);
// })

function DeleteItemCart(e) {
    const edits = e.currentTarget;
    // console.log(edits)
    const edit = edits.parentElement.parentElement.parentElement
    document.querySelector('.cartWrap-divcart').removeChild(edit)
}

let priceTotal = $('div.remove').parentElement

function pricejs() {
    qty = document.querySelector('.qty')
    document.querySelector('.Price-Setup').innerHTML = `<input type="text" class="qty" placeholder="${qty.value}" onblur="pricejs()" /> x $5.00`
    document.querySelector('.prodTotals').innerText = `$${qty.value * 5}.00`
}

