package com.dxc.ppm.patientadapter.delegate;

import com.dxc.ppm.patientadapter.api.V1ApiDelegate;
import com.dxc.ppm.patientadapter.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class V1ApiDelegateImp implements V1ApiDelegate {

    @Autowired
    private PatientService patientService;

    @Override
    public ResponseEntity<List<String>> addPatientProfiles(List<String> patientIds) {
        return ResponseEntity.ok(patientService.addPatientProfiles(patientIds));
    }

    @Override
    public ResponseEntity<List<String>> checkDeletedProfiles(List<String> patientIds) {
        return ResponseEntity.ok(patientService.checkDeletedProfiles(patientIds));
    }

    @Override
    public ResponseEntity<String> deletePatientProfiles(List<String> patientIds) {
        return ResponseEntity.ok(patientService.deletePatientProfiles(patientIds));
    }
}
