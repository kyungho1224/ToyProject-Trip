package com.fastcampus.BE7.domain.itinerary.enums;

/**
 * Created by KimKyungHo on 2023-12-29(029)
 */
public enum ItineraryStatus {
    SUCCESS("검색된 여정 목록입니다."),
    NOT_FOUND("해당 키워드의 여정이 존재하지 않습니다."),
    ;

    private final String message;

    ItineraryStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
