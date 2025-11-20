package com.city3d.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.city3d.dao.entry.PeopleBase;
import com.city3d.service.PeopleBaseService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/peopleBase")
public class PeopleBaseController {
    @Autowired
    private PeopleBaseService peopleBaseService;

    @RequestMapping("/getPeopleBaseAll")
    public @ResponseBody List<PeopleBase> getPeopleBaseAll() {
        return peopleBaseService.getPeopleBaseAll();
    }

    @RequestMapping("/queryPeoplebasePart")
    public @ResponseBody List<PeopleBase> queryPeoplebasePart(@RequestBody PeopleBase peopleBase) {
        return peopleBaseService.queryPeoplebasebyPartExample(peopleBase);
    }

    @RequestMapping("/queryPeoplebase")
    public @ResponseBody Set<Map> queryPeoplebase(@RequestBody PeopleBase peopleBase) throws Exception {
        List<PeopleBase> result = peopleBaseService.queryPeoplebasebyExample(peopleBase);
        Set<Map> resSet = new HashSet<>();
        for (PeopleBase pb : result) {
            String identity = pb.getIdentity();
            long ages = 0;
            if (identity != null && !"".equals(identity) && identity.length() == 18) {
                String dates = identity.substring(6, 10) + "-" + identity.substring(10, 12) + "-" + identity.substring(12, 14);
                Date nowDate = new Date();
                //获取当前时间
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate = df.parse(dates);
                //格式化出生日期
                long diff = nowDate.getTime() - birthDate.getTime();
                ages = diff / (1000 * 60 * 60 * 24) / 365;
            }
            Map map = new HashMap();
            if (!"".equals(peopleBase.getIsFlow()) && !"".equals(peopleBase.getIsLost())) {
                if (ages >= Long.parseLong(peopleBase.getIsFlow()) && ages <= Long.parseLong(peopleBase.getIsLost())) {
                    if (pb.getAddId() != null && pb.getAddress() != null && pb.getAddress().getPoi() != null && pb.getAddress().getPoi().length() > 0) {
                        map.put("ppId", pb.getPpId());
                        map.put("name", pb.getName());
                        map.put("onceName", pb.getOnceName());
                        map.put("gender", pb.getGender());
                        map.put("height", pb.getHeight());
                        map.put("bloodType", pb.getBloodType());
                        map.put("identity", pb.getIdentity());
                        map.put("nation", pb.getNation());
                        map.put("isDrug", pb.getIsDrug());
                        map.put("peopleType", pb.getPeopleType());
                        map.put("calture", pb.getCalture());
                        map.put("tel", pb.getTel());
                        map.put("region", pb.getRegion());
                        map.put("political", pb.getPolitical());
                        map.put("marriage", pb.getMarriage());
                        map.put("unitName", pb.getUnitName());
                        map.put("job", pb.getJob());
                        map.put("householdNature", pb.getHouseholdNature());
                        map.put("householdAddress", pb.getHouseholdAddress());
                        map.put("fatherName", pb.getFatherName());
                        map.put("fatherIdentity", pb.getFatherIdentity());
                        map.put("motherName", pb.getMotherName());
                        map.put("motherIdentity", pb.getMotherIdentity());
                        map.put("mateName", pb.getMateName());
                        map.put("mateIdentity", pb.getMateIdentity());
                        map.put("serveArmy", pb.getServeArmy());
                        map.put("address", pb.getAddress());
                    } else {
                        map.put("ppId", pb.getPpId());
                        map.put("name", pb.getName());
                        map.put("onceName", pb.getOnceName());
                        map.put("gender", pb.getGender());
                        map.put("height", pb.getHeight());
                        map.put("bloodType", pb.getBloodType());
                        map.put("identity", pb.getIdentity());
                        map.put("nation", pb.getNation());
                        map.put("isDrug", pb.getIsDrug());
                        map.put("peopleType", pb.getPeopleType());
                        map.put("calture", pb.getCalture());
                        map.put("tel", pb.getTel());
                        map.put("region", pb.getRegion());
                        map.put("political", pb.getPolitical());
                        map.put("marriage", pb.getMarriage());
                        map.put("unitName", pb.getUnitName());
                        map.put("job", pb.getJob());
                        map.put("householdNature", pb.getHouseholdNature());
                        map.put("householdAddress", pb.getHouseholdAddress());
                        map.put("fatherName", pb.getFatherName());
                        map.put("fatherIdentity", pb.getFatherIdentity());
                        map.put("motherName", pb.getMotherName());
                        map.put("motherIdentity", pb.getMotherIdentity());
                        map.put("mateName", pb.getMateName());
                        map.put("mateIdentity", pb.getMateIdentity());
                        map.put("serveArmy", pb.getServeArmy());
                        map.put("address", pb.getAddress());
                    }
                }
            } else {
                if (pb.getAddId() != null && pb.getAddress() != null && pb.getAddress().getPoi() != null && pb.getAddress().getPoi().length() > 0) {
                    map.put("ppId", pb.getPpId());
                    map.put("name", pb.getName());
                    map.put("onceName", pb.getOnceName());
                    map.put("gender", pb.getGender());
                    map.put("height", pb.getHeight());
                    map.put("bloodType", pb.getBloodType());
                    map.put("identity", pb.getIdentity());
                    map.put("nation", pb.getNation());
                    map.put("isDrug", pb.getIsDrug());
                    map.put("peopleType", pb.getPeopleType());
                    map.put("calture", pb.getCalture());
                    map.put("tel", pb.getTel());
                    map.put("region", pb.getRegion());
                    map.put("political", pb.getPolitical());
                    map.put("marriage", pb.getMarriage());
                    map.put("unitName", pb.getUnitName());
                    map.put("job", pb.getJob());
                    map.put("householdNature", pb.getHouseholdNature());
                    map.put("householdAddress", pb.getHouseholdAddress());
                    map.put("fatherName", pb.getFatherName());
                    map.put("fatherIdentity", pb.getFatherIdentity());
                    map.put("motherName", pb.getMotherName());
                    map.put("motherIdentity", pb.getMotherIdentity());
                    map.put("mateName", pb.getMateName());
                    map.put("mateIdentity", pb.getMateIdentity());
                    map.put("serveArmy", pb.getServeArmy());
                    map.put("address", pb.getAddress());
                } else {
                    map.put("ppId", pb.getPpId());
                    map.put("name", pb.getName());
                    map.put("onceName", pb.getOnceName());
                    map.put("gender", pb.getGender());
                    map.put("height", pb.getHeight());
                    map.put("bloodType", pb.getBloodType());
                    map.put("identity", pb.getIdentity());
                    map.put("nation", pb.getNation());
                    map.put("isDrug", pb.getIsDrug());
                    map.put("peopleType", pb.getPeopleType());
                    map.put("calture", pb.getCalture());
                    map.put("tel", pb.getTel());
                    map.put("region", pb.getRegion());
                    map.put("political", pb.getPolitical());
                    map.put("marriage", pb.getMarriage());
                    map.put("unitName", pb.getUnitName());
                    map.put("job", pb.getJob());
                    map.put("householdNature", pb.getHouseholdNature());
                    map.put("householdAddress", pb.getHouseholdAddress());
                    map.put("fatherName", pb.getFatherName());
                    map.put("fatherIdentity", pb.getFatherIdentity());
                    map.put("motherName", pb.getMotherName());
                    map.put("motherIdentity", pb.getMotherIdentity());
                    map.put("mateName", pb.getMateName());
                    map.put("mateIdentity", pb.getMateIdentity());
                    map.put("serveArmy", pb.getServeArmy());
                    map.put("address", pb.getAddress());
                }
            }
            resSet.add(map);
        }
        return resSet;
    }

    @RequestMapping("/queryPeoplebaseByPolygon")
    public @ResponseBody List<PeopleBase> queryPeoplebaseByPolygon(@RequestBody PeopleBase peopleBase) {
        return peopleBaseService.queryPeoplebaseByPolygon(peopleBase);
    }

    @RequestMapping("/getPeopleBaseById")
    public @ResponseBody PeopleBase getPeopleBaseById(@RequestBody PeopleBase peopleBase) {
        return peopleBaseService.getPeopleBaseById(peopleBase.getPpId());
    }

    @RequestMapping("/queryPeopleByAddId")
    public @ResponseBody List<PeopleBase> queryPeopleByAddId(@RequestBody PeopleBase peopleBase) {
        return peopleBaseService.queryPeopleByAddId(peopleBase.getAddId());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("ppId") String ppId,
                                    @RequestParam("addId") String addId, @RequestParam("identity") String identity, @RequestParam("identity1") String identity1,
                                    @RequestParam("tel") String tel, @RequestParam("motherIdentity") String motherIdentity, @RequestParam("motherName") String motherName,
                                    @RequestParam("nation") String nation, @RequestParam("mateIdentity") String mateIdentity, @RequestParam("mateName") String mateName,
                                    @RequestParam("height") String height, @RequestParam("communityCode") String communityCode, @RequestParam("gender") String gender,
                                    @RequestParam("calture") String calture, @RequestParam("name") String name, @RequestParam("bloodType") String bloodType,
                                    @RequestParam("region") String region, @RequestParam("political") String political, @RequestParam("onceName") String onceName,
                                    @RequestParam("unitName") String unitName, @RequestParam("job") String job, @RequestParam("fatherIdentity") String fatherIdentity,
                                    @RequestParam("fatherName") String fatherName, @RequestParam("householdAddress") String householdAddress, @RequestParam("householdNature") String householdNature,
                                    @RequestParam("marriage") String marriage, @RequestParam("fromCountry") String fromCountry, @RequestParam("fromProvince") String fromProvince,
                                    @RequestParam("inDate") String inDate, @RequestParam("inReason") String inReason, @RequestParam("serveArmy") String serveArmy,
                                    @RequestParam("overseasRelation") String overseasRelation, @RequestParam("peopleType") String peopleType, @RequestParam("entryType") String entryType,
                                    @RequestParam("isDrug") String isDrug, @RequestParam("isFlow") String isFlow, @RequestParam("isImportant") String isImportant,
                                    @RequestParam("isLost") String isLost, @RequestParam("isMental") String isMental, @RequestParam("isOut") String isOut,
                                    @RequestParam("isSupervise") String isSupervise, @RequestParam("isVisit") String isVisit, @RequestParam("isXinjiang") String isXinjiang,
                                    @RequestParam("isKey") String isKey, @RequestParam("imgurl") String imgurl, HttpServletRequest request) throws Exception {
        PeopleBase peopleBase = new PeopleBase();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/identity/" + identity + extName;
                        peopleBase.setImgurl(fileName);
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
        peopleBase.setPpId(uid);
        peopleBase.setAddId(addId);
        peopleBase.setIdentity(identity);
        peopleBase.setIdentity1(identity1);
        peopleBase.setTel(tel);
        peopleBase.setMotherIdentity(motherIdentity);
        peopleBase.setMotherName(motherName);
        peopleBase.setNation(nation);
        peopleBase.setMateIdentity(mateIdentity);
        peopleBase.setMateName(mateName);
        peopleBase.setHeight(height);
        String fianlCommunity = communityCode;
        if (communityCode.contains(",")) {
            fianlCommunity = communityCode.substring(1);
        }
        peopleBase.setCommunityCode(fianlCommunity);
        peopleBase.setGender(gender);
        peopleBase.setCalture(calture);
        peopleBase.setName(name);
        peopleBase.setBloodType(bloodType);
        peopleBase.setRegion(region);
        peopleBase.setPolitical(political);
        peopleBase.setOnceName(onceName);
        peopleBase.setUnitName(unitName);
        peopleBase.setJob(job);
        peopleBase.setFatherIdentity(fatherIdentity);
        peopleBase.setFatherName(fatherName);
        peopleBase.setHouseholdAddress(householdAddress);
        peopleBase.setHouseholdNature(householdNature);
        peopleBase.setMarriage(marriage);
        peopleBase.setFromCountry(fromCountry);
        peopleBase.setFromProvince(fromProvince);
        peopleBase.setInDate(inDate);
        peopleBase.setInReason(inReason);
        peopleBase.setServeArmy(serveArmy);
        peopleBase.setOverseasRelation(overseasRelation);
        peopleBase.setPeopleType(peopleType);
        peopleBase.setEntryType(entryType);
        peopleBase.setIsDrug(isDrug);
        peopleBase.setIsFlow(isFlow);
        peopleBase.setIsImportant(isImportant);
        peopleBase.setIsLost(isLost);
        peopleBase.setIsMental(isMental);
        peopleBase.setIsOut(isOut);
        peopleBase.setIsSupervise(isSupervise);
        peopleBase.setIsVisit(isVisit);
        peopleBase.setIsXinjiang(isXinjiang);
        peopleBase.setIsKey(isKey);
        return peopleBaseService.insert(peopleBase);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("ppId") String ppId,
                                    @RequestParam("addId") String addId, @RequestParam("identity") String identity, @RequestParam("identity1") String identity1,
                                    @RequestParam("tel") String tel, @RequestParam("motherIdentity") String motherIdentity, @RequestParam("motherName") String motherName,
                                    @RequestParam("nation") String nation, @RequestParam("mateIdentity") String mateIdentity, @RequestParam("mateName") String mateName,
                                    @RequestParam("height") String height, @RequestParam("communityCode") String communityCode, @RequestParam("gender") String gender,
                                    @RequestParam("calture") String calture, @RequestParam("name") String name, @RequestParam("bloodType") String bloodType,
                                    @RequestParam("region") String region, @RequestParam("political") String political, @RequestParam("onceName") String onceName,
                                    @RequestParam("unitName") String unitName, @RequestParam("job") String job, @RequestParam("fatherIdentity") String fatherIdentity,
                                    @RequestParam("fatherName") String fatherName, @RequestParam("householdAddress") String householdAddress, @RequestParam("householdNature") String householdNature,
                                    @RequestParam("marriage") String marriage, @RequestParam("fromCountry") String fromCountry, @RequestParam("fromProvince") String fromProvince,
                                    @RequestParam("inDate") String inDate, @RequestParam("inReason") String inReason, @RequestParam("serveArmy") String serveArmy,
                                    @RequestParam("overseasRelation") String overseasRelation, @RequestParam("peopleType") String peopleType, @RequestParam("entryType") String entryType,
                                    @RequestParam("isDrug") String isDrug, @RequestParam("isFlow") String isFlow, @RequestParam("isImportant") String isImportant,
                                    @RequestParam("isLost") String isLost, @RequestParam("isMental") String isMental, @RequestParam("isOut") String isOut,
                                    @RequestParam("isSupervise") String isSupervise, @RequestParam("isVisit") String isVisit, @RequestParam("isXinjiang") String isXinjiang,
                                    @RequestParam("isKey") String isKey, @RequestParam("imgurl") String imgurl, HttpServletRequest request) throws Exception {
        PeopleBase peopleBase = new PeopleBase();
        peopleBase.setImgurl(imgurl);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/identity/" + identity + extName;
                        peopleBase.setImgurl(fileName);
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
        peopleBase.setPpId(ppId);
        peopleBase.setAddId(addId);
        peopleBase.setIdentity(identity);
        peopleBase.setIdentity1(identity1);
        peopleBase.setTel(tel);
        peopleBase.setMotherIdentity(motherIdentity);
        peopleBase.setMotherName(motherName);
        peopleBase.setNation(nation);
        peopleBase.setMateIdentity(mateIdentity);
        peopleBase.setMateName(mateName);
        peopleBase.setHeight(height);
        peopleBase.setCommunityCode(communityCode);
        peopleBase.setGender(gender);
        peopleBase.setCalture(calture);
        peopleBase.setName(name);
        peopleBase.setBloodType(bloodType);
        peopleBase.setRegion(region);
        peopleBase.setPolitical(political);
        peopleBase.setOnceName(onceName);
        peopleBase.setUnitName(unitName);
        peopleBase.setJob(job);
        peopleBase.setFatherIdentity(fatherIdentity);
        peopleBase.setFatherName(fatherName);
        peopleBase.setHouseholdAddress(householdAddress);
        peopleBase.setHouseholdNature(householdNature);
        peopleBase.setMarriage(marriage);
        peopleBase.setFromCountry(fromCountry);
        peopleBase.setFromProvince(fromProvince);
        peopleBase.setInDate(inDate);
        peopleBase.setInReason(inReason);
        peopleBase.setServeArmy(serveArmy);
        peopleBase.setOverseasRelation(overseasRelation);
        peopleBase.setPeopleType(peopleType);
        peopleBase.setEntryType(entryType);
        peopleBase.setIsDrug(isDrug);
        peopleBase.setIsFlow(isFlow);
        peopleBase.setIsImportant(isImportant);
        peopleBase.setIsLost(isLost);
        peopleBase.setIsMental(isMental);
        peopleBase.setIsOut(isOut);
        peopleBase.setIsSupervise(isSupervise);
        peopleBase.setIsVisit(isVisit);
        peopleBase.setIsXinjiang(isXinjiang);
        peopleBase.setIsKey(isKey);
        return peopleBaseService.updateByPrimaryKey(peopleBase);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody PeopleBase peopleBase) throws Exception {
        if (peopleBase.getImgurl() != null && !Objects.equals(peopleBase.getImgurl(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + peopleBase.getImgurl();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return peopleBaseService.deleteByPrimaryKey(peopleBase.getPpId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<PeopleBase> peopleBases) throws Exception {
        List<String> ppIds = new ArrayList<>();
        for (PeopleBase peopleBase : peopleBases) {
            ppIds.add(peopleBase.getPpId());
            if (peopleBase.getImgurl() != null && !Objects.equals(peopleBase.getImgurl(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + peopleBase.getImgurl();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return peopleBaseService.batchDelete(ppIds);
    }
}
