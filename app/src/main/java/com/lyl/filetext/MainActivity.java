package com.lyl.filetext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        Button show = (Button) findViewById(R.id.show);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileSave();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }
    private void show(){
        String content ="";
        try {
            FileInputStream in = openFileInput("data.txt");
            byte[] by = new byte[in.available()];
            in.read(by);
            content = new String(by);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("HHHHH",content);
    }

    private void fileSave() {
        String file = "data.txt";
        String content = "Hello World!";
        FileOutputStream fos;


        try {
            fos = openFileOutput(file,MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
