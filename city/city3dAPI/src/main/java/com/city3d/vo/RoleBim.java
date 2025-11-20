package com.city3d.vo;

import com.city3d.dao.entry.Bim;
import com.city3d.dao.entry.SysRoleBim;

public class RoleBim {
    Bim bim;

    SysRoleBim sysRoleBim;

    public Bim getBim() {
        return bim;
    }

    public void setBim(Bim bim) {
        this.bim = bim;
    }

    public SysRoleBim getSysRoleBim() {
        return sysRoleBim;
    }

    public void setSysRoleBim(SysRoleBim sysRoleBim) {
        this.sysRoleBim = sysRoleBim;
    }
}
