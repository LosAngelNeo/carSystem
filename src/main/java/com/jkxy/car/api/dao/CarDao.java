package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.BuyRecord;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.QueryConditions;
import com.jkxy.car.api.pojo.StockRecord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "CarDao")
public interface CarDao {
    @Select("select * from carMessage")
    List<Car> findAll();

    @Select("select * from carMessage where id = #{id}")
    Car findById(int id);

    @Select("select * from carMessage where carName = #{carName}")
    List<Car> findByCarName(String carName);

    @Delete("delete from carMessage where id = #{id}")
    void deleteById(int id);

    @Update("update carMessage set carName=#{carName},carType=#{carType},price=#{price},carSeries=#{carSeries} where id = #{id}")
    void updateById(Car car);

    @Insert("insert into carMessage(carName,carType,price,carSeries) values(#{carName},#{carType},#{price},#{carSeries})")
    void insertCar(Car car);

    @Select("select * from ( select * from carMessage where 1=1 and carSeries like concat('%',#{carSeries},'%') and carName like concat('%',#{carName},'%') order by id)p limit #{currPage},#{pageSize} ")
    List<Car> findByKeyword(QueryConditions condition);

    @Select("select count(*) from carMessage where 1=1 and carSeries like concat('%',#{carSeries},'%') and carName like concat('%',#{carName},'%') ")
    int countByKeyword(QueryConditions condition);

    @Select( "select * from stockRecord,carMessage where stockRecord.id = carMessage.id and stockRecord.id = #{carId}  " )
    StockRecord findStockRecordById(int carId);

    @Insert( "insert into buyRecord (carId,userName,buyQuantity,buyTime) values(#{carId},#{userName},#{buyQuantity},now()) " )
    void insertBuyRecord(BuyRecord record);

    @Update( "update stockRecord set sellCount=#{buyQuantity}+sellCount where id=#{carId}" )
    void updateStockRecord(BuyRecord record);
}
