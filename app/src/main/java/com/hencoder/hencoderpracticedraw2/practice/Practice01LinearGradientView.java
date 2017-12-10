package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01LinearGradientView(Context context) {
        super(context);
        prepare();
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        prepare();
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        prepare();
    }

    private void prepare() {
        LinearGradient lg = new LinearGradient(0, 0, 1000, 600,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.REPEAT);
        paint.setShader(lg);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawCircle(400, 400, 350, paint);
        canvas.drawRect(50, 50, 900, 600, paint);
    }
}
