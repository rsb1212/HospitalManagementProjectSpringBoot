package com.example.demo.service;

import com.example.demo.modul.Doctor;
import com.example.demo.modul.Patient;
import com.example.demo.repository.DoctorRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    public static final org.slf4j.Logger logger= LoggerFactory.getLogger(DoctorService.class);

    private DoctorRepository doctorRepository;
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }
    public List<Doctor> getAllDoctor(){
        try{
            return doctorRepository.findAll();
        } catch (Exception e) {
            logger.error("error in get all doctor list:{}",e.getMessage());
            return  null;
        }
    }
    public Optional<Doctor> getDoctorById(Long id){
        try{
           return doctorRepository.findById(id);
        } catch (Exception e) {
            logger.error("error in get  doctor by id:{}",e.getMessage());
            return  null;
        }
    }
    public Doctor createDoctor(Doctor doctor){
        try {
            logger.info("Doctor Entity is created !");
            return doctorRepository.save(doctor);
        }catch (Exception e){
            logger.error("error in create doctor list:{}",e.getMessage());
            return doctor;
        }
    }
    public Doctor updateDoctorById(Long id,Doctor doctor){
        try {

            Optional<Doctor> existingDoctor=doctorRepository.findById(id);
            if (existingDoctor.isPresent()){
                Doctor d=existingDoctor.get();
                d.setAge(doctor.getAge());
                d.setGender(doctor.getGender());
                d.setSpeciality(doctor.getSpeciality());
                doctorRepository.save(doctor);
                return doctor;
            }
            else {
                logger.error("Doctor not found with id:{}",id);
                return null;
            }

        }catch (Exception e){
            logger.error("error in update doctor list:{}",e.getMessage());
            return null;
        }
    }
    public void deleteDoctor(Long id){
        try {
            doctorRepository.deleteById(id);
            logger.info("Doctor deleted successfully !");
        }catch (Exception e){
            logger.error("error in delete doctor list:{}",e.getMessage());
        }
    }
}
