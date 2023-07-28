<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Registration</title>
</head>
<body>
     <h2>Create New Account</h2>
     <form action="saveReg" method="post">
        <pre>
           First Name<input type="text" name="name"/>
           User Name<input type="text" name="userName"/>
           Email<input type="text" name="email"/>
           Password<input type="text" name="password"/>
           OTP<input type="hidden" name="otp"/>
           <input type="submit" value="save"/>
        </pre>   
     </form>
</body>
</html>