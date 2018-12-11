package com.dxc.ppmadminadapter.service;

import com.dxc.ppmadminadapter.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private PatientRepository patientRepository;

    public List<String> checkDeletedProfiles(List<String> patientIds) {
        return patientRepository.findPatientId(patientIds);
    }

}
