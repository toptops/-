package mine.game.data;

import java.util.ArrayList;

public class Board {
	private ArrayList<InnerPixel> innerBoardMap;
	private ArrayList<BackPixel> backBoardMap;
	private ArrayList<Pixel> mainBoardMap;

	public Board(){
		innerBoardMap = new ArrayList<>();
		backBoardMap = new ArrayList<>();
		mainBoardMap = new ArrayList<>();
	}
	public Board(ArrayList<InnerPixel> innerBoardMap, ArrayList<BackPixel> backBoardMap) {
		this.innerBoardMap = innerBoardMap;
		this.backBoardMap = backBoardMap;
	}
	
	public ArrayList<InnerPixel> getInnerBoardMap() {
		return innerBoardMap;
	}
	public void setInnerBoardMap(ArrayList<InnerPixel> innerBoardMap) {
		this.innerBoardMap = innerBoardMap;
	}
	public ArrayList<BackPixel> getBackBoardMap() {
		return backBoardMap;
	}
	public void setBackBoardMap(ArrayList<BackPixel> backBoardMap) {
		this.backBoardMap = backBoardMap;
	}
	public ArrayList<Pixel> getMainBoardMap() {
		return mainBoardMap;
	}
	public void setMainBoardMap(ArrayList<Pixel> mainBoardMap) {
		this.mainBoardMap = mainBoardMap;
	}
}
