package lv1;

import java.util.Scanner;

//���۽ð� 2040
//����ð� 2052
//�ҿ�ð� 12��
class Ex04{
	int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
	int[] scores = new int[5];
}
public class Class_Question2_p {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ex04 aa = new Ex04();
		
		// ����1) scores�迭�� 1~100�� ������ ������ 5�� ����
		// �� 1) 87, 11, 92, 14, 47
		int[] arr = {87, 11, 92, 14, 47};
		for(int i=0; i<aa.scores.length; i++) {
			aa.scores[i] = arr[i];
			System.out.print(aa.scores[i]+" ");
		}
		System.out.println();
		// ����2) �������� ������ ��� ���
		// �� 2) ����(251) ���(50.2)
		double total = 0;
		double cnt = 0;
		for(int i=0; i<aa.scores.length; i++) {
			total += aa.scores[i];
			cnt++;
		}
		double avg = total/cnt;
		System.out.println("����: "+total+"  ���: "+avg);
		

		// ����3) ������ 60�� �̻��̸� �հ�. �հݻ� �� ���
		// �� 3) 2��
		int pass = 0;
		for(int i=0; i<aa.scores.length; i++) {
			if(aa.scores[i] >= 60) {
				pass++;
			}
		}
		System.out.println("�հ��� : "+pass);
		
		// ����4) �ε����� �Է¹޾� ���� ���
		// ����4) �ε��� �Է� : 1 ���� : 11��
		System.out.print("idx : ");
		int idx = scan.nextInt();
		
		System.out.println(aa.scores[idx]);

		// ����5) ������ �Է¹޾� �ε��� ���
		// ����5) ���� �Է� : 11 �ε��� : 1
		System.out.print("����: ");
		int num = scan.nextInt();
		
		idx = -1;
		for(int i=0; i<aa.scores.length; i++) {
			if(num == aa.scores[i]) {
				idx = i;
			}
		}
		System.out.println(idx);

		// ����6) �й��� �Է¹޾� ���� ���
		// ����6) �й� �Է� : 1003 ���� : 92��
		System.out.print("�й��Է�: ");
		int hak = scan.nextInt();
		
		idx = -1;
		for(int i=0; i<aa.hakbuns.length; i++) {
			if(hak == aa.hakbuns[i]) {
				idx = i;
			}
		}
		System.out.println(aa.scores[idx]);
		
		// ����7) �й��� �Է¹޾� ���� ���
		// ��, �����й� �Է� �� ����ó��
		// �� 7)
		// �й� �Է� : 1002 ���� : 11��
		// �й� �Է� : 1000 �ش��й��� �������� �ʽ��ϴ�.
		System.out.println("�й��Է�: ");
		int hakb = scan.nextInt();
		
		int check = -1;
		for(int i=0; i<aa.hakbuns.length; i++) {
			if(hakb == aa.hakbuns[i]) {
				check = i;
			}
		}
		if(check == -1) {
			System.out.println("�й��Է�: "+hakb+" �ش� �л��� �����ϴ�.");
		}
		else {
			System.out.println("�й��Է�: "+hakb+" ���� :"+aa.scores[check]);
		}
		
		
		// ����8) 1���л��� �й��� ���� ���
		// ����8) 1004��(98��)
		int best = 0;
		int max = 0;
		
		for(int i=0; i<aa.scores.length; i++) {
			if(max < aa.scores[i]) {
				max = aa.scores[i];
				best = i;
			}
		}
		System.out.println("1���л� : "+aa.hakbuns[best]+" ����: "+max);
		
		
	}
}
