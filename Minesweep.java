import java.util.*;
public class Minesweep{
	public static void main(String[] args){
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		Random rand = new Random();
		Scanner keyboard = new Scanner(System.in);
		int[][] bombs =new int[9][9];
		for(int i = 0; i<=10;i++){
			bombs[rand.nextInt(bombs.length-1)][rand.nextInt(bombs[0].length-1)]=1;
		}
		int[][] board = new int[bombs.length][bombs[0].length];
		for(int i = 0; i<bombs.length;i++){
			for(int j = 0; j<bombs[0].length;j++){
				board[i][j]=0;
				if(i<bombs[0].length-1 && bombs[i+1][j]==1){
					board[i][j]++;
				}
				if(i>0 && bombs[i-1][j]==1){
					board[i][j]++;
				}
				if(j<bombs.length-1 && bombs[i][j+1]==1){
					board[i][j]++;
				}
				if(j>0 && bombs[i][j-1]==1){
					board[i][j]++;
				}
				if(i<bombs[0].length-1 && j<bombs.length-1 && bombs[i+1][j+1]==1){
					board[i][j]++;
				}
				if(i>0 && j>0 && bombs[i-1][j-1]==1){
					board[i][j]++;
				}
				if(i<bombs[0].length-1 && j>0 && bombs[i+1][j-1]==1){
					board[i][j]++;
				}
				if(i>0 && j<bombs.length-1 && bombs[i-1][j+1]==1){
					board[i][j]++;
				}
				if(bombs[i][j]==1){
					board[i][j]=0;
				}
				System.out.print(board[i][j] + " ");
				}
			System.out.println();
		}
		int[][] visual = new int[board.length][board[0].length];
		while(true){
			int counter=0;
			System.out.println("Row: ");
			int row = keyboard.nextInt() - 1;
			System.out.println("Col: ");
			int col = keyboard.nextInt() - 1;
			if(bombs[row][col]==1){
				System.out.println("You Lost!");
				break;
			}

			if(board[row][col]!=0){
				visual[row][col]=board[row][col];
			}
			if(board[row][col]==0){
				map=new HashMap<Integer,String>();
				int temprow=0,tempcol=0;
				for(int q=0;q<3;q++){
					int counter2=0;
					String[] k = new String[2];
					map.put(0,row+","+col);
					if(row-1>=0 && col-1>=0 && board[row-1][col-1]==0 ){
						counter2++;
						map.put(counter2,(row-1)+","+(col-1));
					}
					if(row-1>=0 && board[row-1][col]==0){
						counter2++;
						map.put(counter2,(row-1)+","+col);
					}
					if(col-1>=0 && board[row][col-1]==0){
						counter2++;
						map.put(counter2,row+","+(col-1));
					}
					if(row+1<board.length-1 && col+1<board.length-1 && board[row+1][col+1]==0){
						counter2++;
						map.put(counter2,(row+1)+","+(col+1));
					}
					if( row+1<board.length-1 && board[row+1][col]==0){
						counter2++;
						map.put(counter2,(row+1)+","+col);
					}
					if(col+1<board.length-1 && board[row][col+1]==0){
						counter2++;
						map.put(counter2,row+","+(col+1));
					}
					if(row+1<board.length-1 && col-1>=0 && board[row+1][col-1]==0){
						counter2++;
						map.put(counter2,(row+1)+","+(col-1));
					}
					if(row-1>=0 && col+1<board.length-1 && board[row-1][col+1]==0){
						counter2++;
						map.put(counter2,(row-1)+","+(col+1));
					}
					for(int i = 0; i<map.size();i++){
						k = map.get(i).split(",");
						temprow = Integer.parseInt(k[0]);
						tempcol = Integer.parseInt(k[1]);
						System.out.println(map.get(i));
						if(temprow-1>=0 && tempcol+1<board.length-1){
							visual[temprow-1][tempcol+1]=board[temprow-1][tempcol+1];
						}
						if(temprow+1<board.length-1 && tempcol-1>=0){
							visual[temprow+1][tempcol-1]=board[temprow+1][tempcol-1];
						}
						if(temprow+1<board.length-1 && tempcol+1<board.length-1){
							visual[temprow+1][tempcol+1]=board[temprow+1][tempcol+1];
						}
						if(temprow-1>=0 && tempcol-1>=0){
							visual[temprow-1][tempcol-1]=board[temprow-1][tempcol-1];
						}
						if(temprow-1>=0){
							visual[temprow-1][tempcol]=board[temprow-1][tempcol];
						}
						if(tempcol+1<board.length-1){
							visual[temprow][tempcol+1]=board[temprow][tempcol+1];
						}
						if(temprow+1<board.length-1){
							visual[temprow+1][tempcol]=board[temprow+1][tempcol];
						}
						if(tempcol-1>=0){
							visual[temprow][tempcol-1]=board[temprow][tempcol-1];
						}
					}
					System.out.println(col + " " + row + " " + tempcol + " " + temprow);
					if(row==temprow && col==tempcol){
						break;
					}
					col=tempcol;
					row=temprow;
				}
			}

			for(int i = 0; i<visual.length;i++){
				for(int j = 0; j<visual.length;j++){
					if(visual[i][j]==board[i][j]){
						counter++;
					}
					System.out.print(visual[i][j] + " ");
				}
				System.out.println();
			}
			if(counter==visual.length*visual[0].length){
				System.out.println("You Win!!");
				break;
			}
		}
	}
}
