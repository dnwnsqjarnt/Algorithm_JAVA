package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10422 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 1;
		for(int i=4; i<5001; i++){
			if(i%2==1)continue;
			for(int j=0; j<i/2; j++){
				dp[i] += dp[(i-2)-(2*j)]*dp[2*j];
				dp[i] %= 1000000007;
			}
		}
		for(int i=0; i<T; i++){
			int x;
			x = Integer.parseInt(br.readLine());
			System.out.println(dp[x]);
		}
	}

}
