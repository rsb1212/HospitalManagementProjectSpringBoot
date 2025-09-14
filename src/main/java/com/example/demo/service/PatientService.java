package com.example.demo.service;

import com.example.demo.modul.Patient;
import com.example.demo.repository.PatientRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private PatientRepository patientRepository;
    public  PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
    public static final org.slf4j.Logger logger= LoggerFactory.getLogger(PatientService.class);
    public List<Patient> getAllPatient(){
        try{
            logger.error(" get all Patient list:{}");
            return patientRepository.findAll();
        } catch (Exception e) {
            logger.error("error in get all Patient list:{}",e.getMessage());
            return  null;
        }
    }
    public Patient createPatient(Patient patient){
        try{
            logger.info("Patient Created successfully !");
           return patientRepository.save(patient);
        } catch (Exception e) {
            logger.error("error in  createPatient :{}",e.getMessage());
            return patient;
        }
    }

    public Optional<Patient> getPatientById(Long id){
        try{
           return patientRepository.findById(id);
        } catch (Exception e) {
            logger.error("error in getPatientById :{}",e.getMessage());
            return null;
        }
    }

    public void deletePatientById(Long id){
        try{
            logger.info("Doctor deleted successfully !");
            patientRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("error in deletePatientById :{}",e.getMessage());
        }
    }
    public Patient updatePatientById(Long id,Patient patient){
        try{
            Optional<Patient> existingPatient=patientRepository.findById(id);
            if (existingPatient.isPresent()){
                Patient p=existingPatient.get();
                p.setAge(patient.getAge());
                p.setName(patient.getName());
                p.setGender(patient.getGender());
                return  patientRepository.save(patient);
            }
            else {
                logger.info("Patient not found with id:{}",id);
                return null;
            }
        } catch (Exception e) {
            logger.error("error in updatePatientById :{}",e.getMessage());
            return null;
        }
    }
}
