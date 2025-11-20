package com.city3d.controller;

import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.city3d.dao.entry.SysRoleCar;
import com.city3d.service.SysRoleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.city3d.dao.entry.Car;
import com.city3d.dao.entry.EquipmentRel;
import com.city3d.dao.entry.VehicleRealData;
import com.city3d.service.CarService;
import com.city3d.service.EquipmentRelService;
import com.city3d.service.VehicleRealDataService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private VehicleRealDataService vehicleRealDataService;

    @Autowired
    private EquipmentRelService equipmentRelService;

    @Autowired
    private SysRoleCarService sysRoleCarService;

    @RequestMapping("/getAllCars")
    public @ResponseBody List<Car> getAllCars() {
        return carService.getPoliceCarList();
    }

    @RequestMapping("/getCarRealgpsByPhone")
    public @ResponseBody List<VehicleRealData> getCarRealgpsByPhone(@RequestBody Car car) {
        String phone = car.getCardNum();
        Map<String, Object> params = new HashMap<>();
        params.put("simNo", phone);
        VehicleRealData realData = vehicleRealDataService.getVehicleByPhone(params);
        List<VehicleRealData> realdataList = new ArrayList<VehicleRealData>();
        realdataList.add(realData);
        return realdataList;
    }

    @RequestMapping("/getPoliceCarRealDataPart")
    public @ResponseBody List<Object> getPoliceCarRealDataPart(@RequestBody Car car) {
        List<Car> carList = carService.getPoliceCarListPart(car.getCarLicenses());
        List<String> simNos = new ArrayList<>();
        for (Car car0 : carList) {
            simNos.add(car0.getCardNum());
        }
        List<Object> realdataList = new ArrayList<>();
        List<VehicleRealData> realDatas = vehicleRealDataService.getVehiclePartByPhone(simNos);
        for (int i = 0; i < carList.size(); i++) {
            Map<String, Object> result = new HashMap<>();
            result.put("car", carList.get(i));
            for (VehicleRealData vehicleRealData : realDatas) {
                if (vehicleRealData.getSimNo().equals(carList.get(i).getCardNum())) {
                    result.put("realdata", vehicleRealData);
                    break;
                }
            }
            realdataList.add(result);
        }
        return realdataList;
    }

    @RequestMapping("/getPoliceCarRealData")
    public @ResponseBody List<Object> getPoliceCarRealData() throws Exception {
        List<Car> carList = carService.getPoliceCarList();
        List<String> simNos = new ArrayList<>();
        for (Car car0 : carList) {
            simNos.add(car0.getCardNum());
        }
        List<Object> realdataList = new ArrayList<>();
        List<VehicleRealData> realDatas = vehicleRealDataService.getVehiclePartByPhone(simNos);
        for (int i = 0; i < carList.size(); i++) {
            Map<String, Object> result = new HashMap<>();
            result.put("car", carList.get(i));
            for (VehicleRealData vehicleRealData : realDatas) {
                if (vehicleRealData.getSimNo().equals(carList.get(i).getCardNum())) {
                    result.put("realdata", vehicleRealData);
                    break;
                }
            }
            realdataList.add(result);
        }
        return realdataList;
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("carId") String carId,
                                    @RequestParam("carLicense") String carLicense, @RequestParam("carStyle") String carStyle, @RequestParam("carDate") String carDate,
                                    @RequestParam("driver") String driver, @RequestParam("policeType") String policeType, @RequestParam("cardNum") String cardNum,
                                    @RequestParam("image") String image, @Nullable @RequestParam("equips") List<String> equips, @RequestParam("roleId") String roleId,
                                    HttpServletRequest request) throws Exception {
        Car car = new Car();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/car/car_" + carLicense + extName;
                        car.setImage(fileName);
                        String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                        File newFile = new File(path);
                        //父级目录不在就创建一个
                        if (!newFile.getParentFile().exists()) {
                            newFile.mkdirs();
                        }
                        file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        car.setCarId(uid);
        car.setCarLicense(carLicense);
        car.setCarStyle(carStyle);
        car.setCarDate(carDate);
        car.setDriver(driver);
        car.setPoliceType(policeType);
        car.setCardNum(cardNum);
        int result = carService.insert(car);
        //插入配套设备
        if (equips != null) {
            for (String equipId : equips) {
                EquipmentRel equipmentRel = new EquipmentRel();
                String equipRelId = characterUtils.getUUID();
                equipmentRel.setEquipRelId(equipRelId);
                equipmentRel.setEquipId(equipId);
                equipmentRel.setRelId(uid);
                equipmentRelService.insertEquipmentRel(equipmentRel);
            }
        }
        //插入权属
        CharacterUtils characterUtilsRole = new CharacterUtils();
        String uidRole = characterUtilsRole.getUUID();
        SysRoleCar sysRoleCar = new SysRoleCar();
        sysRoleCar.setRoleCarId(uidRole);
        sysRoleCar.setCarId(uid);
        sysRoleCar.setRoleId(roleId);
        sysRoleCarService.insertSysRoleCar(sysRoleCar);
        return result;
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("carId") String carId,
                                    @RequestParam("carLicense") String carLicense, @RequestParam("carStyle") String carStyle, @RequestParam("carDate") String carDate,
                                    @RequestParam("driver") String driver, @RequestParam("policeType") String policeType, @RequestParam("cardNum") String cardNum,
                                    @RequestParam("image") String image, @Nullable @RequestParam("equips") List<String> equips, HttpServletRequest request) throws Exception {
        equipmentRelService.deleteEquipmentRel(carId);
        Car car = new Car();
        car.setImage(image);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/car/car_" + carLicense + extName;
                        car.setImage(fileName);
                        String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                        File newFile = new File(path);
                        //父级目录不在就创建一个
                        if (!newFile.getParentFile().exists()) {
                            newFile.mkdirs();
                        }
                        file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        car.setCarId(carId);
        car.setCarLicense(carLicense);
        car.setCarStyle(carStyle);
        car.setCarDate(carDate);
        car.setDriver(driver);
        car.setPoliceType(policeType);
        car.setCardNum(cardNum);
        int result = carService.updateByPrimaryKey(car);
        CharacterUtils characterUtils = new CharacterUtils();
        if (equips != null) {
            for (String equipId : equips) {
                EquipmentRel equipmentRel = new EquipmentRel();
                String equipRelId = characterUtils.getUUID();
                equipmentRel.setEquipRelId(equipRelId);
                equipmentRel.setEquipId(equipId);
                equipmentRel.setRelId(carId);
                equipmentRelService.insertEquipmentRel(equipmentRel);
            }
        }
        return result;
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Car car) throws Exception {
        if (car.getImage() != null && !Objects.equals(car.getImage(), "null") && !Objects.equals(car.getImage(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + car.getImage();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        equipmentRelService.deleteEquipmentRel(car.getCarId());
        return carService.deleteByPrimaryKey(car.getCarId());
    }

    @RequestMapping("/getCarAndEquipmentsByPuid")
    public @ResponseBody Map<String, Object> getCarAndEquipmentsByPuid(@RequestBody Car car) {
        Map<String, Object> resultmap = new HashMap<>();
        try {
            Car result = carService.getCarAndEquipmentsByPuid(car.getCarId());
            resultmap.put("carId", result.getCarId());
            resultmap.put("depId", result.getDepId());
            resultmap.put("carLicense", result.getCarLicense());
            resultmap.put("carStyle", result.getCarStyle());
            resultmap.put("carDate", result.getCarDate());
            resultmap.put("driver", result.getDriver());
            resultmap.put("policeType", result.getPoliceType());
            resultmap.put("deviceId", result.getDeviceId());
            resultmap.put("cardNum", result.getCardNum());
            resultmap.put("image", result.getImage());
            resultmap.put("CarEquipments", result.getEquipmentRels());
            Map<String, Object> params = new HashMap<>();
            params.put("simNo", result.getCardNum());
            VehicleRealData realData = vehicleRealDataService.getVehicleByPhone(params);
            if (realData != null) {
                resultmap.put("updateDate", realData.getUpdateDate());
                resultmap.put("velocity", realData.getVelocity());
                resultmap.put("direction", realData.getDirection());
                resultmap.put("gas", realData.getGas());
                resultmap.put("mileage", realData.getMileage());
            } else {
                resultmap.put("updateDate", "");
                resultmap.put("velocity", "");
                resultmap.put("direction", "");
                resultmap.put("gas", "");
                resultmap.put("mileage", "");
            }
        } catch (Exception e) {
            List<Car> result = carService.findCarByPuid(car.getCarId());
            resultmap.put("carId", result.get(0).getCarId());
            resultmap.put("depId", result.get(0).getDepId());
            resultmap.put("carLicense", result.get(0).getCarLicense());
            resultmap.put("carStyle", result.get(0).getCarStyle());
            resultmap.put("carDate", result.get(0).getCarDate());
            resultmap.put("driver", result.get(0).getDriver());
            resultmap.put("policeType", result.get(0).getPoliceType());
            resultmap.put("deviceId", result.get(0).getDeviceId());
            resultmap.put("cardNum", result.get(0).getCardNum());
            resultmap.put("image", result.get(0).getImage());
            resultmap.put("CarEquipments", null);
            Map<String, Object> params = new HashMap<>();
            params.put("simNo", result.get(0).getCardNum());
            VehicleRealData realData = vehicleRealDataService.getVehicleByPhone(params);
            if (realData != null) {
                resultmap.put("updateDate", realData.getUpdateDate());
                resultmap.put("velocity", realData.getVelocity());
                resultmap.put("direction", realData.getDirection());
                resultmap.put("gas", realData.getGas());
                resultmap.put("mileage", realData.getMileage());
            } else {
                resultmap.put("updateDate", "");
                resultmap.put("velocity", "");
                resultmap.put("direction", "");
                resultmap.put("gas", "");
                resultmap.put("mileage", "");
            }
        }
        return resultmap;
    }
}