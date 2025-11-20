package com.city3d.controller;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.PoliceNet;
import com.city3d.service.PoliceNetService;
import com.city3d.utils.CharacterUtils;
import com.city3d.utils.GeoTools;

@Controller
@RequestMapping("/policeNet")
public class PoliceNetController {
    @Autowired
    private PoliceNetService policeNetService;

    @RequestMapping("/getPoliceNet")
    public @ResponseBody List<PoliceNet> getPoliceNet() {
        return policeNetService.getPoliceNet();
    }

    @RequestMapping("/queryPoliceNet")
    public @ResponseBody List<PoliceNet> queryPoliceNet(@RequestBody PoliceNet policeNet) {
        return policeNetService.queryPoliceNet(policeNet);
    }

    @RequestMapping("/getNetByContains")
    public @ResponseBody PoliceNet getNetByContains(String position) {
        PoliceNet result = new PoliceNet();
        String[] poiArr = position.split(",");
        Point2D.Double point = new Point2D.Double(Double.parseDouble(poiArr[0]), Double.parseDouble(poiArr[1]));
        List<Point2D.Double> pts = new ArrayList<>();
        List<PoliceNet> netList = policeNetService.getPoliceNet();
        for (PoliceNet policeNet : netList) {
            String[] netPolygenArr = policeNet.getNetPolygen().split(",");
            for (int i = 0; i < netPolygenArr.length; i = i + 3) {
                pts.add(new Point2D.Double(Double.parseDouble(netPolygenArr[i]), Double.parseDouble(netPolygenArr[i + 1])));
            }
            if (GeoTools.IsPtInPoly(point, pts)) {
                result = policeNet;
                break;
            }
        }
        return result;
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody PoliceNet policeNet) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        policeNet.setNetId(uid);
        return policeNetService.insert(policeNet);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody PoliceNet policeNet) throws Exception {
        return policeNetService.updateByPrimaryKey(policeNet);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody PoliceNet policeNet) throws Exception {
        return policeNetService.deleteByPrimaryKey(policeNet.getNetId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<PoliceNet> policeNets) throws Exception {
        List<String> netIds = new ArrayList<>();
        for (PoliceNet policeNet : policeNets) {
            netIds.add(policeNet.getNetId());
        }
        return policeNetService.batchDelete(netIds);
    }
}
