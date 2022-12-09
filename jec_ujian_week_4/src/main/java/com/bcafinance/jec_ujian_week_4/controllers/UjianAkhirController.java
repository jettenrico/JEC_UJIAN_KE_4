package com.bcafinance.jec_ujian_week_4.controllers;


import com.bcafinance.jec_ujian_week_4.handler.ResourceNotFoundException;
import com.bcafinance.jec_ujian_week_4.handler.ResponseHandler;
import com.bcafinance.jec_ujian_week_4.models.UjianAkhir;
import com.bcafinance.jec_ujian_week_4.services.UjianAkhirService;
import com.bcafinance.jec_ujian_week_4.utils.ConstantMessage;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class UjianAkhirController {

    @Getter
    private UjianAkhirService ujianAkhirService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public UjianAkhirController(UjianAkhirService ujianAkhirService) {
        this.ujianAkhirService = ujianAkhirService;
    }

    @PostMapping("/v1/installments")
    public ResponseEntity<Object>
    saveInstallment(@Valid @RequestBody UjianAkhir ujianAkhir) throws Exception {
        if(ujianAkhir == null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        ujianAkhirService.saveInstallmentQuery(ujianAkhir);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE,
                HttpStatus.OK,null,null,null);
    }

    @PostMapping("/v1/installments/bulk")
    public  ResponseEntity<Object>
    saveAllInstallment(@RequestBody List <UjianAkhir> ujianAkhirs) throws Exception{
        if (ujianAkhirs == null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        ujianAkhirService.saveAllInstallments(ujianAkhirs);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @GetMapping("/v1/installment/search/dto/{size}/{page}")
    public ResponseEntity<Object> pageFindWalletByNameDTO(@PathVariable("size") int size,
                                                          @PathVariable("page") int page )throws Exception {
        Pageable pageable = PageRequest.of(page, size);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK, ujianAkhirService.findAllInstallment(pageable),null,null);

    }

}