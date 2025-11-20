package com.city3d.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.city3d.dao.entry.*;
import com.city3d.dao.mapper.datasource1.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.entry.NetExample.Criteria;
import com.city3d.service.NetService;
import org.springframework.stereotype.Service;

@Service
public class NetServiceImpl implements NetService {
    @Autowired
    private NetMapperC netMapper;
    @Autowired
    private PeopleBaseMapper peopleBaseMapper;
    @Autowired
    private AddressMapperC addressMapperC;
    @Autowired
    private HouseMapperC houseMapperC;
    @Autowired
    private CompanyMapperC companyMapperC;
    @Autowired
    private BuildingRemoveMapperC buildingRemoveMapperC;
    @Autowired
    private SysRoleMapperC sysRoleMapperC;

    @Override
    public List<Object> getNetAndCount(Net net) {
        NetExample netExample = new NetExample();
        netExample.or().andNetLevelEqualTo(net.getNetLevel());
        List<Net> net3List = netMapper.selectByExample(netExample);
        netExample.clear();
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3List);
        PeopleBaseExample example = new PeopleBaseExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : net3List) {
            netExample.or().andNetPidEqualTo(value.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            long peopleBaseCount = 0;
            for (Net item : net4List) {
                example.or().andCommunityCodeEqualTo(item.getNetId());
                peopleBaseCount += peopleBaseMapper.countByExample(example);
                example.clear();
            }
            resultList.add(peopleBaseCount);

            long addressCount = 0;
            for (Net item : net4List) {
                addressExample.or().andPidEqualTo(item.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount);

            netExample.or().andNetPidEqualTo(value.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetAndCountById(Net net) {
        //根据权限获取net
        SysRole sysRole = sysRoleMapperC.getAllandNetById(net.getNetPid());
        List<Net> net3List = new ArrayList<>();
        for (SysRoleNet sysRoleNet : sysRole.getSysRoleNet()) {
            if (sysRoleNet.getNet().getNetLevel().equals(net.getNetLevel())) {
                net3List.add(sysRoleNet.getNet());
            }
        }
        //输出结果
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3List);

        NetExample netExample = new NetExample();
        PeopleBaseExample example = new PeopleBaseExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : net3List) {
            netExample.or().andNetPidEqualTo(value.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            long peopleBaseCount = 0;
            for (Net item : net4List) {
                example.or().andCommunityCodeEqualTo(item.getNetId());
                peopleBaseCount += peopleBaseMapper.countByExample(example);
                example.clear();
            }
            resultList.add(peopleBaseCount);

            long addressCount = 0;
            for (Net item : net4List) {
                addressExample.or().andPidEqualTo(item.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount);

            netExample.or().andNetPidEqualTo(value.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetByExample(Net net) {
        NetExample netExample = new NetExample();
        Criteria criteriaResult = netExample.or();
        if (net.getNetLevel() != null) {
            criteriaResult = criteriaResult.andNetLevelEqualTo(net.getNetLevel());
        }
        if (net.getNetPid() != null) {
            criteriaResult = criteriaResult.andNetPidEqualTo(net.getNetPid());
        }
        List<Net> net4List = netMapper.selectByExample(netExample);
        netExample.clear();
        List<Object> resultList = new ArrayList<>();
        resultList.add(net4List);
        PeopleBaseExample example = new PeopleBaseExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : net4List) {
            example.or().andCommunityCodeEqualTo(value.getNetId());
            resultList.add(peopleBaseMapper.countByExample(example));
            example.clear();

            addressExample.or().andPidEqualTo(value.getNetId());
            resultList.add(addressMapperC.countByExample(addressExample));
            addressExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetAndCountHouse(Net net) {
        NetExample netExample = new NetExample();
        netExample.or().andNetLevelEqualTo(net.getNetLevel());
        List<Net> net3List = netMapper.selectByExample(netExample);
        netExample.clear();
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3List);
        HouseExample example = new HouseExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : net3List) {
            netExample.or().andNetPidEqualTo(value.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            long houseCount = 0;
            for (Net item : net4List) {
                example.or().andHouseUrlEqualTo(item.getNetId());
                houseCount += houseMapperC.countByExample(example);
                example.clear();
            }
            resultList.add(houseCount);

            long addressCount = 0;
            for (Net item : net4List) {
                addressExample.or().andPidEqualTo(item.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount);

            netExample.or().andNetPidEqualTo(value.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetAndCountHouseById(Net net) {
        //根据权限获取net
        SysRole sysRole = sysRoleMapperC.getAllandNetById(net.getNetPid());
        List<Net> net3List = new ArrayList<>();
        for (SysRoleNet sysRoleNet : sysRole.getSysRoleNet()) {
            if (sysRoleNet.getNet().getNetLevel().equals(net.getNetLevel())) {
                net3List.add(sysRoleNet.getNet());
            }
        }
        //输出结果
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3List);

        NetExample netExample = new NetExample();
        HouseExample example = new HouseExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : net3List) {
            netExample.or().andNetPidEqualTo(value.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            long houseCount = 0;
            for (Net item : net4List) {
                example.or().andHouseUrlEqualTo(item.getNetId());
                houseCount += houseMapperC.countByExample(example);
                example.clear();
            }
            resultList.add(houseCount);

            long addressCount = 0;
            for (Net item : net4List) {
                addressExample.or().andPidEqualTo(item.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount);

            netExample.or().andNetPidEqualTo(value.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetHouseByExample(Net net) {
        NetExample netExample = new NetExample();
        Criteria criteriaResult = netExample.or();
        if (net.getNetLevel() != null) {
            criteriaResult = criteriaResult.andNetLevelEqualTo(net.getNetLevel());
        }
        if (net.getNetPid() != null) {
            criteriaResult = criteriaResult.andNetPidEqualTo(net.getNetPid());
        }
        List<Net> net4List = netMapper.selectByExample(netExample);
        netExample.clear();
        List<Object> resultList = new ArrayList<>();
        resultList.add(net4List);
        HouseExample example = new HouseExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : net4List) {
            example.or().andHouseUrlEqualTo(value.getNetId());
            resultList.add(houseMapperC.countByExample(example));
            example.clear();

            addressExample.or().andPidEqualTo(value.getNetId());
            resultList.add(addressMapperC.countByExample(addressExample));
            addressExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetCompanyByExample(Net net) {
        NetExample netExample = new NetExample();
        netExample.or().andNetLevelEqualTo(net.getNetLevel());
        List<Net> result = netMapper.selectByExample(netExample);
        netExample.clear();
        List<Object> resultList = new ArrayList<>();
        resultList.add(result);
        CompanyExample example = new CompanyExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : result) {
            example.or().andCommunityEqualTo(value.getNetId());
            resultList.add(companyMapperC.countByExample(example));
            example.clear();

            addressExample.or().andPidEqualTo(value.getNetId());
            resultList.add(addressMapperC.countByExample(addressExample));
            addressExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetCompanyByExampleById(Net net) {
        //根据权限获取net
        SysRole sysRole = sysRoleMapperC.getAllandNetById(net.getNetPid());
        List<Net> net3List = new ArrayList<>();
        for (SysRoleNet sysRoleNet : sysRole.getSysRoleNet()) {
            if (sysRoleNet.getNet().getNetLevel().equals(net.getNetLevel())) {
                net3List.add(sysRoleNet.getNet());
            }
        }
        //输出结果
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3List);

        NetExample netExample = new NetExample();
        CompanyExample example = new CompanyExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : net3List) {
            example.or().andCommunityEqualTo(value.getNetId());
            resultList.add(companyMapperC.countByExample(example));
            example.clear();

            addressExample.or().andPidEqualTo(value.getNetId());
            resultList.add(addressMapperC.countByExample(addressExample));
            addressExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetAndCountAddress(Net net) {
        NetExample netExample = new NetExample();
        netExample.or().andNetLevelEqualTo(net.getNetLevel());
        List<Net> result = netMapper.selectByExample(netExample);
        netExample.clear();
        List<Object> resultList = new ArrayList<>();
        resultList.add(result);
        AddressExample addressExample = new AddressExample();
        for (Net value : result) {
            netExample.or().andNetPidEqualTo(value.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            addressExample.or().andPidEqualTo(value.getNetId());
            long addressPreCount = addressMapperC.countByExample(addressExample);
            addressExample.clear();

            long addressCount = 0;
            for (Net item : net4List) {
                addressExample.or().andPidEqualTo(item.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount + addressPreCount);

            netExample.or().andNetPidEqualTo(value.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetAndCountAddressById(Net net) {
        //根据权限获取net
        SysRole sysRole = sysRoleMapperC.getAllandNetById(net.getNetPid());
        List<Net> net3List = new ArrayList<>();
        for (SysRoleNet sysRoleNet : sysRole.getSysRoleNet()) {
            if (sysRoleNet.getNet().getNetLevel().equals(net.getNetLevel())) {
                net3List.add(sysRoleNet.getNet());
            }
        }
        //输出结果
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3List);

        NetExample netExample = new NetExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : net3List) {
            netExample.or().andNetPidEqualTo(value.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            addressExample.or().andPidEqualTo(value.getNetId());
            long addressPreCount = addressMapperC.countByExample(addressExample);
            addressExample.clear();

            long addressCount = 0;
            for (Net item : net4List) {
                addressExample.or().andPidEqualTo(item.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount + addressPreCount);

            netExample.or().andNetPidEqualTo(value.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetAddressByExample(Net net) {
        NetExample netExample = new NetExample();
        Criteria criteriaResult = netExample.or();
        if (net.getNetLevel() != null) {
            criteriaResult = criteriaResult.andNetLevelEqualTo(net.getNetLevel());
        }
        if (net.getNetPid() != null) {
            criteriaResult = criteriaResult.andNetPidEqualTo(net.getNetPid());
        }
        List<Net> result = netMapper.selectByExample(netExample);
        netExample.clear();
        List<Object> resultList = new ArrayList<>();
        resultList.add(result);
        AddressExample addressExample = new AddressExample();
        HouseExample example = new HouseExample();
        for (Net value : result) {
            addressExample.or().andPidEqualTo(value.getNetId());
            resultList.add(addressMapperC.countByExample(addressExample));
            addressExample.clear();

            example.or().andHouseUrlEqualTo(value.getNetId());
            resultList.add(houseMapperC.countByExample(example));
            example.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetAndCountAll(Net net) {
        NetExample netExample = new NetExample();
        netExample.or().andNetLevelEqualTo(net.getNetLevel());
        List<Net> net3List = netMapper.selectByExample(netExample);
        netExample.clear();
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3List);
        AddressExample addressExample = new AddressExample();
        PeopleBaseExample example = new PeopleBaseExample();
        HouseExample houseExample = new HouseExample();
        CompanyExample companyExample = new CompanyExample();
        for (Net value : net3List) {
            netExample.or().andNetPidEqualTo(value.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            addressExample.or().andPidEqualTo(value.getNetId());
            long addressPreCount = addressMapperC.countByExample(addressExample);
            addressExample.clear();

            long addressCount = 0;
            for (Net item : net4List) {
                addressExample.or().andPidEqualTo(item.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount + addressPreCount);

            long peopleBaseCount = 0;
            for (Net item : net4List) {
                example.or().andCommunityCodeEqualTo(item.getNetId());
                peopleBaseCount += peopleBaseMapper.countByExample(example);
                example.clear();
            }
            resultList.add(peopleBaseCount);

            long houseCount = 0;
            for (Net item : net4List) {
                houseExample.or().andHouseUrlEqualTo(item.getNetId());
                houseCount += houseMapperC.countByExample(houseExample);
                houseExample.clear();
            }
            resultList.add(houseCount);

            companyExample.or().andCommunityEqualTo(value.getNetId());
            resultList.add(companyMapperC.countByExample(companyExample));
            companyExample.clear();

            netExample.or().andNetPidEqualTo(value.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Object> getNetAndCountAllById(Net net) {
        //根据权限获取net
        SysRole sysRole = sysRoleMapperC.getAllandNetById(net.getNetPid());
        List<Net> net3List = new ArrayList<>();
        for (SysRoleNet sysRoleNet : sysRole.getSysRoleNet()) {
            if (sysRoleNet.getNet().getNetLevel().equals(net.getNetLevel())) {
                net3List.add(sysRoleNet.getNet());
            }
        }
        //输出结果
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3List);

        NetExample netExample = new NetExample();
        AddressExample addressExample = new AddressExample();
        PeopleBaseExample example = new PeopleBaseExample();
        HouseExample houseExample = new HouseExample();
        CompanyExample companyExample = new CompanyExample();
        for (Net value : net3List) {
            netExample.or().andNetPidEqualTo(value.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            addressExample.or().andPidEqualTo(value.getNetId());
            long addressPreCount = addressMapperC.countByExample(addressExample);
            addressExample.clear();

            long addressCount = 0;
            for (Net item : net4List) {
                addressExample.or().andPidEqualTo(item.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount + addressPreCount);

            long peopleBaseCount = 0;
            for (Net item : net4List) {
                example.or().andCommunityCodeEqualTo(item.getNetId());
                peopleBaseCount += peopleBaseMapper.countByExample(example);
                example.clear();
            }
            resultList.add(peopleBaseCount);

            long houseCount = 0;
            for (Net item : net4List) {
                houseExample.or().andHouseUrlEqualTo(item.getNetId());
                houseCount += houseMapperC.countByExample(houseExample);
                houseExample.clear();
            }
            resultList.add(houseCount);

            companyExample.or().andCommunityEqualTo(value.getNetId());
            resultList.add(companyMapperC.countByExample(companyExample));
            companyExample.clear();

            netExample.or().andNetPidEqualTo(value.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        }
        return resultList;
    }

    @Override
    public List<Net> queryNetData(Net net) {
        NetExample netExample = new NetExample();
        Criteria criteriaResult = netExample.or();
        if (net.getNetLevel() != null && !Objects.equals(net.getNetLevel(), "")) {
            criteriaResult = criteriaResult.andNetLevelEqualTo(net.getNetLevel());
        }
        if (net.getNetName() != null && !Objects.equals(net.getNetName(), "")) {
            criteriaResult = criteriaResult.andNetNameLike("%" + net.getNetName() + "%");
        }
        if (net.getNetPid() != null && !Objects.equals(net.getNetPid(), "")) {
            criteriaResult = criteriaResult.andNetPidEqualTo(net.getNetPid());
        }
        return netMapper.selectByExample(netExample);
    }

    @Override
    public List<Object> getNetById(String netId) {
        Net net3 = netMapper.selectByPrimaryKey(netId);
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3);
        AddressExample addressExample = new AddressExample();
        PeopleBaseExample peopleExample = new PeopleBaseExample();
        HouseExample houseExample = new HouseExample();
        CompanyExample example = new CompanyExample();
        NetExample netExample = new NetExample();
        if (net3.getNetLevel().equals("3")) {
            netExample.or().andNetPidEqualTo(net3.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            long addressCount = 0;
            for (Net net : net4List) {
                addressExample.or().andPidEqualTo(net.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount);

            long peopleBaseCount = 0;
            for (Net net : net4List) {
                peopleExample.or().andCommunityCodeEqualTo(net.getNetId());
                peopleBaseCount += peopleBaseMapper.countByExample(peopleExample);
                peopleExample.clear();
            }
            resultList.add(peopleBaseCount);

            long houseCount = 0;
            for (Net net : net4List) {
                houseExample.or().andHouseUrlEqualTo(net.getNetId());
                houseCount += houseMapperC.countByExample(houseExample);
                houseExample.clear();
            }
            resultList.add(houseCount);

            example.or().andCommunityEqualTo(net3.getNetId());
            resultList.add(companyMapperC.countByExample(example));
            example.clear();

            netExample.or().andNetPidEqualTo(net3.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        } else if (net3.getNetLevel().equals("4")) {
            addressExample.or().andPidEqualTo(net3.getNetId());
            resultList.add(addressMapperC.countByExample(addressExample));
            addressExample.clear();

            peopleExample.or().andCommunityCodeEqualTo(net3.getNetId());
            resultList.add(peopleBaseMapper.countByExample(peopleExample));
            peopleExample.clear();

            houseExample.or().andHouseUrlEqualTo(net3.getNetId());
            resultList.add(houseMapperC.countByExample(houseExample));
            houseExample.clear();

            example.or().andCommunityEqualTo(net3.getNetId());
            resultList.add(companyMapperC.countByExample(example));
            example.clear();

            netExample.or().andNetPidEqualTo(net3.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        }
        return resultList;
    }

    @Override
    public Net getNetInfoById(String netId) {
        return netMapper.selectByPrimaryKey(netId);
    }

    @Override
    public List<Object> getNetAndCountAllN(Net net) {
        NetExample netExample = new NetExample();
        netExample.or().andNetPidEqualTo(net.getNetPid());
        List<Net> result = netMapper.selectByExample(netExample);
        netExample.clear();
        List<Object> resultList = new ArrayList<>();
        resultList.add(result);
        AddressExample addressExample = new AddressExample();
        PeopleBaseExample peopleExample = new PeopleBaseExample();
        HouseExample houseExample = new HouseExample();
        CompanyExample example = new CompanyExample();
        for (Net value : result) {
            addressExample.or().andPidEqualTo(value.getNetId());
            resultList.add(addressMapperC.countByExample(addressExample));
            addressExample.clear();

            peopleExample.or().andCommunityCodeEqualTo(value.getNetId());
            resultList.add(peopleBaseMapper.countByExample(peopleExample));
            peopleExample.clear();

            houseExample.or().andHouseUrlEqualTo(value.getNetId());
            resultList.add(houseMapperC.countByExample(houseExample));
            houseExample.clear();

            example.or().andCommunityEqualTo(value.getNetId());
            resultList.add(companyMapperC.countByExample(example));
            example.clear();

            netExample.or().andNetPidEqualTo(value.getNetId());
            resultList.add(netMapper.countByExample(netExample));
            netExample.clear();
        }
        return resultList;
    }

    @Override
    public int insertNet(Net net) {
        return netMapper.insert(net);
    }

    @Override
    public int deleteByPrimaryKey(String netId) {
        return netMapper.deleteByPrimaryKey(netId);
    }

    @Override
    public int batchDelete(List<String> netIds) {
        return netMapper.batchDelete(netIds);
    }

    @Override
    public int updateByPrimaryKey(Net net) {
        return netMapper.updateByPrimaryKey(net);
    }

    @Override
    public List<Object> getNetAndCountBuildingRemove(Net net) {
        NetExample netExample = new NetExample();
        netExample.or().andNetLevelEqualTo(net.getNetLevel());
        List<Net> net3List = netMapper.selectByExample(netExample);
        netExample.clear();
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3List);
        BuildingRemoveExample example = new BuildingRemoveExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : net3List) {
            netExample.or().andNetPidEqualTo(value.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            long houseCount = 0;
            for (Net item : net4List) {
                example.or().andRemovePidEqualTo(item.getNetId());
                houseCount += buildingRemoveMapperC.countByExample(example);
                example.clear();
            }
            resultList.add(houseCount);

            long addressCount = 0;
            for (Net item : net4List) {
                addressExample.or().andPidEqualTo(item.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount);

            long signCount = 0;
            for (int j = 0; j < net4List.size(); j++) {
                example.or().andRemoveSignEqualTo("已签约");
                signCount = buildingRemoveMapperC.countByExample(example);
                example.clear();
            }
            resultList.add(signCount);

            long signNoCount = 0;
            for (int j = 0; j < net4List.size(); j++) {
                example.or().andRemoveSignNotEqualTo("已签约");
                signNoCount = buildingRemoveMapperC.countByExample(example);
                example.clear();
            }
            resultList.add(signNoCount);
        }
        return resultList;
    }

    @Override
    public List<Object> getNetAndCountBuildingRemoveById(Net net) {
        //根据权限获取net
        SysRole sysRole = sysRoleMapperC.getAllandNetById(net.getNetPid());
        List<Net> net3List = new ArrayList<>();
        for (SysRoleNet sysRoleNet : sysRole.getSysRoleNet()) {
            if (sysRoleNet.getNet().getNetLevel().equals(net.getNetLevel())) {
                net3List.add(sysRoleNet.getNet());
            }
        }
        //输出结果
        List<Object> resultList = new ArrayList<>();
        resultList.add(net3List);

        NetExample netExample = new NetExample();
        BuildingRemoveExample example = new BuildingRemoveExample();
        AddressExample addressExample = new AddressExample();
        for (Net value : net3List) {
            netExample.or().andNetPidEqualTo(value.getNetId());
            List<Net> net4List = netMapper.selectByExample(netExample);
            netExample.clear();

            long houseCount = 0;
            for (Net item : net4List) {
                example.or().andRemovePidEqualTo(item.getNetId());
                houseCount += buildingRemoveMapperC.countByExample(example);
                example.clear();
            }
            resultList.add(houseCount);

            long addressCount = 0;
            for (Net item : net4List) {
                addressExample.or().andPidEqualTo(item.getNetId());
                addressCount += addressMapperC.countByExample(addressExample);
                addressExample.clear();
            }
            resultList.add(addressCount);

            long signCount = 0;
            for (int j = 0; j < net4List.size(); j++) {
                example.or().andRemoveSignEqualTo("已签约");
                signCount = buildingRemoveMapperC.countByExample(example);
                example.clear();
            }
            resultList.add(signCount);

            long signNoCount = 0;
            for (int j = 0; j < net4List.size(); j++) {
                example.or().andRemoveSignNotEqualTo("已签约");
                signNoCount = buildingRemoveMapperC.countByExample(example);
                example.clear();
            }
            resultList.add(signNoCount);
        }
        return resultList;
    }

    @Override
    public List<Object> getBuildingRemoveNetById(Net net) {
        Net netResult = netMapper.selectByPrimaryKey(net.getNetId());
        BuildingRemoveExample example = new BuildingRemoveExample();
        AddressExample addressExample = new AddressExample();
        List<Object> resultList = new ArrayList<>();
        resultList.add(netResult);

        example.or().andRemovePidEqualTo(net.getNetId());
        long houseCount = buildingRemoveMapperC.countByExample(example);
        resultList.add(houseCount);
        example.clear();

        addressExample.or().andPidEqualTo(net.getNetId());
        long addressCount = addressMapperC.countByExample(addressExample);
        resultList.add(addressCount);
        addressExample.clear();

        example.or().andRemoveSignEqualTo("已签约");
        long signCount = buildingRemoveMapperC.countByExample(example);
        resultList.add(signCount);
        example.clear();

        example.or().andRemoveSignNotEqualTo("已签约");
        long signNoCount = buildingRemoveMapperC.countByExample(example);
        resultList.add(signNoCount);
        example.clear();

        return resultList;
    }
}
