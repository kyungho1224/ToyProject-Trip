package com.fastcampus.BE7.domain.itinerary.converter;

import com.fastcampus.BE7.domain.itinerary.model.ItineraryDto;
import com.fastcampus.BE7.domain.itinerary.model.ItineraryEntity;
import com.fastcampus.BE7.utils.FormatUtil;

/**
 * Created by KimKyungHo on 2023-12-28(028)
 */
public class ItineraryConverter {

    public ItineraryDto toDto(ItineraryEntity itineraryEntity) {
        return new ItineraryDto.Builder()
                .itineraryId(itineraryEntity.getItineraryId())
                .departurePlace(itineraryEntity.getDeparturePlace())
                .destination(itineraryEntity.getDestination())
                .departureTime(FormatUtil.localDateTimeToString(itineraryEntity.getDepartureTime(), true))
                .arrivalTime(FormatUtil.localDateTimeToString(itineraryEntity.getArrivalTime(), true))
                .checkIn(FormatUtil.localDateTimeToString(itineraryEntity.getCheckIn(), true))
                .checkOut(FormatUtil.localDateTimeToString(itineraryEntity.getCheckOut(), true))
                .build();
    }

    public ItineraryEntity toEntity(ItineraryDto itineraryDto) {
        return new ItineraryEntity.Builder()
                .itineraryId(itineraryDto.getItineraryId())
                .departurePlace(itineraryDto.getDeparturePlace())
                .destination(itineraryDto.getDestination())
                .departureTime(FormatUtil.stringToLocalDateTime(itineraryDto.getDepartureTime()))
                .arrivalTime(FormatUtil.stringToLocalDateTime(itineraryDto.getArrivalTime()))
                .checkIn(FormatUtil.stringToLocalDateTime(itineraryDto.getCheckIn()))
                .checkOut(FormatUtil.stringToLocalDateTime(itineraryDto.getCheckOut()))
                .build();
    }
}
