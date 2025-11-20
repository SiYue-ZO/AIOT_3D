package com.city3d.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.city3d.dao.entry.KeyPeople;
import com.city3d.service.KeyPeopleService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/keyPeople")
public class KeyPeopleController {
    @Autowired
    private KeyPeopleService keyPeopleService;

    @RequestMapping("/getKeypeople")
    public @ResponseBody List<HashMap<String, String>> getKeypeople() {
        return keyPeopleService.getKeypeople();
    }

    @RequestMapping("/getKeypeopleAll")
    public @ResponseBody List<KeyPeople> getKeypeopleAll() {
        return keyPeopleService.getKeypeopleAll();
    }

    @RequestMapping("/getKeypeopleNoPic")
    public @ResponseBody List<KeyPeople> getKeypeopleNoPic() {
        return keyPeopleService.getKeypeopleNoPic();
    }

    @RequestMapping("/getKeypeopleById")
    public @ResponseBody KeyPeople getKeypeopleById(@RequestBody KeyPeople keyPeople) {
        return keyPeopleService.getKeypeopleById(keyPeople.getKeyId());
    }

    @RequestMapping("/queryKeypeople")
    public @ResponseBody List<KeyPeople> queryKeypeople(@RequestBody KeyPeople keyPeople) {
        return keyPeopleService.queryKeypeoplebyExample(keyPeople);
    }

    @RequestMapping("/queryKeypeopleByIdentity")
    public @ResponseBody KeyPeople queryKeypeopleByIdentity(@RequestBody KeyPeople keyPeople) {
        return keyPeopleService.queryKeypeopleByIdentity(keyPeople.getIdentity());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("keyId") String keyId,
                                    @RequestParam("addId") String addId,
                                    @RequestParam("name") String name, @RequestParam("identity") String identity, @RequestParam("gender") String gender,
                                    @RequestParam("nation") String nation, @RequestParam("birthday") String birthday, @RequestParam("height") String height,
                                    @RequestParam("job") String job, @RequestParam("tel") String tel, @RequestParam("type") String type,
                                    @RequestParam("origin") String origin, @RequestParam("describe") String describe, @RequestParam("blood") String blood,
                                    @RequestParam("imgurl") String imgurl, HttpServletRequest request) throws Exception {
        KeyPeople keyPeople = new KeyPeople();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/identity/key_" + identity + extName;
                        keyPeople.setImgurl(fileName);
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
        keyPeople.setKeyId(uid);
        keyPeople.setAddId(addId);
        keyPeople.setName(name);
        keyPeople.setIdentity(identity);
        keyPeople.setGender(gender);
        keyPeople.setNation(nation);
        keyPeople.setBirthday(birthday);
        keyPeople.setHeight(height);
        keyPeople.setJob(job);
        keyPeople.setTel(tel);
        keyPeople.setType(type);
        keyPeople.setOrigin(origin);
        keyPeople.setDescribe(describe);
        keyPeople.setBlood(blood);
        return keyPeopleService.insert(keyPeople);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("keyId") String keyId,
                                    @RequestParam("addId") String addId,
                                    @RequestParam("name") String name, @RequestParam("identity") String identity, @RequestParam("gender") String gender,
                                    @RequestParam("nation") String nation, @RequestParam("birthday") String birthday, @RequestParam("height") String height,
                                    @RequestParam("job") String job, @RequestParam("tel") String tel, @RequestParam("type") String type,
                                    @RequestParam("origin") String origin, @RequestParam("describe") String describe, @RequestParam("blood") String blood,
                                    @RequestParam("imgurl") String imgurl, HttpServletRequest request) throws Exception {
        KeyPeople keyPeople = new KeyPeople();
        keyPeople.setImgurl(imgurl);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/identity/key_" + identity + extName;
                        keyPeople.setImgurl(fileName);
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
        keyPeople.setKeyId(keyId);
        keyPeople.setAddId(addId);
        keyPeople.setName(name);
        keyPeople.setIdentity(identity);
        keyPeople.setGender(gender);
        keyPeople.setNation(nation);
        keyPeople.setBirthday(birthday);
        keyPeople.setHeight(height);
        keyPeople.setJob(job);
        keyPeople.setTel(tel);
        keyPeople.setType(type);
        keyPeople.setOrigin(origin);
        keyPeople.setDescribe(describe);
        keyPeople.setBlood(blood);
        return keyPeopleService.updateByPrimaryKey(keyPeople);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody KeyPeople keyPeople) throws Exception {
        if (keyPeople.getImgurl() != null && !Objects.equals(keyPeople.getImgurl(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + keyPeople.getImgurl();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return keyPeopleService.deleteByPrimaryKey(keyPeople.getKeyId());
    }
}
