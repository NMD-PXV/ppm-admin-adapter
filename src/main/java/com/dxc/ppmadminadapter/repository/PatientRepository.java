package com.dxc.ppmadminadapter.repository;

import com.dxc.ppmadminadapter.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p.patientId from Patient p where p.patientId in :patientIds and p.deleted = false")
    List<String> findPatientIds(@Param("patientIds") List<String> patientIds);

    Patient findByPatientId (String id);


}
