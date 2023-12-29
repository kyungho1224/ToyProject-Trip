package com.fastcampus.BE7.domain.trip.model;

import com.fastcampus.BE7.domain.itinerary.model.ItineraryDto;
import com.fastcampus.BE7.domain.itinerary.model.ItineraryEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public class TripDto {

    @SerializedName("trip_id")
    @Expose
    private int tripId;

    @SerializedName("trip_name")
    @Expose
    private String tripName;

    @SerializedName("start_date")
    @Expose
    private String startDate;

    @SerializedName("end_date")
    @Expose
    private String endDate;

    @SerializedName("itineraries")
    @Expose
    private List<ItineraryDto> itineraryDtoList;

    public TripDto() {
    }

    public TripDto(int tripId, String tripName, String startDate, String endDate, List<ItineraryDto> itineraryDtoList) {
        this.tripId = tripId;
        this.tripName = tripName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.itineraryDtoList = itineraryDtoList;
    }

    public static class Builder {
        private int tripId;
        private String tripName;
        private String startDate;
        private String endDate;
        private List<ItineraryDto> itineraryDtoList;

        public Builder tripId(int tripId) {
            this.tripId = tripId;
            return this;
        }

        public Builder tripName(String tripName) {
            this.tripName = tripName;
            return this;
        }

        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder itineraryDTOList(List<ItineraryDto> itineraryDtoList) {
            this.itineraryDtoList = itineraryDtoList;
            return this;
        }

        public TripDto build() {
            return new TripDto(
                    this.tripId,
                    this.tripName,
                    this.startDate,
                    this.endDate,
                    this.itineraryDtoList);
        }
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public List<ItineraryDto> getItineraryDTOList() {
        return itineraryDtoList;
    }

    public void setItineraryDtoList(List<ItineraryDto> itineraryDtoList) {
        this.itineraryDtoList = itineraryDtoList;
    }
}
