package mine.game.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;

import mine.game.data.BoardMap;
import mine.game.data.InnerPixel;

import java.awt.BorderLayout;
import java.awt.Color;

public class mineMap {

	private BoardMap boardMap;
	public JFrame frmMinedataprint;
	
	/**
	 * Create the application.
	 */
	public mineMap(BoardMap boardMap) {
		this.boardMap = boardMap;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMinedataprint = new JFrame();
		frmMinedataprint.setTitle("MineDataPrint");
		frmMinedataprint.setBounds(100, 100, 480, 380);
		frmMinedataprint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMinedataprint.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmMinedataprint.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[27px][27px][]", "[27px]"));
		
		int X = 0;
		int Y = 0;
		for(InnerPixel pixel : boardMap.getInnerBoardMap()) {
			if(Y == 10) {
				Y=0;
				X++;
			}
			
			JButton button = new JButton();
			button.setBackground(Color.PINK);
			
			if(pixel.getPixelNum() == -1) 
				button.setText("X");
			else if(pixel.getPixelNum() == 0)
				button.setText("  ");
			else 
				button.setText(pixel.getPixelNum()+""); 
			
			panel.add(button, "cell "+X+" "+Y);
			Y++;
		}
	}
}
