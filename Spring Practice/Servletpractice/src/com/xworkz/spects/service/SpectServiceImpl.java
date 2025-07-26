package com.xworkz.spects.service;

import com.xworkz.spects.dto.SpectDTO;

public class SpectServiceImpl implements SpectService{

    @Override
    public boolean save(SpectDTO spectDTO) {
      if(spectDTO==null){
          System.out.println("SpectDTO is invalid");
          return false;
      }
        System.out.println("SpectDTO is valid");
        String shape = spectDTO.getShape();
        if(shape!=null&&shape.length()<6){
            System.out.println("shape is valid");
        }else{
            System.out.println("shape is invalid");
        }

        String brand = spectDTO.getBrand();
        if(brand!=null&&brand.length()<6){
            System.out.println("brand is valid");
        }else {
            System.out.println("brand is invalid");
        }

        String price = spectDTO.getPrice();
        if(price!=null&&price.length()<10000){
            System.out.println("price is valid");
        }else{
            System.out.println("price is invalid");
        }
      return true;
    }

}
