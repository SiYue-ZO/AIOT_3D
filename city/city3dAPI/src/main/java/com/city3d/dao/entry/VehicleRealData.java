package com.city3d.dao.entry;

public class VehicleRealData {
	// 唯一库表ID，没有实际意义
	private int iD;
	public final int getID() {
		return iD;
	}

	public final void setID(int value) {
		iD = value;
	}
	
	private int vehicleId;
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	// 设备终端状态
	private String status;
	public final String getStatus() {
		return status;
	}

	public final void setStatus(String value) {
		status = value;
	}

	/*// 部门
	private int depId;
	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	//在线时间
	private Date onlineDate;
	public Date getOnlineDate() {
		return onlineDate;
	}

	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}*/
	
	// 车牌号
	private String plateNo;
	public final String getPlateNo() {
		return plateNo;
	}

	public final void setPlateNo(String value) {
		plateNo = value;
	}
	
	// 车终端卡号
	private String simNo;
	public final String getSimNo() {
		return simNo;
	}

	public final void setSimNo(String value) {
		simNo = value;
	}

	// 地理位置的文字描述,如省,市，县，路的详细描述
	private String location;
	public final String getLocation() {
		return location;
	}

	public final void setLocation(String value) {
		location = value;
	}
	
	// 发送时间
	private String sendTime;
	public final String getSendTime() {
		return sendTime;
	}

	public final void setSendTime(String value) {
		sendTime = value;
	}

	// 入库时间
	private String updateDate;
	public final String getUpdateDate() {
		return updateDate;
	}

	public final void setUpdateDate(String value) {
		updateDate = value;
	}

	// 经度
	private double longitude;
	public final double getLongitude() {
		return longitude;
	}

	public final void setLongitude(double value) {
		longitude = value;
	}

	// 纬度
	private double latitude;
	public final double getLatitude() {
		return latitude;
	}

	public final void setLatitude(double value) {
		latitude = value;
	}

	// 速度
	private double velocity;
	public final double getVelocity() {
		return velocity;
	}

	public final void setVelocity(double value) {
		velocity = value;
	}
	
	// 方向
	private int direction;
	public final int getDirection() {
		return direction;
	}

	public final void setDirection(int value) {
		direction = value;
	}
	
	// 海拔
	private double altitude;
	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	// 行驶记录仪速度
	private double recordVelocity;
	public final double getRecordVelocity() {
		return recordVelocity;
	}

	public final void setRecordVelocity(double value) {
		recordVelocity = value;
	}
	
	// 当前油量
	private double gas;
	public double getGas() {
		return gas;
	}

	public void setGas(double gas) {
		this.gas = gas;
	}
	
	// 行驶里程总量
	private double mileage;
	public final double getMileage() {
		return mileage;
	}

	public final void setMileage(double value) {
		mileage = value;
	}

	// GPS的定位状态，false代表没有定位,被屏蔽或找不到卫星
	private boolean valid;
	public final boolean IsValid() {
		return valid;
	}

	public final void setValid(boolean value) {
		valid = value;
	}
	
}
