package com.fastcampus.BE7.business;

import com.fastcampus.BE7.domain.itinerary.enums.ItineraryStatus;
import com.fastcampus.BE7.domain.itinerary.model.ItineraryDto;
import com.fastcampus.BE7.domain.itinerary.model.ItineraryResponse;
import com.fastcampus.BE7.domain.trip.converter.TripConverter;
import com.fastcampus.BE7.domain.trip.enums.SaveStatus;
import com.fastcampus.BE7.domain.trip.enums.TripStatus;
import com.fastcampus.BE7.domain.trip.model.TripDto;
import com.fastcampus.BE7.domain.trip.model.TripResponse;
import com.fastcampus.BE7.enums.TravelStatus;
import com.fastcampus.BE7.model.TravelResponse;
import com.fastcampus.BE7.utils.FormatUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.fastcampus.BE7.utils.FileUtil.*;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public class TravelBusiness {

    private final TripConverter tripConverter;

    public TravelBusiness() {
        tripConverter = new TripConverter();
    }

    public TripResponse saveTrip(TripDto tripDto) {
        int id = getCountTripRecord() + 1;
        tripDto.setTripId(id);
        if (!FormatUtil.isValid(tripDto.getStartDate()) || !FormatUtil.isValid(tripDto.getEndDate())) {
            return new TripResponse(SaveStatus.NOT_MATCH_LOCAL_DATE_TIME, tripDto);
        }
        var tripEntity = tripConverter.toEntity(tripDto);
        saveFile(tripEntity);
        return new TripResponse(SaveStatus.INSERT_TRIP_SUCCESS, tripDto);
    }

    public TripResponse saveItinerary(int id, ItineraryDto itineraryDto) {

        TripDto tripDto = getTripFromFileById(id);
        List<ItineraryDto> itineraryDtoList = new ArrayList<>();
        itineraryDtoList.addAll(tripDto.getItineraryDTOList());
        itineraryDtoList.add(itineraryDto);
        tripDto.setItineraryDtoList(itineraryDtoList);

        if (!FormatUtil.isValid(itineraryDto.getDepartureTime())
                || !FormatUtil.isValid(itineraryDto.getArrivalTime())
                || !FormatUtil.isValid(itineraryDto.getCheckIn())
                || !FormatUtil.isValid(itineraryDto.getCheckOut())) {
            return new TripResponse(SaveStatus.INSERT_ITINERARY_SUCCESS, tripDto);
        }

        for (int i = 0; i < tripDto.getItineraryDTOList().size(); i++) {
            tripDto.getItineraryDTOList().get(i).setItineraryId(i + 1);
        }

        var tripEntity = tripConverter.toEntity(tripDto);
        saveFile(tripEntity);
        return new TripResponse(SaveStatus.INSERT_ITINERARY_SUCCESS, tripDto);
    }

    public TravelResponse getTripList() {
        List<TripDto> tripDtoList = new ArrayList<>();
        File[] files = new File(path).listFiles();
        if (files == null || getCountTripRecord() == 0) {
            return new TravelResponse(TravelStatus.TRIP_LIST_NULL, tripDtoList);
        }
        for (File file : files) {
            tripDtoList.add(getTripFromFileByFilename(file.getName()));
        }
        if (tripDtoList.size() == 0) {
            return new TravelResponse(TravelStatus.OTHERS, tripDtoList);
        }
        return new TravelResponse(TravelStatus.TRIP_LIST_SUCCESS, tripDtoList);
    }

    public TripResponse getTripInfo(String tripId) {
        String fileName = prefix + tripId + ".json";
        TripDto tripDto = new TripDto();
        if (!isFileExist(fileName)) {
            return new TripResponse(TripStatus.NOT_FOUND_ID, tripDto);
        }
        tripDto = getTripFromFileById(Integer.parseInt(tripId));
        if (tripDto.getItineraryDTOList().size() == 0) {
            return new TripResponse(TripStatus.ITINERARY_IS_ZERO, tripDto);
        }
        return new TripResponse(TripStatus.CONTENTS_SUCCESS, tripDto);
    }

    public ItineraryResponse searchItineraryList(String keyword) {
        List<TripDto> allTripData = getAllTripData();
        List<TripDto> filterData = new ArrayList<>();

        for (TripDto tripDto : allTripData) {
            List<ItineraryDto> itineraryDtoList = new ArrayList<>();
            for (ItineraryDto itineraryDto : tripDto.getItineraryDTOList()) {
                if (itineraryDto.getDeparturePlace().contains(keyword)
                        || itineraryDto.getDestination().contains(keyword)) {
                    itineraryDtoList.add(itineraryDto);
                }
            }
            if (itineraryDtoList.size() > 0) {
                filterData.add(new TripDto.Builder()
                        .tripId(tripDto.getTripId())
                        .tripName(tripDto.getTripName())
                        .itineraryDTOList(itineraryDtoList).build()
                );
            }
        }

        if (allTripData.size() == 0 || filterData.size() == 0) {
            return new ItineraryResponse(ItineraryStatus.NOT_FOUND, filterData);
        }

        return new ItineraryResponse(ItineraryStatus.SUCCESS, filterData);
    }
}
