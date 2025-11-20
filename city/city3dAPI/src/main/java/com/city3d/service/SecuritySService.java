package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Security;

public interface SecuritySService {
    List<Security> getSecurityAll();

    Security getSecuritySById(String securityId);

    List<Security> querySecurityS(Security security);

    int countSecuritySByPid(Security security);

    int insert(Security security);

    int updateByPrimaryKey(Security security);

    int deleteByPrimaryKey(String securityId);

    int batchDelete(List<String> securityIds);
}
