package com.fastcampus.BE7.domain.itinerary.enums;

import java.util.Arrays;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public enum ItineraryMenu {

    YES("Y", "여정 정보를 입력합니다."),
    NO("N", "메인메뉴로 돌아갑니다."),
    OTHERS("", "잘못된 입력입니다.");

    private final String menu;
    private final String message;

    ItineraryMenu(String menu, String message) {
        this.menu = menu;
        this.message = message;
    }

    public static ItineraryMenu selectMenu(String userInput) {
        return Arrays.stream(ItineraryMenu.values())
                .filter(itineraryMenu -> itineraryMenu.menu.equalsIgnoreCase(userInput))
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
