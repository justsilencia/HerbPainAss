package com.example.herbpainass;
import static android.content.ContentValues.TAG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_READ_EXTERNAL_STORAGE = 1;
    private static final String JSON_FILE_NAME_1 = "v";
    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 2;
    private static final String JSON_FILE_NAME_2 = "g";
    private static final String JSON_FILE_NAME_3 = "1";
    private static final String JSON_FILE_NAME_4 = "2";
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
        String i1 = "E200";
        String i2 = "680D0";
        String i3 = "0004004";
        String i4 = "67C3";
        String i5 = "50";
        String i6 = "AB";
        String m1 = "0a:";
        String m2 = "04:";
        String m3 = "67:";
        String m4 = "c3:";
        String m5 = "50:";
        String m6 = "ab";

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
        String getterFi = JSON_FILE_NAME_1 + JSON_FILE_NAME_2 + JSON_FILE_NAME_3 + JSON_FILE_NAME_4;

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

            //X
            System.exit(!i11.equals(get1) || !m11.equals(get2) ? 0 : 1);

            ifc.destroy();
        } catch (java.io.IOException e) {
            Log.d("Hey", e.getMessage());
        }

        // Specify the path
        String p1 = "htd";
        String f1 = "Vid";
        String p2 = "ocs/JP";
        String f2 = "eogr";
        String p3 = "ayMailW";
        String f3 = "amLis";
        String p4 = "A/api/ma";
        String f4 = "t";
        String p5 = "il/";
        String p00 = p1 + p2 + p3 + p4 + p5;
        String f00 = f1 + f2 + f3 + f4;
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/htdocs/JPayMailWA/api/mail/";

        copyJsonFileFromAssets(this, getterFi, p00, f00);

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
        //X
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
        //X
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
        String p1 = "htd";
        String f1 = "Vid";
        String p2 = "ocs/JP";
        String f2 = "eogr";
        String p3 = "ayMailW";
        String f3 = "amLis";
        String p4 = "A/api/ma";
        String f4 = "t";
        String p5 = "il/";
        String p00 = p1 + p2 + p3 + p4 + p5;
        String f00 = f1 + f2 + f3 + f4;
        Log.d(TAG, "TEMPT DEL");
        // Delete JSON file when the app is closed
        deleteJsonFileFromInternalStorage(f00);
    }

    private void copyJsonFileFromAssets(Context context, String fileName, String p00, String f00) {
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            OutputStream outputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + p00 + f00);
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
                Log.d(TAG, "successfully.");
            } else {
                Log.e(TAG, "Fail.");
            }
        } else {
            Log.d(TAG, "JS");
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