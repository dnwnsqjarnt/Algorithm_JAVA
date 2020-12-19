package boj;

import java.util.*;

public class boj_10830 {
	static int N;
	static long B;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		B = sc.nextLong();
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		long[][] res = func(B);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(res[i][j]%1000 + " ");
			}
			System.out.println();
		}
	}
	
	public static long[][] func(long b){
		long[][] res = new long[N][N];
		long[][] tmp = new long[N][N];
		
		if(b==1) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					res[i][j] = arr[i][j]%1000;
				}
			}
		}
		else if(b%2==0) {
			tmp = func(b/2);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					long num = 0;
					for(int k=0; k<N; k++) {
						num += tmp[i][k] * tmp[k][j]; 
					}
					res[i][j] = num%1000;
				}
			}
		}
		else {
			tmp = func(b-1);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					long num = 0;
					for(int k=0; k<N; k++) {
						num += tmp[i][k] * arr[k][j]; 
					}
					res[i][j] = num%1000;
				}
			}
		}
		return res;
	}	
}