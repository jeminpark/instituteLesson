package lv1;


//���۽ð� 1949
//����ð� 1959
//�ҿ�ð� 10��
class Ex03{
	int[] arr = {87, 100, 11, 72, 92};
}
public class Class_Question1_p {
	public static void main(String[] args) {
				
		Ex03 aa = new Ex03();
				// ���� 1) ��ü �� ���
				// ���� 1) 362				
				int total = 0;
				for(int i=0; i<aa.arr.length; i++) {
					total += aa.arr[i];
				}
				System.out.println(total);

				// ���� 2) 4�� ����� �� ���
				// ���� 2) 264
				total = 0;
				for(int i=0; i<aa.arr.length; i++) {
					if(aa.arr[i]%4 == 0) {
						
						total += aa.arr[i];
					}
				}
				System.out.println(total);

				// ���� 3) 4�� ����� ���� ���
				// ���� 3) 3
				int cnt = 0;
				for(int i=0; i<aa.arr.length; i++) {
					if(aa.arr[i]%4 == 0) {
						cnt++;
					}
				}
				System.out.println(cnt);
				
				// ���� 4) ¦���� ���� ���
				// ���� 4) 3
				cnt = 0;
				for(int i=0; i<aa.arr.length; i++) {
					if(aa.arr[i]%2== 0) {
						cnt++;
					}
				}
				System.out.println(cnt);
		
	}
}
