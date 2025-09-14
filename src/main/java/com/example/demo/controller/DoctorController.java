package com.example.demo.controller;

import com.example.demo.modul.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }
    @GetMapping
    public List<Doctor> getAllDoctor(){
        System.out.println("all doctor form database");
        return  doctorService.getAllDoctor();
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        System.out.println("doctor is created in database");
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id){
        System.out.println("get doctor by id");
        return doctorService.getDoctorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable Long id){
        System.out.println("Doctor delete from database ");
        doctorService.deleteDoctor(id);
    }

    @PostMapping("/{id}")
    public Doctor updateDoctorById(@PathVariable Long id,@RequestBody Doctor doctor){
        System.out.println("update doctor by id");
        return  doctorService.updateDoctorById(id,doctor);
    }
}
