package com.skula.tikal.services;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.skula.tikal.R;
import com.skula.tikal.constantes.Cnst;

public class Drawer {
	private Paint paint;
	private Resources res;

	public Drawer(Resources res) {
		this.res = res;
		this.paint = new Paint();
	}

	public void draw(Canvas c) {
		paint.setColor(Color.WHITE);
		c.drawRect(new Rect(0,0,1280,800), paint);
		drawTiles(c);
	}

	private void drawTiles(Canvas c) {
		int dx = Cnst.TILE_DRAW_WIDTH;
		int dy = Cnst.TILE_DRAW_HIGHT;
		int x = 0;
		int y = 0;
		int yEcart = 63;
		int xEcart = 42;

		for (int j = 0; j < Cnst.ROW_COUNT; j++) {
			for (int i = 0; i < Cnst.COLUMN_COUNT; i++) {
				x = dx * i+25;
				if(i>0){
					x-=xEcart*i;
				}
				
				if (i % 2 == 0) { // col haute
					y = dy * j;
				} else {
					y = dy * j + yEcart;
				}
				y+=25;
				drawTile(c, new Rect(x,y,x+Cnst.TILE_DRAW_WIDTH, y+Cnst.TILE_DRAW_HIGHT), R.drawable.tile);
			}
		}
	}

	private void drawTile(Canvas canvas, Rect rect, int id) {
		canvas.drawBitmap(getPict(id), new Rect(0, 0, Cnst.TILE_WIDTH,
				Cnst.TILE_HIGHT), rect, null);
	}

	private Bitmap getPict(int id) {
		return BitmapFactory.decodeStream(res.openRawResource(id));
	}
}
