package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		long k = Integer.parseInt(br.readLine());
		long res = 0;
		long left = 0;
		long right = k;
		while(left<=right) {
			long mid = (left+right)/2;
			int cnt = 0;
			for(int i=1; i<=n; i++){
				cnt += Math.min(mid/i,n);
			}
			if(cnt>=k){
				res = mid;
				right = mid-1;
			}else{
				left = mid+1;
			}
		}
		System.out.println(res);
	}

}
