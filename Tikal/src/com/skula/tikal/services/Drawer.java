package com.skula.tikal.services;

import java.util.List;
import java.util.Map;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

import com.skula.tikal.R;
import com.skula.tikal.constantes.Cnst;
import com.skula.tikal.constantes.PictureLibrary;
import com.skula.tikal.models.Player;
import com.skula.tikal.models.Tile;

public class Drawer {
	private Paint paint;
	private Resources res;
	private GameEngine engine;
	private PictureLibrary lib;
	private String message;

	public Drawer(Resources res, GameEngine engine) {
		this.res = res;
		this.paint = new Paint();
		this.engine = engine;
		this.lib = new PictureLibrary(res);
		this.message = "";
	}

	public void draw(Canvas c) {
		/** carte **/
		// arriere plan
		drawBackground(c);
		
		//tuiles
		drawTiles(c, engine.getBoard().getTiles());
		//drawGrid(c);
		drawSpawnsAndLeaders(c, engine.getBoard().getTiles());

		/** panneau de droite **/
		// points d'action
		drawPA(c, engine.getActpntLeft());

		// actions
		drawActions(c, engine.getActions());
		
		// scores + etat des joueurs
		drawScores(c, engine.getPlayers());
		
		// message
		paint.setColor(Color.RED);
		paint.setTextSize(40f);
		if(engine.isSrcSelected()){
			c.drawText(message, 180, 70, paint);
		}
	}
	
	private void drawPA(Canvas c, int n){
		paint.setColor(Color.BLACK);
		paint.setTextSize(35f);
		c.drawText(n + " PA", 1100, 330, paint);
	}
	
	private void drawScores(Canvas c, Player[] players){
		int x = 1080;
		int y = 5;
		int dy = 70;
		int xsize = 190;
		int ysize = 60;
		int i = 0;
		int id = 0;
		for (Player p : players) {
			switch(p.getId()){
			case 0:
				id = R.drawable.scorep1;
				break;
			case 1:
				id = R.drawable.scorep2;
				break;
			case 2:
				id = R.drawable.scorep3;
				break;
			case 3:
				id = R.drawable.scorep4;
				break;
			default:
				break;
			
			}
			drawScore(c, id, new Rect(x, y + i * dy, x + xsize, y + i * dy + ysize));
			
			paint.setColor(Color.YELLOW);
			paint.setTextSize(25f);
			// paint.setStrokeWidth(5);
			c.drawText("1000", x + 40, y + i * dy + 27, paint);
			c.drawText("9", x + 40, y + i * dy + 52, paint);
			c.drawBitmap(lib.get(R.drawable.leaderlogo), new Rect(0, 0, 48, 48), new Rect(x + 130, y + 7 + i * dy,
					x + 130 + 48, y + 7 + i * dy + 48), null);
			//c.drawText("^", x + 130, y + i * dy + 60, paint);
			i++;
		}
	}
	
	private void drawActions(Canvas c, List<Integer> actions){
		int x = 1180;
		int dy = 95;
		int size = 80;
		int y = 360;
		int id = 0;
		paint.setColor(Color.BLUE);
		
		for(int cpt=0; cpt<actions.size(); cpt++){
			if(cpt%2==0){
				x = 1085;
			}else{
				x = 1180;
			}
			
			switch(actions.get(cpt)){
			case Cnst.ACTION_ADD_LEADER:
				id=0;
				break;
			case Cnst.ACTION_ADD_SPAWN:
				id = R.drawable.actionaddspawn;
				break;
			case Cnst.ACTION_MOVE_LEADER:
				id = R.drawable.actionmoveleader;
				break;
			case Cnst.ACTION_MOVE_SPAWN:
				id = R.drawable.actionmovespawn;
				break;
			case Cnst.ACTION_DIG:
				id = R.drawable.actiondig;
				break;
			case Cnst.ACTION_CLEAN_TEMPLE:
				id = R.drawable.actionupgrade;
				break;
			case Cnst.ACTION_BUILD_CAMP:
				id = R.drawable.actioncamp;
				break;
			case Cnst.ACTION_OWN_TEMPLE:
				id = R.drawable.actiontaketemple;
				break;
			case Cnst.ACTION_SWAP_MEDALLIONS:
				id = R.drawable.actionswapmed;
				break;
			case Cnst.ACTION_PUT_CARD:
				id = R.drawable.actionaddcard;
				break;
			case Cnst.ACTION_TURN_LEFT:
				id = R.drawable.actionturnleft;
				break;
			case Cnst.ACTION_TURN_RIGHT:
				id = R.drawable.actionturnright;
				break;
			case Cnst.ACTION_CHANGE_CAMP_SPAWN:
				id = 0;
				break;
			case Cnst.ACTION_CHANGE_CAMP_LEADER:
				id = 0;
				break;
			default:
				id = 0;
				break;
			}
			if(id!=0){
				drawAction(c, id,  new Rect(x, y + cpt/2 * dy, x + size, y + cpt/2 * dy + size));
			}
		}
	}
	
	private void drawGrid(Canvas c) {
		paint.setStyle(Paint.Style.STROKE);
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
				c.drawRect(r, paint);
			}
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
	
	private void drawSpawnsAndLeaders(Canvas c, Tile[][] tiles) {
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
					// leader
					drawLeaders(c, tiles[i][j].getLeaders(), x, y);
					// pions
					drawSpawns(c, tiles[i][j].getSpawns(), x, y);
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
			c.drawBitmap(lib.get(R.drawable.tile), new Rect(0, 0,
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
			// proprietaire
			if (t.isSettled()) {
				drawTempleOwner(c, t.getOwnerId(), t.getLevel(), x, y);
			} else {
				drawTemple(c, t.getLevel(), x, y);
				drawMostPop(c, t.getDominant(), x, y);
			}
		} else if (t.isTreasure()) {
			// tresors
			drawTresor(c, t.getLevel(), x, y);
		}

		// camp

		

	}

	private void drawSpawns(Canvas c, Map<Integer, Integer> spawns, int x, int y) {
		int x1 = 0;
		int y1 = 0;
		int id = 0;
		for (int key : spawns.keySet()) {
			int nb = spawns.get(key);
			if (nb > 0) {
				switch (key) {
				case 0:
					x1 = x + 36;
					y1 = y + 1;
					id = R.drawable.spawnsp1;
					break;
				case 1:
					x1 = x + 100;
					y1 = y + 1;
					id = R.drawable.spawnsp2;
					break;
				case 2:
					x1 = x + 36;
					y1 = y + 92;
					id = R.drawable.spawnsp3;
					break;
				case 3:
					x1 = x + 100;
					y1 = y + 92;
					id = R.drawable.spawnsp4;
					break;
				default:
					break;
				}
				c.drawBitmap(lib.get(id), new Rect(0, 0, 32, 32), new Rect(x1,
						y1, x1 + 32, y1 + 32), null);
				if(nb<10){
					x1 += 10;			
				}else{
					x1 += 5;
				}
				y1 += 23;
				paint.setTextSize(20f);
				paint.setStyle(Style.FILL);
				paint.setColor(Color.YELLOW);
				c.drawText(nb + "", x1, y1, paint);
			}
		}
	}
	
	private void drawLeaders(Canvas c, List<Integer> leaders, int x, int y) {
		int x1 = 0;
		int y1 = 0;
		int id = 0;
		for (int leader : leaders) {
			switch (leader) {
			case 0:
				x1 = x + 27;
				y1 = y - 7;
				id = R.drawable.leaderp1;
				break;
			case 1:
				x1 = x + 91;
				y1 = y - 7;
				id = R.drawable.leaderp2;
				break;
			case 2:
				x1 = x + 27;
				y1 = y + 84;
				id = R.drawable.leaderp3;
				break;
			case 3:
				x1 = x + 91;
				y1 = y + 84;
				id = R.drawable.leaderp4;
				break;
			default:
				break;
			}
			c.drawBitmap(lib.get(id), new Rect(0, 0, 48, 48), new Rect(x1,
					y1, x1 + 48, y1 + 48), null);
			
			y1 += 23;
		}
	}

	private void drawTempleOwner(Canvas c, int id, int level, int x, int y) {
		x += 49;
		y += 28;
		int img = 0;
		switch (id) {
		case 0:
			img = R.drawable.templeownerp1;
			break;
		case 1:
			img = R.drawable.templeownerp2;
			break;
		case 2:
			img = R.drawable.templeownerp3;
			break;
		case 3:
			img = R.drawable.templeownerp4;
			break;
		default:
			break;
		}

		c.drawBitmap(lib.get(img), new Rect(0, 0, 68, 68), new Rect(x, y,
				x + 68, y + 68), null);

		switch (level) {
		case 1:
			img = R.drawable.templeownerl1;
			break;
		case 2:
			img = R.drawable.templeownerl2;
			break;
		case 3:
			img = R.drawable.templeownerl3;
			break;
		case 4:
			img = R.drawable.templeownerl4;
			break;
		case 5:
			img = R.drawable.templeownerl5;
			break;
		case 6:
			img = R.drawable.templeownerl6;
			break;
		case 7:
			img = R.drawable.templeownerl7;
			break;
		case 8:
			img = R.drawable.templeownerl8;
			break;
		case 9:
			img = R.drawable.templeownerl9;
			break;
		case 10:
			img = R.drawable.templeownerl10;
			break;
		default:
			return;
		}

		c.drawBitmap(lib.get(img), new Rect(0, 0, 68, 68), new Rect(x, y,
				x + 68, y + 68), null);
	}

	private void drawMostPop(Canvas c, int id, int x, int y) {
		if (id == -1) {
			return;
		}

		x += 52;
		y += 30;
		int img = 0;
		switch (id) {
		case 0:
			img = R.drawable.mostpopp1;
			break;
		case 1:
			img = R.drawable.mostpopp2;
			break;
		case 2:
			img = R.drawable.mostpopp3;
			break;
		case 3:
			img = R.drawable.mostpopp4;
			break;
		default:
			break;

		}
		
		c.drawBitmap(lib.get(img), new Rect(0, 0, 62, 62), new Rect(x, y,
				x + 62, y + 62), null);
	}

	private void drawStonesN(Canvas c, Tile t, int x, int y) {
		// N
		x += 68;
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
		c.drawBitmap(lib.get(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);
	}

	private void drawStonesNE(Canvas c, Tile t, int x, int y) {
		x += 115;
		y += 24;
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
		c.drawBitmap(lib.get(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);

	}

	private void drawStonesSE(Canvas c, Tile t, int x, int y) {
		x += 115;
		y += 69;
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
		c.drawBitmap(lib.get(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);

	}

	private void drawStonesS(Canvas c, Tile t, int x, int y) {
		x += 68;
		y += 93;
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
		c.drawBitmap(lib.get(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);

	}

	private void drawStonesSW(Canvas c, Tile t, int x, int y) {
		x += 20;
		y += 70;
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
		c.drawBitmap(lib.get(id), new Rect(0, 0, Cnst.STONES_SIZE,
				Cnst.STONES_SIZE), new Rect(x, y, x + Cnst.STONES_SIZE, y
				+ Cnst.STONES_SIZE), null);

	}

	private void drawStonesNW(Canvas c, Tile t, int x, int y) {
		x += 19;
		y += 23;
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

		c.drawBitmap(lib.get(id), new Rect(0, 0, Cnst.STONES_SIZE,
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
		c.drawBitmap(lib.get(id), new Rect(0, 0, Cnst.TEMPLE_SIZE,
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
		c.drawBitmap(lib.get(id), new Rect(0, 0, Cnst.TRESOR_SIZE,
				Cnst.TRESOR_SIZE), new Rect(x, y, x + Cnst.TRESOR_SIZE, y
				+ Cnst.TRESOR_SIZE), null);
	}

	private void drawBackground(Canvas canvas) {
		canvas.drawBitmap(lib.get(R.drawable.background), new Rect(0, 0, 1280,
				736), new Rect(0, 0, 1280, 736), null);
	}

	private void drawTreasor(Canvas canvas, Rect rect, int id) {
		canvas.drawBitmap(lib.get(id), new Rect(0, 0, 80, 80), rect, null);
	}

	private void drawAction(Canvas canvas, int id, Rect rect) {
		canvas.drawBitmap(lib.get(id), new Rect(0, 0, 80, 80),
				rect, null);
	}

	private void drawScore(Canvas canvas, int id, Rect rect) {
		canvas.drawBitmap(lib.get(id), new Rect(0, 0, 190, 60),
				rect, null);
	}
	
	/*private void drawBackground(Canvas canvas) {
		canvas.drawBitmap(getPict(R.drawable.background), new Rect(0, 0, 1280,
				736), new Rect(0, 0, 1280, 736), null);
	}

	private void drawTreasor(Canvas canvas, Rect rect, int id) {
		canvas.drawBitmap(getPict(id), new Rect(0, 0, 80, 80), rect, null);
	}

	private void drawAction(Canvas canvas, int id, Rect rect) {
		canvas.drawBitmap(getPict(id), new Rect(0, 0, 80, 80),
				rect, null);
	}

	private void drawScore(Canvas canvas, int id, Rect rect) {
		canvas.drawBitmap(getPict(id), new Rect(0, 0, 190, 60),
				rect, null);
	}*/

	private Bitmap getPict(int id) {
		return BitmapFactory.decodeStream(res.openRawResource(id));
	}
	
	public void setMessage(String message){
		this.message=message;
	}
	
}
