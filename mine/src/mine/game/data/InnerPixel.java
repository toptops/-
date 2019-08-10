package mine.game.data;

import mine.game.PixelEnum.PixelType;

public class InnerPixel extends Pixel{
	private int pixelNum;
	private boolean isMine;
	
	public InnerPixel(int x, int y, PixelType type) {
		super(x, y, type);
		this.pixelNum = 0;
		this.isMine = false;
	}
	
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
