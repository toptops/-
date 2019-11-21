package mine.game.service;

import java.util.ArrayList;
import java.util.Arrays;

import mine.game.PixelEnum.PixelType;
import mine.game.data.BackPixel;
import mine.game.data.BoardMap;
import mine.game.data.InnerPixel;
import mine.game.data.Pixel;
import mine.game.utill.Utill;

/**
 * ����(����, inner, back)�� �׷��ִ� ���� ��ü (���� ���� ���⼭ �����ϸ�ȴ�).
 * ���带 ���⼭ �����ϸ� ��� �׷��ִ� �̺�Ʋ�� ���⼭ ó���Ѵ�.
 * 
 * @author top
 *
 */
public class BoardService{
	private BoardMap board;
	private ArrayList<InnerPixel> innerBoardMap;
	private ArrayList<BackPixel> backBoardMap;
	private ArrayList<Pixel> mainBoardMap;
	
	// ����ã�⿡�� ������ ��ġ�� ��Ÿ���� �迭
	int[] minesLoc;
	
	/**
	 * ���带 �ʱ�ȭ�ϴ� �޼ҵ�.
	 * Inner(����,���� ������), back(Ÿ�� ���), Main(���� ����)�� �ʱ�ȭ�Ѵ�.
	 * 
	 */
	public void init() {
		this.board = new BoardMap();
		this.innerBoardMap = this.board.getInnerBoardMap();
		this.backBoardMap = this.board.getBackBoardMap();
		this.mainBoardMap = this.board.getMainBoardMap();
		
		pixelInnerBoardInit();
		pixelBackBoardInit();
		mineInit(minesLoc);
		setMine(minesLoc);
		setMainBoard();
	}
	
	/**
	 * ���ڸ� ���� �� �����Ҽ� �ְ� �ϴ� �޼ҵ�
	 * ���ڸ� �����ҽ� ���� ������ 1���̻� 100�� �̸��̴�.
	 * �⺻ ���� ���� ���ڰ����� 10���̴�.
	 * 
	 * @param isRandom
	 * @param minesLoc
	 */
	public void setPersonalMinset(boolean isRandom, int[] minesLoc, int randomMineCount) {
		if(isRandom) {
			if(randomMineCount > 0 && randomMineCount < 100)
				this.minesLoc = Utill.getRandomNums(randomMineCount, 100);
			else
				this.minesLoc = Utill.getRandomNums(10, 100);
				
		}else {
			if(minesLoc.length > 1 && minesLoc.length < 100) {
				this.minesLoc = Arrays.copyOf(minesLoc, minesLoc.length);
			}else {}
		}
	}
	
	/**
	 * ����(inner, back)�� ������ִ� �޼ҵ�  
	 * �ߺ� ������ �ִ�.
	 * 
	 * @param type
	 */
	public void printBoard(PixelType type) {
		int check = 0;
		
		if(type == PixelType.back) {
			for(BackPixel pixel : backBoardMap) {
				if(check == 10) {
					System.out.println();
					check = 0;
				}
				System.out.print(pixel.getBackPixelShape() + " ");
				check++;
			}
		} else if(type == PixelType.Inner) {
			for(InnerPixel pixel : innerBoardMap) {
				if(check == 10) {
					System.out.println();
					check = 0;
				}
				if(pixel.getPixelNum() == -1) System.out.print("X "); 
				else System.out.print(pixel.getPixelNum() + " ");

				check++;
			}
		}
	}
	
	/**
	 * ��ó�� innerMapBoard�� �ʱ�ȭ ���ش�.
	 * 10 * 10 ĭ���� ��� innerMapBoard�� InnerPixel�� ��ǥ,Ÿ��,������ ���� ���ڿ��� �ʱ�ȭ.
	 * 
	 */
	private void pixelInnerBoardInit() {
		for(int x=0; x<10; x++) 
			for(int y=0; y<10; y++) 
				innerBoardMap.add(new InnerPixel(x, y, PixelType.Inner));
	}
	
	/**
	 * ��ó�� backBoardMap�� �ʱ�ȭ ���ش�.
	 * 10 * 10 ĭ���� backBoardMap�� BackPixel�� ��ǥ, Ÿ��, ����� �ʱ�ȭ
	 * 
	 */
	private void pixelBackBoardInit() {
		for(int x=0; x<10; x++) 
			for(int y=0; y<10; y++) 
				backBoardMap.add(new BackPixel(x, y, PixelType.back,"��"));
	}
	
	/**
	 * ���ڸ� �����Ѵ�. 
	 * ���� ��ġ�� ���� minesLoc�� ���� ArrayList�� ���� ��ġ.
	 * ���⼭ mine -1�� �ϴ� ������ ArrayList�� 0���� ���������� -1�� ���ش�.
	 * 
	 * @param minesLoc
	 */
	private void mineInit(int[] minesLoc) {
		for(int mine : minesLoc) {
			mine -= 1;
			innerBoardMap.get(mine).setMine(Utill.thisMine);
			innerBoardMap.get(mine).setPixelNum(-1);
		}
	}
	
	/**
	 * ��� ���� �ֺ��� ���� ���� �����Ѵ�.
	 * ������ ������ 10�������� 10���� ���� �ֺ��� ���� ������ �����Ѵ�.
	 * ���� ��ǥ�� �������� �ֺ� ��ǥ arroudMineNumSetBoard(�ֺ� 8ĭ)<- ���� �ش��ϴ� ��ǥ�鿡 +1�� ���ش�.
	 * 
	 * @param minesLoc
	 */
	private void setMine(int[] minesLoc) {
		int[][] arroudMineNumSetBoard = Utill.arroudMineNumSetBoard;
		int x = 0;
		int y = 0;
		int site = 0;
		
		for(int i=0;i<minesLoc.length;i++) {
			for(int j=0;j<arroudMineNumSetBoard.length;j++) {
				x = innerBoardMap.get(minesLoc[i] - 1).getX() - arroudMineNumSetBoard[j][0];
				y = innerBoardMap.get(minesLoc[i] - 1).getY() - arroudMineNumSetBoard[j][1];
				
				if( x >= 0 && x < 10 && y >= 0 && y < 10) {
					site = (x * 10) + y;
					if(!innerBoardMap.get(site).isMine())
						innerBoardMap.get(site).addPixel();
				}
			}
		}
	}
	
	/**
	 * Main ���带 �ʱ�ȭ ���ִ� �κ�.
	 * �� ó�� ����� �⺻������ ��縸 �ִ� �ȼ� Ÿ�������� backBoardMap�� �����ؼ� �����Ѵ�.
	 * 
	 */
	private void setMainBoard() {
		mainBoardMap.addAll(backBoardMap);
	}

	/**
	 * ���带 �����ϴ� �޼ҵ�
	 * 
	 * @return
	 */
	public BoardMap getBoard() {
		return board;
	}
}
