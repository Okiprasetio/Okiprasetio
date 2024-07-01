package com.sis.app.impl;

import com.sis.app.entitity.Transaksi;
import com.sis.app.repo.TransaksiRepo;
import com.sis.app.service.TransaksiService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TransaksiServiceImpl implements TransaksiService {

    @Autowired
    private TransaksiRepo transaksiRepo;

    @Override
    public BaseResponse getAllTransaksi(int page, int limit, String search) {
        List<Transaksi> transaksi = new ArrayList<>();
        HashMap<String, Object> addEntity = new HashMap<>();
        if (page < 0 || limit < 0) {
            transaksi = transaksiRepo.findAll();
        } else {
            Pageable pageable = Pageable.ofSize(limit).withPage(page);
            Page<Transaksi> transaksiPage = transaksiRepo.findAll(pageable);
            transaksi = transaksiPage.toList();

            addEntity.put("totalPage", transaksiPage.getTotalPages());
            addEntity.put("totalData", transaksiPage.getTotalElements());
            addEntity.put("numberOfData", transaksiPage.getNumberOfElements());
            addEntity.put("number", transaksiPage.getNumber());
        }

        return new BaseResponse(true, "", transaksi, addEntity);
    }

    @Override
    public BaseResponse getTransaksiById(int id) {
        return new BaseResponse(true, "", transaksiRepo.findById(id).orElse(null));
    }

    @Override
    public BaseResponse saveTransaksi(Transaksi transaksi) {
        return new BaseResponse(true, "", transaksiRepo.save(transaksi));
    }

    @Override
    public BaseResponse deleteTransaksi(int id) {
        transaksiRepo.deleteById(id);
        return new BaseResponse(true, "", null);
    }
}
