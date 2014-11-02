package com.skula.tikal.models;

import com.skula.tikal.constantes.Cnst;
import com.skula.tikal.enums.CardType;
import com.skula.tikal.enums.Direction;

public class Board {
	private Tile tiles[][];
	private int nPlayers;


	public Board(int nPlayers) {
		this.nPlayers = nPlayers;
		tiles = new Tile[Cnst.COLUMNS_COUNT][Cnst.ROWS_COUNT];
		tiles[0][3] = new Tile(Card.CARD_X0Y3, nPlayers);
		tiles[0][4] = new Tile(Card.CARD_X0Y4, nPlayers);
		tiles[1][3] = new Tile(Card.CARD_X1Y3, nPlayers);
		tiles[1][4] = new Tile(Card.CARD_X1Y4, nPlayers);
		
		mock();
	}
	
	private void mock(){
		// random order
		/*List<Card> cards = Card.getAllCards();
		int cpt = 0;
		for(int j=0; j<Cnst.ROWS_COUNT; j++){
			for(int i=0; i<Cnst.COLUMNS_COUNT; i++){
				if((i==0 && j==4) || (i==0 && j==3) || (i==1 && j==3) || (i==1 && j==4)){
					
					
				}else{
					tiles[i][j] = new Tile(cards.get(cpt),1); 
					cpt++;
				}
			}
		}*/
		
		//A
		tiles[0][0] = new Tile(new Card(1, CardType.TEMPLE, 1, 0, 0, 0, 2, 1, 0), 4);
		tiles[0][0].putLeader(2);
		tiles[0][0].addSpawn(3);
		tiles[0][0].addSpawn(2);
		tiles[0][0].addSpawn(1);
		tiles[0][0].settle(1);
		tiles[0][1] = new Tile(new Card(1, CardType.TREASURE, 4, 0, 0, 0, 2, 0, 1), 4);
		tiles[0][1].addSpawn(0);
		tiles[0][1].addSpawn(3);
		tiles[0][1].putLeader(3);
		tiles[0][2] = new Tile(new Card(1, CardType.JUNGLE, 0, 1, 1, 0, 1, 0, 0), 4);
		tiles[0][2].addSpawn(0);
		tiles[1][0] = new Tile(new Card(1, CardType.TEMPLE, 2, 0, 0, 0, 2, 0, 1), 4);
		tiles[1][0].putLeader(0);
		tiles[1][0].addSpawn(0);
		tiles[1][0].addSpawn(1);
		tiles[1][0].addSpawn(1);
		tiles[1][1] = new Tile(new Card(1, CardType.TREASURE, 4, 0, 1, 0, 2, 0, 0), 4);
		tiles[1][2] = new Tile(new Card(1, CardType.TEMPLE, 2, 1, 0, 0, 2, 0, 0), 4);
		tiles[1][2].putLeader(1);
		tiles[1][2].addSpawn(0);
		tiles[1][2].addSpawn(1);
		//B
		tiles[2][0] = new Tile(new Card(2, CardType.VOLCANO, 0, 0, 0, 0, 0, 0, 0), 4);
		tiles[2][1] = new Tile(new Card(2, CardType.TEMPLE, 2, 0, 1, 0, 2, 0, 0), 4);
		tiles[2][2] = new Tile(new Card(2, CardType.JUNGLE, 0, 0, 0, 0, 2, 1, 0), 4);
		tiles[2][2].addSpawn(0);
		tiles[2][2].settle(0);
		tiles[2][3] = new Tile(new Card(2, CardType.JUNGLE, 0, 0, 0, 0, 2, 0, 1), 4);
		tiles[2][4] = new Tile(new Card(2, CardType.TREASURE, 4, 0, 0, 1, 2, 0, 0), 4);
		tiles[3][0] = new Tile(new Card(2, CardType.TEMPLE, 3, 1, 0, 0, 2, 0, 0), 4);
		tiles[3][0].addSpawn(0);
		//C
		tiles[3][1] = new Tile(new Card(3, CardType.TEMPLE, 4, 0, 1, 0, 2, 0, 0), 4);
		tiles[3][2] = new Tile(new Card(3, CardType.JUNGLE, 0, 0, 0, 0, 3, 0, 0), 4);
		tiles[3][3] = new Tile(new Card(3, CardType.JUNGLE, 0, 1, 1, 0, 1, 0, 0), 4);
		tiles[3][4] = new Tile(new Card(3, CardType.TREASURE, 3, 0, 0, 0, 3, 0, 0), 4);
		tiles[4][0] = new Tile(new Card(3, CardType.TEMPLE, 3, 0, 0, 0, 3, 0, 0), 4);
		//D
		tiles[4][1] = new Tile(new Card(4, CardType.TEMPLE, 5, 0, 0, 0, 3, 0, 0), 4);
		tiles[4][2] = new Tile(new Card(4, CardType.TREASURE, 3, 0, 0, 0, 3, 0, 0), 4);
		tiles[4][3] = new Tile(new Card(4, CardType.VOLCANO, 0, 0, 0, 0, 0, 0, 0), 4);
		tiles[4][4] = new Tile(new Card(4, CardType.JUNGLE, 0, 0, 1, 0, 1, 0, 1), 4);
		tiles[5][0] = new Tile(new Card(4, CardType.TEMPLE, 5, 1, 0, 0, 2, 0, 0), 4);
		//E
		tiles[5][1] = new Tile(new Card(5, CardType.TEMPLE, 6, 0, 0, 0, 3, 0, 0), 4);
		tiles[5][2] = new Tile(new Card(5, CardType.TREASURE, 2, 0, 0, 1, 2, 0, 0), 4);
		tiles[5][3] = new Tile(new Card(5, CardType.JUNGLE, 0, 1, 0, 0, 2, 0, 0), 4);
		tiles[5][4] = new Tile(new Card(5, CardType.JUNGLE, 0, 1, 0, 0, 2, 0, 0), 4);
		tiles[6][0] = new Tile(new Card(5, CardType.TEMPLE, 5, 0, 0, 0, 3, 0, 0), 4);
		//F
		tiles[6][1] = new Tile(new Card(6, CardType.TEMPLE, 4, 0, 0, 0, 3, 0, 0), 4);
		tiles[6][2] = new Tile(new Card(6, CardType.VOLCANO, 0, 0, 0, 0, 0, 0, 0), 4);
		tiles[6][3] = new Tile(new Card(6, CardType.JUNGLE, 0, 1, 0, 0, 2, 0, 0), 4);
		tiles[6][4] = new Tile(new Card(6, CardType.TREASURE, 2, 1, 0, 0, 2, 0, 0), 4);
		tiles[7][0] = new Tile(new Card(6, CardType.TEMPLE, 4, 0, 0, 0, 2, 1, 0), 4);
		//G
		tiles[7][1] = new Tile(new Card(7, CardType.TEMPLE, 3, 0, 0, 1, 2, 0, 0), 4);
		tiles[7][2] = new Tile(new Card(7, CardType.JUNGLE, 0, 1, 0, 0, 2, 0, 0), 4);
		tiles[7][3] = new Tile(new Card(7, CardType.TEMPLE, 3, 0, 0, 0, 2, 0, 1), 4);
		tiles[7][4] = new Tile(new Card(7, CardType.TREASURE, 2, 0, 0, 0, 3, 0, 0), 4);
	}

	// a faire et a tester
	public boolean isReachable(int xSrc, int ySrc, int xDest, int yDest) {
		if(tiles[xDest][yDest]==null){
			return false;
		}
		
		Direction dir = Direction.getAdjacent(xSrc, ySrc, xDest, yDest);
		if(dir.equals(Direction.NULL)){
			return false;
		}
		
		if(tiles[xDest][yDest].isVolcano()){
			return false;
		}
		
		return getStonesCount(dir, xSrc, ySrc, xDest, yDest) > 0;
	}

	public boolean isPositionable(Card c, int x, int y) {
		if (getTile(x, y) != null) {
			return false;
		}

		Tile adj = null;
		// N
		adj = getTile(x, y - 1);
		if (adj != null) {
			if (c.getStonesN() + adj.getStonesS() > 0) {
				return true;
			}
		}

		// S
		adj = getTile(x, y + 1);
		if (adj != null) {
			if (c.getStonesS() + adj.getStonesN() > 0) {
				return true;
			}
		}

		if (x % 2 == 0) { // haute colonne
			// NE
			adj = getTile(x + 1, y - 1);
			if (adj != null) {
				if (c.getStonesNE() + adj.getStonesSW() > 0) {
					return true;
				}
			}
			// SE
			adj = getTile(x + 1, y);
			if (adj != null) {
				if (c.getStonesSE() + adj.getStonesNW() > 0) {
					return true;
				}
			}
			// SW
			adj = getTile(x - 1, y);
			if (adj != null) {
				if (c.getStonesSW() + adj.getStonesNE() > 0) {
					return true;
				}
			}
			// NW
			adj = getTile(x - 1, y - 1);
			if (adj != null) {
				if (c.getStonesNW() + adj.getStonesSE() > 0) {
					return true;
				}
			}
		} else {
			// NE
			adj = getTile(x + 1, y);
			if (adj != null) {
				if (c.getStonesNE() + adj.getStonesSW() > 0) {
					return true;
				}
			}
			// SE
			adj = getTile(x + 1, y + 1);
			if (adj != null) {
				if (c.getStonesSE() + adj.getStonesNW() > 0) {
					return true;
				}
			}
			// SW
			adj = getTile(x - 1, y + 1);
			if (adj != null) {
				if (c.getStonesSW() + adj.getStonesNE() > 0) {
					return true;
				}
			}
			// NW
			adj = getTile(x - 1, y);
			if (adj != null) {
				if (c.getStonesNW() + adj.getStonesSE() > 0) {
					return true;
				}
			}
		}

		return false;
	}

	// ok
	public int getStonesCount(Direction dir, int xSrc, int ySrc, int xDest, int yDest) {
		switch (dir) {
		case NORTH:
			return tiles[xSrc][ySrc].getStonesN()
					+ tiles[xDest][yDest].getStonesS();
		case NORTH_EAST:
			return tiles[xSrc][ySrc].getStonesNE()
					+ tiles[xDest][yDest].getStonesSW();
		case SOUTH_EAST:
			return tiles[xSrc][ySrc].getStonesSE()
					+ tiles[xDest][yDest].getStonesNW();
		case SOUTH:
			return tiles[xSrc][ySrc].getStonesS()
					+ tiles[xDest][yDest].getStonesN();
		case SOUTH_WEST:
			return tiles[xSrc][ySrc].getStonesSW()
					+ tiles[xDest][yDest].getStonesNE();
		case NORTH_WEST:
			return tiles[xSrc][ySrc].getStonesNW()
					+ tiles[xDest][yDest].getStonesSE();
		default:
			break;
		}
		return 0;
	}
	
	public boolean canMove(int actPoints, int x, int y){
		Tile adj = null;
		Tile curr = tiles[x][y];
		// N
		adj = getTile(x, y - 1);
		if (adj != null) {
			if (curr.getStonesN() + adj.getStonesS() <= actPoints) {
				return true;
			}
		}

		// S
		adj = getTile(x, y + 1);
		if (adj != null) {
			if (curr.getStonesS() + adj.getStonesN() <= actPoints) {
				return true;
			}
		}

		if (x % 2 == 0) { // haute colonne
			// NE
			adj = getTile(x + 1, y - 1);
			if (adj != null) {
				if (curr.getStonesNE() + adj.getStonesSW() <= actPoints) {
					return true;
				}
			}
			// SE
			adj = getTile(x + 1, y);
			if (adj != null) {
				if (curr.getStonesSE() + adj.getStonesNW() <= actPoints) {
					return true;
				}
			}
			// SW
			adj = getTile(x - 1, y);
			if (adj != null) {
				if (curr.getStonesSW() + adj.getStonesNE() <= actPoints) {
					return true;
				}
			}
			// NW
			adj = getTile(x - 1, y - 1);
			if (adj != null) {
				if (curr.getStonesNW() + adj.getStonesSE() <= actPoints) {
					return true;
				}
			}
		} else {
			// NE
			adj = getTile(x + 1, y);
			if (adj != null) {
				if (curr.getStonesNE() + adj.getStonesSW() <= actPoints) {
					return true;
				}
			}
			// SE
			adj = getTile(x + 1, y + 1);
			if (adj != null) {
				if (curr.getStonesSE() + adj.getStonesNW() <= actPoints) {
					return true;
				}
			}
			// SW
			adj = getTile(x - 1, y + 1);
			if (adj != null) {
				if (curr.getStonesSW() + adj.getStonesNE() <= actPoints) {
					return true;
				}
			}
			// NW
			adj = getTile(x - 1, y);
			if (adj != null) {
				if (curr.getStonesNW() + adj.getStonesSE() <= actPoints) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean hasCamp(int playerId, int x, int y){
		if(x==0 && y==4){
			return true;
		}
		
		Tile t = getTile(x, y);
		return t.isSettled() && t.getOwnerId()==playerId;		
	}

	public Tile getTile(int i, int j) {
		if (i < 0 || i >= Cnst.COLUMNS_COUNT || j < 0 || j >= Cnst.ROWS_COUNT) {
			return null;
		}
		return tiles[i][j];
	}
	
	public Tile[][] getTiles(){
		return tiles;
	}
}
