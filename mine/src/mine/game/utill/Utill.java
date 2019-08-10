package mine.game.utill;

import java.util.Arrays;
import java.util.Random;

/**
 * 기타 꼭 필요하지 않는 객체들의 집합. 
 * 
 * @author top
 *
 */
public class Utill {
	public static final boolean thisMine = true;			// 지뢰다.
	public static final boolean unThisMine = false;			// 지뢰가 아니다.
	
	/**
	 * 8방 타일을 비교할 int형 2차배열
	 * (-1,-1) (-1,0) (-1,1)
	 * (0, -1) (  값  ) (0,1)
	 * (1, -1) (1, 0) (1,1)
	 */
	public static final int[][] arroudMineNumSetBoard = { {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1} }; 
	
	// 랜덤 지뢰를 사용시 사용함 랜덤 함수.
	public static int[] getRandomNums(int count, int range) {
		int nums[] = new int[count];
		
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = r.nextInt(range) + 1;
			
			for(int j=0;j<i;j++) {
				if(nums[i]==nums[j]) {
					i--;
				}
			}
		}
		Arrays.sort(nums);
		
		return nums;
	}
}
