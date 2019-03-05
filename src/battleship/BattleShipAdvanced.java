package battleship;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class BattleShipAdvanced {
	
	private static final String shipThere = "S";
	private static final String shipNotThere = "N";
	private static final Integer shipPoints = 10;
	private static final Integer boardSize = 6;
	//private static final Integer shipPoints = 10;
	 

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
		System.out.println("You Get 15 chances to play");
		int counter = 0;
		for(int i=0;i<15;i++){
			counter+=shoot(new Scanner(System.in),board,playBoard);
			showBoard(board);
		}
		if(counter<shipPoints){
			System.out.println("YOU LOSE");
		}else{
			System.out.println("YOU WIN");
		}
	}

	private static int shoot(Scanner scanner, LinkedHashMap<Integer, LinkedList<String>> board,
			LinkedHashMap<Integer, LinkedList<String>> playBoard) {
		Integer row, column;
		System.out.println("Enter Coordinates for Hit: ");
		System.out.print("Row: ");
		row=scanner.nextInt();
		System.out.print("Column : ");
		column=scanner.nextInt();
		if(column > board.get(1).size() || row > board.keySet().size()){
			System.out.println("HIT outside the board - lose a chance");
			return 0;
		}else{
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
	}

	private static void populateBoard(LinkedHashMap<Integer, LinkedList<String>> board2) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<boardSize; i++) {
			LinkedList<String> list = new LinkedList<String>(Collections.nCopies(boardSize, "*"));
			board2.put(i+1, list);
			}
	}

	private static void showBoard(LinkedHashMap<Integer, LinkedList<String>> board){

	// TODO Auto-generated method stub
		System.out.print("\t"+" ");
		for(int i=1;i<boardSize+1; i++) {
		System.out.print(i+"  ");
		}
		System.out.print("\n");
	for(int i=1;i<boardSize+1; i++) {

	System.out.println(i +"\t"+board.get(i));
	}
	}

	private static void populateShips(Scanner scanner, LinkedHashMap<Integer,  LinkedList<String>> board){

	// TODO Auto-generated method stub
	Integer row, column, size;
	int[] ships = {2,3,5};
	int counter = 0 ;
	do {

	//System.out.println("Place your ship no "+counter+1+"");
	System.out.println("Adding ship of size: "+ships[counter]);
	System.out.print("Row : ");
	row=scanner.nextInt();
	System.out.print("Column : ");
	column=scanner.nextInt();
	if(canShipBePlaced(row,column,ships[counter],board)){
	
	for(int j=0;j<ships[counter];j++){
		board.get(row+j).set(column-1, shipThere);
		
	}
	counter++;
	}else{
		System.out.println("Ship cannot be placed here - please try again");
	}
	//board.get(row).set(column-1, shipThere);
	
	}while(counter<3);
	}

	private static boolean canShipBePlaced(Integer row, Integer column, int shipSize, LinkedHashMap<Integer, LinkedList<String>> board) {
		// TODO Auto-generated method stub
		if(row+shipSize-1<=board.keySet().size() && column<=board.get(1).size() && !isAShipThere(row,column,shipSize,board)){
			return true;
		}
		return false;
	}

	private static boolean isAShipThere(Integer row, Integer column, int shipSize,
			LinkedHashMap<Integer, LinkedList<String>> board) {
		// TODO Auto-generated method stub
		for(int i=row;i<row+shipSize;i++){
			if(board.get(i).get(column-1).equals(shipThere)){
				return true;
			}
				
		}
		return false;
	}
	




}
