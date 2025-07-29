<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Ice Cream Parlor</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-image: url('images/icecream-bg.jpg'); /* Correct mapped path */
            background-size: cover;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
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

        nav ul {
            list-style: none;
            display: flex;
            justify-content: center;
        }

        nav ul li {
            margin: 0 20px;
        }

        nav ul li a {
            color: #fff;
            text-decoration: none;
            font-weight: 600;
            font-size: 16px;
            transition: color 0.3s;
        }

        nav ul li a:hover {
            color: #fdd835;
        }

        main {
            flex-grow: 1;
            padding: 60px 20px;
        }

        button {
            padding: 10px 25px;
            font-size: 16px;
            background-color: #fdd835;
            color: #000;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #ffeb3b;
        }

        footer {
            background-color: rgba(0, 0, 0, 0.75);
            color: #ddd;
            padding: 15px 0;
            text-align: center;
            font-size: 14px;
            box-shadow: 0 -2px 4px rgba(0,0,0,0.5);
        }
    </style>
</head>
<body>

<nav>
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="Order.jsp">Order Ice Cream</a></li>
    </ul>
</nav>

<main>
    <h2>Welcome to Ice-Cream Parlor</h2>
    <br><br>
    <a href="Order.jsp">
        <button>Order Ice-Cream</button>
    </a>
</main>

<footer>
    &copy; <%= java.time.Year.now() %> Ice Cream Parlor. All rights reserved.
</footer>

</body>
</html>
