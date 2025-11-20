package com.city3d.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.city3d.dao.mapper.datasource1.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.entry.SysPara;
import com.city3d.dao.entry.VideoExample;
import com.city3d.service.GeneralService;
import org.springframework.stereotype.Service;

@Service
public class GeneralServiceImpl implements GeneralService {
    @Autowired
    private GeneralMapper generalMapper;
    @Autowired
    private PoliceCaseMapper policeCaseMapper;
    @Autowired
    private WallMapper wallMapper;
    @Autowired
    private FaceIdentityMapper faceIdentityMapper;
    @Autowired
    private AlertMapper alertMapper;
    @Autowired
    private AlarmMapper alarmMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private PoliceMapper policeMapper;
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private PeopleBaseMapper peopleBaseMapper;
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private NetMapper netMapper;
    @Autowired
    private SecurityMapper securityMapper;
    @Autowired
    private EplanMapper eplanMapper;
    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private BimMapper bimMapper;
    @Autowired
    private KeyPeopleMapper keyPeopleMapper;
    @Autowired
    private CoverageMapper coverageMapper;
    @Autowired
    private PoliceNetMapper policeNetMapper;
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private Tiles3dMapper tiles3dMapper;
    @Autowired
    private DatalayerMapper datalayerMapper;
    @Autowired
    private RoamMapper roamMapper;
    @Autowired
    private SysParaMapper sysParaMapper;


    @Override
    public List<HashMap<String, String>> countPeople() {
        return generalMapper.countPeople();
    }

    @Override
    public List<HashMap<String, String>> countAdd() {
        return generalMapper.countAdd();
    }

    @Override
    public List<HashMap<String, String>> countDep() {
        return generalMapper.countDep();
    }

    @Override
    public List<HashMap<String, String>> countPatrol() {
        return generalMapper.countPatrol();
    }

    @Override
    public List<HashMap<String, String>> countCam() {
        return generalMapper.countCam();
    }

    @Override
    public List<HashMap<String, String>> countMan() {
        return generalMapper.countMan();
    }

    @Override
    public List<SysPara> getMain() {
        return sysParaMapper.selectByExample(null);
    }

    @Override
    public List<Object> countGeneralByExample() {
        List<Object> resultList = new ArrayList<>();
        resultList.add(policeCaseMapper.countByExample(null));
        resultList.add(wallMapper.countByExample(null));
        resultList.add(faceIdentityMapper.countByExample(null));
        resultList.add(alertMapper.countByExample(null));
        resultList.add(alarmMapper.countByExample(null));
        VideoExample example = new VideoExample();
        example.or().andCamIsnodeEqualTo(false);
        resultList.add(videoMapper.countByExample(example));
        resultList.add(policeMapper.countByExample(null));
        resultList.add(carMapper.countByExample(null));
        resultList.add(equipmentMapper.countByExample(null));
        resultList.add(addressMapper.countByExample(null));
        resultList.add(peopleBaseMapper.countByExample(null));
        resultList.add(houseMapper.countByExample(null));
        resultList.add(companyMapper.countByExample(null));
        resultList.add(netMapper.countByExample(null));
        resultList.add(securityMapper.countByExample(null));
        resultList.add(eplanMapper.countByExample(null));
        resultList.add(planMapper.countByExample(null));
        resultList.add(bimMapper.countByExample(null));
        resultList.add(keyPeopleMapper.countByExample(null));
        resultList.add(coverageMapper.countByExample(null));
        resultList.add(policeNetMapper.countByExample(null));
        resultList.add(buildingMapper.countByExample(null));
        resultList.add(tiles3dMapper.countByExample(null));
        resultList.add(datalayerMapper.countByExample(null));
        resultList.add(roamMapper.countByExample(null));
        return resultList;
    }
}
