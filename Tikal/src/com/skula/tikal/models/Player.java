package com.skula.tikal.models;

import java.util.HashMap;
import java.util.Map;

public class Player {
	private int id;
	private int spawnLeft;
	private boolean leaderIn;
	private int campsLeft;
	private Map<Integer, Integer> medallions;
	private int score;
	private int templesOwned;

	public Player(int id) {
		this.id = id;
		this.score = 0;
		this.medallions = new HashMap<Integer, Integer>();
		this.spawnLeft = 10;
	}

	public void addPoints(int n) {
		score += n;
	}

	public void addMedallion(int id) {
		if (medallions.containsKey(id)) {
			medallions.put(id, medallions.get(id) + 1);
		} else {
			medallions.put(id, 1);
		}
	}
	
	public boolean hasSingleMedallion(){
		for(Integer m: medallions.keySet()){
			if(medallions.get(m)==1){
				return true;
			}
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpawnLeft() {
		return spawnLeft;
	}

	public void setSpawnLeft(int spawnLeft) {
		this.spawnLeft = spawnLeft;
	}

	public boolean isLeaderIn() {
		return leaderIn;
	}

	public void setLeaderIn(boolean leaderIn) {
		this.leaderIn = leaderIn;
	}

	public int getCampsLeft() {
		return campsLeft;
	}

	public void setCampsLeft(int campsLeft) {
		this.campsLeft = campsLeft;
	}

	public Map<Integer, Integer> getMedallions() {
		return medallions;
	}

	public void setMedallions(Map<Integer, Integer> medallions) {
		this.medallions = medallions;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTemplesOwned() {
		return templesOwned;
	}

	public void setTemplesOwned(int templesOwned) {
		this.templesOwned = templesOwned;
	}
}
