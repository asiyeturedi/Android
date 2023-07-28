package com.test.catchkenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView scoreText;
    TextView timerText;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;

    ImageView[] imageArray;

    Handler handler;

    Runnable runnable;


    int score;

    //heryerde tekrar kullanılabilmesi için burada tanımanıyor (oncreate dısında!)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization
        timerText = (TextView) findViewById(R.id.timerText);
        scoreText = (TextView) findViewById(R.id.ScoreText);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView6);
        //imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView2);
        imageView10 = (ImageView) findViewById(R.id.imageView3);


        imageArray  = new ImageView[]{ imageView1 ,imageView2 , imageView3 , imageView4 ,
                imageView5,imageView6,imageView7,imageView8,imageView9,imageView10 } ;


        hideImage();


        score = 0;
        new CountDownTimer(10000, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                timerText.setText("Time:" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    private void hideImage()
    {
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run()
            {

                for(ImageView image:imageArray)
                {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,1000);

            }
        };

        handler.post(runnable);

    }


    public void IncreaseScore(View view)
    {
        score++;
        scoreText.setText("score: "+ score);
    }






}