package com.purvik.studinfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends Activity {

    private static final int SPLASH_DURATION = 3000; //3 second
    private Handler myHandler;
    private boolean backbtnPress;
    ImageView img;
    TextView tv;
    Context contex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


       /* myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // For ProgressBar

                for (int i = 1; i <= 3; i++) {
                    try {
                        myHandler.wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                finish();

                if (!backbtnPress) {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    SplashScreen.this.startActivity(intent);
                }
            }
        }, SPLASH_DURATION);

*/
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in_from_left);

        img = (ImageView)findViewById(R.id.splashScreenImage);
        img.setAnimation(anim);

        tv = (TextView) findViewById(R.id.splashAppName);
        tv.setAnimation(anim1);

        anim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {


                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(intent);

                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        /*
        new Thread(new Runnable() {

            @Override
            public void run() {


                img = (ImageView)findViewById(R.id.splashScreenImage);
//                if(img != null) {
                    img.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
//                }
                try {
                    //MAKE THREAD FOR 3 SECOND
                    Thread.sleep(5000);

                    //SHOW PROGRESSBAR WITH DESIRED FILL PROGRESS


                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


                if (!backbtnPress) {
                    //START MAIN ACTIVITY
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    SplashScreen.this.startActivity(intent);

                    //TO FINISH SPLACH SCREEN ACTIVITY
                    finish();
                }

            }
        }).start();
*/
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        backbtnPress = true;
        super.onBackPressed();
    }

}

