package com.example.myapplication;

import android.animation.Animator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView splashImg,background;
    TextView title1,title2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashImg = findViewById(R.id.my_wallet);
        title1 = findViewById(R.id.Title1);
        title2 = findViewById(R.id.Title2);
        background = findViewById(R.id.ribbons);

        splashImg.animate()
                .scaleX(1.5f) // Scale to 0 in the X direction
                .scaleY(1.5f) // Scale to 0 in the Y direction
                .alpha(0.0f)  // Set alpha to 0 for disappearance
                .setDuration(1000) // Animation duration in milliseconds
                .setStartDelay(2000) // Delay before starting the animation
                .start();

        title1.animate()
                .scaleX(1.5f) // Scale to 0 in the X direction
                .scaleY(1.5f) // Scale to 0 in the Y direction
                .alpha(0.0f)  // Set alpha to 0 for disappearance
                .setDuration(1000) // Animation duration in milliseconds
                .setStartDelay(2000) // Delay before starting the animation
                .start();

        title2.animate()
                .scaleX(1.5f) // Scale to 0 in the X direction
                .scaleY(1.5f) // Scale to 0 in the Y direction
                .alpha(0.0f)  // Set alpha to 0 for disappearance
                .setDuration(1000) // Animation duration in milliseconds
                .setStartDelay(2000) // Delay before starting the animation
                .start();

        background.animate()
                .scaleX(0.0f) // Scale to 0 in the X direction
                .scaleY(0.0f) // Scale to 0 in the Y direction
                .alpha(0.0f)  // Set alpha to 0 for disappearance
                .setDuration(1000) // Animation duration in milliseconds
                .setStartDelay(2000) // Delay before starting the animation
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {

                        if (isLoggedIn()) {
                            // User is logged in, go to Demo activity
                            Intent intent = new Intent(MainActivity.this, Home.class);
                            startActivity(intent);
                            finish(); // Optional: Close the MainActivity
                        } else {
                            // User is not logged in, go to Login activity
                            Intent intent = new Intent(MainActivity.this, slider_activity.class);
                            startActivity(intent);
                            finish(); // Optional: Close the MainActivity
                        }
                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {

                    }
                })
                .start();



    }
    private boolean isLoggedIn() {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return preferences.getBoolean("isLoggedIn", false);
    }

}