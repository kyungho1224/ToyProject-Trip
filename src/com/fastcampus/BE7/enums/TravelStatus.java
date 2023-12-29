package com.fastcampus.BE7.enums;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public enum TravelStatus {
    TRIP_LIST_SUCCESS(1200, "저장된 여행 리스트입니다."),
    TRIP_LIST_NULL(1404, "저장된 여행 목록이 없습니다."),
    OTHERS(1405, "잘못된 입력입니다.")
    ;

    private final int code;
    private final String message;

    TravelStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
