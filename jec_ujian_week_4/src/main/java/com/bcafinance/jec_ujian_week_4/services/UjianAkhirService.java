package com.bcafinance.jec_ujian_week_4.services;

import com.bcafinance.jec_ujian_week_4.handler.ResourceNotFoundException;
import com.bcafinance.jec_ujian_week_4.models.UjianAkhir;
import com.bcafinance.jec_ujian_week_4.repos.UjianAkhirRepo;
import com.bcafinance.jec_ujian_week_4.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UjianAkhirService {

    private UjianAkhirRepo ujianAkhirRepo;

    @Autowired
    public UjianAkhirService(UjianAkhirRepo ujianAkhirRepo) {
        this.ujianAkhirRepo = ujianAkhirRepo;
    }
    @Transactional(rollbackFor = Exception.class)
        public void saveInstallmentQuery(UjianAkhir ujianAkhir) throws Exception{
        Integer consId = ujianAkhir.getConsumenId();
        Double install = ujianAkhir.getInstallment();
        String name = ujianAkhir.getCarName();
        if(consId == null) throw new ResourceNotFoundException(ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_CONSUMEN_ID);
        if(install == null) throw new ResourceNotFoundException(ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_INSTALLMENT);
        if(name == null) throw new ResourceNotFoundException(ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_CAR_NAME);

        ujianAkhirRepo.insertInstallments(consId, install, name);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllInstallments(List<UjianAkhir> lsins){
        ujianAkhirRepo.saveAll(lsins);
    }

    public Page<UjianAkhir> findAllInstallment(Pageable pageable)
    {
        return ujianAkhirRepo.findAll(pageable);
    }
}