package lv1;

import java.util.Scanner;

//���۽ð� 2105
//����ð� 2115
//�ҿ�ð� 10��
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
			System.out.println("1.������ ����Ȯ��");
			System.out.println("2.1���л� ����Ȯ��");
			System.out.println("3.�õ��л� ����Ȯ��");
			System.out.println("4.����Ȯ���ϱ�");
			System.out.println("5.�����ϱ�");
		 */
		
		aa.name = "�׸��п�";
		
		while(true) {
			System.out.println("=== "+aa.name+" === ");
			System.out.println("1.������ ����Ȯ��\n2.1���л� ����Ȯ��\n3.�õ��л� ����Ȯ��\n4.����Ȯ���ϱ�\n5.�����ϱ�");
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
				System.out.println("1���л�: "+aa.arhakbun[best]+" ����: "+max);
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
				System.out.println("�õ��л�: "+aa.arhakbun[worst]+" ����: "+min);
				
			}
			else if(sel == 4) {
				System.out.println("�й��Է�: ");
				int hak = scan.nextInt();
				
				int check = -1;
				for(int i=0; i<aa.arhakbun.length; i++) {
					if(hak == aa.arhakbun[i]) {
						check = i;
					}
				}
				if(check == -1) {
					System.out.println("�ش��й��� �����ϴ�.");
				}
				else {
					System.out.println("�й��Է�: "+hak+" ����: "+aa.arScore[check]);
				}
			}
			else if(sel == 5) {
				System.out.println("�����մϴ�.");
				break;
			}
			
		}
		
		
	}
}
