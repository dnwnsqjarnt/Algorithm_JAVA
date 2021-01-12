package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1561 {

	public static void main(String[] args) throws IOException {
		int N,M;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(N<=M) {
			System.out.println(N);
			return;
		}
		long left = 0;
		long right = 2000000000L*30L;
		while(left<=right) {
			long mid = (left+right)/2;
			long cnt = M;
			for(int i=1; i<=M; i++) {
				cnt += mid/arr[i];
			}
			if(cnt>=N) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		long n = left-1;
		long sum = M;
		for(int i=1; i<=M; i++) {
			sum+=n/arr[i];
		}
		for(int i=1; i<=M; i++) {
			if(left%arr[i]==0) {
				sum++;
			}
			if(sum==N) {
				System.out.println(i);
				return;
			}
		}

	}

}