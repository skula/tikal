package com.skula.tikal.enums;

public enum Direction {
	NORTH, NORTH_EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, NORTH_WEST, NULL;
	
	public static Direction getAdjacent(int xSrc, int ySrc, int xDest, int yDest) {
		if (xDest == xSrc && yDest == ySrc - 1) {
			return Direction.NORTH;
		}

		if (xDest == xSrc && yDest == ySrc + 1) {
			return Direction.SOUTH;
		}

		if (xSrc % 2 == 0) { // colonne haute
			if (xDest == xSrc + 1 && yDest == ySrc - 1) {
				return Direction.NORTH_EAST;
			}

			if (xDest == xSrc + 1 && yDest == ySrc) {
				return Direction.SOUTH_EAST;
			}

			if (xDest == xSrc - 1 && yDest == ySrc) {
				return Direction.SOUTH_WEST;
			}

			if (xDest == xSrc - 1 && yDest == ySrc - 1) {
				return Direction.NORTH_WEST;
			}

		} else { // colonne basse
			if (xDest == xSrc + 1 && yDest == ySrc) {
				return Direction.NORTH_EAST;
			}

			if (xDest == xSrc + 1 && yDest == ySrc + 1) {
				return Direction.SOUTH_EAST;
			}

			if (xDest == xSrc - 1 && yDest == ySrc + 1) {
				return Direction.SOUTH_WEST;
			}

			if (xDest == xSrc - 1 && yDest == ySrc) {
				return Direction.NORTH_WEST;
			}
		}

		return Direction.NULL;
	}
}
