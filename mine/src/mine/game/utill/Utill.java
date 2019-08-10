package mine.game.utill;

import java.util.Arrays;
import java.util.Random;

/**
 * ��Ÿ �� �ʿ����� �ʴ� ��ü���� ����. 
 * 
 * @author top
 *
 */
public class Utill {
	public static final boolean thisMine = true;			// ���ڴ�.
	public static final boolean unThisMine = false;			// ���ڰ� �ƴϴ�.
	
	/**
	 * 8�� Ÿ���� ���� int�� 2���迭
	 * (-1,-1) (-1,0) (-1,1)
	 * (0, -1) (  ��  ) (0,1)
	 * (1, -1) (1, 0) (1,1)
	 */
	public static final int[][] arroudMineNumSetBoard = { {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1} }; 
	
	// ���� ���ڸ� ���� ����� ���� �Լ�.
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
