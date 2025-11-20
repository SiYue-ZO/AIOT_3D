package com.city3d.dao.entry;

public class PeopleIllegal {
    private String illegalId;

    private String handleCompany;

    private String handleDate;

    private String handleMode;

    private String handleResult;

    private String handleTerm;

    private String illegalDate;

    private String illegalPlace;

    private String ppId;

    private String caseType;

    public String getIllegalId() {
        return illegalId;
    }

    public void setIllegalId(String illegalId) {
        this.illegalId = illegalId == null ? null : illegalId.trim();
    }

    public String getHandleCompany() {
        return handleCompany;
    }

    public void setHandleCompany(String handleCompany) {
        this.handleCompany = handleCompany == null ? null : handleCompany.trim();
    }

    public String getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(String handleDate) {
        this.handleDate = handleDate == null ? null : handleDate.trim();
    }

    public String getHandleMode() {
        return handleMode;
    }

    public void setHandleMode(String handleMode) {
        this.handleMode = handleMode == null ? null : handleMode.trim();
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult == null ? null : handleResult.trim();
    }

    public String getHandleTerm() {
        return handleTerm;
    }

    public void setHandleTerm(String handleTerm) {
        this.handleTerm = handleTerm == null ? null : handleTerm.trim();
    }

    public String getIllegalDate() {
        return illegalDate;
    }

    public void setIllegalDate(String illegalDate) {
        this.illegalDate = illegalDate == null ? null : illegalDate.trim();
    }

    public String getIllegalPlace() {
        return illegalPlace;
    }

    public void setIllegalPlace(String illegalPlace) {
        this.illegalPlace = illegalPlace == null ? null : illegalPlace.trim();
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId == null ? null : ppId.trim();
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
    }
}