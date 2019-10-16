package com.example.lolz;


import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.SeekBar;
import java.util.Random;


import android.os.Bundle;
import android.widget.Toast;

public class FullscreenActivity extends AppCompatActivity {

    TextView txt;
    Button b;
    SeekBar s;
    Random r;
    int maxi=5;
    TextView txt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        txt = (TextView) findViewById(R.id.textView);
        b = findViewById(R.id.button);
        s = findViewById(R.id.seekBar);
        txt2 = findViewById(R.id.textView2);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r = new Random();
                if (maxi == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Value is limited to 0",
                            Toast.LENGTH_SHORT);
                    toast.show();
                    txt.setText("" + 0);
                } else {
                    int num = r.nextInt(maxi);
                    txt.setText("" + num);

                }
            }
        });
        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                maxi = (int)(progress*5);
                txt2.setVisibility(View.VISIBLE);
                txt2.setText(""+maxi);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}