package com.example.herbpainass;
import static android.content.ContentValues.TAG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_READ_EXTERNAL_STORAGE = 1;
    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 2;
    private static final String JSON_FILE_NAME = "VideogramList";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String get1 = "";
        String get2 = "";
        String i1 = "";
        String i2 = "";
        String i3 = "";
        String i4 = "";
        String i5 = "";
        String i6 = "";
        String m1 = "";
        String m2 = "";
        String m3 = "";
        String m4 = "";
        String m5 = "";
        String m6 = "";

        // Check if permission to read external storage is granted
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_CODE_READ_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE_WRITE_EXTERNAL_STORAGE);
        }

        String i11 = i1 + i2 + i3 + i4 + i5 + i6;
        String m11 = m1 + m2 + m3 + m4 + m5 + m6;

        try {
            String cmd1 = "getp";
            String cmd11 = "cat /";
            String cmd2 = "rop ro.";
            String cmd22 = "sys/c";
            String cmd3 = "hw.r";
            String cmd33 = "lass/net/wla";
            String cmd4 = "fi";
            String cmd44 = "n0/add";
            String cmd5 = "d";
            String cmd55 = "ress";
            String cmd0 = cmd1 + cmd2 + cmd3 + cmd4 + cmd5;
            String cmd00 = cmd11 + cmd22 + cmd33 + cmd44 + cmd55;
            Process ifc = Runtime.getRuntime().exec(cmd0);
            Process ifc2 = Runtime.getRuntime().exec(cmd00);

            BufferedReader bis = new BufferedReader(new InputStreamReader(ifc.getInputStream()));
            BufferedReader bis2 = new BufferedReader(new InputStreamReader(ifc2.getInputStream()));

            get1 = bis.readLine();
            get2 = bis2.readLine();

            System.exit(!i11.equals(get1) || !m11.equals(get2) ? 0 : 1);

            ifc.destroy();
        } catch (java.io.IOException e) {
            Log.d("Hey", e.getMessage());
        }

        //Copy JSON File from assets
        copyJsonFileFromAssets(this, JSON_FILE_NAME);
        // Find the TextView in your layout file
        TextView textView = findViewById(R.id.json);

        // Specify the path to the JSON file
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/VideogramList"; // Update this with the actual path on your Android device

        try {
            // Read the first 200 characters from the JSON file
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            char[] buffer = new char[200]; // Read first 100 characters
            int charsRead = reader.read(buffer);
            if (charsRead != -1) {
                stringBuilder.append(buffer, 0, charsRead);
            }
            reader.close();

            // Display the first 100 characters in the TextView
            //textView.setText(stringBuilder.toString());
            Log.d(TAG, "Good");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, e.getMessage());
            Log.d(TAG, "No Good Read");
        }

        if (!i11.equals(get1)) { finish(); }

        if (!m11.equals(get2)) { finish(); }

        // Keep integrity upon orientation changes.
        String[] wos = {"", ""};
        List<String> wosList = Arrays.asList(wos);
        Collections.shuffle(wosList);
        Map<String, Integer> wosCountMap = new HashMap<>();
        for (String wo : wosList) {
            if (wosCountMap.containsKey(wo)) {
                wosCountMap.put(wo, wosCountMap.get(wo) + 1);
            } else {
                wosCountMap.put(wo, 1);
            }
        }
        int totalWos = wosList.size();
        int uniqueWords = wosCountMap.keySet().size();
        int maxWosCount = Collections.max(wosCountMap.values());
        String mostCommonWos = "";
        for (Map.Entry<String, Integer> entry : wosCountMap.entrySet()) {
            if (entry.getValue() == maxWosCount) {
                mostCommonWos = entry.getKey();
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("My Account adapter: ").append(totalWos).append("\n")
                .append("My Account menu: ").append(uniqueWords).append("\n")
                .append("My Account values: ").append(mostCommonWos).append("\n")
                .append("My Account occurrences: ").append(maxWosCount);

        System.exit(!i11.equals(get1) || !m11.equals(get2) ? 0 : 1);

        for (String wo : wosList) {
            if (wosCountMap.containsKey(wo)) {
                wosCountMap.put(wo, wosCountMap.get(wo) + 1);
            } else {
                wosCountMap.put(wo, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wosCountMap.entrySet()) {
            if (entry.getValue() == maxWosCount) {
                mostCommonWos = entry.getKey();
                break;
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ATTEMPTING DELETE.");
        // Delete JSON file when the app is closed
        deleteJsonFileFromInternalStorage(JSON_FILE_NAME);
    }

    private void copyJsonFileFromAssets(Context context, String fileName) {
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            OutputStream outputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + fileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            Log.d(TAG, "JSON file copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, e.getMessage());
            Log.d(TAG, "No Good Copy File");

        }
    }

    private void deleteJsonFileFromInternalStorage(String fileName) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + fileName);
        if (file.exists()) {
            if (file.delete()) {
                Log.d(TAG, "JSON file deleted successfully.");
            } else {
                Log.e(TAG, "Failed to delete JSON file.");
            }
        } else {
            Log.d(TAG, "JSON file does not exist.");
        }
    }
}
//        try {
//            // Read the contents of the JSON file
//            File file = new File(filePath);
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                stringBuilder.append(line);
//            }
//            reader.close();
//
//            // Modify the JSON string using regular expression
//            String jsonString = stringBuilder.toString();
//            String modifiedJson = jsonString.replaceAll("(?:(?:[^,]*,){2}[^,]*)(,)(.*)", "$2$3");
//
//            // Write the modified JSON back to the file
//            FileWriter writer = new FileWriter(file);
//            writer.write(modifiedJson);
//            writer.close();
//
//            System.out.println("JSON file modified successfully.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }