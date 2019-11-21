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
 * 보드(메인, inner, back)을 그려주는 서비스 객체 (삭제 또한 여기서 구현하면된다).
 * 보드를 여기서 관리하며 모든 그려주는 이벤틀를 여기서 처리한다.
 * 
 * @author top
 *
 */
public class BoardService{
	private BoardMap board;
	private ArrayList<InnerPixel> innerBoardMap;
	private ArrayList<BackPixel> backBoardMap;
	private ArrayList<Pixel> mainBoardMap;
	
	// 지뢰찾기에서 지뢰의 위치를 나타내는 배열
	int[] minesLoc;
	
	/**
	 * 보드를 초기화하는 메소드.
	 * Inner(숫자,지뢰 데이터), back(타일 모양), Main(메인 보드)를 초기화한다.
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
	 * 지뢰를 랜덤 및 지정할수 있게 하는 메소드
	 * 지뢰를 지정할시 지뢰 개수는 1개이상 100개 미만이다.
	 * 기본 랜덤 사용시 지뢰개수는 10개이다.
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
	 * 보드(inner, back)를 출력해주는 메소드  
	 * 중복 문제가 있다.
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
	 * 맨처음 innerMapBoard를 초기화 해준다.
	 * 10 * 10 칸으로 모든 innerMapBoard의 InnerPixel의 좌표,타입,데이터 값과 지뢰여부 초기화.
	 * 
	 */
	private void pixelInnerBoardInit() {
		for(int x=0; x<10; x++) 
			for(int y=0; y<10; y++) 
				innerBoardMap.add(new InnerPixel(x, y, PixelType.Inner));
	}
	
	/**
	 * 맨처음 backBoardMap을 초기화 해준다.
	 * 10 * 10 칸으로 backBoardMap의 BackPixel의 좌표, 타입, 모양을 초기화
	 * 
	 */
	private void pixelBackBoardInit() {
		for(int x=0; x<10; x++) 
			for(int y=0; y<10; y++) 
				backBoardMap.add(new BackPixel(x, y, PixelType.back,"■"));
	}
	
	/**
	 * 지뢰를 셋팅한다. 
	 * 지뢰 위치를 받은 minesLoc를 통해 ArrayList에 지뢰 설치.
	 * 여기서 mine -1을 하는 이유는 ArrayList는 0부터 시작임으로 -1을 해준다.
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
	 * 모든 지뢰 주변에 대한 값을 설정한다.
	 * 지뢰의 개수는 10개임으로 10개의 지뢰 주변에 대한 값들을 설정한다.
	 * 지뢰 좌표를 기준으로 주변 좌표 arroudMineNumSetBoard(주변 8칸)<- 값에 해당하는 좌표들에 +1을 해준다.
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
	 * Main 보드를 초기화 해주는 부분.
	 * 맨 처음 보드는 기본적으로 모양만 있는 픽셀 타일임으로 backBoardMap을 복사해서 구성한다.
	 * 
	 */
	private void setMainBoard() {
		mainBoardMap.addAll(backBoardMap);
	}

	/**
	 * 보드를 리턴하는 메소드
	 * 
	 * @return
	 */
	public BoardMap getBoard() {
		return board;
	}
}
