package mine.game.data;

import mine.game.PixelEnum.PixelType;

/**
 * �⺻ �ȼ� Ÿ���� ��Ÿ����.
 * ��ǥ X, Y�� Type�� �ִ�.
 * 
 * @author top
 *
 */
public abstract class Pixel {
	private int x;
	private int y;
	private PixelType type;
	
	public Pixel(int x, int y, PixelType type) {
		this.x = x;
		this.y = y;		 
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public PixelType getPixelType () {
		return this.type;
	}
}
