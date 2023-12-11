package lv1;

import java.util.Scanner;
//���۽ð� 0140
//����ð� 0155
//�ҿ�ð� 15��

/*
 * # ��ȭ�� �¼����� : Ŭ���� + ����
 * 1. ����ڷκ��� �¼���ȣ(index)�� �Է¹޾� �����ϴ� �ý����̴�.
 * 2. ���Ű� �Ϸ�Ǹ� �ش� �¼� ���� 1�� �����Ѵ�.
 * 3. �̹� ���Ű� �Ϸ�� �¼��� �籸���� �� ����.
 * 4. �� �¼��� ���� ������ 12000���̴�.
 * 5. ���α׷� ���� ��, �ش� ��ȭ���� �� ������� ����Ѵ�.
 * ��)
 * seat = 0 0 0 0 0 0 0
 * 
 * �¼����� : 1
 * seat = 0 1 0 0 0 0 0
 * 
 * �¼����� : 3
 * seat = 0 1 0 1 0 0 0
 * 
 * �¼����� : 3
 * seat = 0 1 0 1 0 0 0
 * �̹� ���Ű� �Ϸ�� �ڸ��Դϴ�.
 * ----------------------
 * ����� : 24000��
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
					System.out.print("�� ");
				}
				else {
					System.out.print("�� ");
				}
			}
			System.out.println();
			
			System.out.println("[MOVIE]");
			System.out.println("[1]�¼�����");
			System.out.println("[2]�����ϱ�");
			
			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				System.out.printf("������ �¼��� �Է��ϼ���. 0~%d", e.seat.length-1);
				int idx = scan.nextInt()-1;
				
				if(e.seat[idx] == 0) {
					e.seat[idx] = 1;
					e.money += 12000;
				}
			}
			else if(sel == 2) {
				System.out.println("�Ѹ����: "+e.money+" ��");
				break;
			}
		}
	}
}
