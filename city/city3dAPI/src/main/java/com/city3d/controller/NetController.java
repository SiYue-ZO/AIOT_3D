package com.city3d.controller;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.city3d.service.SysRoleNetService;
import com.city3d.vo.RoleNet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import com.city3d.dao.entry.Net;
import com.city3d.service.NetService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/net")
public class NetController {
    @Autowired
    private NetService netService;

    @Autowired
    private SysRoleNetService sysRoleNetService;

    @RequestMapping("/getNetAndCount")
    public @ResponseBody List<Object> getNetAndCount(@RequestBody Net net) {
        return netService.getNetAndCount(net);
    }

    @RequestMapping("/getNetAndCountById")
    public @ResponseBody List<Object> getNetAndCountById(@RequestBody Net net) {
        return netService.getNetAndCountById(net);
    }

    @RequestMapping("/queryNet")
    public @ResponseBody List<Object> queryNet(@RequestBody Net net) {
        return netService.getNetByExample(net);
    }

    @RequestMapping("/getNetAndCountHouse")
    public @ResponseBody List<Object> getNetAndCountHouse(@RequestBody Net net) {
        return netService.getNetAndCountHouse(net);
    }

    @RequestMapping("/getNetAndCountHouseById")
    public @ResponseBody List<Object> getNetAndCountHouseById(@RequestBody Net net) {
        return netService.getNetAndCountHouseById(net);
    }

    @RequestMapping("/queryNetHouse")
    public @ResponseBody List<Object> queryNetHouse(@RequestBody Net net) {
        return netService.getNetHouseByExample(net);
    }

    @RequestMapping("/queryNetCompany")
    public @ResponseBody List<Object> queryNetCompany(@RequestBody Net net) {
        return netService.getNetCompanyByExample(net);
    }

    @RequestMapping("/queryNetCompanyById")
    public @ResponseBody List<Object> queryNetCompanyById(@RequestBody Net net) {
        return netService.getNetCompanyByExampleById(net);
    }

    @RequestMapping("/getNetAndCountAddress")
    public @ResponseBody List<Object> getNetAndCountAddress(@RequestBody Net net) {
        return netService.getNetAndCountAddress(net);
    }

    @RequestMapping("/getNetAndCountAddressById")
    public @ResponseBody List<Object> getNetAndCountAddressById(@RequestBody Net net) {
        return netService.getNetAndCountAddressById(net);
    }

    @RequestMapping("/queryNetAddress")
    public @ResponseBody List<Object> queryNetAddress(@RequestBody Net net) {
        return netService.getNetAddressByExample(net);
    }

    @RequestMapping("/getNetAndCountAll")
    public @ResponseBody List<Object> getNetAndCountAll(@RequestBody Net net) {
        return netService.getNetAndCountAll(net);
    }

    @RequestMapping("/getNetAndCountAllById")
    public @ResponseBody List<Object> getNetAndCountAllById(@RequestBody Net net) {
        return netService.getNetAndCountAllById(net);
    }

    @RequestMapping("/queryNetData")
    public @ResponseBody List<Net> queryNetData(@RequestBody Net net) {
        return netService.queryNetData(net);
    }

    @RequestMapping("/getNetById")
    public @ResponseBody List<Object> getNetById(@RequestBody Net net) {
        return netService.getNetById(net.getNetId());
    }

    @RequestMapping("/getNetInfoById")
    public @ResponseBody Net getNetInfoById(@RequestBody Net net) {
        return netService.getNetInfoById(net.getNetId());
    }

    @RequestMapping("/getNetAndCountAllN")
    public @ResponseBody List<Object> getNetAndCountAllN(@RequestBody Net net) {
        return netService.getNetAndCountAllN(net);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody RoleNet roleNet) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        roleNet.getNet().setNetId(uid);

        CharacterUtils characterUtilsRole = new CharacterUtils();
        String uidRole = characterUtilsRole.getUUID();
        roleNet.getSysRoleNet().setRoleNetId(uidRole);
        roleNet.getSysRoleNet().setNetId(uid);

        sysRoleNetService.insertSysRoleNet(roleNet.getSysRoleNet());
        return netService.insertNet(roleNet.getNet());
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody Net net) throws Exception {
        return netService.deleteByPrimaryKey(net.getNetId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Net> nets) throws Exception {
        List<String> netIds = new ArrayList<>();
        for (Net net : nets) {
            netIds.add(net.getNetId());
        }
        return netService.batchDelete(netIds);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@RequestBody Net net) throws Exception {
        return netService.updateByPrimaryKey(net);
    }

    @RequestMapping("/getNetAndCountBuildingRemove")
    public @ResponseBody List<Object> getNetAndCountBuildingRemove(@RequestBody Net net) {
        return netService.getNetAndCountBuildingRemove(net);
    }

    @RequestMapping("/getNetAndCountBuildingRemoveById")
    public @ResponseBody List<Object> getNetAndCountBuildingRemoveById(@RequestBody Net net) {
        return netService.getNetAndCountBuildingRemoveById(net);
    }

    @RequestMapping("/getBuildingRemoveNetById")
    public @ResponseBody List<Object> getBuildingRemoveNetById(@RequestBody Net net) {
        return netService.getBuildingRemoveNetById(net);
    }

    // 宁波江北区一张图项目的城市智脑接口访问方法---留下学习用
    @RequestMapping("/getSign")
    public @ResponseBody Map<String, Object> getSign(@RequestBody Net net) throws Exception {
        String appKey = "955424763436597248";
        String secret = "bdccc0aa1a5d48279c80bd81d2055df9";
        // 业务参数
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("xianjudz", net.getNetPoi());
        jsonMap.put("sfzh", net.getNetLevel());
        jsonMap.put("xm", net.getNetName());
        String json = JSON.toJSONString(jsonMap);
        json = URLEncoder.encode(json, "utf-8");

        // 系统参数
        Map<String, Object> param = new HashMap<>();
        param.put("name", "getPeopleInfo");
        param.put("app_key", appKey);
        param.put("data", json);
        param.put("timestamp", getTime());
        param.put("version", "1.0");
        param.put("access_token", "");

        String sign = buildSign(param, secret);
        param.put("sign", sign);

        return param;
    }

    /**
     * 构建签名
     *
     * @param paramsMap 参数
     * @param secret    密钥
     */
    public static String buildSign(Map<String, ?> paramsMap, String secret) {
        Set<String> keySet = paramsMap.keySet();
        List<String> paramNames = new ArrayList<>(keySet);

        Collections.sort(paramNames);

        StringBuilder paramNameValue = new StringBuilder();

        for (String paramName : paramNames) {
            paramNameValue.append(paramName).append(paramsMap.get(paramName));
        }

        String source = secret + paramNameValue.toString() + secret;

        return md5(source);
    }

    /**
     * 生成md5,全部大写
     */
    public static String md5(String message) {
        try {
            // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 2 将消息变成byte数组
            byte[] input = message.getBytes();

            // 3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);

            // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            return byte2hex(buff);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 二进制转十六进制字符串
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    public String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
