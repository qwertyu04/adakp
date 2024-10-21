    package com.example.trafficlight;

    import android.annotation.SuppressLint;
    import android.graphics.Bitmap;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        Button redbtn, yellowbtn, greenbtn;
        Bitmap bitmap;
        Canvas canvas;
        ImageView img;
        Paint paint;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);

            bitmap = Bitmap.createBitmap(800, 800, Bitmap.Config.ARGB_8888); // Increased height for spacing
            paint = new Paint();
            canvas = new Canvas(bitmap);

            redbtn = findViewById(R.id.red);
            yellowbtn = findViewById(R.id.yellow);
            greenbtn = findViewById(R.id.green);
            img = findViewById(R.id.img);

            redbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clearCanvas();
                    paint.setColor(Color.argb(255, 255, 0, 0)); // Red color
                    canvas.drawCircle(400, 200, 100, paint); // Draw red light
                    img.setImageBitmap(bitmap);
                }
            });

            yellowbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clearCanvas();
                    paint.setColor(Color.argb(255, 255, 255, 0)); // Proper Yellow color
                    canvas.drawCircle(400, 400, 100, paint); // Draw yellow light
                    img.setImageBitmap(bitmap);
                }
            });

            greenbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clearCanvas();
                    paint.setColor(Color.argb(255, 0, 255, 0)); // Green color
                    canvas.drawCircle(400, 600, 100, paint); // Draw green light
                    img.setImageBitmap(bitmap);
                }
            });
        }

        // Method to clear the canvas before drawing a new circle
        private void clearCanvas() {
            canvas.drawColor(Color.TRANSPARENT, android.graphics.PorterDuff.Mode.CLEAR);
        }
    }
