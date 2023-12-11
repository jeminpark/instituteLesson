package lv1;

import java.security.SecureRandomParameters;
import java.util.Random;

//���۽ð� 0120
//����ð� 0126
//�ҿ�ð� 6��

/*
 * # OMRī�� : Ŭ���� + ����
 * 1. �迭 answer�� ���蹮���� �������̴�.
 * 2. �迭 hgd�� 1~5 ������ ���� ���� 5���� �����Ѵ�.
 * 3. answer�� hgd ���� ���� ����ǥ�� ����Ѵ�.
 * 4. �� ������ 20���̴�.
 * ��)
 * answer = {1, 3, 4, 2, 5}
 * hgd    = {1, 1, 4, 4, 3}
 * ����ǥ     = {O, X, O, X, X}
 * ����        = 40��
 */
class Ex06{
	int[] answer = {1, 3, 4, 2, 5};		// ������
	int[] hgd = new int[5];				// �л����
	
	int cnt = 0;						// ���� ���� ����
	int score = 0;						// ����
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
		System.out.println("���᰹��: "+aa.cnt);
		System.out.println("����: "+aa.score);
		
		
	}
}
