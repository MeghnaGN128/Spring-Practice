package com.xworkz.spects.repository;

import com.xworkz.spects.dto.SpectDTO;

public interface SpectRepository {
    boolean persist(SpectDTO spectDTO);
}
