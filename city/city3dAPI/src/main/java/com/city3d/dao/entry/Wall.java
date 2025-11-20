package com.city3d.dao.entry;

public class Wall {
    private String wallId;

    private String wallPoi;

    private String wallIn;

    private String wallOut;

    private String wallName;

    public String getWallId() {
        return wallId;
    }

    public void setWallId(String wallId) {
        this.wallId = wallId == null ? null : wallId.trim();
    }

    public String getWallPoi() {
        return wallPoi;
    }

    public void setWallPoi(String wallPoi) {
        this.wallPoi = wallPoi == null ? null : wallPoi.trim();
    }

    public String getWallIn() {
        return wallIn;
    }

    public void setWallIn(String wallIn) {
        this.wallIn = wallIn == null ? null : wallIn.trim();
    }

    public String getWallOut() {
        return wallOut;
    }

    public void setWallOut(String wallOut) {
        this.wallOut = wallOut == null ? null : wallOut.trim();
    }

    public String getWallName() {
        return wallName;
    }

    public void setWallName(String wallName) {
        this.wallName = wallName == null ? null : wallName.trim();
    }
}