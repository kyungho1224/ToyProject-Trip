package com.fastcampus.BE7.domain.trip.model;

import com.fastcampus.BE7.domain.trip.enums.SaveStatus;
import com.fastcampus.BE7.domain.trip.enums.TripStatus;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public class TripResponse {

    private TripStatus tripStatus;

    private SaveStatus saveStatus;

    private TripDto tripDto;

    public TripResponse() {
    }

    public TripResponse(TripStatus tripStatus, TripDto tripDto) {
        this.tripStatus = tripStatus;
        this.tripDto = tripDto;
    }

    public TripResponse(SaveStatus saveStatus, TripDto tripDto) {
        this.saveStatus = saveStatus;
        this.tripDto = tripDto;
    }

    public TripResponse(TripStatus tripStatus, SaveStatus saveStatus, TripDto tripDto) {
        this.tripStatus = tripStatus;
        this.saveStatus = saveStatus;
        this.tripDto = tripDto;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public SaveStatus getSaveStatus() {
        return saveStatus;
    }

    public TripDto getTripDto() {
        return tripDto;
    }
}
