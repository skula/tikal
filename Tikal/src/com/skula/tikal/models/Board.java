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
		tiles[0][0] = new Tile(new Card(1, CardType.TREASURE, 1, 1, 1, 1, 1, 1, 1), nPlayers);

		tiles[0][1] = new Tile(new Card(1, CardType.TREASURE, 2, 2, 1, 1, 1, 1, 1), nPlayers);
		tiles[0][2] = new Tile(new Card(1, CardType.TREASURE, 3, 3, 1, 1, 1, 1, 1), nPlayers);

		tiles[1][0] = new Tile(new Card(1, CardType.TREASURE, 4, 1, 1, 1, 1, 1, 1), nPlayers);
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
