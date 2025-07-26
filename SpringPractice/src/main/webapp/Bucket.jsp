<html>
<body>
<h2>Enter Bucket Details</h2>
<form action="give" method="post">
    Material: <input type="text" name="material" required><br><br>
    Color: <input type="text" name="color" required><br><br>
    Capacity (in liters): <input type="number" step="0.1" name="capacityInLiters" required><br><br>
    Price: <input type="number" step="0.01" name="price" required><br><br>
    Has Handle:
    <input type="radio" name="hasHandle" value="true" checked> Yes
    <input type="radio" name="hasHandle" value="false"> No<br><br>

    <button type="submit">Save Bucket</button>
</form>
</body>
</html>
