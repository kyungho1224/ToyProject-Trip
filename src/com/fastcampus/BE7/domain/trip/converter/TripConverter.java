package com.fastcampus.BE7.domain.trip.converter;

import com.fastcampus.BE7.domain.itinerary.converter.ItineraryConverter;
import com.fastcampus.BE7.domain.itinerary.model.ItineraryDto;
import com.fastcampus.BE7.domain.itinerary.model.ItineraryEntity;
import com.fastcampus.BE7.domain.trip.model.TripDto;
import com.fastcampus.BE7.domain.trip.model.TripEntity;
import com.fastcampus.BE7.utils.FormatUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by KimKyungHo on 2023-12-28(028)
 */
public class TripConverter {

    public TripDto toDto(TripEntity tripEntity) {
        List<ItineraryDto> itineraryDtoList = tripEntity.getItineraryEntityList()
                .stream()
                .map(itineraryEntity -> new ItineraryConverter().toDto(itineraryEntity))
                .collect(Collectors.toList());

        return new TripDto.Builder()
                .tripId(tripEntity.getTripId())
                .tripName(tripEntity.getTripName())
                .startDate(FormatUtil.localDateTimeToString(tripEntity.getStartDate(), false))
                .endDate(FormatUtil.localDateTimeToString(tripEntity.getEndDate(), false))
                .itineraryDTOList(itineraryDtoList)
                .build();
    }

    public TripEntity toEntity(TripDto tripDto) {
        List<ItineraryEntity> itineraryEntityList = tripDto.getItineraryDTOList()
                .stream()
                .map(itineraryDto -> new ItineraryConverter().toEntity(itineraryDto))
                .collect(Collectors.toList());

        return new TripEntity.Builder()
                .tripId(tripDto.getTripId())
                .tripName(tripDto.getTripName())
                .startDate(FormatUtil.stringToLocalDateTime(tripDto.getStartDate()))
                .endDate(FormatUtil.stringToLocalDateTime(tripDto.getEndDate()))
                .itineraryEntityList(itineraryEntityList)
                .build();
    }
}
