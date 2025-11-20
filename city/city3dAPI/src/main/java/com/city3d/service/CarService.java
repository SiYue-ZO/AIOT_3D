package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Car;

public interface CarService {
    List<Car> getPoliceCarList();

    List<Car> getPoliceCarListPart(String[] carLicenses);

    int insert(Car car);

    int updateByPrimaryKey(Car car);

    int deleteByPrimaryKey(String carId);

    Car getCarAndEquipmentsByPuid(String carId);

    List<Car> findCarByPuid(String carId);
}
