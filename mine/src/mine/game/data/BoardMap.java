package mine.game.data;

import java.util.ArrayList;

/**
 * ����ã���� ������ ���հ�ü. (���� ���� �ʿ�� ��Ӱ���� ������ �ִ�)
 * innerBoardMap(�ڷ� ������ Ÿ��) 
 * backBoardMap(��� ������ Ÿ��)
 * mainBoardMap(���� �����Ͱ� ���ε� Ÿ��)
 * 
 * �� 3���� ���带 �����Ѵ�.
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
