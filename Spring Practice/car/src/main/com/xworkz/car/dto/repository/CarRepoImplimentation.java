package main.com.xworkz.car.dto.repository;

import main.com.xworkz.car.dto.CarDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CarRepoImplimentation implements CarRepo {
    @Override
    public boolean peristant(CarDto carDto) {
        if(carDto!=null){
            String URL="jdbc:mysql://localhost:3306/carmanagement";
            String USERNAME="root";
            String PASSWORD="Meghna@8122002";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
                String Sql="insert into car_deatails values(0,'"+carDto.getCarname()+"','"+carDto.getRegnumber()+"','"+carDto.getLocation()+"')";
                Statement statement=connection.createStatement();
                statement.executeUpdate(Sql);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
}
