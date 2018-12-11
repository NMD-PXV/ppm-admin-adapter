package com.dxc.ppmadminadapter.delegate;

import com.dxc.ppmadminadapter.api.V1ApiDelegate;
import com.dxc.ppmadminadapter.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class V1ApiDelegateImp implements V1ApiDelegate {

    @Autowired
    private AdminService adminService;

    @Override
    public ResponseEntity<List<String>> addPatientProfiles(List<String> patientIds) {
        return ResponseEntity.ok(adminService.addPatientProfiles(patientIds));
    }

    @Override
    public ResponseEntity<List<String>> checkDeletedProfiles(List<String> patientIds) {
        return ResponseEntity.ok(adminService.checkDeletedProfiles(patientIds));
    }

    @Override
    public ResponseEntity<String> deletePatientProfiles(List<String> patientIds) {
        return ResponseEntity.ok(adminService.deletePatientProfiles(patientIds));
    }
}
