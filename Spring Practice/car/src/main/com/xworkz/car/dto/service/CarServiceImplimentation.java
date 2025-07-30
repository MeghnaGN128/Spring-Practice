package main.com.xworkz.car.dto.service;

import main.com.xworkz.car.dto.CarDto;
import main.com.xworkz.car.dto.repository.CarRepo;
import main.com.xworkz.car.dto.repository.CarRepoImplimentation;

public class CarServiceImplimentation implements CarService{
    @Override
    public boolean verfication(CarDto carDto) {
        if(carDto!=null){
            if(carDto.getCarname().length()>3){
                System.out.println("Car Name is valid");
                CarRepo carRepo=new CarRepoImplimentation();
                return carRepo.peristant(carDto);
            }
        }
        System.out.println("Car is  not valid");
        return false;
    }
}
