package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2352 {
	static int[] arr1;
	static int[] arr2;
	static int N, cnt;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr1 = new int[N];
		arr2 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		cnt = 1;
		arr2[0] = arr1[0];
		for(int i=1; i<N; i++){
			if(arr2[cnt-1]<arr1[i]){
				arr2[cnt++] = arr1[i];
			}
			else{
				int idx = binary_search(arr1[i]);
				arr2[idx] = arr1[i];
			}
		}
		System.out.println(cnt);
	}
	public static int binary_search(int num) {
		int left = 0;
		int right = cnt-1;
		while(left<=right){
			int mid = (left+right)/2;
			if(arr2[mid]<num){
				left = mid+1;
			}else{
				right = mid-1;
			}
		}
		return left;
	}
}
