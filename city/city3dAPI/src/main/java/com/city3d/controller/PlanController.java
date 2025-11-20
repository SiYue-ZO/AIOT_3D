package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Plan;
import com.city3d.service.PlanService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;

    @RequestMapping("/getPlan")
    public @ResponseBody List<Plan> getPlan() {
        return planService.getPlan();
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody Plan plan) throws Exception {
        return planService.deleteByPrimaryKey(plan.getPlanId());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Plan plan) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        plan.setPlanId(uid);
        return planService.insert(plan);
    }
}
