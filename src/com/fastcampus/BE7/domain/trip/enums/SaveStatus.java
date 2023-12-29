package com.fastcampus.BE7.domain.trip.enums;

/**
 * Created by KimKyungHo on 2023-12-28(028)
 */
public enum SaveStatus {

    NOT_MATCH_LOCAL_DATE_TIME("날짜 형식을 바르게 입력하세요."),
    INSERT_TRIP_SUCCESS("여행정보가 저장되었습니다."),
    INSERT_ITINERARY_SUCCESS("여정정보가 저장되었습니다."),
    ;

    private final String message;

    SaveStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
