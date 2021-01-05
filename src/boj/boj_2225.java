package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2225 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N,K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long[][] dp = new long[N+1][K+1];
		for(int i=0; i<=N; i++) {
			dp[i][1] = 1;
		}
		
		for(int i=0; i<=N; i++) {
			for(int j=2; j<=K; j++) {
				long sum = 0;
				for(int k=0; k<=i; k++) {
					sum += dp[k][j-1];
				}
				dp[i][j] = sum%1000000000;
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
