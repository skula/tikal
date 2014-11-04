package com.skula.tikal.constantes;

import java.util.HashMap;
import java.util.Map;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.skula.tikal.R;

public class PictureLibrary{
	private Map<Integer, Bitmap> map;
	
	public PictureLibrary(Resources res){
		this.map = new HashMap<Integer, Bitmap>();
		this.map.put(R.drawable.actionaddcard, 		BitmapFactory.decodeResource(res, R.drawable.actionaddcard));
		this.map.put(R.drawable.actionaddspawn, 	BitmapFactory.decodeResource(res, R.drawable.actionaddspawn));
		this.map.put(R.drawable.actioncamp, 		BitmapFactory.decodeResource(res, R.drawable.actioncamp));
		this.map.put(R.drawable.actiondig, 			BitmapFactory.decodeResource(res, R.drawable.actiondig));
		this.map.put(R.drawable.actionmovespawn, 		BitmapFactory.decodeResource(res, R.drawable.actionmovespawn));
		this.map.put(R.drawable.actionmoveleader, 		BitmapFactory.decodeResource(res, R.drawable.actionmoveleader));
		this.map.put(R.drawable.actionswapmed, 		BitmapFactory.decodeResource(res, R.drawable.actionswapmed));
		this.map.put(R.drawable.actiontaketemple,	BitmapFactory.decodeResource(res, R.drawable.actiontaketemple));
		this.map.put(R.drawable.actionturnleft, 	BitmapFactory.decodeResource(res, R.drawable.actionturnleft));
		this.map.put(R.drawable.actionturnright,	BitmapFactory.decodeResource(res, R.drawable.actionturnright));
		this.map.put(R.drawable.actionupgrade, 		BitmapFactory.decodeResource(res, R.drawable.actionupgrade));
		this.map.put(R.drawable.background, 		BitmapFactory.decodeResource(res, R.drawable.background));
		this.map.put(R.drawable.mostpopp1, 			BitmapFactory.decodeResource(res, R.drawable.mostpopp1));
		this.map.put(R.drawable.mostpopp2, 			BitmapFactory.decodeResource(res, R.drawable.mostpopp2));
		this.map.put(R.drawable.mostpopp3, 			BitmapFactory.decodeResource(res, R.drawable.mostpopp3));
		this.map.put(R.drawable.mostpopp4, 			BitmapFactory.decodeResource(res, R.drawable.mostpopp4));
		this.map.put(R.drawable.scorep1, 				BitmapFactory.decodeResource(res, R.drawable.scorep1));
		this.map.put(R.drawable.scorep2, 				BitmapFactory.decodeResource(res, R.drawable.scorep2));
		this.map.put(R.drawable.scorep3, 				BitmapFactory.decodeResource(res, R.drawable.scorep3));
		this.map.put(R.drawable.scorep4, 				BitmapFactory.decodeResource(res, R.drawable.scorep4));
		this.map.put(R.drawable.spawnsp1, 			BitmapFactory.decodeResource(res, R.drawable.spawnsp1));
		this.map.put(R.drawable.spawnsp2, 			BitmapFactory.decodeResource(res, R.drawable.spawnsp2));
		this.map.put(R.drawable.spawnsp3, 			BitmapFactory.decodeResource(res, R.drawable.spawnsp3));
		this.map.put(R.drawable.spawnsp4, 			BitmapFactory.decodeResource(res, R.drawable.spawnsp4));
		this.map.put(R.drawable.stones1n, 			BitmapFactory.decodeResource(res, R.drawable.stones1n));
		this.map.put(R.drawable.stones1ne, 			BitmapFactory.decodeResource(res, R.drawable.stones1ne));
		this.map.put(R.drawable.stones1nw, 			BitmapFactory.decodeResource(res, R.drawable.stones1nw));
		this.map.put(R.drawable.stones1s, 			BitmapFactory.decodeResource(res, R.drawable.stones1s));
		this.map.put(R.drawable.stones1se, 			BitmapFactory.decodeResource(res, R.drawable.stones1se));
		this.map.put(R.drawable.stones1sw, 			BitmapFactory.decodeResource(res, R.drawable.stones1sw));
		this.map.put(R.drawable.stones2n, 			BitmapFactory.decodeResource(res, R.drawable.stones2n));
		this.map.put(R.drawable.stones2ne, 			BitmapFactory.decodeResource(res, R.drawable.stones2ne));
		this.map.put(R.drawable.stones2nw, 			BitmapFactory.decodeResource(res, R.drawable.stones2nw));
		this.map.put(R.drawable.stones2s, 			BitmapFactory.decodeResource(res, R.drawable.stones2s));
		this.map.put(R.drawable.stones2se, 			BitmapFactory.decodeResource(res, R.drawable.stones2se));
		this.map.put(R.drawable.stones2sw, 			BitmapFactory.decodeResource(res, R.drawable.stones2sw));
		this.map.put(R.drawable.stones3n, 			BitmapFactory.decodeResource(res, R.drawable.stones3n));
		this.map.put(R.drawable.stones3ne, 			BitmapFactory.decodeResource(res, R.drawable.stones3ne));
		this.map.put(R.drawable.stones3nw, 			BitmapFactory.decodeResource(res, R.drawable.stones3nw));
		this.map.put(R.drawable.stones3s, 			BitmapFactory.decodeResource(res, R.drawable.stones3s));
		this.map.put(R.drawable.stones3se, 			BitmapFactory.decodeResource(res, R.drawable.stones3se));
		this.map.put(R.drawable.stones3sw, 			BitmapFactory.decodeResource(res, R.drawable.stones3sw));
		this.map.put(R.drawable.temple1, 			BitmapFactory.decodeResource(res, R.drawable.temple1));
		this.map.put(R.drawable.temple10, 			BitmapFactory.decodeResource(res, R.drawable.temple10));
		this.map.put(R.drawable.temple2, 			BitmapFactory.decodeResource(res, R.drawable.temple2));
		this.map.put(R.drawable.temple3, 			BitmapFactory.decodeResource(res, R.drawable.temple3));
		this.map.put(R.drawable.temple4, 			BitmapFactory.decodeResource(res, R.drawable.temple4));
		this.map.put(R.drawable.temple5, 			BitmapFactory.decodeResource(res, R.drawable.temple5));
		this.map.put(R.drawable.temple6, 			BitmapFactory.decodeResource(res, R.drawable.temple6));
		this.map.put(R.drawable.temple7, 			BitmapFactory.decodeResource(res, R.drawable.temple7));
		this.map.put(R.drawable.temple8, 			BitmapFactory.decodeResource(res, R.drawable.temple8));
		this.map.put(R.drawable.temple9, 			BitmapFactory.decodeResource(res, R.drawable.temple9));
		this.map.put(R.drawable.templeownerl1, 		BitmapFactory.decodeResource(res, R.drawable.templeownerl1));
		this.map.put(R.drawable.templeownerl10, 	BitmapFactory.decodeResource(res, R.drawable.templeownerl10));
		this.map.put(R.drawable.templeownerl2, 		BitmapFactory.decodeResource(res, R.drawable.templeownerl2));
		this.map.put(R.drawable.templeownerl3, 		BitmapFactory.decodeResource(res, R.drawable.templeownerl3));
		this.map.put(R.drawable.templeownerl4, 		BitmapFactory.decodeResource(res, R.drawable.templeownerl4));
		this.map.put(R.drawable.templeownerl5, 		BitmapFactory.decodeResource(res, R.drawable.templeownerl5));
		this.map.put(R.drawable.templeownerl6, 		BitmapFactory.decodeResource(res, R.drawable.templeownerl6));
		this.map.put(R.drawable.templeownerl7, 		BitmapFactory.decodeResource(res, R.drawable.templeownerl7));
		this.map.put(R.drawable.templeownerl8, 		BitmapFactory.decodeResource(res, R.drawable.templeownerl8));
		this.map.put(R.drawable.templeownerl9, 		BitmapFactory.decodeResource(res, R.drawable.templeownerl9));
		this.map.put(R.drawable.templeownerp1, 		BitmapFactory.decodeResource(res, R.drawable.templeownerp1));
		this.map.put(R.drawable.templeownerp2, 		BitmapFactory.decodeResource(res, R.drawable.templeownerp2));
		this.map.put(R.drawable.templeownerp3, 		BitmapFactory.decodeResource(res, R.drawable.templeownerp3));
		this.map.put(R.drawable.templeownerp4, 		BitmapFactory.decodeResource(res, R.drawable.templeownerp4));
		this.map.put(R.drawable.tile, 				BitmapFactory.decodeResource(res, R.drawable.tile));
		this.map.put(R.drawable.volcano, 			BitmapFactory.decodeResource(res, R.drawable.volcano));
		this.map.put(R.drawable.tresor1, 			BitmapFactory.decodeResource(res, R.drawable.tresor1));
		this.map.put(R.drawable.tresor2, 			BitmapFactory.decodeResource(res, R.drawable.tresor2));
		this.map.put(R.drawable.tresor3, 			BitmapFactory.decodeResource(res, R.drawable.tresor3));
		this.map.put(R.drawable.tresor4, 			BitmapFactory.decodeResource(res, R.drawable.tresor4));
		this.map.put(R.drawable.leaderp1, 			BitmapFactory.decodeResource(res, R.drawable.leaderp1));
		this.map.put(R.drawable.leaderp2, 			BitmapFactory.decodeResource(res, R.drawable.leaderp2));
		this.map.put(R.drawable.leaderp3, 			BitmapFactory.decodeResource(res, R.drawable.leaderp3));
		this.map.put(R.drawable.leaderp4, 			BitmapFactory.decodeResource(res, R.drawable.leaderp4));
		this.map.put(R.drawable.leaderlogo, 			BitmapFactory.decodeResource(res, R.drawable.leaderlogo));
		this.map.put(R.drawable.campp1, 			BitmapFactory.decodeResource(res, R.drawable.campp1));
		this.map.put(R.drawable.campp2, 			BitmapFactory.decodeResource(res, R.drawable.campp2));
		this.map.put(R.drawable.campp3, 			BitmapFactory.decodeResource(res, R.drawable.campp3));
		this.map.put(R.drawable.campp4, 			BitmapFactory.decodeResource(res, R.drawable.campp4));
		this.map.put(R.drawable.volcanologo, 		BitmapFactory.decodeResource(res, R.drawable.volcanologo));
	}
		
	public Bitmap get(int id){
		return map.get(id);
	}	
}
