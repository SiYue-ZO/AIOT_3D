package com.city3d.dao.entry;

public class Plan {
    private String planId;

    private String planDate;

    private String planPos;

    private String planName;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate == null ? null : planDate.trim();
    }

    public String getPlanPos() {
        return planPos;
    }

    public void setPlanPos(String planPos) {
        this.planPos = planPos == null ? null : planPos.trim();
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }
}