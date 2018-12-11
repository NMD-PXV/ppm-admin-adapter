package com.dxc.ppmadminadapter.service;

import com.dxc.ppmadminadapter.common.AdminStorageError;
import com.dxc.ppmadminadapter.exception.AdminException;
import com.dxc.ppmadminadapter.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.dxc.ppmadminadapter.common.AdminStorageError.PATIENT_NOT_FOUND;

@Service
public class AdminService {

    @Autowired
    private PatientRepository patientRepository;

    public List<String> checkDeletedProfiles(List<String> patientIds) {
        List<String> ids = patientRepository.findPatientId(patientIds);
        if(ids.isEmpty())
            throw new AdminException(PATIENT_NOT_FOUND);
        return patientRepository.findPatientId(patientIds);
    }
}
