package com.example.msusers.repository;

import com.example.msusers.domain.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillRepository {
    private FeignBillsRepository feignBillsRepository;

    public BillRepository(FeignBillsRepository feignBillsRepository) {
        this.feignBillsRepository = feignBillsRepository;
    }

    public List<Bill> findByUserId(String id_user) {
        ResponseEntity<List<Bill>> response = feignBillsRepository.findByUserId(id_user);
        return response.getBody();
    }

}
