package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.FaceIdentity;

public interface FaceIdentityService {
    int insert(FaceIdentity faceIdentity);

    FaceIdentity getFaceIdentityAndVideoById(String faceId);

    List<FaceIdentity> getFaceIdentity();

    int updateByPrimaryKey(FaceIdentity faceIdentity);

    int deleteByPrimaryKey(String faceId);

    List<FaceIdentity> getFaceIdentityByRepoTypeandUserId(FaceIdentity faceIdentity);

    int batchDelete(List<String> faceIds);
}
