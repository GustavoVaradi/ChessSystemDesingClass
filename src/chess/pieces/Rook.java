package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position auxPosition = new Position(0,0);
		
		// acima da peça
		auxPosition.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setRow(auxPosition.getRow() - 1);
		}
		
		if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
			
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;

		}
		
		// a baixo da peça
				auxPosition.setValues(position.getRow() + 1, position.getColumn());
				while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
					matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
					auxPosition.setRow(auxPosition.getRow() + 1);
				}

				if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {

					matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;

				}
					
		
		// a esquerda da peça
		auxPosition.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setColumn(auxPosition.getColumn() - 1);
		}

		if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {

			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;

		}
		
		// a direita da peça
		auxPosition.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setColumn(auxPosition.getColumn() + 1);
		}

		if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {

			matrix[auxPosition.getRow()][auxPosition.getColumn()] = true;

		}
				
		return matrix;
	}
	
}
