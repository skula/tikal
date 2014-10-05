package com.skula.tikal.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skula.tikal.enums.CardType;
import com.skula.tikal.enums.Direction;

public class Card {
	public static Card CARD_X0Y4; // camp de depart
	public static Card CARD_X0Y3; // temple
	public static Card CARD_X1Y3; // jungle
	public static Card CARD_X1Y4; // temple

	static {
		// TODO: caracteristiques cartes fixes
		CARD_X0Y4 = new Card(0, CardType.START_CAMP,0, 	1,1,1,0,0,0);
		CARD_X0Y3 = new Card(0, CardType.TEMPLE,2, 		1,1,0,1,0,0);
		CARD_X1Y3 = new Card(0, CardType.JUNGLE,0, 		1,1,1,0,0,0);
		CARD_X1Y4 = new Card(0, CardType.TEMPLE,1, 		0,1,0,0,0,1);
	}

	private int group;
	private CardType type;
	private int level;

	private int stonesN;
	private int stonesNE;
	private int stonesSE;
	private int stonesS;
	private int stonesSW;
	private int stonesNW;

	private Direction orientation;

	public static void main(String[] args) {
		List<Card> cards = getAllCards();
		int a = cards.size();
	}

	public Card() {
	}

	public Card(Card card) {
		this.group = card.group;
		this.type = card.type;
		this.level = card.level;
		this.orientation = card.orientation;
		this.stonesNW = card.stonesNW;
		this.stonesN = card.stonesN;
		this.stonesNE = card.stonesNE;
		this.stonesSE = card.stonesSE;
		this.stonesS = card.stonesS;
		this.stonesSW = card.stonesSW;
	}

	public Card(int group, CardType type, int level, int northStones,
			int northEastStones, int southEastStones, int southStones,
			int southWestStones, int northWestStones) {
		this.group = group;
		this.type = type;
		this.level = level;

		this.orientation = Direction.NORTH;
		this.stonesNW = northWestStones;
		this.stonesN = northStones;
		this.stonesNE = northEastStones;
		this.stonesSE = southEastStones;
		this.stonesS = southStones;
		this.stonesSW = southWestStones;
	}

	public void show() {
		System.out.println(stonesNW + "  " + stonesN + "  " + stonesNE);
		if (type.equals(CardType.TEMPLE)) {
			System.out.println(" Te=" + level);
		} else if (type.equals(CardType.TREASURE)) {
			System.out.println(" Tr=" + level);
		} else if (type.equals(CardType.VOLCANO)) {
			System.out.println("O V");
		} else {
			System.out.println("");
		}
		System.out.println(stonesSW + "  " + stonesS + "  " + stonesSE);
	}

	public static List<Card> getAllCards() {
		List<Card> resA = new ArrayList<Card>();
		resA.add(new Card(1, CardType.TEMPLE, 1, 0, 0, 0, 2, 1, 0));
		resA.add(new Card(1, CardType.TREASURE, 4, 0, 0, 0, 2, 0, 1));
		resA.add(new Card(1, CardType.JUNGLE, 0, 1, 1, 0, 1, 0, 0));
		resA.add(new Card(1, CardType.TEMPLE, 2, 0, 0, 0, 2, 0, 1));
		resA.add(new Card(1, CardType.TREASURE, 4, 0, 1, 0, 2, 0, 0));
		resA.add(new Card(1, CardType.TEMPLE, 2, 1, 0, 0, 2, 0, 0));
		Collections.shuffle(resA);

		List<Card> resB = new ArrayList<Card>();
		resB.add(new Card(2, CardType.VOLCANO, 0, 0, 0, 0, 0, 0, 0));
		resB.add(new Card(2, CardType.TEMPLE, 2, 0, 1, 0, 2, 0, 0));
		resB.add(new Card(2, CardType.JUNGLE, 0, 0, 0, 0, 2, 1, 0));
		resB.add(new Card(2, CardType.JUNGLE, 0, 0, 0, 0, 2, 0, 1));
		resB.add(new Card(2, CardType.TREASURE, 4, 0, 0, 1, 2, 0, 0));
		resB.add(new Card(2, CardType.TEMPLE, 3, 1, 0, 0, 2, 0, 0));
		Collections.shuffle(resB);

		List<Card> resC = new ArrayList<Card>();
		resC.add(new Card(3, CardType.TEMPLE, 4, 0, 1, 0, 2, 0, 0));
		resC.add(new Card(3, CardType.JUNGLE, 0, 0, 0, 0, 3, 0, 0));
		resC.add(new Card(3, CardType.JUNGLE, 0, 1, 1, 0, 1, 0, 0));
		resC.add(new Card(3, CardType.TREASURE, 3, 0, 0, 0, 3, 0, 0));
		resC.add(new Card(3, CardType.TEMPLE, 3, 0, 0, 0, 3, 0, 0));
		Collections.shuffle(resC);

		List<Card> resD = new ArrayList<Card>();
		resD.add(new Card(4, CardType.TEMPLE, 5, 0, 0, 0, 3, 0, 0));
		resD.add(new Card(4, CardType.TREASURE, 3, 0, 0, 0, 3, 0, 0));
		resD.add(new Card(4, CardType.VOLCANO, 0, 0, 0, 0, 0, 0, 0));
		resD.add(new Card(4, CardType.JUNGLE, 0, 0, 1, 0, 1, 0, 1));
		resD.add(new Card(4, CardType.TEMPLE, 5, 1, 0, 0, 2, 0, 0));
		Collections.shuffle(resD);

		List<Card> resE = new ArrayList<Card>();
		resE.add(new Card(5, CardType.TEMPLE, 6, 0, 0, 0, 3, 0, 0));
		resE.add(new Card(5, CardType.TREASURE, 2, 0, 0, 1, 2, 0, 0));
		resE.add(new Card(5, CardType.JUNGLE, 0, 1, 0, 0, 2, 0, 0));
		resE.add(new Card(5, CardType.JUNGLE, 0, 1, 0, 0, 2, 0, 0));
		resE.add(new Card(5, CardType.TEMPLE, 5, 0, 0, 0, 3, 0, 0));
		Collections.shuffle(resE);

		List<Card> resF = new ArrayList<Card>();
		resF.add(new Card(6, CardType.TEMPLE, 4, 0, 0, 0, 3, 0, 0));
		resF.add(new Card(6, CardType.VOLCANO, 0, 0, 0, 0, 0, 0, 0));
		resF.add(new Card(6, CardType.JUNGLE, 0, 1, 0, 0, 2, 0, 0));
		resF.add(new Card(6, CardType.TREASURE, 2, 1, 0, 0, 2, 0, 0));
		resF.add(new Card(6, CardType.TEMPLE, 4, 0, 0, 0, 2, 1, 0));
		Collections.shuffle(resF);

		List<Card> resG = new ArrayList<Card>();
		resG.add(new Card(7, CardType.TEMPLE, 3, 0, 0, 1, 2, 0, 0));
		resG.add(new Card(7, CardType.JUNGLE, 0, 1, 0, 0, 2, 0, 0));
		resG.add(new Card(7, CardType.TEMPLE, 3, 0, 0, 0, 2, 0, 1));
		resG.add(new Card(7, CardType.TREASURE, 2, 0, 0, 0, 3, 0, 0));
		Collections.shuffle(resG);

		List<Card> res = new ArrayList<Card>();
		res.addAll(resA);
		res.addAll(resB);
		res.addAll(resC);
		res.addAll(resD);
		res.addAll(resE);
		res.addAll(resF);
		res.addAll(resG);
		return res;
	}

	public void rotateClockWise() {
		int tmp = getStonesN();
		setStonesN(getStonesNW());
		setStonesNW(getStonesSW());
		setStonesSW(getStonesS());
		setStonesS(getStonesSE());
		setStonesSE(getStonesNE());
		setStonesNE(tmp);
	}

	public void rotateAntiClockWise() {
		int tmp = getStonesN();
		setStonesN(getStonesNE());
		setStonesNE(getStonesSE());
		setStonesSE(getStonesS());
		setStonesS(getStonesSW());
		setStonesSW(getStonesNW());
		setStonesNW(tmp);
	}

	public void rotate(Direction dir) {
		switch (dir) {
		case NORTH_EAST:
			rotateClockWise();
			break;
		case SOUTH_EAST:
			rotateClockWise();
			rotateClockWise();
			break;
		case SOUTH:
			rotateClockWise();
			rotateClockWise();
			rotateClockWise();
			break;
		case SOUTH_WEST:
			rotateAntiClockWise();
			rotateAntiClockWise();
			break;
		case NORTH_WEST:
			rotateAntiClockWise();
		default:
			break;
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	public Direction getOrientation() {
		return orientation;
	}

	public void setOrientation(Direction direction) {
		this.orientation = direction;
	}

	public int getStonesNW() {
		return stonesNW;
	}

	public void setStonesNW(int stonesNW) {
		this.stonesNW = stonesNW;
	}

	public int getStonesN() {
		return stonesN;
	}

	public void setStonesN(int stonesN) {
		this.stonesN = stonesN;
	}

	public int getStonesNE() {
		return stonesNE;
	}

	public void setStonesNE(int stonesNE) {
		this.stonesNE = stonesNE;
	}

	public int getStonesSE() {
		return stonesSE;
	}

	public void setStonesSE(int stonesSE) {
		this.stonesSE = stonesSE;
	}

	public int getStonesS() {
		return stonesS;
	}

	public void setStonesS(int stonesS) {
		this.stonesS = stonesS;
	}

	public int getStonesSW() {
		return stonesSW;
	}

	public void setStonesSW(int stonesSW) {
		this.stonesSW = stonesSW;
	}
}
