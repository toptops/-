package mine.game.service;

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
