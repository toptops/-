package mine.game.data;

import java.util.ArrayList;

/**
 * 지뢰찾기의 보드의 집합객체. (보드 또한 필요시 상속관계로 나뉠수 있다)
 * innerBoardMap(자료 데이터 타일) 
 * backBoardMap(배경 데이터 타일)
 * mainBoardMap(직접 데이터가 매핑될 타일)
 * 
 * 총 3가지 보드를 관리한다.
 * 
 * @author top
 *
 */
public class BoardMap {
	private ArrayList<InnerPixel> innerBoardMap;
	private ArrayList<BackPixel> backBoardMap;
	private ArrayList<Pixel> mainBoardMap;

	public BoardMap(){
		innerBoardMap = new ArrayList<>();
		backBoardMap = new ArrayList<>();
		mainBoardMap = new ArrayList<>();
	}
	public BoardMap(ArrayList<InnerPixel> innerBoardMap, ArrayList<BackPixel> backBoardMap) {
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
