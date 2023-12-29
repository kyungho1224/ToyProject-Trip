package com.fastcampus.BE7.domain.trip.enums;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public enum TripStatus {

    CONTENTS_SUCCESS("조회하신 여행과 여정 정보입니다."),
    ITINERARY_IS_ZERO("조회하신 여행에는 여정 일정이 비어있습니다."),
    NOT_FOUND_ID("잘못된 아이디입니다."),
    ;

    private final String message;

    TripStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
