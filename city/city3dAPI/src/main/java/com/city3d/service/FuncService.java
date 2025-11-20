package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.SysFunc;

public interface FuncService {
    List<SysFunc> getFunc();

    int insert(SysFunc sysFunc);

    int updateByPrimaryKey(SysFunc sysFunc);

    int deleteByPrimaryKey(String funcId);

    List<SysFunc> getFuncByLevel(SysFunc sysFunc);

    List<SysFunc> getFuncAndRel(String roleId);

    List<SysFunc> getFuncBySrc(String funcSrc);
}
