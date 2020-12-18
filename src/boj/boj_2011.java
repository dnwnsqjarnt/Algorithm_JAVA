package boj;

import java.util.*;

public class boj_2011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		if(s.charAt(0)-'0'==0) {
			System.out.println('0');
			return;
		}
		long[] dp = new long[s.length()+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<=s.length(); i++) {
			int curr = s.charAt(i-1) - '0';
			int prev = s.charAt(i-2) - '0';
			if(curr==0) {
				if(prev==1 || prev==2) {
					dp[i] = dp[i-2]%1000000;
				}
				else {
					System.out.println('0');
					return;
				}
			}
			else {
				if(prev==0) {
					dp[i] = dp[i-1]%1000000;
				}
				else {
					int num = prev*10 + curr;
					if(num>=10 && num<=26) {
						dp[i] = (dp[i-1] + dp[i-2])%1000000;
					}
					else {
						dp[i] = dp[i-1]%1000000;
					}
				}
			}
		}
		System.out.println(dp[s.length()]%1000000);
	}
}
