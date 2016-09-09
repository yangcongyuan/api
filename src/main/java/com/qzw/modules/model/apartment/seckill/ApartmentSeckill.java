package com.qzw.modules.model.apartment.seckill;

import java.util.Date;

public class ApartmentSeckill {
    private Long apartmentId;

    private Date startTime;

    private Date endTime;

    private Integer places;

    private Integer placesMan;

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public Integer getPlacesMan() {
        return placesMan;
    }

    public void setPlacesMan(Integer placesMan) {
        this.placesMan = placesMan;
    }
}