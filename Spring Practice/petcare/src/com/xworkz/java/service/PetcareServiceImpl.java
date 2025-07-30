package com.xworkz.java.service;

import com.xworkz.java.dto.PetcareDTO;
import com.xworkz.java.repository.PetcareRepo;
import com.xworkz.java.repository.PetcareRepoImpl;

public class PetcareServiceImpl implements PetcareService {
    @Override
    public boolean present(PetcareDTO petcareDTO) {
        if (petcareDTO == null) {
            System.out.println("petcareDTO is null");
        }

        boolean isValid = true;

        String name = petcareDTO.getName();
        if (name != null && name.length() < 20) {
            System.out.println("Name is valid");
        } else {
            System.out.println("Name is invalid");
            isValid = false;
        }

        int id = petcareDTO.getId();
        if (id > 0) {
            System.out.println("ID is valid");
        } else {
            System.out.println("ID is invalid");
            isValid = false;
        }

        String location = petcareDTO.getLocation();
        if (location != null && location.length() < 20) {
            System.out.println("Location is valid");
        } else {
            System.out.println("Location is invalid");
            isValid = false;
        }

        boolean hasService = petcareDTO.isHasservice();
        if (hasService) {
            System.out.println("Service availability is valid");
        }
      PetcareRepo petcareRepo=new PetcareRepoImpl();
        return petcareRepo.persist(petcareDTO)
            return false;
        }
    }
