package mine.game.main;

import mine.game.PixelEnum.PixelType;
import mine.game.service.BoardService;

/**
 * ���� ȭ��.
 * �ȼ��� �ʱ�ȭ�ϰ� ȭ���� ����ش�.
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
