package lv1;

import java.util.Scanner;

//���۽ð� 1539
//����ð� 1603
//�ҿ�ð� 24��

/*
 * # �����̵�[3�ܰ�] : Ŭ���� + ����
 * 1. ����2�� ĳ�����̴�.
 * 2. ����1�� �Է��ϸ�, ĳ���Ͱ� ��������
 * 	    ����2�� �Է��ϸ�, ĳ���Ͱ� ���������� �̵��Ѵ�.
 * 3. ���� 1�� ���̴�. ���� ������ �̵��� �� ����.
 * 4. ��, ����3�� �Է��ϸ�, ���� ������ �� �ִ�.
 * 5. �¿� ���� �����ص� ��� �ݴ������� �̵��� �����ϴ�.
 * ��) 
 *  0 0 0 0 0 0 0 2 
 *  ����(1) ������(2) : 2
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
			System.out.println("1)�����̵� 2)�������̵� 3)���μ���");
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
