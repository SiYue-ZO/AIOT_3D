package com.city3d.dao.entry;

public class Video0Live {
    private String id;

    private String camIp;

    private String camUser;

    private String camPw;

    private String camPort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCamIp() {
        return camIp;
    }

    public void setCamIp(String camIp) {
        this.camIp = camIp == null ? null : camIp.trim();
    }

    public String getCamUser() {
        return camUser;
    }

    public void setCamUser(String camUser) {
        this.camUser = camUser == null ? null : camUser.trim();
    }

    public String getCamPw() {
        return camPw;
    }

    public void setCamPw(String camPw) {
        this.camPw = camPw == null ? null : camPw.trim();
    }

    public String getCamPort() {
        return camPort;
    }

    public void setCamPort(String camPort) {
        this.camPort = camPort == null ? null : camPort.trim();
    }
}