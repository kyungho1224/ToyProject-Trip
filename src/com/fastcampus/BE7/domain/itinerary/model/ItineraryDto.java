package com.fastcampus.BE7.domain.itinerary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public class ItineraryDto {

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
    private String departureTime;

    @SerializedName("arrival_time")
    @Expose
    private String arrivalTime;

    @SerializedName("check_in")
    @Expose
    private String checkIn;

    @SerializedName("check_out")
    @Expose
    private String checkOut;

    public ItineraryDto() {
    }

    public ItineraryDto(int itineraryId, String departurePlace, String destination, String departureTime, String arrivalTime, String checkIn, String checkOut) {
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
        String departureTime;
        String arrivalTime;
        String checkIn;
        String checkOut;

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

        public Builder departureTime(String departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        public Builder arrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        public Builder checkIn(String checkIn) {
            this.checkIn = checkIn;
            return this;
        }

        public Builder checkOut(String checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public ItineraryDto build() {
            return new ItineraryDto(
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

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

}
