package lv1;

import java.util.Random;
import java.util.Scanner;

/*
 * # 기억력 게임 : 클래스 + 변수
 * 1. front 배열 카드 10장을 섞는다.
 * 2. front 배열에서 같은 카드를 골라 카드의 위치를 입력한다.
 * 3. 선택한 2장의 카드가 같은 카드이면, back 배열에 표시한다.
 * 4. 모든 카드가 뒤집히면(back배열의 0이 사라지면) 게임은 종료된다. 
 */

//시작시간 1230
//종료시간 1243
//소요시간 13분

class Ex09{
	int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
	int[] back = new int[10];
	
	int cnt = 0;		// 정답을 맞춘 횟수
}
public class Class_MemoryGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		Ex09 aa = new Ex09();
		
		for(int i=0; i<1000; i++) {
			int rIdx = rand.nextInt(aa.front.length);
			
			int temp = aa.front[0];
			aa.front[0] = aa.front[rIdx];
			aa.front[rIdx] = temp;
		}
		
		while(true) {
			for(int i=0; i<aa.front.length; i++) {
				System.out.print(i+1+" ");
			}
			System.out.println();
			for(int i=0; i<aa.front.length; i++) {
				System.out.print(aa.front[i]+" ");
			}
			System.out.println();
			for(int i=0; i<aa.front.length; i++) {
				if(aa.back[i] == 1) {
					System.out.print(aa.front[i]+" ");
				}
				else {
					System.out.print(aa.back[i]+" ");
				}
			}
			System.out.println();
			
			if(aa.cnt == aa.front.length) {
				System.out.println("게임 성공");
				break;
			}
			
			System.out.print("idx1: ");
			int idx1 = scan.nextInt()-1;
			System.out.print("idx2: ");
			int idx2 = scan.nextInt()-1;
			
			if(idx1 == idx2 || idx1 < 0 || idx1 > aa.front.length || idx2 < 0 || idx2 > aa.front.length ||
					aa.back[idx1] == 1 || aa.front[idx1] != aa.front[idx2]) {
				continue;
			}
			aa.back[idx1] = 1;
			aa.back[idx2] = 1;
			aa.cnt+=2;
		}
	}
}
