package com.skula.tikal.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.skula.tikal.constantes.Cnst;
import com.skula.tikal.models.Board;
import com.skula.tikal.models.Card;
import com.skula.tikal.models.Player;
import com.skula.tikal.models.Tile;

public class GameEngine {
	private int nPlayers;
	private List<Card> cards;
	private List<Integer> medallions;
	private Player[] players;
	private Board board;
	private List<Integer> actions;
	private int actionChoice;
	private int token;
	private int actpntLeft;

	private int xSrc;
	private int ySrc;
	private int xDest;
	private int yDest;

	public GameEngine(int nPlayers) {
		this.nPlayers = nPlayers;
		this.players = new Player[nPlayers];
		for (int i = 0; i < nPlayers; i++) {
			players[i] = new Player(i);
		}

		this.board = new Board(nPlayers);
		cards = Card.getAllCards();

		this.medallions = new ArrayList<Integer>();
		shuffleMedallions();

		this.actions = new ArrayList<Integer>();
		this.xSrc = -1;
		this.ySrc = -1;
		this.xDest = -1;
		this.yDest = -1;

		this.token = 0;
		this.actpntLeft = 10;
		
		mock();
	}
	
	private void mock(){
		actions.add(0);
		actions.add(2);
		actions.add(4);
		actions.add(5);
		actions.add(6);
		actions.add(7);

		actions.add(9);
		actions.add(10);
		players[0].setScore(999);
	}

	public void nextPlayer() {
		if (token == nPlayers - 1) {
			token = 0;
		} else {
			token++;
		}
	}

	public void tally(int playerId) {
		for (int j = 0; j < Cnst.ROWS_COUNT; j++) {
			for (int i = 0; i < Cnst.COLUMNS_COUNT; i++) {
				Tile t = board.getTile(i, j);
				if (t != null) {
					if (t.isTemple() && t.getDominant() == playerId) {
						players[playerId].addPoints(t.getLevel());
					}
				}
			}
		}

		Map<Integer, Integer> medallions = players[playerId].getMedallions();
		for (Integer type : medallions.keySet()) {
			switch (medallions.get(type)) {
			case 1:
				players[playerId].addPoints(Cnst.MEDALLION_SINGLE_POINTS);
				break;
			case 2:
				players[playerId].addPoints(Cnst.MEDALLION_DOUBLE_POINTS);
				break;
			case 3:
				players[playerId].addPoints(Cnst.MEDALLION_TRIPLE_POINTS);
				break;
			default:
				break;
			}
		}
	}

	public void settleTemple(int x, int y, int playerId) {
		board.getTile(x, y).removeSpawn(playerId);
		board.getTile(x, y).settle(playerId);
	}

	public void settleCamp(int x, int y, int playerId) {
		board.getTile(x, y).settle(playerId);
	}

	private void shuffleMedallions() {
		for (int i = 0; i < Cnst.MEDALLION_TYPE_COUNT; i++) {
			medallions.add(i);
			medallions.add(i);
			medallions.add(i);
		}
		Collections.shuffle(medallions);
	}

	public List<Integer> pickMedallions(int n) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			res.add(medallions.remove(i));
		}
		return res;
	}
	
	public void handleClick() {
		if(isDestSelected()){
			actions.clear();
		}else{
			if(isSrcSelected()){
				actions.clear();
				setActions(token, xSrc, ySrc);
			}else{
				actions.clear();
			}
		}
	}

	public void setActions(int playerId, int x, int y) {
		Tile t = board.getTile(x, y);
		// ajouter pions et chef
		if (actpntLeft >= Cnst.ACTION_ADD_SPAWN_POINTS && players[playerId].getSpawnLeft()>0
				&& (board.hasCamp(playerId, x, y) || x==0 && y==4)) {
			// ajouter pions
			if (players[playerId].getSpawnLeft() > 0) {
				actions.add(Cnst.ACTION_ADD_SPAWN);
			}

			// ajouter chef
			if (!players[playerId].isLeaderIn()) {
				actions.add(Cnst.ACTION_ADD_LEADER);
			}
		}
		

		// deplacer pion vers un autre camp

		// deplacer chef vers un autre camp

		// deplacer pion
		if (t.hasSpawn(playerId) && board.canMove(actpntLeft, x, y)) {
			actions.add(Cnst.ACTION_MOVE_SPAWN);
		}

		// deplacer chef
		if (t.hasLeader(playerId) && board.canMove(actpntLeft, x, y)) {
			actions.add(Cnst.ACTION_MOVE_LEADER);
		}

		// degager temple
		if (actpntLeft >= Cnst.ACTION_CLEAN_TEMPLE_POINTS && t.isTemple()
				&& !t.isSettled()
				&& (t.hasSpawn(playerId) || t.hasLeader(playerId))) {
			actions.add(Cnst.ACTION_CLEAN_TEMPLE);
		}

		// creuser
		if (t.hasSpawn(playerId) && actpntLeft >= Cnst.ACTION_DIG_POINTS && t.isTreasure()) {
			actions.add(Cnst.ACTION_DIG);
		}

		// posseder temple
		if (actpntLeft >= Cnst.ACTION_OWN_TEMPLE_POINTS && t.isTemple()
				&& !t.isSettled() && t.getDominant() == playerId) {
			actions.add(Cnst.ACTION_OWN_TEMPLE);
		}

		// construire camp
		if (t.hasSpawn(playerId) && actpntLeft >= Cnst.ACTION_BUILD_CAMP_POINTS && t.isJungle()
				&& !t.isSettled()) {
			actions.add(Cnst.ACTION_BUILD_CAMP);
		}

		// echanger medaillons
		if (actpntLeft >= Cnst.ACTION_SWAP_MEDALLIONS_POINTS
				&& players[playerId].hasSingleMedallion()) {
			actions.add(Cnst.ACTION_SWAP_MEDALLIONS);
		}
	}

	public void executeAction(int action) {
		// WARNING: ne pas oublier de reduire les PA !!
		switch (action) {
		case Cnst.ACTION_ADD_SPAWN:
			break;
		case Cnst.ACTION_ADD_LEADER:
			break;
		case Cnst.ACTION_MOVE_SPAWN:
			break;
		case Cnst.ACTION_MOVE_LEADER:
			break;
		case Cnst.ACTION_CLEAN_TEMPLE:
			break;
		case Cnst.ACTION_DIG:
			break;
		case Cnst.ACTION_OWN_TEMPLE:
			break;
		case Cnst.ACTION_BUILD_CAMP:
			break;
		case Cnst.ACTION_SWAP_MEDALLIONS:
			break;
		default:
			break;
		}
	}
	
	/****************************/
	public void setSrc(int x, int y){
		this.xSrc = x;
		this.ySrc = y;
	}
	
	public void setDest(int x, int y){
		this.xDest = x;
		this.yDest = y;	
	}
	
	public boolean isSrcSelected(){
		return xSrc !=-1 && ySrc != -1;
	}
	
	public boolean isDestSelected(){
		return xDest !=-1 && yDest != -1;
	}
	
	public int getXSrc(){
		return xSrc;
	}
	
	public int getYSrc(){
		return ySrc;
	}
	
	public int getXDest(){
		return xDest;
	}
	
	public int getYDest(){
		return yDest;
	}
	
	public int getnPlayers() {
		return nPlayers;
	}

	public void setnPlayers(int nPlayers) {
		this.nPlayers = nPlayers;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Integer> getMedallions() {
		return medallions;
	}

	public void setMedallions(List<Integer> medallions) {
		this.medallions = medallions;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Integer> getActions() {
		return actions;
	}

	public void setActions(List<Integer> actions) {
		this.actions = actions;
	}

	public int getActionChoice() {
		return actionChoice;
	}

	public void setActionChoice(int actionChoice) {
		this.actionChoice = actionChoice;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public int getActpntLeft() {
		return actpntLeft;
	}

	public void setActpntLeft(int actpntLeft) {
		this.actpntLeft = actpntLeft;
	}
}