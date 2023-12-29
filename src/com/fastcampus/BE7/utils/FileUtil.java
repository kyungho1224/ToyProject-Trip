package com.fastcampus.BE7.utils;

import com.fastcampus.BE7.domain.trip.model.TripDto;
import com.fastcampus.BE7.domain.trip.model.TripEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by KimKyungHo on 2023-12-27(027)
 */
public class FileUtil {

    public static final String path = "travels/";
    public static final String prefix = "BE7-KIMKYUNGHO_";
    private static final GsonBuilder gsonBuilder = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .setPrettyPrinting();
    private static final Gson gson = gsonBuilder.create();

    private FileUtil() {
    }

    public static void saveFile(TripEntity tripEntity) {
        if (!new File(path).isDirectory()) {
            new File(path).mkdirs();
        }
        String saveData = gson.toJson(tripEntity, TripEntity.class);
        String fileName = prefix + tripEntity.getTripId() + ".json";
        File file = new File(path, fileName);
        try {
            FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8);
            fw.write(saveData);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static TripDto getTripFromFileById(int id) {
        String fileName = prefix + id + ".json";
        FileReader fr;
        try {
            fr = new FileReader(new File(path, fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gson.fromJson(fr, TripDto.class);
    }

    public static TripDto getTripFromFileByFilename(String filename) {
        FileReader fr;
        try {
            fr = new FileReader(new File(path, filename), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gson.fromJson(fr, TripDto.class);
    }

    public static List<TripDto> getAllTripData() {
        List<TripDto> tripDtoList = new ArrayList<>();
        File[] files = new File(path).listFiles();
        if (files != null) {
            for (File file : files) {
                tripDtoList.add(getTripFromFileByFilename(file.getName()));
            }
        }
        return tripDtoList;
    }

    public static boolean isFileExist(String filename) {
        return new File(path, filename).isFile();
    }

    public static int getCountTripRecord() {
        if (new File(path).listFiles() == null) {
            return 0;
        }
        return (int) Arrays.stream(Objects.requireNonNull(new File(path).listFiles())).count();
    }

}
