package com.city3d.dao.entry;

import java.util.List;

public class SysRole {
    private String roleId;

    private String roleName;
    
    private List<SysRoleFunc> sysRoleFunc;
    
    private List<SysFunc> sysFunc;
    
    private List<SysRoleTiles3d> sysRoleTiles3d;
    
    private List<SysRoleBim> sysRoleBim;

	private List<SysRoleCar> sysRoleCar;

	private List<SysRoleDevice> sysRoleDevice;

	private List<SysRoleNet> sysRoleNet;

	private List<SysRolePolice> sysRolePolice;

	private List<SysRoleSecurity> sysRoleSecurity;

	private List<SysRoleUav> sysRoleUav;

	private List<SysRoleVideo> sysRoleVideo;

	private List<SysRoleVideo> sysRoleVideoIndoor;

	public List<SysRoleVideo> getSysRoleVideoIndoor() {
		return sysRoleVideoIndoor;
	}

	public void setSysRoleVideoIndoor(List<SysRoleVideo> sysRoleVideoIndoor) {
		this.sysRoleVideoIndoor = sysRoleVideoIndoor;
	}

	public List<SysRoleCar> getSysRoleCar() {
		return sysRoleCar;
	}

	public void setSysRoleCar(List<SysRoleCar> sysRoleCar) {
		this.sysRoleCar = sysRoleCar;
	}

	public List<SysRoleDevice> getSysRoleDevice() {
		return sysRoleDevice;
	}

	public void setSysRoleDevice(List<SysRoleDevice> sysRoleDevice) {
		this.sysRoleDevice = sysRoleDevice;
	}

	public List<SysRoleNet> getSysRoleNet() {
		return sysRoleNet;
	}

	public void setSysRoleNet(List<SysRoleNet> sysRoleNet) {
		this.sysRoleNet = sysRoleNet;
	}

	public List<SysRolePolice> getSysRolePolice() {
		return sysRolePolice;
	}

	public void setSysRolePolice(List<SysRolePolice> sysRolePolice) {
		this.sysRolePolice = sysRolePolice;
	}

	public List<SysRoleSecurity> getSysRoleSecurity() {
		return sysRoleSecurity;
	}

	public void setSysRoleSecurity(List<SysRoleSecurity> sysRoleSecurity) {
		this.sysRoleSecurity = sysRoleSecurity;
	}

	public List<SysRoleUav> getSysRoleUav() {
		return sysRoleUav;
	}

	public void setSysRoleUav(List<SysRoleUav> sysRoleUav) {
		this.sysRoleUav = sysRoleUav;
	}

	public List<SysRoleVideo> getSysRoleVideo() {
		return sysRoleVideo;
	}

	public void setSysRoleVideo(List<SysRoleVideo> sysRoleVideo) {
		this.sysRoleVideo = sysRoleVideo;
	}

	public List<SysRoleBim> getSysRoleBim() {
		return sysRoleBim;
	}

	public void setSysRoleBim(List<SysRoleBim> sysRoleBim) {
		this.sysRoleBim = sysRoleBim;
	}

	public List<SysRoleTiles3d> getSysRoleTiles3d() {
		return sysRoleTiles3d;
	}

	public void setSysRoleTiles3d(List<SysRoleTiles3d> sysRoleTiles3d) {
		this.sysRoleTiles3d = sysRoleTiles3d;
	}

	public List<SysFunc> getSysFunc() {
		return sysFunc;
	}

	public void setSysFunc(List<SysFunc> sysFunc) {
		this.sysFunc = sysFunc;
	}

	public List<SysRoleFunc> getSysRoleFunc() {
		return sysRoleFunc;
	}

	public void setSysRoleFunc(List<SysRoleFunc> sysRoleFunc) {
		this.sysRoleFunc = sysRoleFunc;
	}

	public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}