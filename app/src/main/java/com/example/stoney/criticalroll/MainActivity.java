package com.example.stoney.criticalroll;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView diceText;
    private ImageView diceImage;
    private TextView criticalText;
    private Random rng = new Random();
    private MediaPlayer mp;
    private MediaPlayer missEffect;
    private MediaPlayer winEffect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceText = findViewById(R.id.dice_value);
        diceImage = findViewById(R.id.imageView_dice);
        criticalText = findViewById(R.id.textView);
        mp = MediaPlayer.create(this, R.raw.diceroll);
        missEffect = MediaPlayer.create(this, R.raw.miss);
        winEffect = MediaPlayer.create(this, R.raw.horn);

        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
    }

    private void rollDice() {

        mp.start();

        int randomNumber = rng.nextInt(20) + 1;
        diceText.setText("" + randomNumber);
        if (randomNumber==1){
            criticalText.setText("Critical Miss");
            missEffect.start();
        } else if (randomNumber==20){
            criticalText.setText("Critical Hit");
            winEffect.start();
        } else {
            criticalText.setText("");
        }
    }
}
