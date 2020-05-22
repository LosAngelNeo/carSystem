package com.jkxy.car.api.pojo;

public class QueryConditions {
    private int currPage;  //开始显示的页数
    private int pageSize;   //每页显示的记录数
    private String carName; //车名
    private String carSeries; //车系名

    public int getCurrPage() {
        return currPage - 1;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }
}

