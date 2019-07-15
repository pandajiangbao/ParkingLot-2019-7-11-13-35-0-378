package com.thoughtworks.tdd.Story5;

public class Ticket {
    private Integer carId;
    private Integer parkingLotId;
    private boolean isValidity;
    private String remark;

    public Ticket(){
        this.isValidity = true;
    }
    public Ticket(Integer carId) {
        this.carId = carId;
        this.isValidity = true;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public boolean getValidity() {
        return isValidity;
    }

    public void setValidity(boolean validity) {
        this.isValidity = validity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
