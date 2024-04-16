package com.example.imageviewerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button prevButton;
    private Button nextButton;
    private int[] imageIds = {R.drawable.image1, R.drawable.image2};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        updateImage();

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    // Nếu đang ở ảnh đầu tiên, chuyển đến ảnh cuối cùng trong danh sách
                    currentIndex = imageIds.length - 1;
                }
                updateImage();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < imageIds.length - 1) {
                    currentIndex++;
                } else {
                    // Nếu đang ở ảnh cuối cùng, chuyển đến ảnh đầu tiên trong danh sách
                    currentIndex = 0;
                }
                updateImage();
            }
        });
    }

    private void updateImage() {
        imageView.setImageResource(imageIds[currentIndex]);
    }
}
