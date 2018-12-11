package com.dxc.ppmadminadapter.model;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PATIENT_ID")
    private String patientId;

    @Column(name = "DELETED")
    private boolean deleted;
}
