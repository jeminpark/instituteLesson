package lv1;

import java.util.Scanner;
//시작시간 0140
//종료시간 0155
//소요시간 15분

/*
 * # 영화관 좌석예매 : 클래스 + 변수
 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
 * 4. 한 좌석당 예매 가격은 12000원이다.
 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
 * 예)
 * seat = 0 0 0 0 0 0 0
 * 
 * 좌석선택 : 1
 * seat = 0 1 0 0 0 0 0
 * 
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 이미 예매가 완료된 자리입니다.
 * ----------------------
 * 매출액 : 24000원
 */

class Ex07{
	int[] seat = new int[7];
	int money = 0;
}
public class Class_Theater_p {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Ex07 e = new Ex07();
		
		while(true) {
			for(int i=0; i<e.seat.length; i++) {
				if(e.seat[i] == 1) {
					System.out.print("■ ");
				}
				else {
					System.out.print("□ ");
				}
			}
			System.out.println();
			
			System.out.println("[MOVIE]");
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				System.out.printf("예매할 좌석을 입력하세요. 0~%d", e.seat.length-1);
				int idx = scan.nextInt()-1;
				
				if(e.seat[idx] == 0) {
					e.seat[idx] = 1;
					e.money += 12000;
				}
			}
			else if(sel == 2) {
				System.out.println("총매출액: "+e.money+" 원");
				break;
			}
		}
	}
}
