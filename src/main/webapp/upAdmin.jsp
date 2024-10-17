<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Login Form Design | CodeLab</title>
      <link rel="stylesheet" href="unpp.css">
   </head>
   <body>
      <div class="wrapper">
         <div class="title">
            Login Form
         </div>
         <form action="up" method="post">
            <div class="field">
               <input  type="text" name="uName"  required>
               <label> Username </label>
            </div>
            <div class="field">
               <input  type="password" name="uPass"  required>
               <label>Password</label>
            </div>
            <div class="content">
               <div class="checkbox">
                 <!--  <input type="checkbox" id="remember-me">
                  <label for="remember-me">Remember me</label> -->
               </div>
               <div class="pass-link">
                 <!--  <a href="#">Forgot password?</a> -->
               </div>
            </div>
            <div class="field">
               <input type="submit" name="action" value="login">
            </div>
            <div class="signup-link" >
               Not a member? <a> <input type="submit" name="action" value="signup"></a>
            </div>
         </form>
      </div>
   </body>
</html>