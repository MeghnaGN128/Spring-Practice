<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ice Cream Order</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-image: url('images/icecream-bg.jpg');
            background-size: cover;
            background-position: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: white;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            align-items: center;
        }

        nav {
            background-color: rgba(0, 0, 0, 0.75);
            padding: 15px 0;
            width: 100%;
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

        form {
            background-color: rgba(0, 0, 0, 0.6);
            padding: 30px;
            margin-top: 50px;
            border-radius: 12px;
            width: 320px;
            text-align: left;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: 500;
        }

        input[type="text"],
        input[type="number"],
        select {
            width: 100%;
            padding: 8px;
            border-radius: 6px;
            border: none;
            margin-top: 5px;
        }

        input[type="checkbox"] {
            margin-top: 8px;
        }

        .checkbox-label {
            display: flex;
            align-items: center;
            margin-top: 15px;
        }

        .checkbox-label input {
            margin-right: 10px;
        }

        button {
            margin-top: 20px;
            padding: 10px 20px;
            width: 100%;
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
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="Order.jsp">Order Ice Cream</a></li>
    </ul>
</nav>

<form action="save" method="post">
    <h2>Place Your Order</h2>

    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required>

    <label for="flavour">Flavour:</label>
    <select name="flavour" id="flavour">
        <option>Vanilla</option>
        <option>Chocolate</option>
        <option>Strawberry</option>
        <option>Pista</option>
        <option>Mango</option>
        <option>Browny</option>
        <option>Blueberry</option>


    </select>

    <label for="quantity">Quantity:</label>
    <input type="number" name="quantity" id="quantity" min="1" max="10" required>

    <div class="checkbox-label">
        <input type="checkbox" name="takeAway" id="takeAway" value="true">
        <label for="takeAway">Take Away</label>
    </div>

    <label for="coupon">Coupon Code:</label>
    <input type="text" name="coupon" id="coupon">

    <label for="addOns">Add-ons (comma separated):</label>
    <input type="text" name="addOns" id="addOns" placeholder="Nuts, Chocolate Chips" required>

    <button type="submit">Submit Order</button>
</form>

<footer>
    &copy; <%= java.time.Year.now() %> Ice Cream Parlor. All rights reserved.
</footer>

</body>
</html>
