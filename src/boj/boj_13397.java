package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13397 {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		int right = 0,left = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]>right)right = arr[i];
		}
		int ans = 10001;
		while(left<=right){
			int mid = (right+left)/2;
			if(check(mid)){
				right = mid-1;
				if(ans>mid)ans = mid;
			}else{
				left = mid+1;
			}
		}
		System.out.println(left);
	}
	public static boolean check(int mid) {
		int cnt = 1;
		int max = arr[0];
		int min = arr[0];
		for(int i=0; i<N; i++){
			if(arr[i]>max)max = arr[i];
			if(arr[i]<min)min = arr[i];
			if(max-min>mid){
				cnt++;
				max = arr[i];
				min = arr[i];
			}
		}
		if(cnt<=M) return true;
		else return false;
	}
}
