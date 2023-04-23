package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	public static void main(String[] args) {
		
		var input = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			try {
				
				UI.clearScreen();
				UI.printMatch(chessMatch);
				
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(input);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Tareget: ");
				ChessPosition target = UI.readChessPosition(input);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
			} catch (ChessException erro) {
				System.out.println(erro.getMessage());
				input.nextLine();
				
			} catch (InputMismatchException erro) {
				System.out.println(erro.getMessage());
				input.nextLine();
			}
		}
		
	}
}
