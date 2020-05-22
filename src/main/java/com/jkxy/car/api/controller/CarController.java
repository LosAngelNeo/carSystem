package com.jkxy.car.api.controller;

import com.jkxy.car.api.pojo.BuyRecord;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.QueryConditions;
import com.jkxy.car.api.pojo.StockRecord;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {
        List<Car> cars = carService.findAll();
        return JSONResult.ok( cars );
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById( id );
        return JSONResult.ok( car );
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName( carName );
        return JSONResult.ok( cars );
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById( id );
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById( car );
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar( car );
        return JSONResult.ok();
    }

    /**
     * 通过车名和车系名模糊查询
     *
     * @param condition
     * @return
     */
    @PostMapping("findByKeyword")
    public JSONResult findByKeyword(QueryConditions condition) {
        int totalCount = carService.countByKeyword( condition );
        List<Car> list = new ArrayList<>();
        if (condition.getCarName() == null) {
            condition.setCarName( "" );
        }
        if (condition.getCarSeries() == null) {
            condition.setCarSeries( "" );
        }
        if (totalCount > 0) {
            list = carService.findByKeyword( condition );
        }
        return JSONResult.ok( list );
    }

    /**
     * 通过id购买多辆车
     *
     * @param record
     * @return
     */
    @PostMapping("buyCarById")
    public JSONResult buyCarById(BuyRecord record) {
        StockRecord stockRecord = carService.findStockRecordById( record.getCarId() );
        int currStock = stockRecord.getInventory() - stockRecord.getSellCount();
        if (record.getBuyQuantity() < currStock) {
            int sellCount = stockRecord.getSellCount() + record.getBuyQuantity();
            stockRecord.setSellCount( sellCount );
            carService.updateStockRecord( record );
            carService.insertBuyRecord( record );

        } else {
            return JSONResult.errorMsg( "库存数量不足,当前库存:" + currStock );
        }

        return JSONResult.ok();
    }
}
