package com.fastcampus.BE7.controller;

import com.fastcampus.BE7.business.TravelBusiness;
import com.fastcampus.BE7.domain.itinerary.enums.ItineraryMenu;
import com.fastcampus.BE7.domain.itinerary.enums.ItineraryStatus;
import com.fastcampus.BE7.domain.itinerary.model.ItineraryResponse;
import com.fastcampus.BE7.domain.trip.enums.TripMenu;
import com.fastcampus.BE7.domain.trip.enums.TripStatus;
import com.fastcampus.BE7.domain.trip.model.TripDto;
import com.fastcampus.BE7.domain.trip.model.TripResponse;
import com.fastcampus.BE7.model.TravelResponse;
import com.fastcampus.BE7.view.ConsoleView;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public class TravelController {

    private final ConsoleView consoleView;
    private final TravelBusiness travelBusiness;
    private TripDto tripDto;
    private TripResponse tripResponse;

    public TravelController() {
        consoleView = new ConsoleView();
        travelBusiness = new TravelBusiness();
    }

    public void startApplication() {
        processTripMenu();
    }

    public void processTripMenu() {
        TripMenu tripMenu = TripMenu.selectMenu(consoleView.printTripMenu());
        consoleView.printlnMessage(tripMenu.getMessage());
        switch (tripMenu) {
            case INSERT_TRIP:
                insertTrip();
                break;
            case SEARCH_TRIP:
            case INSERT_ITINERARY:
                searchTripList();
                break;
            case SEARCH_ITINERARY:
                searchItineraryList();
                break;
            case EXIT:
                break;
            case OTHERS:
                processTripMenu();
                break;
        }
    }

    public void insertTrip() {
        tripDto = consoleView.getTripRecord();
        tripResponse = travelBusiness.saveTrip(tripDto);
        consoleView.printlnMessage(tripResponse.getSaveStatus().getMessage());
        switch (tripResponse.getSaveStatus()) {
            case INSERT_TRIP_SUCCESS:
            case INSERT_ITINERARY_SUCCESS:
                processItineraryMenu();
                break;
            case NOT_MATCH_LOCAL_DATE_TIME:
                processTripMenu();
                break;
        }
    }

    public void processItineraryMenu() {
        ItineraryMenu itineraryMenu = ItineraryMenu.selectMenu(consoleView.printContinueItinerary());
        consoleView.printlnMessage(itineraryMenu.getMessage());
        switch (itineraryMenu) {
            case YES:
                insertItinerary();
                break;
            case NO:
            case OTHERS:
                processTripMenu();
                break;
        }
    }

    public void insertItinerary() {
        tripResponse = travelBusiness.saveItinerary(tripDto.getTripId(), consoleView.getItineraryRecord());
        consoleView.printlnMessage(tripResponse.getSaveStatus().getMessage());
        processItineraryMenu();
    }

    public void searchTripList() {
        TravelResponse response = travelBusiness.getTripList();
        consoleView.printlnMessage(response.getStatus().getMessage());
        switch (response.getStatus()) {
            case TRIP_LIST_SUCCESS:
                String tripId = consoleView.printTripRecordList(response.getTripDTOList());
                tripInfo(tripId);
                break;
            case TRIP_LIST_NULL:
            case OTHERS:
                processTripMenu();
                break;
        }
    }

    public void searchItineraryList() {
        String keyword = consoleView.searchItineraryByKeyword();
        ItineraryResponse itineraryResponse = travelBusiness.searchItineraryList(keyword);
        consoleView.printlnMessage(itineraryResponse.getItineraryStatus().getMessage());
        if (itineraryResponse.getItineraryStatus() == ItineraryStatus.SUCCESS) {
            consoleView.printSearchItineraryList(itineraryResponse.getTripDtoList());
        }
        processTripMenu();
    }

    public void tripInfo(String tripId) {
        TripResponse tripResponse = travelBusiness.getTripInfo(tripId);
        TripStatus tripStatus = tripResponse.getTripStatus();
        tripDto = tripResponse.getTripDto();
        consoleView.printlnMessage(tripStatus.getMessage());
        switch (tripStatus) {
            case CONTENTS_SUCCESS:
            case ITINERARY_IS_ZERO:
                consoleView.printTripAndItinerary(tripDto);
                processItineraryMenu();
                break;
            case NOT_FOUND_ID:
                searchTripList();
                break;
        }
    }

}
