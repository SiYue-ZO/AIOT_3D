package com.city3d.controller;

import java.io.File;
import java.util.ArrayList;
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

import com.city3d.dao.entry.Company;
import com.city3d.service.CompanyService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/queryCompanyData")
    public @ResponseBody List<Company> queryCompanyData(@RequestBody Company company) {
        return companyService.queryCompanyData(company);
    }

    @RequestMapping("/selectCompanyById")
    public @ResponseBody Company selectCompanyById(@RequestBody Company company) {
        return companyService.selectCompanyById(company.getCompanyId());
    }

    @RequestMapping("/getCompanyByAddId")
    public @ResponseBody List<Company> getCompanyByAddId(@RequestBody Company company) {
        return companyService.getCompanyByAddId(company.getAddId());
    }

    @RequestMapping("/getCompanyByComName")
    public @ResponseBody List<Company> getCompanyByComName(@RequestBody Company company) {
        return companyService.getCompanyByComName(company.getCommunity());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("companyId") String companyId,
                                    @RequestParam("addId") String addId, @RequestParam("name") String name, @RequestParam("organization") String organization,
                                    @RequestParam("industryType") String industryType, @RequestParam("nineSmallType") String nineSmallType, @RequestParam("tel") String tel,
                                    @RequestParam("economicNature") String economicNature, @RequestParam("leader") String leader, @RequestParam("legalMan") String legalMan,
                                    @RequestParam("identity") String identity, @RequestParam("operateMode") String operateMode, @RequestParam("mainBusiness") String mainBusiness,
                                    @RequestParam("secondBusiness") String secondBusiness, @RequestParam("openDate") String openDate, @RequestParam("licenseNo") String licenseNo,
                                    @RequestParam("registMoney") String registMoney, @RequestParam("registAddress") String registAddress, @RequestParam("registDate") String registDate,
                                    @RequestParam("buildingHeight") String buildingHeight, @RequestParam("buildingStorey") String buildingStorey, @RequestParam("businessScope") String businessScope,
                                    @RequestParam("coverArea") String coverArea, @RequestParam("constructionArea") String constructionArea, @RequestParam("constructionManagerCompany") String constructionManagerCompany,
                                    @RequestParam("geometryInfo") String geometryInfo, @RequestParam("autoFire") String autoFire, @RequestParam("fireLevel") String fireLevel,
                                    @RequestParam("fireManager") String fireManager, @RequestParam("fireMange") String fireMange, @RequestParam("mainManageDepartment") String mainManageDepartment,
                                    @RequestParam("manageDepartment") String manageDepartment, @RequestParam("upperCompany") String upperCompany, @RequestParam("manageType") String manageType,
                                    @RequestParam("saveLevel") String saveLevel, @RequestParam("saveManName") String saveManName, @RequestParam("saveManTel") String saveManTel,
                                    @RequestParam("saveType") String saveType, @RequestParam("community") String community, @RequestParam("imageInfo") String imageInfo,
                                    HttpServletRequest request) throws Exception {
        Company company = new Company();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/company/com_" + name + organization + extName;
                        company.setImageInfo(fileName);
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
        company.setCompanyId(uid);
        company.setAddId(addId);
        company.setName(name);
        company.setOrganization(organization);
        company.setIndustryType(industryType);
        company.setNineSmallType(nineSmallType);
        company.setTel(tel);
        company.setEconomicNature(economicNature);
        company.setLeader(leader);
        company.setLegalMan(legalMan);
        company.setIdentity(identity);
        company.setOperateMode(operateMode);
        company.setMainBusiness(mainBusiness);
        company.setSecondBusiness(secondBusiness);
        company.setOpenDate(openDate);
        company.setLicenseNo(licenseNo);
        company.setRegistMoney(registMoney);
        company.setRegistAddress(registAddress);
        company.setRegistDate(registDate);
        company.setBuildingHeight(buildingHeight);
        company.setBuildingStorey(buildingStorey);
        company.setBusinessScope(businessScope);
        company.setCoverArea(coverArea);
        company.setConstructionArea(constructionArea);
        company.setConstructionManagerCompany(constructionManagerCompany);
        company.setGeometryInfo(geometryInfo);
        company.setAutoFire(autoFire);
        company.setFireLevel(fireLevel);
        company.setFireManager(fireManager);
        company.setFireMange(fireMange);
        company.setMainManageDepartment(mainManageDepartment);
        company.setManageDepartment(manageDepartment);
        company.setUpperCompany(upperCompany);
        company.setManageType(manageType);
        company.setSaveLevel(saveLevel);
        company.setSaveManName(saveManName);
        company.setSaveManTel(saveManTel);
        company.setSaveType(saveType);
        String fianlCommunity = community;
        if (community.contains(",")) {
            fianlCommunity = community.substring(1);
        }
        company.setCommunity(fianlCommunity);
        return companyService.save(company);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("companyId") String companyId,
                                    @RequestParam("addId") String addId, @RequestParam("name") String name, @RequestParam("organization") String organization,
                                    @RequestParam("industryType") String industryType, @RequestParam("nineSmallType") String nineSmallType, @RequestParam("tel") String tel,
                                    @RequestParam("economicNature") String economicNature, @RequestParam("leader") String leader, @RequestParam("legalMan") String legalMan,
                                    @RequestParam("identity") String identity, @RequestParam("operateMode") String operateMode, @RequestParam("mainBusiness") String mainBusiness,
                                    @RequestParam("secondBusiness") String secondBusiness, @RequestParam("openDate") String openDate, @RequestParam("licenseNo") String licenseNo,
                                    @RequestParam("registMoney") String registMoney, @RequestParam("registAddress") String registAddress, @RequestParam("registDate") String registDate,
                                    @RequestParam("buildingHeight") String buildingHeight, @RequestParam("buildingStorey") String buildingStorey, @RequestParam("businessScope") String businessScope,
                                    @RequestParam("coverArea") String coverArea, @RequestParam("constructionArea") String constructionArea, @RequestParam("constructionManagerCompany") String constructionManagerCompany,
                                    @RequestParam("geometryInfo") String geometryInfo, @RequestParam("autoFire") String autoFire, @RequestParam("fireLevel") String fireLevel,
                                    @RequestParam("fireManager") String fireManager, @RequestParam("fireMange") String fireMange, @RequestParam("mainManageDepartment") String mainManageDepartment,
                                    @RequestParam("manageDepartment") String manageDepartment, @RequestParam("upperCompany") String upperCompany, @RequestParam("manageType") String manageType,
                                    @RequestParam("saveLevel") String saveLevel, @RequestParam("saveManName") String saveManName, @RequestParam("saveManTel") String saveManTel,
                                    @RequestParam("saveType") String saveType, @RequestParam("community") String community, @RequestParam("imageInfo") String imageInfo,
                                    HttpServletRequest request) throws Exception {
        Company company = new Company();
        company.setImageInfo(imageInfo);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/company/com_" + name + organization + extName;
                        company.setImageInfo(fileName);
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
        company.setCompanyId(companyId);
        company.setAddId(addId);
        company.setName(name);
        company.setOrganization(organization);
        company.setIndustryType(industryType);
        company.setNineSmallType(nineSmallType);
        company.setTel(tel);
        company.setEconomicNature(economicNature);
        company.setLeader(leader);
        company.setLegalMan(legalMan);
        company.setIdentity(identity);
        company.setOperateMode(operateMode);
        company.setMainBusiness(mainBusiness);
        company.setSecondBusiness(secondBusiness);
        company.setOpenDate(openDate);
        company.setLicenseNo(licenseNo);
        company.setRegistMoney(registMoney);
        company.setRegistAddress(registAddress);
        company.setRegistDate(registDate);
        company.setBuildingHeight(buildingHeight);
        company.setBuildingStorey(buildingStorey);
        company.setBusinessScope(businessScope);
        company.setCoverArea(coverArea);
        company.setConstructionArea(constructionArea);
        company.setConstructionManagerCompany(constructionManagerCompany);
        company.setGeometryInfo(geometryInfo);
        company.setAutoFire(autoFire);
        company.setFireLevel(fireLevel);
        company.setFireManager(fireManager);
        company.setFireMange(fireMange);
        company.setMainManageDepartment(mainManageDepartment);
        company.setManageDepartment(manageDepartment);
        company.setUpperCompany(upperCompany);
        company.setManageType(manageType);
        company.setSaveLevel(saveLevel);
        company.setSaveManName(saveManName);
        company.setSaveManTel(saveManTel);
        company.setSaveType(saveType);
        company.setCommunity(community);
        return companyService.updateByPrimaryKey(company);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody Company company) throws Exception {
        if (company.getImageInfo() != null && !Objects.equals(company.getImageInfo(), "null") && !Objects.equals(company.getImageInfo(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + company.getImageInfo();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return companyService.deleteById(company.getCompanyId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Company> companys) throws Exception {
        List<String> companyIds = new ArrayList<>();
        for (Company company : companys) {
            companyIds.add(company.getCompanyId());
            if (company.getImageInfo() != null && !Objects.equals(company.getImageInfo(), "null") && !Objects.equals(company.getImageInfo(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + company.getImageInfo();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return companyService.batchDelete(companyIds);
    }
}
