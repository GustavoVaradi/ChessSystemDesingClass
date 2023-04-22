package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);

		return piece == null || piece.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {

		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position auxPosition = new Position(0, 0);


		// above
		auxPosition.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// below
		auxPosition.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// left
		auxPosition.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// right
		auxPosition.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// nw
		auxPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// ne
		auxPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// sw
		auxPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// se
		auxPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		return matrix;
	}
}
