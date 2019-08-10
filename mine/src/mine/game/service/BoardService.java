package mine.game.service;

import java.util.ArrayList;

import mine.game.PixelEnum.PixelType;
import mine.game.data.BackPixel;
import mine.game.data.Board;
import mine.game.data.InnerPixel;
import mine.game.data.Pixel;
import mine.game.utill.Utill;

public class BoardService {
	private Board board;
	
	public BoardService() {
		this.board = new Board();
	}
	
	public void init() {
		ArrayList<InnerPixel> innerBoardMap = this.board.getInnerBoardMap();
		ArrayList<BackPixel> backBoardMap = this.board.getBackBoardMap();
		ArrayList<Pixel> mainBoardMap = this.board.getMainBoardMap();
		
		int[] minesLoc = Utill.getRandomNums(10, 100);
		
		pixelInnerBoardInit(innerBoardMap);
		pixelBackBoardInit(backBoardMap);
		mineInit(innerBoardMap, minesLoc);
		setMine(innerBoardMap, minesLoc);
		setMainBoard(mainBoardMap, backBoardMap);
	}
	
	public void openAllPixel(int x, int y ) {
		
	}
	
	public void openParticlePixel() {
		
	}
	
	private void pixelInnerBoardInit(ArrayList<InnerPixel> innerBoardMap) {
		for(int x=0; x<10; x++) 
			for(int y=0; y<10; y++) 
				innerBoardMap.add(new InnerPixel(x, y, PixelType.Inner));
	}
	
	private void pixelBackBoardInit(ArrayList<BackPixel> backBoardMap) {
		for(int x=0; x<10; x++) 
			for(int y=0; y<10; y++) 
				backBoardMap.add(new BackPixel(x, y, PixelType.back,"бс"));
	}
	
	private void mineInit(ArrayList<InnerPixel> innerBoardMap, int[] minesLoc) {
		for(int mine : minesLoc) {
			mine -= 1;
			innerBoardMap.get(mine).setMine(Utill.thisMine);
			innerBoardMap.get(mine).setPixelNum(-1);
		}
	}
	
	private void setMine(ArrayList<InnerPixel> innerBoardMap, int[] minesLoc) {
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
	
	private void setMainBoard(ArrayList<Pixel> mainBoardMap, ArrayList<BackPixel> backBoardMap) {
		mainBoardMap.addAll(backBoardMap);
	}

	public Board getBoard() {
		return board;
	}
}
