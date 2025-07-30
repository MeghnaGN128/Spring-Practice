package com.xworkz.java.repository;

import com.xworkz.java.dto.PetcareDTO;

public interface PetcareRepo {
    boolean persist(PetcareDTO petcareDTO);
}
