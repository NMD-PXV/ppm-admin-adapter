package com.dxc.ppmadminadapter.delegate;

import com.dxc.ppmadminadapter.api.V1ApiDelegate;
import com.dxc.ppmadminadapter.api.model.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class V1ApiDelegateImp implements V1ApiDelegate {
    @Override
    public ResponseEntity<Patient> readPatientById(String patientId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Patient>> searchPatients(String name, String disease, String medicine) {
        return null;
    }

    @Override
    public ResponseEntity<String> searchTest(String id, String name) {
        return null;
    }

    @Override
    public ResponseEntity<String> upsert(Patient patient) {
        return null;
    }

    @Override
    public ResponseEntity<String> upsertMultiPatients(List<Patient> patients) {
        return null;
    }
}
