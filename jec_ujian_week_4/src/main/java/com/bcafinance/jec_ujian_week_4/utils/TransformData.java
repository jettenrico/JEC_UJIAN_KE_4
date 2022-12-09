package com.bcafinance.jec_ujian_week_4.utils;

import com.bcafinance.jec_ujian_week_4.dto.PageInfoDTO;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransformData {

    public Map<String,Object> getDataPaging(List<?> ls ,  Page<?> page)
    {
        Map <String,Object> map = new HashMap<String, Object>();
        PageInfoDTO pageInfoDTO = new PageInfoDTO();
        pageInfoDTO.setNumber(page.getNumber());
        pageInfoDTO.setNumberOfElements(page.getNumberOfElements());
        pageInfoDTO.setTotalPage(page.getTotalPages());
        pageInfoDTO.setSize(page.getSize());
        pageInfoDTO.setTotalElemeent(page.getTotalElements());
        map.put("content",ls);
        map.put("pageInfo",pageInfoDTO);

        return map;

    }
}