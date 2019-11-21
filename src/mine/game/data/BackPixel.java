package mine.game.data;

import mine.game.PixelEnum.PixelType;

/**
 * 게임 상에서 그림을 관리하는 객체
 * Pixel 객체를 상속받아서 X,Y 위치 및 픽셀 타입을 가지고 있다.
 * 해당 객체에서는 그림 및 모양을 설정하도록 만든 Pixel
 * 초기화시 이 객체가 MainBoard에 들어간다.
 * 
 * @author top
 *
 */
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
