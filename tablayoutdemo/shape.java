//to add canvas api in one fragment call this in that fragment
// public class TabCanvasFragment extends Fragment {
//     @Nullable
//     @Override
//     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//         // Inflate the custom ShapeView to draw the circle and rectangle
//         return new ShapeView(getContext(), null);
//     }
// }

package com.example.tabcanvasapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class ShapeView extends View {

    private Paint paintCircle;
    private Paint paintRect;

    public ShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // Initialize paint for the circle
        paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCircle.setStyle(Paint.Style.FILL);
        paintCircle.setColor(Color.CYAN);
        paintCircle.setStrokeWidth(5);
        paintCircle.setShader(new RadialGradient(300, 300, 100, Color.YELLOW, Color.RED, Shader.TileMode.MIRROR));

        // Initialize paint for the rectangle
        paintRect = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRect.setStyle(Paint.Style.STROKE);
        paintRect.setColor(Color.GREEN);
        paintRect.setStrokeWidth(8);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw circle
        canvas.drawCircle(300, 300, 100, paintCircle);

        // Draw rectangle with a border
        Rect rect = new Rect(100, 500, 500, 800);
        canvas.drawRect(rect, paintRect);
    }
}
