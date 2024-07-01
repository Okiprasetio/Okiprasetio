package com.sis.app.controller;

import com.sis.app.entitity.Komponen;
import com.sis.app.impl.KomponenServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/komponen")
public class KomponenServiceController {

    @Autowired
    private KomponenServiceImpl komponenServiceImpl;

    @GetMapping
    public BaseResponse getAllKomponen() {
        return komponenServiceImpl.getAllKomponen();
    }

    @GetMapping("/{id}")
    public BaseResponse getKomponenById(@PathVariable("id") int id) {
        return komponenServiceImpl.getKomponenById(id);
    }

    @PostMapping
    public BaseResponse saveKomponen(Komponen komponen) {
        return komponenServiceImpl.saveKomponen(komponen);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteKomponen(@PathVariable("id") int id) {
        return komponenServiceImpl.deleteKomponen(id);
    }
}