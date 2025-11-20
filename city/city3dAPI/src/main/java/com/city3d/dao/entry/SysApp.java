package com.city3d.dao.entry;

public class SysApp {
    private String appId;

    private String appName;

    private String appLogo;

    private String appUiMode;

    private String appPos;

    private String appImage;

    private String appTerrain;

    private String appVersion;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo == null ? null : appLogo.trim();
    }

    public String getAppUiMode() {
        return appUiMode;
    }

    public void setAppUiMode(String appUiMode) {
        this.appUiMode = appUiMode == null ? null : appUiMode.trim();
    }

    public String getAppPos() {
        return appPos;
    }

    public void setAppPos(String appPos) {
        this.appPos = appPos == null ? null : appPos.trim();
    }

    public String getAppImage() {
        return appImage;
    }

    public void setAppImage(String appImage) {
        this.appImage = appImage == null ? null : appImage.trim();
    }

    public String getAppTerrain() {
        return appTerrain;
    }

    public void setAppTerrain(String appTerrain) {
        this.appTerrain = appTerrain == null ? null : appTerrain.trim();
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }
}