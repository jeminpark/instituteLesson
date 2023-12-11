package lv1;

import java.util.Scanner;

//시작시간 2105
//종료시간 2115
//소요시간 10분
class Ex05{
	String name = "";
	
	int[] arhakbun = {1001, 1002, 1003, 1004, 1005};
	int[] arScore = {92, 38, 87, 100, 11};
}
public class Class_Question3_p {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ex05 aa = new Ex05();
		/*
		 * System.out.println("=== " + mega.name + "===");
			System.out.println("1.전교생 성적확인");
			System.out.println("2.1등학생 성적확인");
			System.out.println("3.꼴등학생 성적확인");
			System.out.println("4.성적확인하기");
			System.out.println("5.종료하기");
		 */
		
		aa.name = "그린학원";
		
		while(true) {
			System.out.println("=== "+aa.name+" === ");
			System.out.println("1.전교생 성적확인\n2.1등학생 성적확인\n3.꼴등학생 성적확인\n4.성적확인하기\n5.종료하기");
			System.out.print("menu: ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				for(int i=0; i<aa.arScore.length; i++) {
					System.out.print(aa.arhakbun[i]+" : "+aa.arScore[i]+"\n");
				}
			}
			else if(sel == 2) {
				int max = 0;
				int best = 0;
				for(int i=0; i<aa.arScore.length; i++) {
					if(max < aa.arScore[i]) {
						max = aa.arScore[i];
						best = i;
					}
				}
				System.out.println("1등학생: "+aa.arhakbun[best]+" 성적: "+max);
			}
			else if(sel == 3) {
				int worst = 0;
				int min = aa.arScore[0];
				for(int i=0; i<aa.arScore.length ;i++) {
					if(min > aa.arScore[i]) {
						min = aa.arScore[i];
						worst = i;
					}
				}
				System.out.println("꼴등학생: "+aa.arhakbun[worst]+" 성적: "+min);
				
			}
			else if(sel == 4) {
				System.out.println("학번입력: ");
				int hak = scan.nextInt();
				
				int check = -1;
				for(int i=0; i<aa.arhakbun.length; i++) {
					if(hak == aa.arhakbun[i]) {
						check = i;
					}
				}
				if(check == -1) {
					System.out.println("해당학번은 없습니다.");
				}
				else {
					System.out.println("학번입력: "+hak+" 성적: "+aa.arScore[check]);
				}
			}
			else if(sel == 5) {
				System.out.println("종료합니다.");
				break;
			}
			
		}
		
		
	}
}
