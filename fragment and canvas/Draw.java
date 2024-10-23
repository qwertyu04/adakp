package com.example.fragmentdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.view.View;

import androidx.annotation.NonNull;

public class Draw extends View {
    private Paint brush;  // Declare Paint object
    private RadialGradient radialGradient;

    public Draw(Context context) {
        super(context);
        init();
    }

    public void init() {
        // Initialize the Paint object FIRST
        brush = new Paint();
        brush.setAntiAlias(true);  // Make the drawing smoother

        // Then set up the gradient
        radialGradient = new RadialGradient(
                0, 0,
                20,
                Color.GREEN,
                Color.BLUE,
                Shader.TileMode.REPEAT
        );

        // Now you can safely set the color and shader
        brush.setColor(Color.parseColor("#00FF00"));  // green color
        brush.setShader(radialGradient);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(
                getMeasuredWidth() / 2f,
                getMeasuredHeight() / 2f,
                308f,
                brush
        );
    }
}