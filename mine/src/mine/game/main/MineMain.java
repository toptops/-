package mine.game.main;

import java.util.ArrayList;

import mine.game.data.BackPixel;
import mine.game.data.Board;
import mine.game.data.InnerPixel;
import mine.game.data.Pixel;
import mine.game.service.BoardService;
import mine.game.service.GameService;
import mine.game.service.ThreadService;

public class MineMain {
	public static void main(String[] args) {
		BoardService boradService = new BoardService();
		boradService.init();
		
		//test
//		print(boradService.getBoard());
//		System.out.println();
//		System.out.println();
//		printBack(boradService.getBoard());
//		System.out.println();
//		System.out.println();
		printMain(boradService.getBoard());
		
//		GameService gameService = new GameService();
//		
//		ThreadService threadService = new ThreadService(boradService, gameService);
//		threadService.start();
	}
	
	static void printMain(Board board) {
		int check = 0;
		for(Pixel pixel : board.getMainBoardMap()) {
			if(check == 10) {
				System.out.println();
				check = 0;
			}
			
			System.out.print(((BackPixel) pixel).getBackPixelShape() + " ");
			
			check++;
		}
	}

	static void printBack(Board board) {
		int check = 0;
		for(BackPixel pixel : board.getBackBoardMap()) {
			if(check == 10) {
				System.out.println();
				check = 0;
			}
			
			System.out.print(pixel.getBackPixelShape() + " ");
			
			check++;
		}
	}
	
	static void print(Board board)  {
		int check = 0;
		for(InnerPixel pixel : board.getInnerBoardMap()) {
			if(check == 10) {
				System.out.println();
				check = 0;
			}
			if(pixel.getPixelNum() == -1) System.out.print("X "); 
			else System.out.print(pixel.getPixelNum() + " ");

			check++;
		}
	}
}
