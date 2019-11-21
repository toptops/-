package mine.game.data;

import mine.game.PixelEnum.PixelType;

/**
 * �簢���� ����, ���ڸ� �����ϴ� ��ü
 * pixeLNum ( �ȼ� Ÿ�� ���� ���� )
 * isMine ( �������� ���� )
 * �� �ȼ� Ÿ�Կ� ���� ���ڿ� ���ڸ� �����Ѵ�. 
 * 
 * Ư�̻����� ���� pixelNum�� �����ִ� �޼ҵ尡 �ִ�.
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
