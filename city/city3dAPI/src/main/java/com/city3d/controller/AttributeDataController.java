package com.city3d.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.AttributeData;
import com.city3d.service.AttributeDataService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/attributeData")
public class AttributeDataController {
    @Autowired
    private AttributeDataService attributeDataService;

    @RequestMapping("/getAttributeDataByCoverageId")
    public @ResponseBody List<AttributeData> getAttributeDataByCoverageId(@RequestBody AttributeData attributeData) {
        return attributeDataService.getAttributeDataAndCoverageByCoverageId(attributeData.getCoverageId());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody AttributeData attributeData) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        attributeData.setId(uid);
        return attributeDataService.insert(attributeData);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@RequestBody AttributeData attributeData) throws Exception {
        return attributeDataService.updateByPrimaryKey(attributeData);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody AttributeData attributeData) throws Exception {
        return attributeDataService.deleteByPrimaryKey(attributeData.getId());
    }

    @RequestMapping("/getAttributeDataAndAddressById")
    public @ResponseBody AttributeData getAttributeDataAndAddressById(@RequestBody AttributeData attributeData) {
        return attributeDataService.getAttributeDataAndAddressById(attributeData.getId());
    }

    @RequestMapping("/getAttributeDataByValue")
    public @ResponseBody List<Map<String, String>> getAttributeDataByValue(@RequestBody Map<String, String> kv) {
        String coverageId = kv.get("coverageId");
        String addName;
        if (kv.get("addName") == null) {
            addName = "";
        } else {
            addName = kv.get("addName");
        }
        Set<String> kvSet = kv.keySet();
        List<AttributeData> result = attributeDataService.getAttributeDataAddressByCoverageIdAndAddName(coverageId, addName);
        if (kvSet.size() == 2 && kvSet.contains("coverageId") && kvSet.contains("addName")) {
            List<Map<String, String>> resultr = new ArrayList<>();
            for (AttributeData ad : result) {
                Map<String, String> map = new HashMap<>();
                map.put("id", ad.getId());
                map.put("value", ad.getValue());
                map.put("attrId", ad.getAttrId());
                map.put("addName", ad.getAddName());
                map.put("poi", ad.getPoi());
                map.put("camPoi", ad.getCamPoi());
                map.put("camHeading", ad.getCamHeading());
                map.put("camPitch", ad.getCamPitch());
                map.put("color", ad.getCoverage().getColor());
                resultr.add(map);
            }
            return resultr;
        } else if (kvSet.size() == 1 && kvSet.contains("coverageId")) {
            List<Map<String, String>> resultr = new ArrayList<>();
            for (AttributeData ad : result) {
                Map<String, String> map = new HashMap<>();
                map.put("id", ad.getId());
                map.put("value", ad.getValue());
                map.put("attrId", ad.getAttrId());
                map.put("addName", ad.getAddName());
                map.put("poi", ad.getPoi());
                map.put("camPoi", ad.getCamPoi());
                map.put("camHeading", ad.getCamHeading());
                map.put("camPitch", ad.getCamPitch());
                map.put("color", ad.getCoverage().getColor());
                resultr.add(map);
            }
            return resultr;
        } else {
            kv.remove("coverageId");
            kv.remove("addName");
            Set<String> keySet = kv.keySet();
            List<String> keyList = new ArrayList<>();
            keyList.addAll(keySet);
            Map<String, List<String>> keyLists = new HashMap<>();
            List<Map<String, String>> listMap = new ArrayList<>();
            for (AttributeData ad : result) {
                Map<String, String> map = new HashMap<>();
                map.put("id", ad.getId());
                String[] keyValue = ad.getValue().split("&");
                for (String kvi : keyValue) {
                    try {
                        map.put(kvi.split("#")[0], kvi.split("#")[1]);
                    } catch (Exception e) {
                        map.put(kvi.split("#")[0], "");
                    }
                }
                listMap.add(map);
            }
            for (String key : keySet) {
                List<String> idList = new ArrayList<>();
                Set<String> idSet = new HashSet<>();
                for (Map<String, String> map : listMap) {
                    if (map.get(key).contains(kv.get(key))) {
                        idSet.add(map.get("id"));
                    }
                }
                idList.addAll(idSet);
                keyLists.put(key, idList);
            }
            List<String> idListPart = new ArrayList<>();
            for (int i = 0; i <= keyList.size() - 1; i++) {
                if (i == 0) {
                    idListPart.addAll(keyLists.get(keyList.get(0)));
                } else {
                    idListPart.retainAll(keyLists.get(keyList.get(i)));
                }
            }
            List<AttributeData> attributeDataListPart = new ArrayList<>();
            for (String id : idListPart) {
                for (AttributeData ad : result) {
                    if (ad.getId().equals(id)) {
                        attributeDataListPart.add(ad);
                    }
                }
            }
            List<Map<String, String>> resultr = new ArrayList<>();
            for (AttributeData ad : attributeDataListPart) {
                Map<String, String> map = new HashMap<>();
                map.put("id", ad.getId());
                map.put("value", ad.getValue());
                map.put("attrId", ad.getAttrId());
                map.put("addName", ad.getAddName());
                map.put("poi", ad.getPoi());
                map.put("camPoi", ad.getCamPoi());
                map.put("camHeading", ad.getCamHeading());
                map.put("camPitch", ad.getCamPitch());
                map.put("color", ad.getCoverage().getColor());
                resultr.add(map);
            }
            return resultr;
        }
    }
}
