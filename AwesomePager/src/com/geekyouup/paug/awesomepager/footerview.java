package com.geekyouup.paug.awesomepager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

public class footerview extends View {
	Paint paint;
	RectF rect;
	private int numOfViews,pos;
	float mid;
	public footerview(Context context,int numOfViews,int width) {
		super(context);
		paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(2);
		this.numOfViews = numOfViews;
		mid = width/2;
		rect = new RectF(mid, 20, mid+7, 27);
		Log.i("footer","testing");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawRGB(164, 198, 57);
		Log.i("footer","testing2");
		for(int i = 0; i < numOfViews; i++) {
			if(pos == i) paint.setStyle(Paint.Style.FILL_AND_STROKE);
			rect.set(mid+i*12, 20, mid+i*12+7, 27);			
			canvas.drawOval(rect, paint);
			paint.setStyle(Paint.Style.STROKE);
		}
		super.onDraw(canvas);
	}
	
	public void Update(int p) {
		pos = p;
		invalidate();
	}
	
	@Override
	public void onSizeChanged(int w, int h, int oldW, int oldH) {
	      // Set the movement bounds for the ball
		mid = w/2;
		mid = mid - numOfViews*6;
	}
}
