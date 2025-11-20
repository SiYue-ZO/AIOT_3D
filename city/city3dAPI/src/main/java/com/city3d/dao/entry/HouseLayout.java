package com.city3d.dao.entry;

public class HouseLayout {
    private String layoutId;

    private String layoutPos;

    private String layoutFloor;

    private String layoutName;

    private String layoutHeight;

    private String pid;

    private String addId;
    
    private Net net;

    public Net getNet() {
		return net;
	}

	public void setNet(Net net) {
		this.net = net;
	}

	public String getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId == null ? null : layoutId.trim();
    }

    public String getLayoutPos() {
        return layoutPos;
    }

    public void setLayoutPos(String layoutPos) {
        this.layoutPos = layoutPos == null ? null : layoutPos.trim();
    }

    public String getLayoutFloor() {
        return layoutFloor;
    }

    public void setLayoutFloor(String layoutFloor) {
        this.layoutFloor = layoutFloor == null ? null : layoutFloor.trim();
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName == null ? null : layoutName.trim();
    }

    public String getLayoutHeight() {
        return layoutHeight;
    }

    public void setLayoutHeight(String layoutHeight) {
        this.layoutHeight = layoutHeight == null ? null : layoutHeight.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getAddId() {
        return addId;
    }

    public void setAddId(String addId) {
        this.addId = addId == null ? null : addId.trim();
    }
}