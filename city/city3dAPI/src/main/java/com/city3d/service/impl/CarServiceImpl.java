package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.CarMapperC;
import com.city3d.dao.entry.Car;
import com.city3d.dao.entry.CarExample;
import com.city3d.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapperC carMapperC;

    @Override
    public List<Car> getPoliceCarList() {
        return carMapperC.selectByExample(null);
    }

    @Override
    public List<Car> getPoliceCarListPart(String[] carLicenses) {
        return carMapperC.getPoliceCarListPart(carLicenses);
    }

    @Override
    public int insert(Car car) {
        return carMapperC.insert(car);
    }

    @Override
    public int updateByPrimaryKey(Car car) {
        return carMapperC.updateByPrimaryKey(car);
    }

    @Override
    public int deleteByPrimaryKey(String carId) {
        return carMapperC.deleteByPrimaryKey(carId);
    }

    @Override
    public Car getCarAndEquipmentsByPuid(String carId) {
        return carMapperC.getCarAndEquipmentsByPuid(carId);
    }

    @Override
    public List<Car> findCarByPuid(String carId) {
        CarExample example = new CarExample();
        example.or().andCarIdEqualTo(carId);
        return carMapperC.selectByExample(example);
    }
}
