package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1939 {
	static int N, M;
	static int start, fin;
	static int[] visit;
	static int res;
	static ArrayList<Node>[] v;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			v[i] = new ArrayList<Node>();
		}
		int max_cost=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			v[from].add(new Node(to, weight));
			v[to].add(new Node(from, weight));
			max_cost = Math.max(max_cost, weight);
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		fin = Integer.parseInt(st.nextToken());
		int left = 0;
		int right = max_cost;
		while(left<=right) {
			visit = new int[N+1];
			int mid = (left+right)/2;
			if(BFS(mid)) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(res);
	}
	
	public static boolean BFS(int cost) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = 1;
		q.offer(start);
		while(!q.isEmpty()) {
			int cc = q.poll();
			if(cc==fin) {
				res = cost;
				return true;
			}
			for(int i=0; i<v[cc].size(); i++) {
				int next = v[cc].get(i).end;
				int next_cost = v[cc].get(i).cost;
				if(visit[next]==1)continue;
				if(cost>next_cost)continue;
				q.offer(next);
				visit[next] = 1;
			}
		}
		
		return false;
	}
	
	static class Node{
		int end;
		int cost;
		
		Node(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
	}
}
