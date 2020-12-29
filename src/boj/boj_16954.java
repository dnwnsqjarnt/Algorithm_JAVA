package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_16954 {
	static class Node{
		int r,c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static char[][] map = new char[9][9];
	static int[][] visit;
	static int[] dy = {0,0,1,-1,-1,1,-1,1,0};
	static int[] dx = {1,-1,0,0,-1,1,1,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<8; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(7,0));
		while(true) {
			if(q.size()==0) {
				System.out.println(0);
				break;
			}
			//이동하기..
			visit = new int[9][9];
			boolean flag = false;
			int q_size = q.size();
			for(int i=0; i<q_size; i++) {
				Node c = q.poll();
				if(map[c.r][c.c]=='#')continue;
				if(c.r==0 && c.c==7) {
					flag = true;
					break;
				}
				for(int d=0; d<9; d++) {
					int nr = c.r + dx[d];
					int nc = c.c + dy[d];
					if(nr<0 || nc<0 || nr>=8 || nc>=8)continue;
					if(visit[nr][nc]==1 || map[nr][nc]=='#')continue;
					q.offer(new Node(nr,nc));
					visit[nr][nc] = 1;
				}
			}
			if(flag) {
				System.out.println(1);
				break;
			}
			//벽내리기
			for(int i=7; i>=0; i--) {
				for(int j=0; j<8; j++) {
					if(map[i][j]=='#') {
						if(i==7) {
							map[i][j] = '.';
						}
						else {
							map[i][j] = '.';
							map[i+1][j] = '#';
						}
					}
				}
			}
		}
		
	}
}
