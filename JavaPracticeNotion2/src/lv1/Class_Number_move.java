package lv1;

import java.util.Scanner;

//시작시간 1539
//종료시간 1603
//소요시간 24분

/*
 * # 숫자이동[3단계] : 클래스 + 변수
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 4. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 * 5. 좌우 끝에 도달해도 계속 반대편으로 이동이 가능하다.
 * 예) 
 *  0 0 0 0 0 0 0 2 
 *  왼쪽(1) 오른쪽(2) : 2
 *  
 *  2 0 0 0 0 0 0 0 
 */


class Ex08{
	int[] game = {0, 0, 1, 0, 2, 0, 0, 1, 0};
}
public class Class_Number_move {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ex08 aa = new Ex08();
		
		int idx = 0;
		for(int i=0; i<aa.game.length; i++) {
			if(aa.game[i] == 2) {
				idx = i;
			}
		}
		while(true) {
			for(int i=0; i<aa.game.length; i++) {
				System.out.print(aa.game[i]+" ");
			}
			System.out.println();
			System.out.println("1)왼쪽이동 2)오른쪽이동 3)벽부수기");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				if(idx -1 >= 0 && aa.game[idx-1] == 0) {
					aa.game[idx] = 0;
					aa.game[idx-1] = 2;
					idx--;
				}
			}
			else if(sel == 2) {
				if(idx +1 < aa.game.length && aa.game[idx+1] == 0) {
					aa.game[idx] = 0;
					aa.game[idx+1] = 2;
					idx++;
				}
			}
			else if(sel == 3) {
				if(aa.game[idx-1] == 1) {
					aa.game[idx-1] = 0;
				}
				else if(aa.game[idx+1] == 1) {
					aa.game[idx+1] = 0;
				}
			}
		}
		
		
		
	}

}
