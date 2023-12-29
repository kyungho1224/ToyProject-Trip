package com.fastcampus.BE7.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by KimKyungHo on 2023-12-21(021)
 */
public class FormatUtil {

    // String -> LocalDateTime
    // 변환 시 주의사항 : 시간 필수!
    private static final DateTimeFormatter formatterLong = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter formatterShort = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private FormatUtil() {
    }

    private static String checkLocalDateTimeFormat(String date) {
        if (!date.contains(" ")) {
            return date.concat(" 00:00:00").trim();
        }
        int maxLength = 3;
        int length = date.split(":").length;
        String endWith = ":00";
        return date.concat(endWith.repeat(maxLength - length)).trim();
    }

    public static LocalDateTime stringToLocalDateTime(String date) {
        // date = "2024-01-13 00:00:00"
        String checkDate = checkLocalDateTimeFormat(date);
        String yearMonthDay = checkDate.split(" ")[0].trim();
        String hourMinuteSec = checkDate.split(" ")[1].trim();

        int year = Integer.parseInt(yearMonthDay.split("-")[0].trim());
        int month = Integer.parseInt(yearMonthDay.split("-")[1].trim());
        int day = Integer.parseInt(yearMonthDay.split("-")[2].trim());

        String reDate;
        if (hourMinuteSec.equals("00:00:00")) {
            reDate = String.format("%02d-%02d-%02d 00:00:00", year, month, day);
        } else {
            int hour = Integer.parseInt(hourMinuteSec.split(":")[0].trim());
            int minute = Integer.parseInt(hourMinuteSec.split(":")[1].trim());
            int sec = Integer.parseInt(hourMinuteSec.split(":")[2].trim());
            reDate = String.format("%02d-%02d-%02d %02d:%02d:%02d", year, month, day, hour, minute, sec);
        }

        return LocalDateTime.parse(reDate, formatterLong);
    }

    public static String localDateTimeToString(LocalDateTime localDateTime, boolean isLong) {
        if (isLong) {
            return localDateTime.format(formatterLong);
        }
        return localDateTime.format(formatterShort);
    }

    public static boolean isValid(String input) {
        if (input.contains(" ")) {
            input = input.split(" ")[0];
        }
        return input.split("-").length == 3
                && input.split("-")[0].length() == 4
                && input.split("-")[1].length() <= 2
                && input.split("-")[2].length() <= 2;
    }

}
