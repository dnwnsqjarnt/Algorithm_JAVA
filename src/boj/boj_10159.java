package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10159 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			int x,y;
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = -1;
		}
		for(int k=1; k<=N; k++){
			for(int i=1; i<=N; i++){
				for(int j=1; j<=N; j++){
					if(arr[i][k]==1&&arr[k][j]==1)arr[i][j] = 1;
					if(arr[i][k]==-1&&arr[k][j]==-1)arr[i][j] = -1;
				}
			}
		}
		int[] res = new int[N+1];
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				if(arr[i][j]==0)res[i]++;
			}
		}
		for(int i=1; i<=N; i++){
			System.out.println(res[i]-1);
		}
	}

}
