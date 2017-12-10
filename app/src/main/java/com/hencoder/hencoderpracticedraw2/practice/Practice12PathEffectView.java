package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    CornerPathEffect cpe = null;
    DiscretePathEffect dipe = null;
    DashPathEffect dape = null;
    PathDashPathEffect pdpe = null;
    SumPathEffect spe = null;
    ComposePathEffect cope = null;

    public Practice12PathEffectView(Context context) {
        super(context);
        prepare();
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        prepare();
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        prepare();
    }

    private void prepare() {
        cpe = new CornerPathEffect(20);
        dipe = new DiscretePathEffect(20, 5);
        dape = new DashPathEffect(new float[]{20, 10, 5, 10}, 0);
        Path dashPath = new Path();
        dashPath.lineTo(20, -30);
        dashPath.lineTo(40, 0);
        dashPath.close();
        pdpe = new PathDashPathEffect(dashPath, 50, 0, PathDashPathEffect.Style.MORPH);
        spe = new SumPathEffect(dape, dipe);
        cope = new ComposePathEffect(dape, dipe);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        paint.setPathEffect(cpe);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        paint.setPathEffect(dipe);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        paint.setPathEffect(dape);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        paint.setPathEffect(pdpe);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        paint.setPathEffect(spe);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        paint.setPathEffect(cope);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
