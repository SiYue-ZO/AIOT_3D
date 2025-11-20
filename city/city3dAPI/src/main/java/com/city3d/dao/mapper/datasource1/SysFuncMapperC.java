package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysFunc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysFuncMapperC extends SysFuncMapper {
    List<SysFunc> getFuncAndRel(String RoleId);
}