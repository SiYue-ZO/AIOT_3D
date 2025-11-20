package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.FaceIdentity;
import com.city3d.service.FaceIdentityService;

@Controller
@RequestMapping("/faceIdentity")
public class FaceIdentityController {
    @Autowired
    private FaceIdentityService faceIdentityService;

    @RequestMapping("/getFaceIdentity")
    public @ResponseBody List<FaceIdentity> getFaceIdentity() {
        return faceIdentityService.getFaceIdentity();
    }

    @RequestMapping("/getFaceIdentityAndVideoById")
    public @ResponseBody FaceIdentity getFaceIdentityAndVideoById(@RequestBody FaceIdentity faceIdentity) {
        return faceIdentityService.getFaceIdentityAndVideoById(faceIdentity.getFaceId());
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@RequestBody FaceIdentity faceIdentity) throws Exception {
        return faceIdentityService.updateByPrimaryKey(faceIdentity);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody FaceIdentity faceIdentity) throws Exception {
        return faceIdentityService.deleteByPrimaryKey(faceIdentity.getFaceId());
    }

    @RequestMapping("/getFaceIdentityByRepoTypeandUserId")
    public @ResponseBody List<FaceIdentity> getFaceIdentityByRepoTypeandUserId(@RequestBody FaceIdentity faceIdentity) {
        return faceIdentityService.getFaceIdentityByRepoTypeandUserId(faceIdentity);
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<FaceIdentity> faceIdentitys) throws Exception {
        List<String> faceIds = new ArrayList<>();
        for (FaceIdentity faceIdentity : faceIdentitys) {
            faceIds.add(faceIdentity.getFaceId());
        }
        return faceIdentityService.batchDelete(faceIds);
    }
}
