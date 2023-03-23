<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="accoutn_main">
        <video muted loop autoplay class="video">
            <source src="images/login.mp4" type="video/mp4">
        </video>

        <div class="form_area">
            <div class="main_con">
                <div class="headline">
                    <h1>Apple Shop</h1>
                    <span>welcome to Apple Shop </span>
                </div>

                <div class="form_con">
                    <div class="log_form">
                        <h2>Login Now!!</h2> 
                          <div class="headline">
                      <span>
                        <% String err = "";
				 if(request.getAttribute("err") != null)
				 {
					 err = (String)request.getAttribute("err");
					 
				 }
				 if(err.equals("1"))
					 { %>
						 <p> You are have account!!! </p>
						<%  }%>
                      </span>
                       </div>
                        <form action="loginUser" method="post">
                            <div class="input-box">
                                <input type="email" name="login-email" required>
                                <label>Email</label>
                            </div>
                            <div class="input-box">
                                <input type="password" name="login-password" required>
                                <label>Password</label>
                            </div>
                            <div class="button">
                                <button type="submit">LOGIN</button>
                            </div>
                             
                        </form>
                    </div>

                    <!-- Registration form -->
                    <div class="reg_form hidden">
                        <h2>Register Pets!!</h2>
				        <form action="Add-User" method="post">
				    
                            <div class="input-box">
                                <input type="text" name="name" required>
                                <label>Name</label>
                            </div>
                            <div class="input-box">
                                <input type="email" name="email" required>
                                <label>Email</label>
                            </div>
                            <div class="input-box">
                                <input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
                                <label>Password</label>
                            </div>
                             <div class="input-box">
                                <input type="password" name="#" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
                                <label>Confirm password</label>
                            </div>
                             <div class="input-box">
                                <input type="text" name="sodienthoai" required>
                                <label>Phone</label>
                            </div>
                             <div class="input-box">
                                <input type="text" name="diachi" required>
                                <label>diachi</label>
                            </div>
                            <div class="button">
                                <button type="submit">REGISTRATION</button>
                            </div>
                        </form>
                    </div>
                    <div class="text-center">
                        <span id="action">Registration</span> <br>
                        <a href="loginAdmin.jsp">Login Admin</a> <br>
                        <a href="gioithieu.jsp">Exit</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $("#action").click(function(){
            $(".log_form, .reg_form").toggle(1200);
        });
    </script>
</body>
</html>