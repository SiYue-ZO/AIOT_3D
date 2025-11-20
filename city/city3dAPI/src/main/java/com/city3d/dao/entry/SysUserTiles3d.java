package com.city3d.dao.entry;

public class SysUserTiles3d {
    private String userTilesId;

    private String userId;

    private String tilesId;

    public String getUserTilesId() {
        return userTilesId;
    }

    public void setUserTilesId(String userTilesId) {
        this.userTilesId = userTilesId == null ? null : userTilesId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTilesId() {
        return tilesId;
    }

    public void setTilesId(String tilesId) {
        this.tilesId = tilesId == null ? null : tilesId.trim();
    }
}