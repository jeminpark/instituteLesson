package lv1;

import java.security.SecureRandomParameters;
import java.util.Random;

//시작시간 0120
//종료시간 0126
//소요시간 6분

/*
 * # OMR카드 : 클래스 + 변수
 * 1. 배열 answer는 시험문제의 정답지이다.
 * 2. 배열 hgd에 1~5 사이의 랜덤 숫자 5개를 저장한다.
 * 3. answer와 hgd 값을 비교해 정오표를 출력한다.
 * 4. 한 문제당 20점이다.
 * 예)
 * answer = {1, 3, 4, 2, 5}
 * hgd    = {1, 1, 4, 4, 3}
 * 정오표     = {O, X, O, X, X}
 * 성적        = 40점
 */
class Ex06{
	int[] answer = {1, 3, 4, 2, 5};		// 시험답안
	int[] hgd = new int[5];				// 학생답안
	
	int cnt = 0;						// 정답 맞춘 개수
	int score = 0;						// 성적
}
public class Class_OMR_p {
	public static void main(String[] args) {
		Random rand = new Random();
		Ex06 aa = new Ex06();
		
		for(int i=0; i<aa.answer.length; i++) {
			System.out.print(aa.answer[i]+" ");
		}
		System.out.println();
		for(int i=0; i<aa.hgd.length; i++) {
			int rNum = rand.nextInt(aa.hgd.length);
			aa.hgd[i] = rNum;
			System.out.print(aa.hgd[i]+" ");
		}
		System.out.println();
		for(int i=0; i<aa.answer.length; i++) {
			if(aa.hgd[i] == aa.answer[i]) {
				aa.cnt++;
				aa.score+= 20;
			}
		}
		System.out.println("맞춘갯수: "+aa.cnt);
		System.out.println("점수: "+aa.score);
		
		
	}
}
