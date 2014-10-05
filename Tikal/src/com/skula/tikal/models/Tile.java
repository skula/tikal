package com.skula.tikal.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skula.tikal.constantes.Cnst;
import com.skula.tikal.enums.CardType;

public class Tile extends Card {
	private int ownerId;
	private boolean settled;
	private List<Integer> medallions; // <medallionId>
	private Map<Integer, Integer> spawns; // <playerId, count>
	private List<Integer> leaders; // <playerId>

	public static void main(String[] args) {
		Card c = new Card(1, CardType.TEMPLE, 1, 1, 2, 3, 4, 5, 6);
		Tile t = new Tile(c, 2);
	}

	public Tile(Card card, int nPlayers) {
		super(card);
		this.settled = false;
		this.ownerId = -1;
		this.spawns = new HashMap<Integer, Integer>();
		for (int i = 0; i < nPlayers; i++) {
			spawns.put(i, 0);
		}
		this.leaders = new ArrayList<Integer>();
	}

	// ok
	public int getDominant() {
		int res = -1;
		int cpt = 0;
		int max = 0;
		for (Integer id : spawns.keySet()) {
			cpt = 0;
			if (leaders.contains(id)) {
				cpt += Cnst.LEADER_COUNT_POINT;
			}
			cpt += spawns.get(id);
			if (cpt > max) {
				max = cpt;
				res = id;
			}
		}
		return res;
	}	
	
	public boolean hasSpawn(int playerId){
		return spawns.get(playerId)>0 || leaders.contains(playerId);
	}
	
	public boolean hasLeader(int playerId){
		return leaders.contains(playerId);
	}
	
	// ok
	public void addSpawn(int playerId) {
		spawns.put(playerId, spawns.get(playerId) + 1);
	}

	public void removeSpawn(int playerId) {
		spawns.put(playerId, spawns.get(playerId) - 1);
	}
	
	public void putLeader(int playerId) {
		leaders.add(playerId);
	}

	public void removeLeader(int playerId) {
		leaders.remove(leaders.indexOf(playerId));
	}

	public void clean(){
		setLevel(getLevel()+1);
	}
	
	public int dig(){
		setLevel(getLevel()-1);
		if(getLevel()==0){
			setType(CardType.JUNGLE);
		}
		return medallions.indexOf(0);
	}
	
	public void settle(int playerId){
		ownerId = playerId;
		settled = true;
	}
	
	public boolean isTemple(){
		return getType().equals(CardType.TEMPLE);
	}
	
	public boolean isTreasure(){
		return getType().equals(CardType.TREASURE);
	}
	
	public boolean isJungle(){
		return getType().equals(CardType.JUNGLE);
	}
	
	public boolean isVolcano(){
		return getType().equals(CardType.VOLCANO);
	}
	
	public boolean canSettle(int playerId){
		switch(getType()){
		case VOLCANO:
			return false;
		case JUNGLE:
			return !settled;
		case TREASURE:
			return !settled && medallions.size()==0;
		case TEMPLE:
			return !settled && hasSpawn(playerId);
		default:
			return false;
		}
	}
	
	/***********************************/
	public List<Integer> getMedallions() {
		return medallions;
	}

	public void setMedallions(List<Integer> medallions) {
		this.medallions = medallions;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public Map<Integer, Integer> getSpawns() {
		return spawns;
	}

	public void setSpawns(Map<Integer, Integer> spawns) {
		this.spawns = spawns;
	}

	public List<Integer> getLeaders() {
		return leaders;
	}

	public void setLeaders(List<Integer> leaders) {
		this.leaders = leaders;
	}

	public boolean isSettled() {
		return settled;
	}

	public void setSettled(boolean settled) {
		this.settled = settled;
	}
}
