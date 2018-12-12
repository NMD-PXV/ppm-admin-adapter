package com.dxc.ppm.patientadapter.service;


import com.dxc.ppm.patientadapter.common.PatientStorageError;
import com.dxc.ppm.patientadapter.exception.PatientException;
import com.dxc.ppm.patientadapter.model.Patient;
import com.dxc.ppm.patientadapter.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<String> checkDeletedProfiles(List<String> patientIds) {
        List<String> ids = patientRepository.findPatientIds(patientIds);
        if(ids.isEmpty())
            throw new PatientException(PatientStorageError.PATIENT_NOT_FOUND);
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
