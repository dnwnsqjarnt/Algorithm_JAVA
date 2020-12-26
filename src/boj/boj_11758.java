package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11758 {
	
	public static void main(String[] args) throws IOException{
		int x[] = new int[4];
		int y[] = new int[4];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1; i<=3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		int a = x[1]*y[2] + x[2]*y[3] + x[3]*y[1];
		int b = x[2]*y[1] + x[3]*y[2] + x[1]*y[3];
		
		if(a-b==0) System.out.println(0);
		else if(a-b>0)System.out.println(1);
		else System.out.println(-1);
	}

}
