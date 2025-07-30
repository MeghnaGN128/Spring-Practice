<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>
        car-reg-management-portal
    </title>
</head>
<body>
<a href="index.jsp">Home</a>
<form action="car" method="post">
    <div align="center">
        <h1>Fill the below Details</h1><br><br>
        Car Name:<input type="text" placeholder="Enter the car name" name="carname"/><br><br>
        Car Reg Number:<input type="text" placeholder="Enter the car Reg number" name="regnumber"/><br><br>
        Car Location:<input type="text" placeholder="Enter the car Rlocation" name="location"/><br><br>
        <input type="submit" value="Reg"/>
    </div>
</form>

</body>
</html>