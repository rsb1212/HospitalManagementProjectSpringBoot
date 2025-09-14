package com.example.demo.service;

import com.example.demo.modul.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    public static final Logger logger=LoggerFactory.getLogger(AppointmentService.class);
    private AppointmentRepository appointmentRepository;
    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }
    public List<Appointment> getAllAppointments(){
        try{
            return  appointmentRepository.findAll();
        }catch (Exception e){
            logger.error("error accor during getting all appointment {}",e.getMessage());
            return  null;
        }
    }

    public Appointment createAppointment(Appointment appointment){
        try{
             appointmentRepository.save(appointment);
            return appointment;
        }catch (Exception e){
            logger.error("error accor during create appointment {}",e.getMessage());
            return  appointment;
        }
    }

    public Optional<Appointment> getAppointmentById(Long  id){
        try{
            Optional<Appointment> appointment=appointmentRepository.findById(id);
            return appointment;
        }catch (Exception e){
            logger.error("error accor during getting appointment by id {}",e.getMessage());
            return  null;
        }
    }
    public Appointment updateAppointmentById(Long  id,Appointment appointment){
        try{
            Optional<Appointment> existingAppo=appointmentRepository.findById(id);

            if (existingAppo.isPresent()){
                Appointment a=existingAppo.get();
                a.setDate(appointment.getDate());
                a.setDoctorId(appointment.getDoctorId());
                a.setPatientId(appointment.getPatientId());
                appointmentRepository.save(appointment);
                return appointment;
            }
            else {
                logger.error("Appointment with id :{}",id);
                return null;
            }

        }catch (Exception e){
            logger.error("error accor during update appointment {}",e.getMessage());
            return  null;
        }
    }

    public void deleteAppointmentById(Long  id){
        try{
            appointmentRepository.deleteById(id);
            logger.info("Appointment Deleted Successfully !");
        }catch (Exception e){
            logger.error("error accor during delete  appointment {}",e.getMessage());
        }
    }
}
