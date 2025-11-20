package com.city3d.dao.entry;

public class Alarm {
    private String alarmId;

    private String wallId;

    private String alarmType;

    private String alarmTime;

    private String alarmPeopleId;

    private String alarmPoi;
    
    private Wall wall;
    
    private KeyPeople keyPeople;

    public KeyPeople getKeyPeople() {
		return keyPeople;
	}

	public void setKeyPeople(KeyPeople keyPeople) {
		this.keyPeople = keyPeople;
	}

	public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId == null ? null : alarmId.trim();
    }

    public String getWallId() {
        return wallId;
    }

    public void setWallId(String wallId) {
        this.wallId = wallId == null ? null : wallId.trim();
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType == null ? null : alarmType.trim();
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime == null ? null : alarmTime.trim();
    }

    public String getAlarmPeopleId() {
        return alarmPeopleId;
    }

    public void setAlarmPeopleId(String alarmPeopleId) {
        this.alarmPeopleId = alarmPeopleId == null ? null : alarmPeopleId.trim();
    }

    public String getAlarmPoi() {
        return alarmPoi;
    }

    public void setAlarmPoi(String alarmPoi) {
        this.alarmPoi = alarmPoi == null ? null : alarmPoi.trim();
    }

	public Wall getWall() {
		return wall;
	}

	public void setWall(Wall wall) {
		this.wall = wall;
	}
}