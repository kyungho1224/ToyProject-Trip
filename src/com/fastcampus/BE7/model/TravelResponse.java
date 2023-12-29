package com.fastcampus.BE7.model;

import com.fastcampus.BE7.domain.trip.model.TripDto;
import com.fastcampus.BE7.enums.TravelStatus;

import java.util.List;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public class TravelResponse {

    private TravelStatus status;

    private List<TripDto> tripDtoList;

    public TravelResponse() {
    }

    public TravelResponse(TravelStatus status, List<TripDto> tripDtoList) {
        this.status = status;
        this.tripDtoList = tripDtoList;
    }

    public TravelStatus getStatus() {
        return status;
    }

    public List<TripDto> getTripDTOList() {
        return tripDtoList;
    }


}
