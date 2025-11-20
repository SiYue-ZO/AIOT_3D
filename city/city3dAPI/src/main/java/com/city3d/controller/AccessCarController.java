package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.AccessCar;
import com.city3d.service.AccessCarService;

@Controller
@RequestMapping("/accessCar")
public class AccessCarController {
    @Autowired
    private AccessCarService accessCarService;

    @RequestMapping("/getAccessCar")
    public @ResponseBody List<AccessCar> getAccessCar() {
        return accessCarService.getAccessCar();
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody AccessCar accessCar) throws Exception {
        return accessCarService.deleteByPrimaryKey(accessCar.getAccessCarId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<AccessCar> accessCars) throws Exception {
        List<String> accessCarIds = new ArrayList<>();
        for (AccessCar accessCar : accessCars) {
            accessCarIds.add(accessCar.getAccessCarId());
        }
        return accessCarService.batchDelete(accessCarIds);
    }
}
