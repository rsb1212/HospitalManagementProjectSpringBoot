package com.example.demo.controller;

import com.example.demo.modul.Bill;
import com.example.demo.service.BillService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Bill")
public class BillController {

    private BillService billService;
    public BillController(BillService billService){
        this.billService=billService;
    }
    @GetMapping
    public List<Bill> getAllBills(){
        System.out.println("get all the bill from database");
        return billService.getAllBill();
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill){
        System.out.println("Bill created");
        return  billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public Optional<Bill> getBillById(@PathVariable Long id){
        System.out.println("get bill by id ");
        return billService.getBillById(id);
    }

    @DeleteMapping("/{id}")
    public  void deleteBillById(@PathVariable long id){
        billService.deleteBillById(id);
        System.out.println("delete bill by id");
    }

    @PutMapping
    public Bill updateBillById(@PathVariable Long id,@RequestBody Bill bill){
        System.out.println("update data by id");
        return billService.updateBillById(id,bill);
    }
}
