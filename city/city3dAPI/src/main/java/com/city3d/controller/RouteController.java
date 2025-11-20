package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.PeopleRoute;
import com.city3d.service.RouteService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteService routeService;

    @RequestMapping("/getRoute")
    public @ResponseBody List<PeopleRoute> getRoute() {
        return routeService.getPeopleRoute();
    }

    @RequestMapping("/getRouteById")
    public @ResponseBody PeopleRoute getCarById(String routeId) {
        return routeService.getRouteById(routeId);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody PeopleRoute PeopleRoute) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        PeopleRoute.setRouteId(uid);
        return routeService.insert(PeopleRoute);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody PeopleRoute PeopleRoute) throws Exception {
        return routeService.updateByPrimaryKey(PeopleRoute);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(String routeId) throws Exception {
        return routeService.deleteByPrimaryKey(routeId);
    }

    @RequestMapping("/iskpBe")
    public @ResponseBody int iskpBe(String kpId) {
        return routeService.iskpBe(kpId);
    }
}
