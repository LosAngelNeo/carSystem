package com.jkxy.car.api.pojo;

public class StockRecord {
    private int id;
    private int inventory; //总库存
    private int sellCount; //已售数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    @Override
    public String toString() {
        return "StockRecord{" +
                "id=" + id +
                ", inventory=" + inventory +
                ", sellCount=" + sellCount +
                '}';
    }
}
