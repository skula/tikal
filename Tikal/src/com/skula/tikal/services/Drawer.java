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
import com.skula.tikal.models.Tile;

public class Drawer {
	private Paint paint;
	private Resources res;
	private GameEngine engine;

	public Drawer(Resources res, GameEngine engine) {
		this.res = res;
		this.paint = new Paint();
		this.engine = engine;
	}

	public void draw(Canvas c) {

		/*
		 * paint.setColor(Color.RED); c.drawRect(new Rect(0,0,1280,800), paint);
		 * paint.setColor(Color.WHITE); c.drawRect(new Rect(0,0,1280,736),
		 * paint);
		 */

		drawBackground(c);
		drawTiles(c, engine.getBoard().getTiles());

		int x = 1180;
		int dy = 95;
		int y = 350;
		int size = 80;

		// points d'action
		paint.setColor(Color.BLACK);
		paint.setTextSize(35f);
		c.drawText("10 PA", 1100, 330, paint);

		// actions
		y = 360;
		paint.setColor(Color.BLUE);
		for (int i = 0; i < 4; i++) {
			// c.drawRect(new Rect(x, y+i*dy, x + size, y+i*dy + size), paint);
			drawAction(c, new Rect(x, y + i * dy, x + size, y + i * dy + size));
		}
		x = 1085;
		for (int i = 0; i < 4; i++) {
			// c.drawRect(new Rect(x, y+i*dy, x + size, y+i*dy + size), paint);
			drawAction(c, new Rect(x, y + i * dy, x + size, y + i * dy + size));
		}

		// scores + etat des joueurs
		x = 1080;
		y = 5;
		dy = 70;
		int xsize = 190;
		int ysize = 60;
		for (int i = 0; i < 4; i++) {
			paint.setColor(Color.GREEN);
			// c.drawRect(new Rect(x, y+i*dy, x + xsize, y+i*dy + ysize),
			// paint);
			drawScore(c, new Rect(x, y + i * dy, x + xsize, y + i * dy + ysize));
			paint.setColor(Color.BLACK);

			paint.setTextSize(25f);
			// paint.setStrokeWidth(5);
			c.drawText("1000 pts", x + 15, y + i * dy + 27, paint);
			c.drawText("9", x + 15, y + i * dy + 52, paint);
			paint.setTextSize(60f);
			c.drawText("^", x + 130, y + i * dy + 60, paint);
		}

	}

	private void drawTiles(Canvas c, Tile[][] tiles) {
		int x = Cnst.TILE_WIDTH + 25;
		int y = 0;
		int yEcart = 63;
		int xEcart = 42;

		for (int j = 0; j < Cnst.ROWS_COUNT; j++) {
			for (int i = 0; i < Cnst.COLUMNS_COUNT; i++) {
				if (tiles[i][j] != null) {
					x = Cnst.TILE_WIDTH * i + 25;
					if (i > 0) {
						x -= xEcart * i;
					}
					x -= 1;
					if (i % 2 == 0) { // col haute
						y = Cnst.TILE_HIGHT * j;
					} else {
						y = Cnst.TILE_HIGHT * j + yEcart;
					}
					y += 25 - 1;
					drawTile(c, tiles[i][j], x, y);
				}
			}
		}
	}

	private void drawTile(Canvas c, Tile t, int x, int y) {
		// tuile
		if (t.isVolcano()) {
			// tuile volcano
			// c.drawBitmap(getPict(R.drawable.volcano), new Rect(0, 0,
			// Cnst.TILE_WIDTH, Cnst.TILE_HIGHT),
			// new Rect(x,y,x+Cnst.TILE_DRAW_WIDTH+1, y+Cnst.TILE_DRAW_HIGHT),
			// null);
			return;
		} else {
			// tuile jungle
			c.drawBitmap(getPict(R.drawable.tile), new Rect(0, 0,
					Cnst.TILE_WIDTH, Cnst.TILE_HIGHT), new Rect(x, y, x
					+ Cnst.TILE_WIDTH + 1, y + Cnst.TILE_HIGHT), null);
		}

		// portes
		if (t.getStonesN() > 0) {
			drawStonesN(c, t, x, y);
		}
		
		if (t.getStonesNE() > 0) {
			drawStonesNE(c, t, x, y);
		}
		if (t.getStonesSE() > 0) {
			drawStonesSE(c, t, x, y);
		}
		if (t.getStonesS() > 0) {
			drawStonesS(c, t, x, y);
		}
		if (t.getStonesSW() > 0) {
			drawStonesSW(c, t, x, y);
		}
		if (t.getStonesNW() > 0) {
			drawStonesNW(c, t, x, y);
		}

		if (t.isTemple()) {
			// temples
			drawTemple(c, t.getLevel(), x, y);
			// proprietaire
		} else if (t.isTreasure()) {
			// tresors
			drawTresor(c, t.getLevel(), x, y);
		}

		// camp

		// pions

		// leader

	}

	private void drawStonesN(Canvas c, Tile t, int x, int y) {
		// N
		x+=68;
		int id = 0;
		switch (t.getStonesN()) {
		case 1:
			id = R.drawable.stones1n;
			break;
		case 2:
			id = R.drawable.stones2n;
			break;
		case 3:
			id = R.drawable.stones3n;
			break;
		default:
			break;
		}
		c.drawBitmap(getPict(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);
	}
	
	private void drawStonesNE(Canvas c, Tile t, int x, int y) {
		x+=115;
		y+=24;
		int id = 0;
		switch (t.getStonesNE()) {
		case 1:
			id = R.drawable.stones1ne;
			break;
		case 2:
			id = R.drawable.stones2ne;
			break;
		case 3:
			id = R.drawable.stones3ne;
			break;
		default:
			break;
		}
		c.drawBitmap(getPict(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);

	}

	private void drawStonesSE(Canvas c, Tile t, int x, int y) {
		x+=115;
		y+=69;
		int id = 0;
		switch (t.getStonesSE()) {
		case 1:
			id = R.drawable.stones1se;
			break;
		case 2:
			id = R.drawable.stones2se;
			break;
		case 3:
			id = R.drawable.stones3se;
			break;
		default:
			break;
		}
		c.drawBitmap(getPict(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);

	}
	
	private void drawStonesS(Canvas c, Tile t, int x, int y) {
		x+=68;
		y+=93;
		int id = 0;
		switch (t.getStonesS()) {
		case 1:
			id = R.drawable.stones1s;
			break;
		case 2:
			id = R.drawable.stones2s;
			break;
		case 3:
			id = R.drawable.stones3s;
			break;
		default:
			break;
		}
		c.drawBitmap(getPict(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);

	}
	
	private void drawStonesSW(Canvas c, Tile t, int x, int y) {
		x+=20;
		y+=70;
		int id = 0;
		switch (t.getStonesSW()) {
		case 1:
			id = R.drawable.stones1sw;
			break;
		case 2:
			id = R.drawable.stones2sw;
			break;
		case 3:
			id = R.drawable.stones3sw;
			break;
		default:
			break;
		}
		c.drawBitmap(getPict(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);

	}
	
	private void drawStonesNW(Canvas c, Tile t, int x, int y) {
		x+=19;
		y+=23;
		int id = 0;
		switch (t.getStonesNW()) {
		case 1:
			id = R.drawable.stones1nw;
			break;
		case 2:
			id = R.drawable.stones2nw;
			break;
		case 3:
			id = R.drawable.stones3nw;
			break;
		default:
			break;
		}

		c.drawBitmap(getPict(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);
	}

	private void drawTemple(Canvas c, int level, int x, int y) {
		int id = 0;
		x += 49;
		y += 28;
		switch (level) {
		case 1:
			id = R.drawable.temple1;
			break;
		case 2:
			id = R.drawable.temple2;
			break;
		case 3:
			id = R.drawable.temple3;
			break;
		case 4:
			id = R.drawable.temple4;
			break;
		case 5:
			id = R.drawable.temple5;
			break;
		case 6:
			id = R.drawable.temple6;
			break;
		case 7:
			id = R.drawable.temple7;
			break;
		case 8:
			id = R.drawable.temple8;
			break;
		case 9:
			id = R.drawable.temple9;
			break;
		case 10:
			id = R.drawable.temple10;
			break;
		default:
			return;
		}
		c.drawBitmap(getPict(id), new Rect(0, 0, Cnst.TEMPLE_SIZE,
				Cnst.TEMPLE_SIZE), new Rect(x, y, x + Cnst.TEMPLE_SIZE, y
				+ Cnst.TEMPLE_SIZE), null);
	}

	private void drawTresor(Canvas c, int level, int x, int y) {
		int id = 0;
		x += 50;
		y += 30;
		switch (level) {
		case 1:
			id = R.drawable.tresor1;
			break;
		case 2:
			id = R.drawable.tresor2;
			break;
		case 3:
			id = R.drawable.tresor3;
			break;
		case 4:
			id = R.drawable.tresor4;
			break;
		default:
			break;
		}
		c.drawBitmap(getPict(id), new Rect(0, 0, Cnst.TRESOR_SIZE,
				Cnst.TRESOR_SIZE), new Rect(x, y, x + Cnst.TRESOR_SIZE, y
				+ Cnst.TRESOR_SIZE), null);
	}

	private void drawBackground(Canvas canvas) {
		canvas.drawBitmap(getPict(R.drawable.background), new Rect(0, 0, 1280,
				736), new Rect(0, 0, 1280, 736), null);
	}

	private void drawTreasor(Canvas canvas, Rect rect, int id) {
		canvas.drawBitmap(getPict(id), new Rect(0, 0, 80, 80), rect, null);
	}

	private void drawAction(Canvas canvas, Rect rect) {
		canvas.drawBitmap(getPict(R.drawable.action), new Rect(0, 0, 80, 80),
				rect, null);
	}

	private void drawScore(Canvas canvas, Rect rect) {
		canvas.drawBitmap(getPict(R.drawable.score), new Rect(0, 0, 190, 60),
				rect, null);
	}

	private Bitmap getPict(int id) {
		return BitmapFactory.decodeStream(res.openRawResource(id));
	}
}
