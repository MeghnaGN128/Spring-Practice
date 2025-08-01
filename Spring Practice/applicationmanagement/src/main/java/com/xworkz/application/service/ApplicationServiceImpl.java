package com.xworkz.application.service;

import com.xworkz.application.entity.ApplicationEntity;
import com.xworkz.application.repository.ApplicationRepositortImpl;
import com.xworkz.application.repository.ApplicationRepository;

public class ApplicationServiceImpl implements ApplicationService {
    @Override
    public boolean Check(ApplicationEntity applicationEntity) {
        if (applicationEntity != null) {
            return false;
        } else {
            if (applicationEntity.getApplicationName().isEmpty()) {
                System.out.println("name is invalid");
                return false;
            }
            if (applicationEntity.getApplicationSize().isEmpty()) {
                System.out.println("size is invalid");
                return false;
            }
            if (applicationEntity.getCompany().isEmpty()) {
                System.out.println("company is invalid");
                return false;
            }
            if (applicationEntity.getNoOfUsers() == null) {
                System.out.println("noofusers invalid");
                return false;
            }
            if ((applicationEntity.getRatings() == null)) {
                System.out.println("ratings invalid");
                return false;
            }
            if (applicationEntity.getLaunchDate() == null) {
                System.out.println("launcheddate is invalid");
                return false;
            }
            ApplicationRepository applicationRepository=new ApplicationRepositortImpl();
        }
        return false;

        }
    }

