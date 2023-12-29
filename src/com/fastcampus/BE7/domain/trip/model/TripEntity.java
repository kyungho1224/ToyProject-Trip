package com.fastcampus.BE7.domain.trip.model;

import com.fastcampus.BE7.domain.itinerary.model.ItineraryEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public class TripEntity {

    @SerializedName("trip_id")
    @Expose
    private int tripId;

    @SerializedName("trip_name")
    @Expose
    private String tripName;

    @SerializedName("start_date")
    @Expose
    private LocalDateTime startDate;

    @SerializedName("end_date")
    @Expose
    private LocalDateTime endDate;

    @SerializedName("itineraries")
    @Expose
    private List<ItineraryEntity> itineraryEntityList;

    public TripEntity() {
    }

    public TripEntity(int tripId, String tripName, LocalDateTime startDate, LocalDateTime endDate, List<ItineraryEntity> itineraryEntityList) {
        this.tripId = tripId;
        this.tripName = tripName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.itineraryEntityList = itineraryEntityList;
    }

    public static class Builder {
        private int tripId;
        private String tripName;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private List<ItineraryEntity> itineraryEntityList;

        public Builder tripId(int tripId) {
            this.tripId = tripId;
            return this;
        }

        public Builder tripName(String tripName) {
            this.tripName = tripName;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder itineraryEntityList(List<ItineraryEntity> itineraryEntityList) {
            this.itineraryEntityList = itineraryEntityList;
            return this;
        }

        public TripEntity build() {
            return new TripEntity(
                    this.tripId,
                    this.tripName,
                    this.startDate,
                    this.endDate,
                    this.itineraryEntityList);
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public List<ItineraryEntity> getItineraryEntityList() {
        return itineraryEntityList;
    }

}
