package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1956 {
	static final int INF = 999999999;
	static int V,E;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new int[V+1][V+1];
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				map[i][j] = INF;
			}
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[x][y] = z;
		}
		for(int k=1; k<=V; k++){
			for(int i=1; i<=V; i++){
				for(int j=1; j<=V; j++){
					if(map[i][k]+map[k][j]<map[i][j])map[i][j] = map[i][k]+map[k][j];
				}
			}
		}
		int min = INF;
		for(int i=1; i<=V; i++) {
			if(map[i][i]<min) min = map[i][i];
		}
		if(min==INF) System.out.println(-1);
		else System.out.println(min);
	}

}
