package mine.game.main;

import mine.game.PixelEnum.PixelType;
import mine.game.service.BoardService;

/**
 * 메인 화면.
 * 픽셀을 초기화하고 화면을 띄워준다.
 * 
 * @author top
 *
 */
public class MineMain {
	public static void main(String[] args) {
		BoardService boardService = new BoardService();
		boardService.setPersonalMinset(true, null);
		boardService.init();
		
		boardService.printBoard(PixelType.back);
		System.out.println();
		System.out.println();
		boardService.printBoard(PixelType.Inner);
		
		
	}
}
