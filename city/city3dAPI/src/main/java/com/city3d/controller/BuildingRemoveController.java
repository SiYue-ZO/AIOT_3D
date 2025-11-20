package com.city3d.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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

import com.city3d.dao.entry.Address;
import com.city3d.dao.entry.BuildingRemove;
import com.city3d.dao.entry.HousePanorama;
import com.city3d.service.AddressService;
import com.city3d.service.BuildingRemoveService;
import com.city3d.service.HousePanoramaService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/buildingRemove")
public class BuildingRemoveController {
    @Autowired
    private BuildingRemoveService buildingRemoveService;

    @Autowired
    private HousePanoramaService housePanoramaService;

    @Autowired
    private AddressService addressService;

    @RequestMapping("/getBuildingRemove")
    public @ResponseBody List<BuildingRemove> getBuildingRemove() {
        return buildingRemoveService.getBuildingRemove();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(
            @Nullable @RequestParam("removePicFile1") MultipartFile[] removePicFile1,
            @Nullable @RequestParam("removePicFile2") MultipartFile[] removePicFile2,
            @Nullable @RequestParam("removePicFile3") MultipartFile[] removePicFile3,
            @Nullable @RequestParam("removePicFile4") MultipartFile[] removePicFile4,
            @Nullable @RequestParam("removePdfFile") MultipartFile[] removePdfFile,
            @Nullable @RequestParam("removePdfFile1") MultipartFile[] removePdfFile1,
            @Nullable @RequestParam("removePdfFile2") MultipartFile[] removePdfFile2,
            @Nullable @RequestParam("removePdfFile3") MultipartFile[] removePdfFile3,
            @Nullable @RequestParam("removePdfFile4") MultipartFile[] removePdfFile4,
            @Nullable @RequestParam("removePdfFile5") MultipartFile[] removePdfFile5,
            @Nullable @RequestParam("removePdfFile6") MultipartFile[] removePdfFile6,
            @Nullable @RequestParam("removePdfFile7") MultipartFile[] removePdfFile7,
            @Nullable @RequestParam("removePdfFile8") MultipartFile[] removePdfFile8,
            @Nullable @RequestParam("removePdfFile9") MultipartFile[] removePdfFile9,
            @Nullable @RequestParam("removePPFile") MultipartFile[] removePPFile,
            @RequestParam("removeId") String removeId,
            @RequestParam("removeName") String removeName,
            @RequestParam("removeSite") String removeSite,
            @RequestParam("removeTel") String removeTel,
            @RequestParam("removeCard") String removeCard,
            @RequestParam("removeLandNum") String removeLandNum,
            @RequestParam("removeProType") String removeProType,
            @RequestParam("removeLandArea") String removeLandArea,
            @RequestParam("removeHouseNum") String removeHouseNum,
            @RequestParam("removeHouseArea") String removeHouseArea,
            @RequestParam("removeState") String removeState,
            @RequestParam("removeUse") String removeUse,
            @RequestParam("removeHouseAreaCheck") String removeHouseAreaCheck,
            @RequestParam("removeBuildingAreaCheck") String removeBuildingAreaCheck,
            @RequestParam("removeAreaNoCer") String removeAreaNoCer,
            @RequestParam("removeLandAreaCheck") String removeLandAreaCheck,
            @RequestParam("removeLandAreaOk") String removeLandAreaOk,
            @RequestParam("removeLandAreaNoCer") String removeLandAreaNoCer,
            @RequestParam("removeNote") String removeNote,
            @RequestParam("removeDate") String removeDate,
            @RequestParam("removeCorner") String removeCorner,
            @RequestParam("removePic1") String removePic1,
            @RequestParam("removePicPos1") String removePicPos1,
            @RequestParam("removePic2") String removePic2,
            @RequestParam("removePicPos2") String removePicPos2,
            @RequestParam("removePic3") String removePic3,
            @RequestParam("removePicPos3") String removePicPos3,
            @RequestParam("removePic4") String removePic4,
            @RequestParam("removePicPos4") String removePicPos4,
            @RequestParam("removePdf") String removePdf,
            @RequestParam("removePdf1") String removePdf1,
            @RequestParam("removePdf2") String removePdf2,
            @RequestParam("removePdf3") String removePdf3,
            @RequestParam("removePdf4") String removePdf4,
            @RequestParam("removePdf5") String removePdf5,
            @RequestParam("removePdf6") String removePdf6,
            @RequestParam("removePdf7") String removePdf7,
            @RequestParam("removePdf8") String removePdf8,
            @RequestParam("removePdf9") String removePdf9,
            @RequestParam("removeSign") String removeSign,
            @RequestParam("addId") String addId,
            @RequestParam("removeTop") String removeTop,
            HttpServletRequest request) throws Exception {
        BuildingRemove buildingRemove = new BuildingRemove();
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        if (removePicFile1 != null) {
            for (MultipartFile file : removePicFile1) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/image/remove_" + removeCard + "_1_" + uid + extName;
                        buildingRemove.setRemovePic1(fileName);
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
        if (removePicFile2 != null) {
            for (MultipartFile file : removePicFile2) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/image/remove_" + removeCard + "_2_" + uid + extName;
                        buildingRemove.setRemovePic2(fileName);
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
        if (removePicFile3 != null) {
            for (MultipartFile file : removePicFile3) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/image/remove_" + removeCard + "_3_" + uid + extName;
                        buildingRemove.setRemovePic3(fileName);
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
        if (removePicFile4 != null) {
            for (MultipartFile file : removePicFile4) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/image/remove_" + removeCard + "_4_" + uid + extName;
                        buildingRemove.setRemovePic4(fileName);
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
        if (removePdfFile != null) {
            for (MultipartFile file : removePdfFile) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_" + removeCard + "_" + uid + extName;
                        buildingRemove.setRemovePdf(fileName);
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
        if (removePdfFile1 != null) {
            for (MultipartFile file : removePdfFile1) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_1_" + removeCard + "_" + uid + extName;
                        buildingRemove.setRemovePdf1(fileName);
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
        if (removePdfFile2 != null) {
            for (MultipartFile file : removePdfFile2) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_2_" + removeCard + "_" + uid + extName;
                        buildingRemove.setRemovePdf2(fileName);
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
        if (removePdfFile3 != null) {
            for (MultipartFile file : removePdfFile3) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_3_" + removeCard + "_" + uid + extName;
                        buildingRemove.setRemovePdf3(fileName);
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
        if (removePdfFile4 != null) {
            for (MultipartFile file : removePdfFile4) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_4_" + removeCard + "_" + uid + extName;
                        buildingRemove.setRemovePdf4(fileName);
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
        if (removePdfFile5 != null) {
            for (MultipartFile file : removePdfFile5) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_5_" + removeCard + "_" + uid + extName;
                        buildingRemove.setRemovePdf5(fileName);
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
        if (removePdfFile6 != null) {
            for (MultipartFile file : removePdfFile6) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_6_" + removeCard + "_" + uid + extName;
                        buildingRemove.setRemovePdf6(fileName);
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
        if (removePdfFile7 != null) {
            for (MultipartFile file : removePdfFile7) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_7_" + removeCard + "_" + uid + extName;
                        buildingRemove.setRemovePdf7(fileName);
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
        if (removePdfFile8 != null) {
            for (MultipartFile file : removePdfFile8) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_8_" + removeCard + "_" + uid + extName;
                        buildingRemove.setRemovePdf8(fileName);
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
        if (removePdfFile9 != null) {
            for (MultipartFile file : removePdfFile9) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_9_" + removeCard + "_" + uid + extName;
                        buildingRemove.setRemovePdf9(fileName);
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
        buildingRemove.setRemoveId(uid);
        buildingRemove.setRemoveName(removeName);
        buildingRemove.setRemoveSite(removeSite);
        buildingRemove.setRemoveTel(removeTel);
        buildingRemove.setRemoveCard(removeCard);
        buildingRemove.setRemoveLandNum(removeLandNum);
        buildingRemove.setRemoveProType(removeProType);
        buildingRemove.setRemoveLandArea(removeLandArea);
        buildingRemove.setRemoveHouseNum(removeHouseNum);
        buildingRemove.setRemoveHouseArea(removeHouseArea);
        buildingRemove.setRemoveState(removeState);
        buildingRemove.setRemoveUse(removeUse);
        buildingRemove.setRemoveHouseAreaCheck(removeHouseAreaCheck);
        buildingRemove.setRemoveBuildingAreaCheck(removeBuildingAreaCheck);
        buildingRemove.setRemoveAreaNoCer(removeAreaNoCer);
        buildingRemove.setRemoveLandAreaCheck(removeLandAreaCheck);
        buildingRemove.setRemoveLandAreaOk(removeLandAreaOk);
        buildingRemove.setRemoveLandAreaNoCer(removeLandAreaNoCer);
        buildingRemove.setRemoveNote(removeNote);
        buildingRemove.setRemoveDate(removeDate);
        buildingRemove.setRemoveCorner(removeCorner);
        buildingRemove.setRemovePicPos1(removePicPos1);
        buildingRemove.setRemovePicPos2(removePicPos2);
        buildingRemove.setRemovePicPos3(removePicPos3);
        buildingRemove.setRemovePicPos4(removePicPos4);
        buildingRemove.setRemoveSign(removeSign);
        buildingRemove.setAddId(addId);
        Address address = addressService.getAddressById(addId);
        buildingRemove.setRemovePid(address.getPid());
        buildingRemove.setRemoveTop(removeTop);
        int result = buildingRemoveService.insert(buildingRemove);
        if (removePPFile != null) {
            for (MultipartFile file : removePPFile) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        HousePanorama housePanorama = new HousePanorama();
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/panorama/pano_" + new Date().getTime() + extName;
                        String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                        File newFile = new File(path);
                        //父级目录不在就创建一个
                        if (!newFile.getParentFile().exists()) {
                            newFile.mkdirs();
                        }
                        file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                        String panoramaId = characterUtils.getUUID();
                        housePanorama.setPanoramaId(panoramaId);
                        housePanorama.setHouseId(uid);
                        housePanorama.setHousePanorama(fileName);
                        housePanorama.setHousePattern("室内");
                        result = housePanoramaService.insert(housePanorama);
                        result = result == 0 ? 2 : result;
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    @RequestMapping("/update")
    public @ResponseBody int update(
            @Nullable @RequestParam("removePicFile1") MultipartFile[] removePicFile1,
            @Nullable @RequestParam("removePicFile2") MultipartFile[] removePicFile2,
            @Nullable @RequestParam("removePicFile3") MultipartFile[] removePicFile3,
            @Nullable @RequestParam("removePicFile4") MultipartFile[] removePicFile4,
            @Nullable @RequestParam("removePdfFile") MultipartFile[] removePdfFile,
            @Nullable @RequestParam("removePdfFile1") MultipartFile[] removePdfFile1,
            @Nullable @RequestParam("removePdfFile2") MultipartFile[] removePdfFile2,
            @Nullable @RequestParam("removePdfFile3") MultipartFile[] removePdfFile3,
            @Nullable @RequestParam("removePdfFile4") MultipartFile[] removePdfFile4,
            @Nullable @RequestParam("removePdfFile5") MultipartFile[] removePdfFile5,
            @Nullable @RequestParam("removePdfFile6") MultipartFile[] removePdfFile6,
            @Nullable @RequestParam("removePdfFile7") MultipartFile[] removePdfFile7,
            @Nullable @RequestParam("removePdfFile8") MultipartFile[] removePdfFile8,
            @Nullable @RequestParam("removePdfFile9") MultipartFile[] removePdfFile9,
            @Nullable @RequestParam("removePPFile") MultipartFile[] removePPFile,
            @RequestParam("removeId") String removeId,
            @RequestParam("removeName") String removeName,
            @RequestParam("removeSite") String removeSite,
            @RequestParam("removeTel") String removeTel,
            @RequestParam("removeCard") String removeCard,
            @RequestParam("removeLandNum") String removeLandNum,
            @RequestParam("removeProType") String removeProType,
            @RequestParam("removeLandArea") String removeLandArea,
            @RequestParam("removeHouseNum") String removeHouseNum,
            @RequestParam("removeHouseArea") String removeHouseArea,
            @RequestParam("removeState") String removeState,
            @RequestParam("removeUse") String removeUse,
            @RequestParam("removeHouseAreaCheck") String removeHouseAreaCheck,
            @RequestParam("removeBuildingAreaCheck") String removeBuildingAreaCheck,
            @RequestParam("removeAreaNoCer") String removeAreaNoCer,
            @RequestParam("removeLandAreaCheck") String removeLandAreaCheck,
            @RequestParam("removeLandAreaOk") String removeLandAreaOk,
            @RequestParam("removeLandAreaNoCer") String removeLandAreaNoCer,
            @RequestParam("removeNote") String removeNote,
            @RequestParam("removeDate") String removeDate,
            @RequestParam("removeCorner") String removeCorner,
            @RequestParam("removePic1") String removePic1,
            @RequestParam("removePicPos1") String removePicPos1,
            @RequestParam("removePic2") String removePic2,
            @RequestParam("removePicPos2") String removePicPos2,
            @RequestParam("removePic3") String removePic3,
            @RequestParam("removePicPos3") String removePicPos3,
            @RequestParam("removePic4") String removePic4,
            @RequestParam("removePicPos4") String removePicPos4,
            @RequestParam("removePdf") String removePdf,
            @RequestParam("removePdf1") String removePdf1,
            @RequestParam("removePdf2") String removePdf2,
            @RequestParam("removePdf3") String removePdf3,
            @RequestParam("removePdf4") String removePdf4,
            @RequestParam("removePdf5") String removePdf5,
            @RequestParam("removePdf6") String removePdf6,
            @RequestParam("removePdf7") String removePdf7,
            @RequestParam("removePdf8") String removePdf8,
            @RequestParam("removePdf9") String removePdf9,
            @RequestParam("removeSign") String removeSign,
            @RequestParam("addId") String addId,
            @RequestParam("removeTop") String removeTop,
            HttpServletRequest request) throws Exception {
        BuildingRemove buildingRemove = new BuildingRemove();
        buildingRemove.setRemoveId(removeId);
        buildingRemove.setRemoveName(removeName);
        buildingRemove.setRemoveSite(removeSite);
        buildingRemove.setRemoveTel(removeTel);
        buildingRemove.setRemoveCard(removeCard);
        buildingRemove.setRemoveLandNum(removeLandNum);
        buildingRemove.setRemoveProType(removeProType);
        buildingRemove.setRemoveLandArea(removeLandArea);
        buildingRemove.setRemoveHouseNum(removeHouseNum);
        buildingRemove.setRemoveHouseArea(removeHouseArea);
        buildingRemove.setRemoveState(removeState);
        buildingRemove.setRemoveUse(removeUse);
        buildingRemove.setRemoveHouseAreaCheck(removeHouseAreaCheck);
        buildingRemove.setRemoveBuildingAreaCheck(removeBuildingAreaCheck);
        buildingRemove.setRemoveAreaNoCer(removeAreaNoCer);
        buildingRemove.setRemoveLandAreaCheck(removeLandAreaCheck);
        buildingRemove.setRemoveLandAreaOk(removeLandAreaOk);
        buildingRemove.setRemoveLandAreaNoCer(removeLandAreaNoCer);
        buildingRemove.setRemoveNote(removeNote);
        buildingRemove.setRemoveDate(removeDate);
        buildingRemove.setRemoveCorner(removeCorner);
        buildingRemove.setRemovePic1(removePic1);
        buildingRemove.setRemovePicPos1(removePicPos1);
        buildingRemove.setRemovePic2(removePic2);
        buildingRemove.setRemovePicPos2(removePicPos2);
        buildingRemove.setRemovePic3(removePic3);
        buildingRemove.setRemovePicPos3(removePicPos3);
        buildingRemove.setRemovePic4(removePic4);
        buildingRemove.setRemovePicPos4(removePicPos4);
        buildingRemove.setRemovePdf(removePdf);
        buildingRemove.setRemovePdf1(removePdf1);
        buildingRemove.setRemovePdf2(removePdf2);
        buildingRemove.setRemovePdf3(removePdf3);
        buildingRemove.setRemovePdf4(removePdf4);
        buildingRemove.setRemovePdf5(removePdf5);
        buildingRemove.setRemovePdf6(removePdf6);
        buildingRemove.setRemovePdf7(removePdf7);
        buildingRemove.setRemovePdf8(removePdf8);
        buildingRemove.setRemovePdf9(removePdf9);
        buildingRemove.setRemoveSign(removeSign);
        buildingRemove.setAddId(addId);
        Address address = addressService.getAddressById(addId);
        buildingRemove.setRemovePid(address.getPid());
        buildingRemove.setRemoveTop(removeTop);
        if (removePicFile1 != null) {
            for (MultipartFile file : removePicFile1) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/image/remove_" + removeCard + "_1_" + removeId + extName;
                        buildingRemove.setRemovePic1(fileName);
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
        if (removePicFile2 != null) {
            for (MultipartFile file : removePicFile2) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/image/remove_" + removeCard + "_2_" + removeId + extName;
                        buildingRemove.setRemovePic2(fileName);
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
        if (removePicFile3 != null) {
            for (MultipartFile file : removePicFile3) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/image/remove_" + removeCard + "_3_" + removeId + extName;
                        buildingRemove.setRemovePic3(fileName);
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
        if (removePicFile4 != null) {
            for (MultipartFile file : removePicFile4) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/image/remove_" + removeCard + "_4_" + removeId + extName;
                        buildingRemove.setRemovePic4(fileName);
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
        if (removePdfFile != null) {
            for (MultipartFile file : removePdfFile) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_" + removeCard + "_" + removeId + extName;
                        buildingRemove.setRemovePdf(fileName);
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
        if (removePdfFile1 != null) {
            for (MultipartFile file : removePdfFile1) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_1_" + removeCard + "_" + removeId + extName;
                        buildingRemove.setRemovePdf1(fileName);
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
        if (removePdfFile2 != null) {
            for (MultipartFile file : removePdfFile2) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_2_" + removeCard + "_" + removeId + extName;
                        buildingRemove.setRemovePdf2(fileName);
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
        if (removePdfFile3 != null) {
            for (MultipartFile file : removePdfFile3) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_3_" + removeCard + "_" + removeId + extName;
                        buildingRemove.setRemovePdf3(fileName);
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
        if (removePdfFile4 != null) {
            for (MultipartFile file : removePdfFile4) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_4_" + removeCard + "_" + removeId + extName;
                        buildingRemove.setRemovePdf4(fileName);
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
        if (removePdfFile5 != null) {
            for (MultipartFile file : removePdfFile5) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_5_" + removeCard + "_" + removeId + extName;
                        buildingRemove.setRemovePdf5(fileName);
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
        if (removePdfFile6 != null) {
            for (MultipartFile file : removePdfFile6) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_6_" + removeCard + "_" + removeId + extName;
                        buildingRemove.setRemovePdf6(fileName);
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
        if (removePdfFile7 != null) {
            for (MultipartFile file : removePdfFile7) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_7_" + removeCard + "_" + removeId + extName;
                        buildingRemove.setRemovePdf7(fileName);
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
        if (removePdfFile8 != null) {
            for (MultipartFile file : removePdfFile8) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_8_" + removeCard + "_" + removeId + extName;
                        buildingRemove.setRemovePdf8(fileName);
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
        if (removePdfFile9 != null) {
            for (MultipartFile file : removePdfFile9) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "remove/pdf/remove_9_" + removeCard + "_" + removeId + extName;
                        buildingRemove.setRemovePdf9(fileName);
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
        int result = buildingRemoveService.updateByPrimaryKey(buildingRemove);
        if (removePPFile != null) {
            for (MultipartFile file : removePPFile) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        HousePanorama housePanorama = new HousePanorama();
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/panorama/pano_" + new Date().getTime() + extName;
                        String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                        File newFile = new File(path);
                        //父级目录不在就创建一个
                        if (!newFile.getParentFile().exists()) {
                            newFile.mkdirs();
                        }
                        file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                        CharacterUtils characterUtils = new CharacterUtils();
                        String panoramaId = characterUtils.getUUID();
                        housePanorama.setPanoramaId(panoramaId);
                        housePanorama.setHouseId(removeId);
                        housePanorama.setHousePanorama(fileName);
                        housePanorama.setHousePattern("室内");
                        result = housePanoramaService.insert(housePanorama);
                        result = result == 0 ? 2 : result;
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody BuildingRemove buildingRemove) throws Exception {
        if (buildingRemove.getRemovePic1() != null && !Objects.equals(buildingRemove.getRemovePic1(), "null") && !Objects.equals(buildingRemove.getRemovePic1(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePic1();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePic2() != null && !Objects.equals(buildingRemove.getRemovePic2(), "null") && !Objects.equals(buildingRemove.getRemovePic2(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePic2();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePic3() != null && !Objects.equals(buildingRemove.getRemovePic3(), "null") && !Objects.equals(buildingRemove.getRemovePic3(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePic3();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePic4() != null && !Objects.equals(buildingRemove.getRemovePic4(), "null") && !Objects.equals(buildingRemove.getRemovePic4(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePic4();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePdf() != null && !Objects.equals(buildingRemove.getRemovePdf(), "null") && !Objects.equals(buildingRemove.getRemovePdf(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePdf1() != null && !Objects.equals(buildingRemove.getRemovePdf1(), "null") && !Objects.equals(buildingRemove.getRemovePdf1(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf1();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePdf2() != null && !Objects.equals(buildingRemove.getRemovePdf2(), "null") && !Objects.equals(buildingRemove.getRemovePdf2(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf2();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePdf3() != null && !Objects.equals(buildingRemove.getRemovePdf3(), "null") && !Objects.equals(buildingRemove.getRemovePdf3(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf3();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePdf4() != null && !Objects.equals(buildingRemove.getRemovePdf4(), "null") && !Objects.equals(buildingRemove.getRemovePdf4(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf4();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePdf5() != null && !Objects.equals(buildingRemove.getRemovePdf5(), "null") && !Objects.equals(buildingRemove.getRemovePdf5(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf5();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePdf6() != null && !Objects.equals(buildingRemove.getRemovePdf6(), "null") && !Objects.equals(buildingRemove.getRemovePdf6(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf6();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePdf7() != null && !Objects.equals(buildingRemove.getRemovePdf7(), "null") && !Objects.equals(buildingRemove.getRemovePdf7(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf7();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePdf8() != null && !Objects.equals(buildingRemove.getRemovePdf8(), "null") && !Objects.equals(buildingRemove.getRemovePdf8(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf8();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (buildingRemove.getRemovePdf9() != null && !Objects.equals(buildingRemove.getRemovePdf9(), "null") && !Objects.equals(buildingRemove.getRemovePdf9(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf9();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        int result = buildingRemoveService.deleteByPrimaryKey(buildingRemove.getRemoveId());
        List<HousePanorama> list = housePanoramaService.getHousePanoramaByHosueId(buildingRemove.getRemoveId());
        for (HousePanorama housePanorama : list) {
            result = deleteHousePanoramaPri(housePanorama);
        }
        return result;
    }

    public int deleteHousePanoramaPri(@RequestBody HousePanorama housePanorama) throws Exception {
        int result = 0;
        try {
            result = housePanoramaService.deleteByPrimaryKey(housePanorama.getPanoramaId());
            String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + housePanorama.getHousePanorama();
            File fileDel = new File(path);
            fileDel.createNewFile();
            fileDel.delete();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/getBuildingRemoveByAddId")
    public @ResponseBody List<BuildingRemove> getBuildingRemoveByAddId(@RequestBody BuildingRemove buildingRemove) {
        return buildingRemoveService.getBuildingRemoveByAddId(buildingRemove.getRemoveId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<BuildingRemove> buildingRemoves) throws Exception {
        List<String> removeIds = new ArrayList<>();
        for (BuildingRemove buildingRemove : buildingRemoves) {
            removeIds.add(buildingRemove.getRemoveId());
            if (buildingRemove.getRemovePic1() != null && !Objects.equals(buildingRemove.getRemovePic1(), "null") && !Objects.equals(buildingRemove.getRemovePic1(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePic1();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePic2() != null && !Objects.equals(buildingRemove.getRemovePic2(), "null") && !Objects.equals(buildingRemove.getRemovePic2(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePic2();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePic3() != null && !Objects.equals(buildingRemove.getRemovePic3(), "null") && !Objects.equals(buildingRemove.getRemovePic3(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePic3();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePic4() != null && !Objects.equals(buildingRemove.getRemovePic4(), "null") && !Objects.equals(buildingRemove.getRemovePic4(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePic4();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePdf() != null && !Objects.equals(buildingRemove.getRemovePdf(), "null") && !Objects.equals(buildingRemove.getRemovePdf(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePdf1() != null && !Objects.equals(buildingRemove.getRemovePdf1(), "null") && !Objects.equals(buildingRemove.getRemovePdf1(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf1();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePdf2() != null && !Objects.equals(buildingRemove.getRemovePdf2(), "null") && !Objects.equals(buildingRemove.getRemovePdf2(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf2();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePdf3() != null && !Objects.equals(buildingRemove.getRemovePdf3(), "null") && !Objects.equals(buildingRemove.getRemovePdf3(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf3();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePdf4() != null && !Objects.equals(buildingRemove.getRemovePdf4(), "null") && !Objects.equals(buildingRemove.getRemovePdf4(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf4();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePdf5() != null && !Objects.equals(buildingRemove.getRemovePdf5(), "null") && !Objects.equals(buildingRemove.getRemovePdf5(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf5();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePdf6() != null && !Objects.equals(buildingRemove.getRemovePdf6(), "null") && !Objects.equals(buildingRemove.getRemovePdf6(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf6();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePdf7() != null && !Objects.equals(buildingRemove.getRemovePdf7(), "null") && !Objects.equals(buildingRemove.getRemovePdf7(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf7();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePdf8() != null && !Objects.equals(buildingRemove.getRemovePdf8(), "null") && !Objects.equals(buildingRemove.getRemovePdf8(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf8();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (buildingRemove.getRemovePdf9() != null && !Objects.equals(buildingRemove.getRemovePdf9(), "null") && !Objects.equals(buildingRemove.getRemovePdf9(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + buildingRemove.getRemovePdf9();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            List<HousePanorama> list = housePanoramaService.getHousePanoramaByHosueId(buildingRemove.getRemoveId());
            for (HousePanorama housePanorama : list) {
                deleteHousePanoramaPri(housePanorama);
            }
        }
        return buildingRemoveService.batchDelete(removeIds);
    }

    @RequestMapping("/batchInsert")
    public @ResponseBody int batchInsert(@RequestBody List<BuildingRemove> buildingRemoves) {
        for (BuildingRemove buildingRemove : buildingRemoves) {
            CharacterUtils characterUtils = new CharacterUtils();
            String uid = characterUtils.getUUID();
            buildingRemove.setRemoveId(uid);
        }
        return buildingRemoveService.batchInsert(buildingRemoves);
    }

    @RequestMapping("/queryBuildingRemove")
    public @ResponseBody List<BuildingRemove> queryBuildingRemove(@RequestBody BuildingRemove buildingRemove) {
        return buildingRemoveService.queryBuildingRemove(buildingRemove);
    }

    @RequestMapping("/getBuildingRemoveByPid")
    public @ResponseBody List<BuildingRemove> getBuildingRemoveByPid(@RequestBody BuildingRemove buildingRemove) {
        return buildingRemoveService.getBuildingRemoveByPid(buildingRemove);
    }

    @RequestMapping("/countBuildingRemove")
    public @ResponseBody int countBuildingRemove() {
        return buildingRemoveService.countBuildingRemove();
    }

    @RequestMapping("/countBuildingRemoveLand")
    public @ResponseBody int countBuildingRemoveLand() {
        return buildingRemoveService.countBuildingRemoveLand();
    }

    @RequestMapping("/sumBuildingRemoveLandArea")
    public @ResponseBody double sumBuildingRemoveLandArea() {
        return buildingRemoveService.sumBuildingRemoveLandArea();
    }

    @RequestMapping("/sumBuildingRemoveHouseArea")
    public @ResponseBody double sumBuildingRemoveHouseArea() {
        return buildingRemoveService.sumBuildingRemoveHouseArea();
    }

    @RequestMapping("/countBuildingRemoveUse")
    public @ResponseBody List<Object> countBuildingRemoveUse() {
        return buildingRemoveService.countBuildingRemoveUse();
    }

    @RequestMapping("/countBuildingRemoveLandNum")
    public @ResponseBody List<Object> countBuildingRemoveLandNum() {
        return buildingRemoveService.countBuildingRemoveLandNum();
    }

    @RequestMapping("/countBuildingRemoveLandArea")
    public @ResponseBody List<Object> countBuildingRemoveLandArea() {
        return buildingRemoveService.countBuildingRemoveLandArea();
    }
}
