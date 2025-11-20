package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.Security;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecurityMapperC extends SecurityMapper {
    Security selectSecurityById(String sId);

    Security getSecurityById(String sId);

    List<Security> selectAll();

    int batchDelete(List<String> sIds);
}
