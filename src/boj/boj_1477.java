package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1477 {
	static int N,M,L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		ArrayList<Integer> way = new ArrayList<Integer>();
		way.add(0);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			int x;
			x = Integer.parseInt(st.nextToken());
			way.add(x);
		}
		way.add(L);
		Collections.sort(way);
		int left = 1;
		int right = L-1;
		int mid = 0;
		while(left<=right){
			mid = (left + right) / 2;
			int store = 0;
			for(int i=1; i<way.size(); i++){
				int dist = way.get(i) - way.get(i-1);
				store += dist/mid;
				if(dist%mid==0)store--;
			}
			if(store>M){
				left = mid+1;
			}else{
				right = mid-1;
			}
		}
		System.out.println(left);
	}

}
