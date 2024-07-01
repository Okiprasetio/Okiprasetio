package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
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
    private Date tglBayar;

    @Column(name = "status")
    @JsonProperty("status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_transaksi", insertable = false, updatable = false)
    private Transaksi transaksi;

    @ManyToOne
    @JoinColumn(name = "id_siswa", insertable = false, updatable = false)
    private Siswa siswa;

    @ManyToOne
    @JoinColumn(name = "id_ta", insertable = false, updatable = false)
    private TahunAjaran tahunAjaran;
}
