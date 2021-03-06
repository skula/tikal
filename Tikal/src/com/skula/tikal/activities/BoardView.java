package com.skula.tikal.activities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.skula.tikal.constantes.Cnst;
import com.skula.tikal.services.Drawer;
import com.skula.tikal.services.GameEngine;

public class BoardView extends View {
	private Drawer drawer;
	private GameEngine engine;
	

	public BoardView(Context context) {
		super(context);
		this.engine = new GameEngine(4);
		this.drawer = new Drawer(context.getResources(), engine);
	}
	
	private void getTile(int mx, int my) {
		int x = Cnst.TILE_WIDTH + 25;
		int y = 0;
		int yEcart = 63;
		int xEcart = 42;
		int dx= 30;

		for (int j = 0; j < Cnst.ROWS_COUNT; j++) {
			for (int i = 0; i < Cnst.COLUMNS_COUNT; i++) {
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
				Rect  r = new Rect(x+dx, y, x-dx + Cnst.TILE_WIDTH + 1, y + Cnst.TILE_HIGHT);
				if(r.contains(mx, my)){
					engine.setSrc(i,j);
					drawer.setMessage("(" + i + ", " + j + ")");
					return;
				}
			}
		}
		drawer.setMessage("null");
		engine.setSrc(-1,-1);
	}
	
	private int getAction(int mx, int my) {	
		int x = 1180;
		int dy = 95;
		int size = 80;
		int y = 360;
		int id = 0;
		Rect r = null;
		for(int cpt=0; cpt<8; cpt++){
			if(cpt%2==0){
				x = 1085;
			}else{
				x = 1180;
			}
			
			r = new Rect(x, y + cpt/2 * dy, x + size, y + cpt/2 * dy + size);
			if(r.contains(mx,my)){
				drawer.setMessage(cpt+"");
				return cpt;
			}
		}
		
		drawer.setMessage("null");
		return -1;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:

			break;
		case MotionEvent.ACTION_MOVE:

			break;
		case MotionEvent.ACTION_UP:
			int a = getAction(x, y);
			if(a!=-1){
				
			}else{
				getTile(x, y);
				engine.handleClick();	
			}
			invalidate();
			break;
		}
		return true;
	}

	
	@Override
	public void draw(Canvas canvas) {
		drawer.draw(canvas);
	}
}
