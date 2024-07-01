package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "tagihan_spp")
public class TagihanSPP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_transaksi")
    @JsonProperty("id_transaksi")
    private int idTransaksi;

    @Column(name = "id_siswa")
    @JsonProperty("id_siswa")
    private int idSiswa;

    @Column(name = "id_ta")
    @JsonProperty("id_ta")
    private int idTa;

    @Column(name = "jml_bayar")
    @JsonProperty("jml_bayar")
    private float jmlBayar;

    @Column(name = "tgl_bayar")
    @JsonProperty("tgl_bayar")
    private LocalDate tglBayar;

    @Column(name = "status")
    @JsonProperty("status")
    private boolean status;

}
