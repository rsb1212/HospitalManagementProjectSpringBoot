package com.example.demo.service;
import com.example.demo.modul.Appointment;
import com.example.demo.modul.Bill;
import com.example.demo.repository.BillRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    public static final org.slf4j.Logger logger=LoggerFactory.getLogger(BillService.class);

    private BillRepository billRepository;
    public BillService(BillRepository billRepository){
        this.billRepository=billRepository;
    }
    public List<Bill> getAllBill(){
        try{
            return billRepository.findAll();
        }catch (Exception e){
            logger.error("error in get get all details Bo bill:{}",e.getMessage());
            return  null;
        }
    }

    public Bill createBill(Bill bill){
        try{
            return billRepository.save(bill);
        }catch (Exception e){
            logger.error("error in new bill created:{}",e.getMessage());
            return  bill;
        }
    }

    public Optional<Bill> getBillById(Long id){
        try{
           Optional<Bill> billrepo= billRepository.findById(id);
           return billrepo;
        }catch (Exception e){
            logger.error("error in get bill by id:{}",id,e.getMessage());
            return  null;
        }
    }
    public Bill updateBillById(Long id,Bill bill){
        try{
            Optional<Bill> existingBill=billRepository.findById(id);

            if (existingBill.isPresent()){
                Bill b=existingBill.get();
                b.setAmount(bill.getAmount());
                b.setStatus(bill.getStatus());
                b.setPatientId(bill.getPatientId());
                billRepository.save(bill);
                logger.info("Bill Updated with id:{}",id);
                return bill;
            }
            else {
                logger.error("bill not found with this id:{}",id);
                return null;
            }
        }catch (Exception e){
            logger.error("error in update bill by id:{}",e.getMessage());
            return  null;
        }
    }
    public void deleteBillById(Long id){
        try{
            billRepository.deleteById(id);
            logger.info("Bill Deleted Successfully !");
        } catch (Exception e) {
            logger.error("error in delete bill by id:{}",e.getMessage());
        }
    }
}
