package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Address;
import com.city3d.service.AddressService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("/getAddress")
    public @ResponseBody List<Address> getAddress() {
        return addressService.getAddress("住宅");
    }

    @RequestMapping("/getAddressById")
    public @ResponseBody Address getAddressById(@RequestBody Address address) {
        return addressService.getAddressById(address.getAddId());
    }

    @RequestMapping("/getAddressByType")
    public @ResponseBody List<Address> getAddressByType() {
        List<Address> result = addressService.getAddressByType("行政");
        List<Address> result1 = addressService.getAddressByType("地点");
        result.addAll(result1);
        return result;
    }

    @RequestMapping("/getAddressByComName")
    public @ResponseBody List<Address> getAddressByComName(@RequestBody Address address) {
        return addressService.getAddressByComName(address.getCommunityName());
    }

    @RequestMapping("/queryAddress")
    public @ResponseBody List<Address> queryAddress(@RequestBody Address address) {
        return addressService.queryAddress(address);
    }

    @RequestMapping("/queryAddressByPolygon")
    public @ResponseBody List<String> queryAddressByPolygon(@RequestBody Address address) {
        return addressService.queryAddressByPolygon(address);
    }

    @RequestMapping("/getNetAllByAddId")
    public @ResponseBody List<Object> getNetAllByAddId(@RequestBody Address address) {
        return addressService.getNetAllByAddId(address.getAddId());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Address address) throws Exception {
        List<Address> AddressList = addressService.getAddressByPid(address.getPid());
        List<String> addNames = new ArrayList<>();
        for (Address add : AddressList) {
            addNames.add(add.getAddName());
        }
        if (addNames.contains(address.getAddName())) {
            return 2;
        } else {
            CharacterUtils characterUtils = new CharacterUtils();
            String uid = characterUtils.getUUID();
            address.setAddId(uid);
            return addressService.insert(address);
        }
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Address address) throws Exception {
        return addressService.updateByPrimaryKey(address);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Address address) throws Exception {
        return addressService.deleteByPrimaryKey(address.getAddId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Address> addresses) throws Exception {
        List<String> addIds = new ArrayList<>();
        for (Address address : addresses) {
            addIds.add(address.getAddId());
        }
        return addressService.batchDelete(addIds);
    }

    @RequestMapping("/getAddressDirectory")
    public @ResponseBody List<Address> getAddressDirectory(@RequestBody Address address) {
        return addressService.getAddressDirectory(address.getPid());
    }

    @RequestMapping("/countAddress")
    public @ResponseBody int countAddress() {
        return addressService.countAddress();
    }
}
