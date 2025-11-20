package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.city3d.dao.mapper.datasource1.SecurityMapperC;
import com.city3d.dao.entry.SecurityExample.Criteria;
import com.city3d.dao.entry.Security;
import com.city3d.dao.entry.SecurityExample;
import com.city3d.service.SecuritySService;
import org.springframework.stereotype.Service;

@Service
public class SecuritySServiceImpl implements SecuritySService {
    @Autowired
    private SecurityMapperC securityMapperC;

    @Override
    public List<Security> getSecurityAll() {
        return securityMapperC.selectAll();
    }

    @Override
    public Security getSecuritySById(String securityId) {
        return securityMapperC.selectByPrimaryKey(securityId);
    }

    @Override
    public List<Security> querySecurityS(Security security) {
        SecurityExample example = new SecurityExample();
        Criteria criteriaResult = example.or();
        if (security.getSecurityName() != null) {
            criteriaResult = criteriaResult.andSecurityNameLike("%" + security.getSecurityName() + "%");
        }
        if (security.getLevel() != null) {
            criteriaResult = criteriaResult.andLevelEqualTo(security.getLevel());
        }
        if (security.getPid() != null) {
            criteriaResult = criteriaResult.andPidEqualTo(security.getPid());
        }
        return securityMapperC.selectByExample(example);
    }

    @Override
    public int countSecuritySByPid(Security security) {
        SecurityExample example = new SecurityExample();
        example.or().andPidEqualTo(security.getPid());
        return securityMapperC.countByExample(example);
    }

    @Override
    public int insert(Security security) {
        return securityMapperC.insert(security);
    }

    @Override
    public int updateByPrimaryKey(Security security) {
        return securityMapperC.updateByPrimaryKey(security);
    }

    @Override
    public int deleteByPrimaryKey(String securityId) {
        return securityMapperC.deleteByPrimaryKey(securityId);
    }

    @Override
    public int batchDelete(List<String> securityIds) {
        return securityMapperC.batchDelete(securityIds);
    }
}
