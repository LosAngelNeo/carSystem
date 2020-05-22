package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.BuyRecord;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.QueryConditions;
import com.jkxy.car.api.pojo.StockRecord;

import java.util.List;


public interface CarService {

    List<Car> findAll();

    Car findById(int id);

    List<Car> findByCarName(String carName);

    void deleteById(int id);

    void updateById(Car car);

    void insertCar(Car car);

    int countByKeyword(QueryConditions condition);

    List<Car> findByKeyword(QueryConditions condition);

    StockRecord findStockRecordById(int carId);

    void insertBuyRecord(BuyRecord record);

    void updateStockRecord(BuyRecord record);
}
