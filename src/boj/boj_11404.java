package boj;
//플로이드-와샬문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11404 {
	static final int INF = 999999999;
	
	public static void main(String[] args) throws IOException {
		int n,m;
		int[][] bus = new int[101][101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				bus[i][j] = INF;
				if(i==j) {
					bus[i][j] = 0;
				}
			}
		}
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			int x,y,z;
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			if(z<bus[x][y]) bus[x][y] = z;
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(bus[i][j]>bus[i][k] + bus[k][j])bus[i][j] = bus[i][k] + bus[k][j];
				}
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(bus[i][j]==INF) {
					System.out.print(0 + " ");
				}
				else System.out.print(bus[i][j] + " ");
			}
			System.out.println();
		}
	}

}
