package com.bcafinance.jec_ujian_week_4.dto;

public class PageInfoDTO {

//    Map<String,Object> map = new HashMap<String,Object>();
//        map.put("content",lCit);
//        map.put("pageSize",pCit.getTotalPages());
//        map.put("totalElements",pCit.getTotalElements());
//        map.put("size",pCit.getSize());
//        map.put("sort",pCit.getSort());
//        map.put("sort",pCit.get);

    private int totalPage;
    private long totalElemeent;
    private int size;
    private int number;
    private int numberOfElements;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalElemeent() {
        return totalElemeent;
    }

    public void setTotalElemeent(long totalElemeent) {
        this.totalElemeent = totalElemeent;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }
}
