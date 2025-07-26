package com.xworkz.spects.repository;

import com.xworkz.spects.dto.SpectDTO;

public class SpectRepositoryImpl implements SpectRepository{
    @Override
    public boolean persist(SpectDTO spectDTO) {
        System.out.println("persist in SpectRepositoryImpl");
        if(spectDTO!=null){
            System.out.println("spectDTO is valid");
            return true;
        }else {
            System.out.println("spectDTO is invalid");
        }
        return false;
    }
}
