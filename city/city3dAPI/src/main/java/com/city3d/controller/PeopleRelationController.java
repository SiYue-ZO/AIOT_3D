package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.PeopleRelation;
import com.city3d.service.PeopleRelationService;

@Controller
@RequestMapping("/peopleRelation")
public class PeopleRelationController {
    //此接口没有应用，留作学习使用
    @Autowired
    private PeopleRelationService peopleRelationService;

    @RequestMapping("/selectPeopleRelationById")
    public @ResponseBody List<PeopleRelation> selectPeopleRelationById(String ppId) {
        return peopleRelationService.selectPeopleRelationById(ppId);
    }
}
