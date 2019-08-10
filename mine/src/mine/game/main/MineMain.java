package mine.game.main;

import java.awt.EventQueue;

import mine.game.PixelEnum.PixelType;
import mine.game.service.BoardService;
import mine.game.swing.mineMap;

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
		
		boardService.printBoard(PixelType.Inner);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mineMap window = new mineMap(boardService.getBoard());
					window.frmMinedataprint.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
