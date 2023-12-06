package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @PreAuthorize("hasAuthority('GROUP_PROVIDERS')")
    @PostMapping("/createBill")
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        return ResponseEntity.ok().body(service.createBill(bill));
    }

    @GetMapping("/findByUserId/{id}")
    public ResponseEntity<List<Bill>> findByUserId(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findByUserId(id));
    }
}
