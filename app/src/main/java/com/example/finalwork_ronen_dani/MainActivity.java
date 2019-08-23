package com.example.finalwork_ronen_dani;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private int score = 0;
    private long timeInMilleSeconds = 30000;
    CountDownTimer counterTimer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FrameLayout myLayout = findViewById(R.id.frameLayout);
        TextView tv = findViewById(R.id.score);
        TextView tv2 = findViewById(R.id.textView4);

        // Starting Timer for the game.
        startGameTime();


        // Creating GridLayout.....
        GridLayout myGridLayout = createNewGridLayout(3, 3);


        //FrameLayout frame = findViewById(R.id.myFrame);
        //tv.append("0");
        //  tv2.append("30");
        myLayout.addView(myGridLayout);

        // myLayout.setGravity(Gravity.CENTER);
        // frame.addView(myGridLayout);
    }

    private void startGameTime() {
        new CountDownTimer(30000, 1000) {
            TextView time = findViewById(R.id.countDownText);

            public void onTick(long millisUntilFinished) {
                time.setText("" + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                time.setText("done!");
            }

        }.start();

    }


    private GridLayout createNewGridLayout(int columns, int rows) {
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(columns);
        gridLayout.setRowCount(rows);
        gridLayout.setId(0);


//        for (int i = 0; i < 9; i++) {
//            //gridLayout.setBackgroundResource(R.drawable.my_c);
//            TextView textView = new TextView(this);
//           // textView.
//            textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ((TextView) view).setGravity(Gravity.CENTER);
//                    //((TextView) view).setBackgroundResource(R.drawable.hole);
//                   //((TextView) view).setBackgroundResource((R.drawable.rat));
////                    ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationX", 100f);
////                    animation.setDuration(1000);
////                    animation.start();
//                   // Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.slide_right_in);
//                   // animation.setStartOffset(0);
//                   // ((TextView) view).startAnimation(animation);
////                    ((TextView)view).animate().x(100f).y(100f).rotation(100f).start();
//                }
//            });
//            textView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
//            textView.setBackgroundResource(R.drawable.hole);
//            gridLayout.addView(textView);
//
//        }

        for (int i = 0; i < 9; i++) {
            ImageView iv = new ImageView(this);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    TextView points = findViewById(R.id.points);
                    int sum = Integer.parseInt(points.getText().toString());
                    sum += 10;
                    points.setText("" + sum);
                    ((ImageView)view).setImageResource(R.drawable.frog);

                    //                    ((ImageView)view).startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.));
//                    ((ImageView)view).setAlpha(127); ;
//                    AlphaAnimation animation1 = new AlphaAnimation(0.1f, 1.0f);
//                    animation1.setDuration(1);
//                    animation1.setStartOffset(5000);
//                    animation1.setFillAfter(true);
//                    ((ImageView)view).startAnimation(animation1);
//                    ((ImageView)view).setAlpha(1f);
                    // Animation


                }
            });
            iv.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
            iv.setBackgroundResource(R.drawable.hole);
            iv.setImageResource(R.drawable.finalmonster);
            //   iv.setImageResource(R.drawable.rat);


            //  iv.setImageDrawable();
            gridLayout.addView(iv);
        }


        return gridLayout;
    }
}
