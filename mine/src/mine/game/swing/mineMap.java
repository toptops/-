package mine.game.swing;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mine.game.data.BoardMap;
import mine.game.data.InnerPixel;
import mine.game.service.BoardService;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

/**
 * Swing으로 그림 그려주기. 
 * 
 * @author top
 *
 */
public class mineMap {

	private BoardService boardService;
	public JFrame frmMinedataprint;
	private JTextField textField1;
	
	/**
	 * Create the application.
	 */
	public mineMap(BoardService boardService) {
		this.boardService = boardService;
		initialize();
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMinedataprint = new JFrame();
		frmMinedataprint.setTitle("MineDataPrint");
		frmMinedataprint.setBounds(100, 100, 722, 450);
		frmMinedataprint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMinedataprint.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 12, 462, 381);
		frmMinedataprint.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[27px][27px][30px][grow][grow]", "[30px][][][][][]"));
		
		paintMinePanel(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(476, 12, 148, 379);
		frmMinedataprint.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		JButton button2 = new JButton();
		button2.setBounds(14, 137, 113, 27);
		panel_1.add(button2);
		button2.setBackground(Color.PINK);
		button2.setText("지뢰 초기화 ");
		
		textField1 = new JTextField();
		textField1.setLocation(14, 101);
		panel_1.add(textField1);
		textField1.setSize(113, 24);
		textField1.setText("10");
		
		JButton button = new JButton();
		button.setBounds(30, 32, 75, 27);
		panel_1.add(button);
		button.setBackground(Color.PINK);
		button.setText("초기화");
		
		JLabel label1 = new JLabel();
		label1.setBounds(0, 76, 148, 18);
		panel_1.add(label1);
		label1.setText("1~99를 입력해주세요");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boardService.setPersonalMinset(true, null, 0);
				boardService.init();
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				paintMinePanel(panel);
			}
		});
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boardService.setPersonalMinset(true, null, Integer.parseInt((textField1.getText())));
				boardService.init();
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				paintMinePanel(panel);
			}
		});
	}
	
	/**
	 * panel을 받아서 Button(픽셀)을 100개 생성하여 각각의 Button와 InnerBoardMap(데이터)매핑시킨다.
	 * 
	 * @param panel
	 */
	public void paintMinePanel(JPanel panel) {
		int X = 0;
		int Y = 0;
		for(InnerPixel pixel : boardService.getBoard().getInnerBoardMap()) {
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
