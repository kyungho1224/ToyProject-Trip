package com.fastcampus.BE7.domain.itinerary.model;

import com.fastcampus.BE7.domain.itinerary.enums.ItineraryStatus;
import com.fastcampus.BE7.domain.trip.model.TripDto;

import java.util.List;

/**
 * Created by KimKyungHo on 2023-12-29(029)
 */
public class ItineraryResponse {

    private ItineraryStatus itineraryStatus;

    private List<TripDto> tripDtoList;

    public ItineraryResponse() {
    }

    public ItineraryResponse(ItineraryStatus itineraryStatus, List<TripDto> tripDtoList) {
        this.itineraryStatus = itineraryStatus;
        this.tripDtoList = tripDtoList;
    }

    public ItineraryStatus getItineraryStatus() {
        return itineraryStatus;
    }

    public void setItineraryStatus(ItineraryStatus itineraryStatus) {
        this.itineraryStatus = itineraryStatus;
    }

    public List<TripDto> getTripDtoList() {
        return tripDtoList;
    }

    public void setTripDtoList(List<TripDto> tripDtoList) {
        this.tripDtoList = tripDtoList;
    }
}
