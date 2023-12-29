package com.fastcampus.BE7.view;

import com.fastcampus.BE7.domain.itinerary.model.ItineraryDto;
import com.fastcampus.BE7.domain.trip.model.TripDto;

import java.util.List;
import java.util.Scanner;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public class ConsoleView {

    private final Scanner scanner = new Scanner(System.in);

    public ConsoleView() {
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public String printTripMenu() {
        System.out.println("====================== 메뉴 리스트 ======================");
        System.out.println("1. 여행기록\t2. 여행조회\t3. 여정기록\t4. 여정조회\t5. 종료");
        System.out.println("=======================================================");
        System.out.print("시작할 메뉴번호를 입력하세요 : ");
        return scanner.nextLine();
    }

    public TripDto getTripRecord() {
        System.out.print("여행이름을 입력하세요 : ");
        String tripName = scanner.nextLine();
        System.out.print("시작 날짜를 입력하세요 (yyyy-MM-dd) : ");
        String startDate = scanner.nextLine();
        System.out.print("종료 날짜를 입력하세요 (yyyy-MM-dd) : ");
        String endDate = scanner.nextLine();

        return new TripDto.Builder()
                .tripName(tripName)
                .startDate(startDate)
                .endDate(endDate)
                .itineraryDTOList(List.of())
                .build();
    }

    public String printContinueItinerary() {
        System.out.print("===== 여정 정보를 추가하시겠습니까? (Y/N) : ");
        return scanner.nextLine();
    }

    public ItineraryDto getItineraryRecord() {
        System.out.print("출발지를 입력하세요 : ");
        String departurePlace = scanner.nextLine();
        System.out.print("출발시간을 입력하세요 (yyyy-MM-dd HH:mm:ss) or (yyyy-MM-dd HH:mm) or (yyyy-MM-dd HH) : ");
        String departureTime = scanner.nextLine();
        System.out.print("도착지를 입력하세요 : ");
        String destination = scanner.nextLine();
        System.out.print("도착시간을 입력하세요 (yyyy-MM-dd HH:mm:ss) or (yyyy-MM-dd HH:mm) or (yyyy-MM-dd HH) : ");
        String arrivalTime = scanner.nextLine();
        System.out.print("체크인(입장)시간을 입력하세요 (yyyy-MM-dd HH:mm:ss) or (yyyy-MM-dd HH:mm) or (yyyy-MM-dd HH) : ");
        String checkIn = scanner.nextLine();
        System.out.print("체크아웃(퇴장)시간을 입력하세요 (yyyy-MM-dd HH:mm:ss) or (yyyy-MM-dd HH:mm) or (yyyy-MM-dd HH) : ");
        String checkOut = scanner.nextLine();

        return new ItineraryDto.Builder()
                .departurePlace(departurePlace)
                .departureTime(departureTime)
                .destination(destination)
                .arrivalTime(arrivalTime)
                .checkIn(checkIn)
                .checkOut(checkOut)
                .build();
    }

    public String searchItineraryByKeyword() {
        System.out.print("검색할 여정의 키워드를 입력하세요 : ");
        return scanner.nextLine();
    }

    public void printSearchItineraryList(List<TripDto> tripDtoList) {

        System.out.println("===========================================");
        for (TripDto tripDto : tripDtoList) {
            System.out.println("여행 아이디: " + tripDto.getTripId() + "\t여행의 제목: " + tripDto.getTripName());
            for (ItineraryDto itineraryDto : tripDto.getItineraryDTOList()) {
                System.out.printf("출발 : %s(%s) ~ 도착 : %s(%s)%n",
                        itineraryDto.getDeparturePlace(),
                        itineraryDto.getDepartureTime(),
                        itineraryDto.getDestination(),
                        itineraryDto.getArrivalTime());
            }
        }
        System.out.println("===========================================");
    }

    public String printTripRecordList(List<TripDto> tripDtoList) {
        for (TripDto tripDto : tripDtoList) {
            System.out.println("여행 아이디: " + tripDto.getTripId() + "\t여행의 제목: " + tripDto.getTripName());
        }
        System.out.print("여행의 아이디를 입력하세요 : ");
        return scanner.nextLine();
    }

    public void printTripAndItinerary(TripDto tripDto) {
        System.out.printf("[여행 : %s, 기간 : %s ~ %s]%n",
                tripDto.getTripName(),
                tripDto.getStartDate(),
                tripDto.getEndDate());
        if (tripDto.getItineraryDTOList().size() > 0) {
            for (ItineraryDto itineraryDto : tripDto.getItineraryDTOList()) {
                System.out.println("** " + itineraryDto.getItineraryId() + "번째 여정 **");
                System.out.printf("출발 : %s(%s) ~ 도착 : %s(%s)%n",
                        itineraryDto.getDeparturePlace(),
                        itineraryDto.getDepartureTime(),
                        itineraryDto.getDestination(),
                        itineraryDto.getArrivalTime());
                System.out.printf("체크인 : %s ~ 체크아웃 : %s%n",
                        itineraryDto.getCheckIn(),
                        itineraryDto.getCheckOut());
                System.out.println();
            }
        }
    }

}
