package sjakk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SpringerProblem {
	
	static int N;
	static int[][] board;
	static int[] x_move = {2,1,-1,-2,-2,-1,1,2};
	static int[] y_move = {1,2,2,1,-1,-2,-2,-1};
	static int move_number = 1;
	static int start_x;
	static int start_y;
	
	static boolean isSafe(int x, int y, int board[][]){
		return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
	}
	
	static void printProblem(int board[][]){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				//System.out.print(Arrays.toString(board[i]) + " fra " + Arrays.toString(board[j]) + " fra " + Arrays.toString(board[i]) + " til " + Arrays.toString(board[j]) + " til ");
				System.out.print(board[i][j] + " ");		
			}
			System.out.println();
		}
	}
	
	static boolean Solve(){
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				board[i][j] = -1;
			}
		}
		
		board[start_x][start_y] = 0;
		
		if(!SolveProblem(start_x, start_y, move_number, board, x_move, y_move)){
			System.out.println("Det finnes ingen løsning");
			return false;
		}
		else{
			printProblem(board);
		}
		return true;
			
	}
	
	static boolean SolveProblem(int start_x, int start_y, int move_number, int board[][], int x_move[], int y_move[]){
		int next_x, next_y;
		
		if(move_number == N*N){
			return true;
		}
		
		for(int i = 0; i < 8; i++){
			
			next_x = start_x + x_move[i];
			next_y = start_y + y_move[i];
			
			if(isSafe(next_x, next_y, board)){
				board[next_x][next_y] = move_number;
				
				if(SolveProblem(next_x, next_y, move_number + 1, board, x_move, y_move)){
					return true;
				}
				else{
					board[next_x][next_y] = -1;
				}
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		
		BufferedReader inn = new BufferedReader( new InputStreamReader(System.in) );
    	inn = new BufferedReader( new InputStreamReader(System.in) );
    	
        try {
        	System.out.println("Velkommen til Sjakkbrettet!");
        	System.out.print("Hvor stort vil du at brettet skal være? : ");
        	N = Integer.parseInt( inn.readLine() );
        	
        	System.out.print("Hvilken x-posisjon vil du starte med? : ");
        	start_x = Integer.parseInt(inn.readLine());
        	
        	System.out.print("Hvilken y-posisjon vil du starte med? : ");
        	start_y = Integer.parseInt(inn.readLine());
        }
        catch( Exception e ) {
        	System.err.println(e) ;
        }
		Solve();
	}

}
