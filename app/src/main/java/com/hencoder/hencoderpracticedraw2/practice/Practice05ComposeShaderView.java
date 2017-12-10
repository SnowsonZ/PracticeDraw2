package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice05ComposeShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice05ComposeShaderView(Context context) {
        super(context);
        prepare();
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        prepare();
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        prepare();
    }

    private void prepare() {
        setLayerType(LAYER_TYPE_SOFTWARE, null); // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader
        Bitmap bg_src = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        BitmapShader bs_bg = new BitmapShader(bg_src, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Bitmap fg_src = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
        BitmapShader bs_fg = new BitmapShader(fg_src, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        ComposeShader cs = new ComposeShader(bs_bg, bs_fg, PorterDuff.Mode.DST_IN);
        paint.setShader(cs);
    }

    {

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(200, 200);
        canvas.drawCircle(170, 200, 200, paint);
    }
}
