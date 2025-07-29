<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
    <style>
        body {
            background-image: url('images/icecream-bg.jpg');
            background-size: cover;
            background-position: center;
            font-family: Arial, sans-serif;
            color: white;
            text-align: center;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        nav {
            background-color: rgba(0, 0, 0, 0.75);
            padding: 15px 0;
            box-shadow: 0 2px 4px rgba(0,0,0,0.5);
        }

        nav a {
            margin: 0 20px;
            color: white;
            text-decoration: none;
            font-weight: bold;
            font-size: 16px;
        }

        nav a:hover {
            color: #fdd835;
        }

        .box {
            background-color: rgba(0, 0, 0, 0.6);
            display: inline-block;
            padding: 30px;
            border-radius: 12px;
            margin: 100px auto 30px;
        }

        h2 {
            color: #ffeb3b;
        }

        footer {
            margin-top: auto;
            background-color: rgba(0, 0, 0, 0.75);
            color: #ddd;
            padding: 15px 0;
            text-align: center;
            font-size: 14px;
            width: 100%;
            box-shadow: 0 -2px 4px rgba(0,0,0,0.5);
        }
    </style>
</head>
<body>

<nav>
    <a href="index.jsp">Home</a>
    <a href="Order.jsp">Order Again</a>
</nav>

<div class="box">
    <h2>Order Successful!</h2>
    <p>Thank you, <strong><%= request.getAttribute("name") %></strong>!</p>
    <p>Your total amount is: <strong>₹<%= request.getAttribute("total") %></strong></p>
</div>

<footer>
    &copy; <%= java.time.Year.now() %> Ice Cream Parlor. All rights reserved.
</footer>

</body>
</html>
