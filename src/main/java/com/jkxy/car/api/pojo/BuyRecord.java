package com.jkxy.car.api.pojo;

import java.util.Date;

public class BuyRecord {
    private int id;
    private int carId; //车辆id
    private String userName; //购买用户姓名
    private int buyQuantity; //购买数量
    private Date buyTime; //购买时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public String toString() {
        return "BuyRecord{" +
                "id=" + id +
                ", carId=" + carId +
                ", userName='" + userName + '\'' +
                ", buyQuantity=" + buyQuantity +
                ", buyTime=" + buyTime +
                '}';
    }
}
