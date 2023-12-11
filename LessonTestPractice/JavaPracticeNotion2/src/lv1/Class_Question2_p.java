package lv1;

import java.util.Scanner;

//시작시간 2040
//종료시간 2052
//소요시간 12분
class Ex04{
	int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
	int[] scores = new int[5];
}
public class Class_Question2_p {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ex04 aa = new Ex04();
		
		// 문제1) scores배열에 1~100점 사이의 정수를 5개 저장
		// 예 1) 87, 11, 92, 14, 47
		int[] arr = {87, 11, 92, 14, 47};
		for(int i=0; i<aa.scores.length; i++) {
			aa.scores[i] = arr[i];
			System.out.print(aa.scores[i]+" ");
		}
		System.out.println();
		// 문제2) 전교생의 총점과 평균 출력
		// 예 2) 총점(251) 평균(50.2)
		double total = 0;
		double cnt = 0;
		for(int i=0; i<aa.scores.length; i++) {
			total += aa.scores[i];
			cnt++;
		}
		double avg = total/cnt;
		System.out.println("총점: "+total+"  평균: "+avg);
		

		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예 3) 2명
		int pass = 0;
		for(int i=0; i<aa.scores.length; i++) {
			if(aa.scores[i] >= 60) {
				pass++;
			}
		}
		System.out.println("합격자 : "+pass);
		
		// 문제4) 인덱스를 입력받아 성적 출력
		// 정답4) 인덱스 입력 : 1 성적 : 11점
		System.out.print("idx : ");
		int idx = scan.nextInt();
		
		System.out.println(aa.scores[idx]);

		// 문제5) 성적을 입력받아 인덱스 출력
		// 정답5) 성적 입력 : 11 인덱스 : 1
		System.out.print("성적: ");
		int num = scan.nextInt();
		
		idx = -1;
		for(int i=0; i<aa.scores.length; i++) {
			if(num == aa.scores[i]) {
				idx = i;
			}
		}
		System.out.println(idx);

		// 문제6) 학번을 입력받아 성적 출력
		// 정답6) 학번 입력 : 1003 성적 : 92점
		System.out.print("학번입력: ");
		int hak = scan.nextInt();
		
		idx = -1;
		for(int i=0; i<aa.hakbuns.length; i++) {
			if(hak == aa.hakbuns[i]) {
				idx = i;
			}
		}
		System.out.println(aa.scores[idx]);
		
		// 문제7) 학번을 입력받아 성적 출력
		// 단, 없는학번 입력 시 예외처리
		// 예 7)
		// 학번 입력 : 1002 성적 : 11점
		// 학번 입력 : 1000 해당학번은 존재하지 않습니다.
		System.out.println("학번입력: ");
		int hakb = scan.nextInt();
		
		int check = -1;
		for(int i=0; i<aa.hakbuns.length; i++) {
			if(hakb == aa.hakbuns[i]) {
				check = i;
			}
		}
		if(check == -1) {
			System.out.println("학번입력: "+hakb+" 해당 학생은 없습니다.");
		}
		else {
			System.out.println("학번입력: "+hakb+" 성적 :"+aa.scores[check]);
		}
		
		
		// 문제8) 1등학생의 학번과 성적 출력
		// 정답8) 1004번(98점)
		int best = 0;
		int max = 0;
		
		for(int i=0; i<aa.scores.length; i++) {
			if(max < aa.scores[i]) {
				max = aa.scores[i];
				best = i;
			}
		}
		System.out.println("1등학생 : "+aa.hakbuns[best]+" 성적: "+max);
		
		
	}
}
