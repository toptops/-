package mine.game.service;

/**
 * 게임을 구현하게 되면 사용될 쓰레드 서비스.
 * 미구현
 * 
 * @author top
 *
 */
public class ThreadService {
	private BoardService boradService;
	private GameService gameService;
	
	public ThreadService(BoardService boradService, GameService gameService) {
		this.boradService = boradService;
		this.gameService = gameService;
	}
	
	public void start() {
		
	}
}
