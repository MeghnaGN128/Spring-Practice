package com.xworkz.application.repository;

import com.xworkz.application.entity.ApplicationEntity;

import java.util.Optional;

public interface ApplicationRepository {
    boolean saveApplication(ApplicationEntity applicationEntity);
     Optional<ApplicationEntity>findById(int id);
     boolean deleteById(int id);
     boolean updateById(int id,String company);
}
