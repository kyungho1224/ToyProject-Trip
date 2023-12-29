package com.fastcampus.BE7.domain.itinerary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public class ItineraryEntity {

    @SerializedName("itinerary_id")
    @Expose
    private int itineraryId;

    @SerializedName("departure_place")
    @Expose
    private String departurePlace;

    @SerializedName("destination")
    @Expose
    private String destination;

    @SerializedName("departure_time")
    @Expose
    private LocalDateTime departureTime;

    @SerializedName("arrival_time")
    @Expose
    private LocalDateTime arrivalTime;

    @SerializedName("check_in")
    @Expose
    private LocalDateTime checkIn;

    @SerializedName("check_out")
    @Expose
    private LocalDateTime checkOut;

    public ItineraryEntity() {
    }

    public ItineraryEntity(int itineraryId, String departurePlace, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.itineraryId = itineraryId;
        this.departurePlace = departurePlace;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public static class Builder {
        int itineraryId;
        String departurePlace;
        String destination;
        LocalDateTime departureTime;
        LocalDateTime arrivalTime;
        LocalDateTime checkIn;
        LocalDateTime checkOut;

        public Builder itineraryId(int itineraryId) {
            this.itineraryId = itineraryId;
            return this;
        }

        public Builder departurePlace(String departurePlace) {
            this.departurePlace = departurePlace;
            return this;
        }

        public Builder destination(String destination) {
            this.destination = destination;
            return this;
        }

        public Builder departureTime(LocalDateTime departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        public Builder arrivalTime(LocalDateTime arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        public Builder checkIn(LocalDateTime checkIn) {
            this.checkIn = checkIn;
            return this;
        }

        public Builder checkOut(LocalDateTime checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public ItineraryEntity build() {
            return new ItineraryEntity(
                    this.itineraryId,
                    this.departurePlace,
                    this.destination,
                    this.departureTime,
                    this.arrivalTime,
                    this.checkIn,
                    this.checkOut
            );
        }
    }

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

}
