package com.bcafinance.jec_ujian_week_4.models;
/*
Created By IntelliJ IDEA 2022.2.3 (Ultimate Edition)
@Author Jett a.k.a. Jett Enrico Chandra
CTO
Created on 09/12/2022
@Last Modified 09/12/2022 13.33
Version 1.0
*/

import com.bcafinance.jec_ujian_week_4.utils.ConstantMessage;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "MstInstallment")
public class UjianAkhir implements Serializable {
    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull(message = ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_CONSUMEN_ID) //"VARIABEL 1 WAJIB DIISI" (PINDAHKAN PESAN KE ConstantMessage)
    @Column(name = "ConsumenId" ,nullable = false)
    private Integer consumenId;

    @NotNull(message = ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_INSTALLMENT)//"VARIABEL 2 WAJIB DIISI" (PINDAHKAN PESAN KE ConstantMessage)
    @Column(name = "Installment" ,nullable = false)
    private Double installment;

    @NotEmpty(message = ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_CAR_NAME)//"VARIABEL 3 WAJIB DIISI" (PINDAHKAN PESAN KE class ConstantMessage)
    @Column(name = "CarName",nullable = false)
    private String carName ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConsumenId() {
        return consumenId;
    }

    public void setConsumenId(Integer consumenId) {
        this.consumenId = consumenId;
    }

    public Double getInstallment() {
        return installment;
    }

    public void setInstallment(Double installment) {
        this.installment = installment;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
