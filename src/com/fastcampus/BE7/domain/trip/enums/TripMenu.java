package com.fastcampus.BE7.domain.trip.enums;

import java.util.Arrays;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public enum TripMenu {

    INSERT_TRIP("1", "여행 정보를 입력합니다."),
    SEARCH_TRIP("2", "여행 정보를 조회합니다."),
    INSERT_ITINERARY("3", "여정 정보를 입력합니다."),
    SEARCH_ITINERARY("4", "여정 정보를 조회합니다."),
    EXIT("5", "프로그램을 종료합니다."),
    OTHERS("", "잘못된 입력입니다.");

    private final String menu;
    private final String message;

    TripMenu(String menu, String message) {
        this.menu = menu;
        this.message = message;
    }

    public static TripMenu selectMenu(String userInput) {
        return Arrays.stream(TripMenu.values())
                .filter(tripMenu -> tripMenu.menu.equals(userInput))
                .findFirst()
                .orElse(OTHERS);
    }

    public String getMenu() {
        return menu;
    }

    public String getMessage() {
        return message;
    }
}
