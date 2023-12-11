package lv1;

import java.util.Random;
import java.util.Scanner;

/*
 * # ���� ���� : Ŭ���� + ����
 * 1. front �迭 ī�� 10���� ���´�.
 * 2. front �迭���� ���� ī�带 ��� ī���� ��ġ�� �Է��Ѵ�.
 * 3. ������ 2���� ī�尡 ���� ī���̸�, back �迭�� ǥ���Ѵ�.
 * 4. ��� ī�尡 ��������(back�迭�� 0�� �������) ������ ����ȴ�. 
 */

//���۽ð� 1230
//����ð� 1243
//�ҿ�ð� 13��

class Ex09{
	int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
	int[] back = new int[10];
	
	int cnt = 0;		// ������ ���� Ƚ��
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
				System.out.println("���� ����");
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
