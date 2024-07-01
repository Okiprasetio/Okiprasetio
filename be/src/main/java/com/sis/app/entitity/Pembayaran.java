package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_ta")
    @JsonProperty("id_ta")
    private int idTa;

    @Column(name = "id_siswa")
    @JsonProperty("id_siswa")
    private int idSiswa;

    @Column(name = "tgl_pembayaran")
    @JsonProperty("tgl_pembayaran")
    private LocalDate tglPembayaran;

    @Column(name = "jumlah_bayar")
    @JsonProperty("jumlah_bayar")
    private int jumlahBayar;

    @Column(name = "metode_bayar")
    @JsonProperty("metode_bayar")
    private int metodeBayar;

    @ManyToOne
    @JoinColumn(name = "id_ta", insertable = false, updatable = false)
    private TahunAjaran tahunAjaran;

    @ManyToOne
    @JoinColumn(name = "id_siswa", insertable = false, updatable = false)
    private Siswa siswa;

    @OneToMany(mappedBy = "pembayaran")
    private List<Transaksi> transaksiList;

}
