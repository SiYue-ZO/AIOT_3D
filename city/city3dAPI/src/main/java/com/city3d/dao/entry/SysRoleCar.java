package com.city3d.dao.entry;

public class SysRoleCar {
    private String roleCarId;

    private String roleId;

    private String carId;

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getRoleCarId() {
        return roleCarId;
    }

    public void setRoleCarId(String roleCarId) {
        this.roleCarId = roleCarId == null ? null : roleCarId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }
}