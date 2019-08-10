package mine.game.utill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import mine.game.data.InnerPixel;

public class Utill {
	public static final boolean thisMine = true;
	public static final boolean unThisMine = false;
	public static final int pixelMine = -1;
	public static final int[][] arroudMineNumSetBoard = { {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1} }; 
	
//	x : -1, y : -1 
//	x : -1, y : 0 
//	x : -1, y : 1 
//	x : 0, y : -1 
//	x : 0, y : 1 
//	x : 1, y : -1 
//	x : 1, y : 0 
//	x : 1, y : 1 
	
	// 00 01 02 03 04 05 06 07 80 09 
	// 10 11 12 13 14 15 16 17 18 19 
	// 20 21 22 23 24 25 26 27 28 29 
	// 30 31 32 33 34 35 36 37 38 39 
	
	// {-1,-1} {-1,0}, {-1,1}
	// {0,-1} ,{0,10} , {0,1} 
	// {1,-1} ,{1,0} , {1,1}
	
	// -11 -10 -09
	// -01  10 +01
	// +09 +10 +11
//23 x : 1, y : 2 x : 1, y : 3 x : 1, y : 4 x : 2, y : 2 x : 2, y : 4 x : 3, y : 2 x : 3, y : 3 x : 3, y : 4 
	
//	1 0 0 0 0 1 X 1 1 X 
//	1 x 0 0 0 2 3 3 2 1 
//	2 1 1 1 1 2 X X 1 0 
//	1 X 1 1 X 2 2 3 2 1 
//	1 1 2 2 2 1 0 1 X 1 
//	0 0 1 X 1 0 0 1 1 1 
//	0 0 1 1 1 0 0 0 0 0 
//	0 0 0 0 0 0 0 1 1 1 
//	0 1 1 1 0 0 0 1 X 1 
//	0 1 X 1 0 0 0 1 1 1 
	
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
	
	public static void main(String[] args) {
		for(int i : getRandomNums(10,100)) {
			System.out.println(i);
		}
	}
}
