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

import android.Manifest;
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

        try {
            String checkID = "";
            String checkMAC = "";
            String cmd1 = "getprop ro.hw.rfid";
            String cmd2 = "cat /sys/class/net/wlan0/address";
            Process ifc = Runtime.getRuntime().exec(cmd1);
            Process ifc2 = Runtime.getRuntime().exec(cmd2);

            BufferedReader bis = new BufferedReader(new InputStreamReader(ifc.getInputStream()));
            BufferedReader bis2 = new BufferedReader(new InputStreamReader(ifc2.getInputStream()));

            String getID = bis.readLine();
            String getMAC = bis2.readLine();

            if (getID != checkID) {
                //finish();
            }

            if (getMAC != checkMAC) {
                //finish();
            }
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