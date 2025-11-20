package com.city3d.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.EmergencyStore;
import com.city3d.service.EmergencyStoreService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/emergencyStore")
public class EmergencyStoreController {
    @Autowired
    private EmergencyStoreService emergencyStoreService;

    @RequestMapping("/getEmergencyStore")
    public @ResponseBody List<HashMap<String, String>> getEmergencyStore() {
        return emergencyStoreService.getEmergencyStore();
    }

    @RequestMapping("/getEmergencyStoreAll")
    public @ResponseBody List<EmergencyStore> getEmergencyStoreAll() {
        return emergencyStoreService.getEmergencyStoreAll();
    }

    @RequestMapping("/getEmergencyStoreById")
    public @ResponseBody EmergencyStore getEmergencyStoreById(String storeId) {
        return emergencyStoreService.getEmergencyStoreById(storeId);
    }

    @RequestMapping("/queryEmergencyStore")
    public @ResponseBody List<EmergencyStore> queryEmergencyStore(@RequestBody EmergencyStore emergencyStore) {
        return emergencyStoreService.queryEmergencyStore(emergencyStore);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody EmergencyStore emergencyStore) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        emergencyStore.setStoreId(uid);
        return emergencyStoreService.insert(emergencyStore);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody EmergencyStore emergencyStore) throws Exception {
        return emergencyStoreService.updateByPrimaryKey(emergencyStore);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(String storeId) throws Exception {
        return emergencyStoreService.deleteByPrimaryKey(storeId);
    }
}