package com.dxc.ppmadminadapter.delegate;

import com.dxc.ppmadminadapter.api.V1ApiDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class V1ApiDelegateImp implements V1ApiDelegate {
    @Override
    public ResponseEntity<List<String>> checkDeletedProfiles(List<String> patientIds) {
        return null;
    }
}
