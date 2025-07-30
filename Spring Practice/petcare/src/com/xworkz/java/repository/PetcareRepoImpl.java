package com.xworkz.java.repository;


import com.xworkz.java.dto.PetcareDTO;

public class PetcareRepoImpl implements PetcareRepo{

    @Override
    public boolean persist(PetcareDTO petcareDTO) {
        if(petcareDTO!=null){
            System.out.println("petcareDTO is valid");
        }else
            System.out.println("petcareDTO is invalid");
        return false;
    }
}
