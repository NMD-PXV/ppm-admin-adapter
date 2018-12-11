package com.dxc.ppmadminadapter.service;


import com.dxc.ppmadminadapter.model.Patient;
import com.dxc.ppmadminadapter.common.AdminStorageError;
import com.dxc.ppmadminadapter.exception.AdminException;
import com.dxc.ppmadminadapter.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dxc.ppmadminadapter.common.AdminStorageError.PATIENT_NOT_FOUND;

@Service
public class AdminService {

    @Autowired
    private PatientRepository patientRepository;

    public List<String> checkDeletedProfiles(List<String> patientIds) {
        return patientRepository.findPatientIds(patientIds);
    }

    public List<String> addPatientProfiles(List<String> patientIds) {
        List<String> existedProfiles = patientRepository.findPatientIds(patientIds);
        if(existedProfiles.isEmpty()) {
            return add(patientIds);
        } else {
            patientIds.removeAll(existedProfiles);
            return add(patientIds);
        }
    }

    public List<String> add(List<String> patientIds) {
        for (String id: patientIds) {
            Patient patient = new Patient();
            patient.setPatientId(id);
            patient.setDeleted(false);
            patientRepository.saveAndFlush(patient);
        }
        return patientIds;
    }

    public String deletePatientProfiles(List<String> patientIds) {
        StringBuffer buffer = new StringBuffer();
       for(String id :patientIds) {
           Patient patient = patientRepository.findByPatientId(id);
           if(patient != null) {
               patient.setDeleted(true);
               patientRepository.save(patient);
               buffer.append(patient.getPatientId());
               buffer.append(": deleted \n");
           } else {
               buffer.append(id);
               buffer.append(": not found \n");
           }
       }
       return buffer.toString();
    }


}
