package com.city3d.dao.entry;

import java.util.List;

public class ManPos {
    private String realId;

    private String realPos;

    private String realTime;

    private String deviceNum;

    private String realType;
    
    private Police police;
    
    private String[] deviceNums;
 
	public String[] getDeviceNums() {
		return deviceNums;
	}

	public void setDeviceNums(String[] deviceNums) {
		this.deviceNums = deviceNums;
	}

	public Police getPolice() {
		return police;
	}

	public void setPolice(Police police) {
		this.police = police;
	}

	public String getRealId() {
        return realId;
    }

    public void setRealId(String realId) {
        this.realId = realId == null ? null : realId.trim();
    }

    public String getRealPos() {
        return realPos;
    }

    public void setRealPos(String realPos) {
        this.realPos = realPos == null ? null : realPos.trim();
    }

    public String getRealTime() {
        return realTime;
    }

    public void setRealTime(String realTime) {
        this.realTime = realTime == null ? null : realTime.trim();
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum == null ? null : deviceNum.trim();
    }

    public String getRealType() {
        return realType;
    }

    public void setRealType(String realType) {
        this.realType = realType == null ? null : realType.trim();
    }
}