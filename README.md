# 패스트캠퍼스 : 백엔드 개발 부트캠프

## ToyProject 1
* 1단계, 2단계, 3단계로 진행
* 최종 구현 목표는 '여행과 여정을 기록/관리하는 SNS 서비스'

### 1단계
* 달성목표 : Java 문법, 파일 입출력, 예외처리, 클래스 설계

### [프로젝트 정의]
1. 회원은 여러 여행 기록을 저장할 수 있습니다.<br>회원 가입은 다음 단계에서 고려하고 본 프로젝트는 여행과 여정을 기록하고 조회하는 기능을 구현하기로 한다.
2. 여행에는 여러 여정이 있을 수 있습니다.<br>여정정보는 이동정보(출발지, 목적지, 출발시간, 도착시간), 숙박정보(체크인, 체크아웃) 등의 종류를 포함할 수 있다.
3. 회원의 여행기록 목록이 출력되며, 각 여행기록 목록을 선택하면 상세한 여정기록이 출력됩니다.
4. 회원 및 여행기록은 향후 데이터베이스 테이블로 관리되지만 1단계 프로젝트에서는 여행별 여정 정보는 json 파일로 관리됩니다.
5. 여행정보 구조는 다음과 같습니다.

|  필드   |    필드ID     |   유형    |         설명         |
|:-----:|:-----------:|:-------:|:------------------:|
| 여행_id |   trip_id   |   정수    |   여행의 고유 식별자입니다.   |
| 여행_이름 |  trip_name  |   문자열   |    여행의 이름 또는 제목    |
| 시작_날짜 | start_date  | 문자열(날짜) |       여행 시작일       |
| 종료_날짜 |  end_date   | 문자열(날짜) |       여행 종료일       |
|  여정   | itineraries |  여정 배열  | 여정 개체를 포함하는 배열입니다. |

6. 여정정보 구조는 다음과 같습니다.

|  필드   |      필드ID       |     유형     |         설명          |
|:-----:|:---------------:|:----------:|:-------------------:|
| 여정_id |  itinerary_id   |     정수     | 각 여정 항목의 고유 식별자입니다. |
|  출발지  | departure_place |    문자열     |        출발 장소        |
|  도착지  |   destination   |  문자열(날짜)   |        도착 장소        |
| 출발_시간 | departure_time  |  문자열(날짜)   |      여행 출발 시간       |
| 도착_시간 |   itineraries   |   여정 배열    |      여행 도착 시간       |
|  체크인  |    check_in     | 문자열(날짜 시간) |       체크인 시간        |
| 체크아웃  |    check_out    | 문자열(날짜 시간) |       체크아웃 시간       |

7. JSON 파일 이름 규칙은 다음과 같습니다.<br><unique_prefix>_<trip_id>.json

### [프로젝트 요구사항]
1. 요구 사항
* 개별 여행은 여러 여정 정보로 구성됩니다. (여행 : 여정 = 1 : n)
* 여정 정보에는 이동 유형(출발지, 도착지, 출발 시간, 도착 시간) 및 숙박(체크인, 체크아웃)이 포함될 수 있습니다.
* 여행 정보 및 특정 여행 정보의 여정 목록은 데이터 저장 경로에 JSON 파일 형태로 저장됩니다.
* 객체지향 성격이 잘 드러날 수 있도록 클래스를 설계합니다.
* 프로젝트 기능구현을 위해 필요한 메소드를 정의하고 구현해봅니다.

2. 세부기능 구현

   1) 여행 및 여정 정보 기록 기능

      * ~~여행일정을 기록해야 한다.~~
      * ~~하나의 여행에 여러 개의 여정 정보를 기록해야 한다.~~
      * ~~여정 정보를 N개 입력 후 계속 기록 여부를 묻고(Y/N) 기록을 종료 할 수 있다.~~

   2) 여행 및 여정 조회 하는 기능

      * ~~여행 전체 리스트를 조회 할 수 있어야 한다.~~
      * ~~여행 전체 리스트에서 확인된 여행 아이디를 입력하면 해당 여행 정보와 여정 정보를 조회 할 수 있어야 한다.~~
      * ~~여행 정보와 여정 정보 조회는 JSON 파일에서 조회가 가능해야 한다.~~

   3) 예외처리

      * ~~여행 정보가 없으면 오류 메시지를 출력한다.~~
      * ~~여행에 여정이 없으면 추가할 수 있어야 한다.~~
      * ~~JSON 형식에 맞지 않으면 오류 메시지를 출력한다.~~
      * ~~한글 문자가 깨지지 않도록 해야 한다.~~

### [개발환경]
* Language : Java
* Build system : IntelliJ
* JDK : Amazon Corretto version 11
* Lib : gson-2.8.9

### [필요기능 정리]
#### FileUtil.java
* public static void saveFile(TripEntity tripEntity) : 여행 정보 JSON 파일 저장
* public static TripDto getTripFromFileById(int id) : 여행 ID로 JSON 파일 읽기
* public static TripDto getTripFromFileByFilename(String filename) : 파일이름으로 JSON 파일 읽기
* public static boolean isFileExist(String filename) : 파일이 있는지 체크
* public static int getCountTripRecord() : 저장된 여행의 개수

#### FormatUtil.java
* private static String checkLocalDateTimeFormat(String date) : 문자열을 LocalDateTime 으로 변환하기 전 체크(LocalDateTime 에서는 시간값이
  필수)
* public static LocalDateTime stringToLocalDateTime(String date) : 문자열을 LocalDateTime 으로 변환
* public static String localDateTimeToString(LocalDateTime localDateTime, boolean isLong) : LocalDateTime 을 문자열로 변환
* public static boolean isValid(String input) : 날짜타입 입력 상태 체크

#### TripConverter.java, ItineraryConverter.java
* Entity <-> Dto 변환 클래스
* Entity 날짜타입은 LocalDateTime(JSON 파일 저장), Dto 날짜타입은 String(사용자 화면 출력)

### [여행/여정 정보 파일 구조]
* travles/
  * 여행_1.json
  * 여행_2.json
  * 여행_3.json
  * ...

### [문제발생과 해결]
1) Entity -> JSON 파일에 저장<br>(Entity 변수명이 JSON 키 값으로 저장, 자바 네이밍 규칙(camelCase)을 지키면서 JSON 키는 제시된(snake_case)로 표기)
* 예상했던 결과
````json
{
  "trip_id": 1,
  "trip_name": "오사카",
  "start_date": "2024-01-13 00:00:00",
  "end_date": "2024-01-15 00:00:00",
  "itineraries": []
}
````
* 실제 결과
````json
{
  "tripId": 1,
  "tripName": "오사카",
  "startDate": "2024-01-13 00:00:00",
  "endDate": "2024-01-15 00:00:00",
  "itineraryEntityList": []
}
````
* 해결 방법
    * Gson 라이브러리의 어노테이션 사용하여 직렬화/역직렬화 이름 지정
````java
@SerializedName("trip_id")
@Expose
private int tripId;

@SerializedName("trip_name")
@Expose
private String tripName;

@SerializedName("start_date")
@Expose
private LocalDateTime startDate;

@SerializedName("end_date")
@Expose
private LocalDateTime endDate;

@SerializedName("itineraries")
@Expose
private List<ItineraryEntity> itineraryEntityList;
````

2) Entity -> JSON 파일에 저장<br>(LocalDateTime date(year,month,day), time(hour,minute,second,nano) 형태로 저장됨💦)
* 예상했던 결과

````json
{
  "trip_id": 1,
  "trip_name": "오사카",
  "start_date": "2024-01-13 00:00:00",
  "end_date": "2024-01-15 00:00:00",
  "itineraries": []
}
````

* 실제 결과

````json
{
  "trip_id": 1,
  "trip_name": "오사카",
  "start_date": {
    "date": {
      "year": 2024,
      "month": 1,
      "day": 13
    },
    "time": {
      "hour": 0,
      "minute": 0,
      "second": 0,
      "nano": 0
    }
  },
  "end_date": {
    "date": {
      "year": 2024,
      "month": 1,
      "day": 15
    },
    "time": {
      "hour": 0,
      "minute": 0,
      "second": 0,
      "nano": 0
    }
  },
  "itineraries": []
}
````

* 해결 방법
    * Gson 라이브러리의 직렬화 인터페이스를 구현하는 클래스를 생성하여 LocalDateTime 포맷 변경
````java
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(formatter.format(localDateTime));
    }

}

// 사용
GsonBuilder gsonBuilder = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
        .setPrettyPrinting();
Gson gson = gsonBuilder.create();
String saveData = gson.toJson(tripEntity, TripEntity.class);
````

###
3) 날짜 타입 체크
````java
public static boolean isValid(String input) {    
    return input.split("-").length == 3
            && input.split("-")[0].length() == 4
            && input.split("-")[1].length() <= 2
            && input.split("-")[2].length() <= 2;
}
````
* isValid 메서드로 사용자가 입력한 날짜의 형태를 체크하다가 여정의 정보가 저장되지 않음을 발견
* 여행 정보는 2024-12-25 과 같은 형태로 날짜만 입력했을 때에 정상 작동 하였지만, 여정 정보는 시간까지 입력하기 때문에 input.split("-")[2] 의 길이가 예상과는 다름을 디버깅으로 발견
````java
public static boolean isValid(String input) {
    if (input.contains(" ")) {
        input = input.split(" ")[0];
    }
    return input.split("-").length == 3
            && input.split("-")[0].length() == 4
            && input.split("-")[1].length() <= 2
            && input.split("-")[2].length() <= 2;
}
````
* 사용자가 입력한 날짜의 형태가 2024-12-25 10:00 처럼 시간까지 포함 했다면 공백을 기준으로 앞부분의 날짜만 체크하는 것으로 변경하여 정상 작동

### [1차 프로젝트 후기]
* 처음 메뉴를 생각했을 때에는 여정 정보는 여행의 하위 목록으로만 생각해서 메뉴를 [1.여행기록 2.여행조회 3.종료] 3개로 진행했습니다.
* 해당 기능이 완료 된 후에 요구사항에 있는 모든 메뉴를 구현하는게 옳다고 생각이 들어서 [3.여정기록 4.여정조회] 를 어떻게 구현해야 할지 고민했습니다.
* [3.여정기록] 을 위해서는 우선적으로 여행정보가 필요하기 때문에 해당 메뉴를 선택하면 여행목록을 출력한 후에 여행을 선택하여 여정을 입력할 수 있도록 했습니다.
* [4.여정조회] 의 기능은 사용자로부터 키워드를 입력받아 모든 여행의 모든 여정에 해당 키워드가 있는지 체크한 후 해당 여행의 기본정보(아이디, 여행이름)과 키워드가 포함된 여정만 리스트에 담아 출력했습니다.
* 여정 정보를 입력받을 때에 체크인/체크아웃이 필수값이 아니라는 생각에 여정 정보를 입력받기 전에 여정의 타입(숙소인지 아닌지)을 사용자로부터 받은 후에 체크인/체크아웃을 선택적으로 받으려고 계획했지만 아직 구현하지 못한 상태입니다.
* 2차 프로젝트가 시작되기 전에 여정의 타입을 입력받아서 체크인/체크아웃을 선택적으로 저장할 수 있도록 추가할 예정입니다.