package mine.game.main;

import java.awt.EventQueue;

import mine.game.PixelEnum.PixelType;
import mine.game.service.BoardService;
import mine.game.swing.mineMap;

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
		boardService.setPersonalMinset(true, null, 0);
		boardService.init();
		boardService.printBoard(PixelType.Inner);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mineMap window = new mineMap(boardService);
					window.frmMinedataprint.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
