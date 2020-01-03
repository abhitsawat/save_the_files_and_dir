package com.example.kuchtumkahokuchhumkahin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final  int REQ_CODE_SPEECH_INPUT=100;
    TextView t, t1;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE_SPEECH_INPUT) {
            if (resultCode == RESULT_OK && null != data) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                t.setText(result.get(0));

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.voiceInput);
        t1 = findViewById(R.id.btnspeak);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // implicent intent
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                // put the lang on extera Lang
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        // get understhand Lang any of
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        "Hi speak abhit");
                startActivityForResult(intent,REQ_CODE_SPEECH_INPUT);
            }
        });



}
    }