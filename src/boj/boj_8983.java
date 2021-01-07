package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_8983 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int res = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(b>L)continue;
			int low = b-L+a;
			int high = L-b+a;
			int left = 0;
			int right = M-1;
			while(left<=right){
				int mid = (left+right)/2;
				if(arr[mid]>=low && arr[mid]<=high){
					res++;
					break;
				}
				if(arr[mid]<low){
					left = mid+1;
				}else if(arr[mid]>high){
					right = mid-1;
				}
			}
		}
		System.out.println(res);
	}

}
