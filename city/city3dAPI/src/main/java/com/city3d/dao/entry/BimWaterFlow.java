package com.city3d.dao.entry;

public class BimWaterFlow {
    private String bimFlowId;

    private String flowPos;

    private String flowName;

    public String getBimFlowId() {
        return bimFlowId;
    }

    public void setBimFlowId(String bimFlowId) {
        this.bimFlowId = bimFlowId == null ? null : bimFlowId.trim();
    }

    public String getFlowPos() {
        return flowPos;
    }

    public void setFlowPos(String flowPos) {
        this.flowPos = flowPos == null ? null : flowPos.trim();
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }
}