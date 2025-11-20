package com.city3d.controller;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.shapefile.dbf.DbaseFileHeader;
import org.geotools.data.shapefile.dbf.DbaseFileReader;
import org.geotools.data.shapefile.files.ShpFiles;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.io.WKTReader;

import com.city3d.dao.entry.Building;
import com.city3d.service.BuildingService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/getBuilding")
    public @ResponseBody List<Building> getBuilding() {
        return buildingService.getBuilding();
    }

    @RequestMapping("/getBuildingById")
    public @ResponseBody Building getBuildingById(@RequestBody Building building) {
        return buildingService.getBuildingById(building.getBuildingId());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(
            @RequestParam("buildingId") String buildingId,
            @RequestParam("coordinates") String coordinates,
            @RequestParam("dbnum") String dbnum,
            @RequestParam("tdxz") String tdxz,
            @RequestParam("yxgs") String yxgs,
            @RequestParam("jzzdmj") String jzzdmj,
            @RequestParam("sjjzmj") String sjjzmj,
            @RequestParam("fwcs") String fwcs,
            @RequestParam("fwjg") String fwjg,
            @RequestParam("zdh") String zdh,
            @RequestParam("fczh") String fczh,
            @RequestParam("note") String note,
            @RequestParam("buildingImg") String buildingImg,
            @RequestParam("buildingPdf1") String buildingPdf1,
            @RequestParam("buildingPdf2") String buildingPdf2,
            @RequestParam("buildingPdf3") String buildingPdf3,
            @Nullable @RequestParam("buildingImgFiles") MultipartFile[] buildingImgFiles,
            @Nullable @RequestParam("buildingPdf1Files") MultipartFile[] buildingPdf1Files,
            @Nullable @RequestParam("buildingPdf2Files") MultipartFile[] buildingPdf2Files,
            @Nullable @RequestParam("buildingPdf3Files") MultipartFile[] buildingPdf3Files,
            HttpServletRequest request) throws Exception {
        Building building = new Building();
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        if (buildingImgFiles != null) {
            for (MultipartFile file : buildingImgFiles) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "building/image/bu_" + dbnum + uid + extName;
                        building.setBuildingImg(fileName);
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
        if (buildingPdf1Files != null) {
            for (MultipartFile file : buildingPdf1Files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "building/pdf/bu_1_" + dbnum + uid + extName;
                        building.setBuildingPdf1(fileName);
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
        if (buildingPdf2Files != null) {
            for (MultipartFile file : buildingPdf2Files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "building/pdf/bu_2_" + dbnum + uid + extName;
                        building.setBuildingPdf2(fileName);
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
        if (buildingPdf3Files != null) {
            for (MultipartFile file : buildingPdf3Files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "building/pdf/bu_3_" + dbnum + uid + extName;
                        building.setBuildingPdf3(fileName);
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
        building.setBuildingId(uid);
        building.setCoordinates(coordinates);
        building.setDbnum(dbnum);
        building.setTdxz(tdxz);
        building.setYxgs(yxgs);
        building.setJzzdmj(jzzdmj);
        building.setSjjzmj(sjjzmj);
        building.setFwcs(fwcs);
        building.setFwjg(fwjg);
        building.setZdh(zdh);
        building.setFczh(fczh);
        building.setNote(note);
        return buildingService.insert(building);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(
            @RequestParam("buildingId") String buildingId,
            @RequestParam("coordinates") String coordinates,
            @RequestParam("dbnum") String dbnum,
            @RequestParam("tdxz") String tdxz,
            @RequestParam("yxgs") String yxgs,
            @RequestParam("jzzdmj") String jzzdmj,
            @RequestParam("sjjzmj") String sjjzmj,
            @RequestParam("fwcs") String fwcs,
            @RequestParam("fwjg") String fwjg,
            @RequestParam("zdh") String zdh,
            @RequestParam("fczh") String fczh,
            @RequestParam("note") String note,
            @RequestParam("buildingImg") String buildingImg,
            @RequestParam("buildingPdf1") String buildingPdf1,
            @RequestParam("buildingPdf2") String buildingPdf2,
            @RequestParam("buildingPdf3") String buildingPdf3,
            @Nullable @RequestParam("buildingImgFiles") MultipartFile[] buildingImgFiles,
            @Nullable @RequestParam("buildingPdf1Files") MultipartFile[] buildingPdf1Files,
            @Nullable @RequestParam("buildingPdf2Files") MultipartFile[] buildingPdf2Files,
            @Nullable @RequestParam("buildingPdf3Files") MultipartFile[] buildingPdf3Files,
            HttpServletRequest request) throws Exception {
        Building building = new Building();
        building.setBuildingId(buildingId);
        building.setCoordinates(coordinates);
        building.setDbnum(dbnum);
        building.setTdxz(tdxz);
        building.setYxgs(yxgs);
        building.setJzzdmj(jzzdmj);
        building.setSjjzmj(sjjzmj);
        building.setFwcs(fwcs);
        building.setFwjg(fwjg);
        building.setZdh(zdh);
        building.setFczh(fczh);
        building.setNote(note);
        building.setBuildingImg(buildingImg);
        building.setBuildingPdf1(buildingPdf1);
        building.setBuildingPdf2(buildingPdf2);
        building.setBuildingPdf3(buildingPdf3);
        if (buildingImgFiles != null) {
            for (MultipartFile file : buildingImgFiles) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "building/image/bu_" + dbnum + buildingId + extName;
                        building.setBuildingImg(fileName);
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
        if (buildingPdf1Files != null) {
            for (MultipartFile file : buildingPdf1Files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "building/pdf/bu_1_" + dbnum + buildingId + extName;
                        building.setBuildingPdf1(fileName);
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
        if (buildingPdf2Files != null) {
            for (MultipartFile file : buildingPdf2Files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "building/pdf/bu_2_" + dbnum + buildingId + extName;
                        building.setBuildingPdf2(fileName);
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
        if (buildingPdf3Files != null) {
            for (MultipartFile file : buildingPdf3Files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "building/pdf/bu_3_" + dbnum + buildingId + extName;
                        building.setBuildingPdf3(fileName);
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
        return buildingService.updateByPrimaryKey(building);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody Building building) throws Exception {
        if (building.getBuildingImg() != null && !Objects.equals(building.getBuildingImg(), "null") && !Objects.equals(building.getBuildingImg(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + building.getBuildingImg();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (building.getBuildingPdf1() != null && !Objects.equals(building.getBuildingPdf1(), "null") && !Objects.equals(building.getBuildingPdf1(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + building.getBuildingPdf1();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (building.getBuildingPdf2() != null && !Objects.equals(building.getBuildingPdf2(), "null") && !Objects.equals(building.getBuildingPdf2(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + building.getBuildingPdf2();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (building.getBuildingPdf3() != null && !Objects.equals(building.getBuildingPdf3(), "null") && !Objects.equals(building.getBuildingPdf3(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + building.getBuildingPdf3();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return buildingService.deleteByPrimaryKey(building.getBuildingId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Building> buildings) throws Exception {
        List<String> buildingIds = new ArrayList<>();
        for (Building building : buildings) {
            buildingIds.add(building.getBuildingId());
            if (building.getBuildingImg() != null && !Objects.equals(building.getBuildingImg(), "null") && !Objects.equals(building.getBuildingImg(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + building.getBuildingImg();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (building.getBuildingPdf1() != null && !Objects.equals(building.getBuildingPdf1(), "null") && !Objects.equals(building.getBuildingPdf1(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + building.getBuildingPdf1();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (building.getBuildingPdf2() != null && !Objects.equals(building.getBuildingPdf2(), "null") && !Objects.equals(building.getBuildingPdf2(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + building.getBuildingPdf2();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (building.getBuildingPdf3() != null && !Objects.equals(building.getBuildingPdf3(), "null") && !Objects.equals(building.getBuildingPdf3(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + building.getBuildingPdf3();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return buildingService.batchDelete(buildingIds);
    }

    @RequestMapping("/queryBuilding")
    public @ResponseBody List<Building> queryBuilding(@RequestBody Building building) {
        return buildingService.queryBuilding(building);
    }

    @RequestMapping("/selectbyshp")
    public @ResponseBody List<Building> selectbyshp(String filename, HttpServletRequest request) {
        ShapefileDataStoreFactory dataStoreFactory = new ShapefileDataStoreFactory();
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
        List<Building> result = new ArrayList<>();
        List<Building> buildingList = buildingService.getBuilding();
        try {
            //读取shp
            String savePath = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\shp\\" + filename;
            ShapefileDataStore sds = (ShapefileDataStore) dataStoreFactory.createDataStore(new File(savePath).toURI().toURL());
            sds.setCharset(Charset.forName("UTF-8"));
            SimpleFeatureSource featureSource = sds.getFeatureSource();
            SimpleFeatureIterator itertor = featureSource.getFeatures().features();
            WKTReader reader = new WKTReader(geometryFactory);
            int n = 0;

            while (itertor.hasNext()) {
                SimpleFeature feature = itertor.next();
                MultiPolygon geom = (MultiPolygon) feature.getAttribute("the_geom");
                String geomStr = "POLYGON((" + geom.toString().substring(16, geom.toString().length() - 3) + "))";
                String[] valueArr = geom.toString().substring(16, geom.toString().length() - 3).split(",");
                String valueStr = "";
                for (int i = 0; i < valueArr.length; i++) {
                    String[] valuexy = valueArr[i].split(" ");
                    if (i == 0) {
                        valueStr += valuexy[0] + "," + valuexy[1] + ",";
                    } else {
                        valueStr += valuexy[1] + "," + valuexy[2] + ",";
                    }
                }
                String valueStrResult = valueStr.substring(0, valueStr.length() - 1);
                Building queryshp = new Building();
                queryshp.setBuildingId("qshp_" + n);
                n++;
                queryshp.setCoordinates(valueStrResult);
                result.add(queryshp);

                //shp框选范围
                Geometry shpgeometry = reader.read(geomStr);
                for (Building building : buildingList) {
                    String coordinates = building.getCoordinates();
                    String[] coordinatesArr = coordinates.split(",");
                    String gtlineStr = "POLYGON((";
                    for (int j = 0; j < coordinatesArr.length; j += 2) {
                        gtlineStr += coordinatesArr[j] + " " + coordinatesArr[j + 1] + ",";
                    }
                    gtlineStr += coordinatesArr[0] + " " + coordinatesArr[1] + "))";
                    Geometry bugeometry = reader.read(gtlineStr);
                    //相交
                    if (shpgeometry.intersects(bugeometry)) {
                        Building resultBu = building;
                        result.add(resultBu);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/saveShp")
    public @ResponseBody int saveShp(String filename, HttpServletRequest request) {
        ShapefileDataStoreFactory dataStoreFactory = new ShapefileDataStoreFactory();
        DbaseFileReader dbfreader;
        int result = 0;
        try {
            //读取shp
            String savePath = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\shp\\" + filename;
            ShapefileDataStore sds = (ShapefileDataStore) dataStoreFactory.createDataStore(new File(savePath).toURI().toURL());
            sds.setCharset(Charset.forName("UTF-8"));
            SimpleFeatureSource featureSource = sds.getFeatureSource();
            SimpleFeatureIterator itertor = featureSource.getFeatures().features();

            //读取dbf
            String dbffilename = filename.substring(0, filename.lastIndexOf(".")) + ".dbf";
            String dbfPath = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\shp\\" + dbffilename;
            dbfreader = new DbaseFileReader(new ShpFiles(dbfPath), false, Charset.forName("GBK"));
            DbaseFileHeader dbfheader = dbfreader.getHeader();
            int numFields = dbfheader.getNumFields();

            while (itertor.hasNext() && dbfreader.hasNext()) {
                SimpleFeature feature = itertor.next();
                MultiPolygon geom = (MultiPolygon) feature.getAttribute("the_geom");
                String geomStr = geom.toString().substring(16, geom.toString().length() - 3).split("\\)")[0];
                String[] valueArr = geomStr.split(",");
                String valueStr = "";
                for (int i = 0; i < valueArr.length; i++) {
                    String[] valuexy = valueArr[i].split(" ");
                    if (i == 0) {
                        valueStr += valuexy[0] + "," + valuexy[1] + ",";
                    } else {
                        valueStr += valuexy[1] + "," + valuexy[2] + ",";
                    }
                }
                String valueStrResult = valueStr.substring(0, valueStr.length() - 1);

                Building building = new Building();
                CharacterUtils characterUtils = new CharacterUtils();
                String uid = characterUtils.getUUID();
                building.setBuildingId(uid);
                building.setCoordinates(valueStrResult);

                Object[] entry = dbfreader.readEntry();
                for (int j = 0; j < numFields; j++) {
                    String title = dbfheader.getFieldName(j);
                    switch (title) {
                        case "dbnum":
                            building.setDbnum(entry[j].toString());
                            break;
                        case "tdxz":
                            building.setTdxz(entry[j].toString());
                            break;
                        case "yxgs":
                            building.setYxgs(entry[j].toString());
                            break;
                        case "jzzdmj":
                            building.setJzzdmj(entry[j].toString());
                            break;
                        case "sjjzmj":
                            building.setSjjzmj(entry[j].toString());
                            break;
                        case "fwcs":
                            building.setFwcs(entry[j].toString());
                            break;
                        case "fwjg":
                            building.setFwjg(entry[j].toString());
                            break;
                        case "zdh":
                            building.setZdh(entry[j].toString());
                            break;
                        case "fczh":
                            building.setFczh(entry[j].toString());
                            break;
                        default:
                            break;
                    }
                }
                result = buildingService.insert(building);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
