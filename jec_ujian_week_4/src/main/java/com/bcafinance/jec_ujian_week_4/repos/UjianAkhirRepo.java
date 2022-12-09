package com.bcafinance.jec_ujian_week_4.repos;

import com.bcafinance.jec_ujian_week_4.models.UjianAkhir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UjianAkhirRepo extends JpaRepository<UjianAkhir,Long> {
    @Modifying
    @Query(
            value =
                    "insert into MstInstallment (ConsumenId, Installment, CarName)" +
                            " values (:consumenId, :balance, :carName)",
            nativeQuery = true)
    void insertInstallments(@Param("consumenId") Integer consumenId,
                            @Param("balance") Double installment,
                            @Param("carName") String carName);
}