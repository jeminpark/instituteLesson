package lv1;
/* 
 * # ∆Ω≈√≈‰
 * === ∆Ω≈√≈‰ ===
 * [X][X][O]
 * [ ][O][ ]
 * [ ][ ][ ]
 * [p1]¿Œµ¶Ω∫ ¿‘∑¬ : 6
 * === ∆Ω≈√≈‰ ===
 * [X][X][O]
 * [ ][O][ ]
 * [O][ ][ ]
 * [p1]Ω¬∏Æ
 * 
 */

import java.util.Scanner;

class Ex10{
	
	String[][] game = new String[3][3];
	
	int turn = 1;
	int win = 0;		
}
public class Class_TicTacto_p {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ex10 aa = new Ex10();
		
		for(int i=0; i<aa.game.length; i++) {
			for(int j=0; j<aa.game[i].length; j++ ) {
				aa.game[i][j] = new String();
				
			}
		}
		
		while(true) {
			for(int i=0; i<aa.game.length; i++) {
				for(int j=0; j<aa.game[i].length; j++) {
					System.out.print("["+aa.game[i][j]+" ]");
					System.out.print("y"+i+"x"+j);
				}
				System.out.println();
			}
			System.out.println();
			System.out.printf("p%d y: ", aa.turn);
			int y = scan.nextInt();
			System.out.printf("p%d x: ", aa.turn);
			int x = scan.nextInt();
			
			if(aa.game[y][x].equals(" ")) {
				aa.game[y][x] = "[X]" ;
			
			}
			
		}
	}
}
