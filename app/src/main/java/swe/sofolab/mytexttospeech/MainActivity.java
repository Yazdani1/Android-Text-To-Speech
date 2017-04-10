package swe.sofolab.mytexttospeech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.speech.tts.TextToSpeech;
import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t1;
    TextView textvoicecheck;

    TextView textview_second;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        textvoicecheck=(TextView)findViewById(R.id.textview);


        textview_second=(TextView)findViewById(R.id.textView_second);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });

        textvoicecheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = textvoicecheck.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        textview_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = "its c";
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }


    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

}
