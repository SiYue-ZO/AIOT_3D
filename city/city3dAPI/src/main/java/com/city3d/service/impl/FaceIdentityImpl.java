package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.FaceIdentityMapperC;
import com.city3d.dao.entry.FaceIdentity;
import com.city3d.service.FaceIdentityService;
import org.springframework.stereotype.Service;

@Service
public class FaceIdentityImpl implements FaceIdentityService {

    @Autowired
    private FaceIdentityMapperC faceIdentityMapperC;

    @Override
    public int insert(FaceIdentity faceIdentity) {
        return faceIdentityMapperC.insert(faceIdentity);
    }

    @Override
    public FaceIdentity getFaceIdentityAndVideoById(String faceId) {
        return faceIdentityMapperC.getFaceIdentityAndVideoById(faceId);
    }

    @Override
    public List<FaceIdentity> getFaceIdentity() {
        return faceIdentityMapperC.selectByExample(null);
    }

    @Override
    public int updateByPrimaryKey(FaceIdentity faceIdentity) {
        return faceIdentityMapperC.updateByPrimaryKey(faceIdentity);
    }

    @Override
    public int deleteByPrimaryKey(String faceId) {
        return faceIdentityMapperC.deleteByPrimaryKey(faceId);
    }


    @Override
    public List<FaceIdentity> getFaceIdentityByRepoTypeandUserId(FaceIdentity faceIdentity) {
        return faceIdentityMapperC.getFaceIdentityByRepoTypeandUserId(faceIdentity);
    }

    @Override
    public int batchDelete(List<String> faceIds) {
        return faceIdentityMapperC.batchDelete(faceIds);
    }
}
