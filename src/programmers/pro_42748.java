package programmers;

import java.util.Arrays;

public class pro_42748 {

	public static void main(String[] args) {
		int[] ans = solution(new int[]{1,5,2,6,3,7,4},new int[][]{{2,5,3},{4,4,1},{1,7,3}});
		System.out.println(Arrays.toString(ans));
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i=0; i<commands.length; i++) {
			int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2]-1];
		}
		
		return answer;
	}

}