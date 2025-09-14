package com.example.demo.controller;
import com.example.demo.modul.Appointment;
import com.example.demo.service.AppointmentService;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Appointment")
public class AppointmentController {
    private AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService=appointmentService;
    }
    @GetMapping
    public List<Appointment> getAllAppointment(){
        System.out.println("all appointments ");
        return appointmentService.getAllAppointments();
    }
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment){
        System.out.println("appointment  created successfully");
        return  appointmentService.createAppointment(appointment);
    }
    @GetMapping("/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable Long id){
        System.out.println("Appointment get by id");
        return appointmentService.getAppointmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id){
        System.out.println("Appointment deleted successfully");
    }

    @PutMapping("/{id}")
    public Appointment updateAppointmentById(@PathVariable Long id,@RequestBody Appointment appointment){
        System.out.println("Appointment upDated ");
        return  appointmentService.updateAppointmentById(id,appointment);
    }
}
