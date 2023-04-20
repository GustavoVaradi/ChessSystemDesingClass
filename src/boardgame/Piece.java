package boardgame;

public abstract class Piece {
	
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
	
	public abstract boolean[][] possibleMoves();
	
	// HookMethods => um método concreto depende de um método abstrato
	public boolean possibleMove(Position position) {
		
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	// HookMethods => um método concreto depende de um método abstrato
	public boolean isThereAnyPossibleMove() {
		// crio uma matriz booleana ou seja uma matriz de true or false
		boolean[][] matrix = possibleMoves();
		
		// percorre a matrix e verifica se ambos (linha e coluna) são true
		for (int i =0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
