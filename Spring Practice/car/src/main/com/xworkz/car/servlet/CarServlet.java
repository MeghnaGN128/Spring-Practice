package main.com.xworkz.car.servlet;

import main.com.xworkz.car.dto.CarDto;
import main.com.xworkz.car.dto.service.CarService;
import main.com.xworkz.car.dto.service.CarServiceImplimentation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/car")
public class CarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carname=req.getParameter("carname");
        String regnumber=req.getParameter("regnumber");
        String location=req.getParameter("location");

        CarDto carDto=new CarDto();
        carDto.setCarname(carname);
        carDto.setRegnumber(regnumber);
        carDto.setLocation(location);
        System.out.println("fetched data from Front end"+carDto);

        CarService carService=new CarServiceImplimentation();
        boolean save=carService.verfication(carDto);
        if(save==true){
            System.out.println("Data was to Repository succefully");
        }
        else{
            System.out.println("Data was not passed");
        }
    }
}
