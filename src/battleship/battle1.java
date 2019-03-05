package battleship;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class battle1 {
	private static final String shipThere = "S";
	private static final String shipNotThere = "N";

	public static void main(String [] args){
		
		 LinkedHashMap<Integer, LinkedList<String>> board= new LinkedHashMap<>();
		 LinkedHashMap<Integer, LinkedList<String>> playBoard= new LinkedHashMap<>();

		populateBoard(board);
		populateBoard(playBoard);
		showBoard(board);
		populateShips(new Scanner(System.in), playBoard);
		//showBoard(board);
		//showBoard(playBoard);
		play(board,playBoard);
		showBoard(board);
		showBoard(playBoard);
	}

	private static void play(LinkedHashMap<Integer, LinkedList<String>> board,
			LinkedHashMap<Integer, LinkedList<String>> playBoard) {
		// TODO Auto-generated method stub
		System.out.println("You Get 5 chances to play");
		int counter = 0;
		for(int i=0;i<5;i++){
			counter+=shoot(new Scanner(System.in),board,playBoard);
			showBoard(board);
		}
		if(counter<3){
			System.out.println("YOU LOSE");
		}else{
			System.out.println("YOU WIN");
		}
	}

	private static int shoot(Scanner scanner, LinkedHashMap<Integer, LinkedList<String>> board,
			LinkedHashMap<Integer, LinkedList<String>> playBoard) {
		Integer row, column;
		System.out.println("Enter Coordinates for Hit: ");
		System.out.println("Row: ");
		row=scanner.nextInt();
		System.out.println("Column : ");
		column=scanner.nextInt();
		
		if(playBoard.get(row).get(column-1).equals(shipThere)){
			if(!board.get(row).get(column-1).equals(shipThere)){
			board.get(row).set(column-1, shipThere);
			return 1;
			}else{
				return 0;
			}
			
		}else{
			board.get(row).set(column-1, shipNotThere);
			return 0;
		}
	}

	private static void populateBoard(LinkedHashMap<Integer, LinkedList<String>> board2) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<5; i++) {
			LinkedList<String> list = new LinkedList<String>(Collections.nCopies(5, "*"));
			board2.put(i+1, list);
			}
	}

	private static void showBoard(LinkedHashMap<Integer, LinkedList<String>> board){

	// TODO Auto-generated method stub
		System.out.println("\n");
	for(int i=1;i<6; i++) {

	System.out.println(i +" "+board.get(i));
	}
	System.out.println("\n");
	}

	private static void populateShips(Scanner scanner, LinkedHashMap<Integer,  LinkedList<String>> board){

	// TODO Auto-generated method stub
	Integer row, column;
	for(int i=0; i<3; i++) {

	System.out.println("Place your ship no "+i+1+"");
	System.out.println("Row : ");
	row=scanner.nextInt();
	System.out.println("Column : ");
	column=scanner.nextInt();
	board.get(row).set(column-1, shipThere);
	}
	}
	


}

