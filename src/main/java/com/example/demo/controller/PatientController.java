package com.example.demo.controller;

import com.example.demo.modul.Patient;
import com.example.demo.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
    private PatientService patientService;
    public PatientController(PatientService patientService){
       this.patientService=patientService;
   }
    @GetMapping
    public List<Patient> getAllPatient(){
        System.out.println("all the patient details");
        List<Patient> patient= patientService.getAllPatient();
        return patient;
    }
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        System.out.println("new patient is created");
        return  patientService.createPatient(patient);
    }
    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id){
        System.out.println("patient by is ");
        return patientService.getPatientById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePatentById(@PathVariable Long id){
        System.out.println("patient deleted from database");
        patientService.deletePatientById(id);
    }
    @PutMapping("/{id}")
    public Patient updatePatientById(@PathVariable Long id,@RequestBody Patient patient){
        System.out.println("Patient Updated");
        return  patientService.updatePatientById(id,patient);
    }
}
