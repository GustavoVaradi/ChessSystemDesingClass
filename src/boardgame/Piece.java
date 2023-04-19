package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		// não precisa definir position = null, por padrão java ja faz isso
		position = null;
	}
	
	protected Board getBoard() {
		return board;
	}
	
	
}
