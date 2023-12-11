package lv1;


//시작시간 1949
//종료시간 1959
//소요시간 10분
class Ex03{
	int[] arr = {87, 100, 11, 72, 92};
}
public class Class_Question1_p {
	public static void main(String[] args) {
				
		Ex03 aa = new Ex03();
				// 문제 1) 전체 합 출력
				// 정답 1) 362				
				int total = 0;
				for(int i=0; i<aa.arr.length; i++) {
					total += aa.arr[i];
				}
				System.out.println(total);

				// 문제 2) 4의 배수의 합 출력
				// 정답 2) 264
				total = 0;
				for(int i=0; i<aa.arr.length; i++) {
					if(aa.arr[i]%4 == 0) {
						
						total += aa.arr[i];
					}
				}
				System.out.println(total);

				// 문제 3) 4의 배수의 개수 출력
				// 정답 3) 3
				int cnt = 0;
				for(int i=0; i<aa.arr.length; i++) {
					if(aa.arr[i]%4 == 0) {
						cnt++;
					}
				}
				System.out.println(cnt);
				
				// 문제 4) 짝수의 개수 출력
				// 정답 4) 3
				cnt = 0;
				for(int i=0; i<aa.arr.length; i++) {
					if(aa.arr[i]%2== 0) {
						cnt++;
					}
				}
				System.out.println(cnt);
		
	}
}
