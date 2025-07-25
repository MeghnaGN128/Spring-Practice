<html>
<body>
<h2>Enter Roller Details</h2>
<form action="submit" method="post">
    Brand: <input type="text" name="brand" required><br><br>
    Color: <input type="text" name="color" required><br><br>
    Price: <input type="number" step="0.01" name="price" required><br><br>
    Soft Grip:
    <input type="radio" name="softGrip" value="true" checked> Yes
    <input type="radio" name="softGrip" value="false"> No<br><br>
    Material: <input type="text" name="material" required><br><br>

    <button type="submit">Save Roller</button>
</form>
</body>
</html>
