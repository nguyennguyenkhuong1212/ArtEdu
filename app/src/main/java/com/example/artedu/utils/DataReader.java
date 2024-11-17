package com.example.artedu.utils;

import android.content.Context;
import android.util.Log;

import com.example.artedu.R;
import com.example.artedu.models.ArtMovement;
import com.example.artedu.models.Painting;
import com.example.artedu.models.Question;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonSyntaxException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataReader {

    public static ArrayList<Question> readQuestionsFromAssets(Context context, String filename) {
        ArrayList<Question> questions = null;
        try {
            InputStream inputStream = context.getAssets().open(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            char[] buffer = new char[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int numRead;
            while ((numRead = inputStreamReader.read(buffer)) != -1) {
                stringBuilder.append(buffer, 0, numRead);
            }

            String jsonString = stringBuilder.toString();
            Gson gson = new Gson();

            JsonObject rootObject = gson.fromJson(jsonString, JsonObject.class);

            JsonArray questionsArray = rootObject.getAsJsonArray("questions");

            Type questionListType = new TypeToken<ArrayList<Question>>(){}.getType();
            questions = gson.fromJson(questionsArray, questionListType);

        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public static ArrayList<ArtMovement> readMovementsFromAssets(Context context, String filename) {
        ArrayList<ArtMovement> movements = null;
        try {
            InputStream inputStream = context.getAssets().open(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            char[] buffer = new char[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int numRead;
            while ((numRead = inputStreamReader.read(buffer)) != -1) {
                stringBuilder.append(buffer, 0, numRead);
            }

            String jsonString = stringBuilder.toString();
            Gson gson = new Gson();

            JsonObject rootObject = gson.fromJson(jsonString, JsonObject.class);

            JsonArray movementsArray = rootObject.getAsJsonArray("movements");

            Type movementListType = new TypeToken<ArrayList<ArtMovement>>(){}.getType();
            movements = gson.fromJson(movementsArray, movementListType);


        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
        return movements;
    }
    public static ArrayList<Painting> readPaintingsFromAssets(Context context, String filename) {
        ArrayList<Painting> paintings = new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            char[] buffer = new char[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int numRead;
            while ((numRead = inputStreamReader.read(buffer)) != -1) {
                stringBuilder.append(buffer, 0, numRead);
            }

            String jsonString = stringBuilder.toString();
            Gson gson = new Gson();

            JsonObject rootObject = gson.fromJson(jsonString, JsonObject.class);

            JsonArray paintingsArray = rootObject.getAsJsonArray("paintings");

            Type paintingsListType = new TypeToken<ArrayList<Painting>>(){}.getType();
            paintings = gson.fromJson(paintingsArray, paintingsListType);

        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
        return paintings;
    }
}
