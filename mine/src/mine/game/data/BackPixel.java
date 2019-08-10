package mine.game.data;

import mine.game.PixelEnum.PixelType;

public class BackPixel extends Pixel{
	private String backPixelShape;
	
	public BackPixel(int x, int y, PixelType type, String backPixelShape) {
		super(x,y,type);
		this.backPixelShape = backPixelShape;
	}

	public String getBackPixelShape() {
		return backPixelShape;
	}

	public void setBackPixelShape(String backPixelShape) {
		this.backPixelShape = backPixelShape;
	}
	
	
}
