package mine.game.data;

import mine.game.PixelEnum.PixelType;

/**
 * 사각형에 숫자, 지뢰를 관리하는 객체
 * pixeLNum ( 픽셀 타입 내부 숫자 )
 * isMine ( 지뢰인지 구분 )
 * 각 픽셀 타입에 대한 숫자와 지뢰를 관리한다. 
 * 
 * 특이사항은 직접 pixelNum을 더해주는 메소드가 있다.
 * 
 */
public class InnerPixel extends Pixel{
	private int pixelNum;
	private boolean isMine;
	
	public InnerPixel(int x, int y, PixelType type) {
		super(x, y, type);
		this.pixelNum = 0;
		this.isMine = false;
	}
	
	/**
	 * �ȼ� ���� 1 ���Ѵ�.
	 * 
	 */
	public void addPixel() {
		this.pixelNum++;
	}
	public int getPixelNum() {
		return pixelNum;
	}
	public void setPixelNum(int pixelNum) {
		this.pixelNum = pixelNum;
	}
	public boolean isMine() {
		return isMine;
	}
	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}
}
