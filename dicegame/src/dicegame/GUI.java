package dicegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener{
	// Include classes
	private Dicegame dg = new Dicegame();
	private RoundPanel panel1 = new RoundPanel();
	private RoundPanel panel2 = new RoundPanel();
	
	// Logo
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("logo.png"));
	
	// Temporary points
	private int diced;
	
	// JLabel
	JLabel p1 = new JLabel("", SwingConstants.LEFT);
	JLabel p2 = new JLabel("", SwingConstants.RIGHT);
	
	private JLabel ppl1 = new JLabel("Pass");
	private JLabel ppl2 = new JLabel("Pass");
	
	private JLabel score1 = new JLabel("0");
	private JLabel score2 = new JLabel("0");
	
	private JLabel winner = new JLabel("Winner");
	private JLabel draw = new JLabel("Draw");
	private JLabel roundLabel = new JLabel("Round 1 of 5");
	private JLabel pleaseStart = new JLabel("Please press start");
	
	// JPanel
	private JPanel pnl1 = new JPanel();
	private int y1 = 0;
	private JScrollPane scrollpane1 = new JScrollPane(pnl1, 
			JScrollPane.VERTICAL_SCROLLBAR_NEVER,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	private JPanel pnl2 = new JPanel();
	private int y2 = 0;
	private JScrollPane scrollpane2 = new JScrollPane(pnl2, 
			JScrollPane.VERTICAL_SCROLLBAR_NEVER,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	// JButtons
	private JButton pd1 = new JButton("Dice");
	private JButton pp1 = new JButton("Pass");
	
	private JButton pd2 = new JButton("Dice");
	private JButton pp2 = new JButton("Pass");
	
	private JButton newround = new JButton("Start");
	
	// Fonts
	Font player = new Font("Sans-Serif", Font.BOLD, 25);
	Font pass = new Font("Sans-Serif", Font.PLAIN, 15);
	Font result = new Font("Sans-Serif", Font.PLAIN, 20);
	
	// Dices
	ImageIcon dice1 = new ImageIcon ("d1.png");
	ImageIcon dice2 = new ImageIcon ("d2.png");
	ImageIcon dice3 = new ImageIcon ("d3.png");
	ImageIcon dice4 = new ImageIcon ("d4.png");
	ImageIcon dice5 = new ImageIcon ("d5.png");
	ImageIcon dice6 = new ImageIcon ("d6.png");
	
	public GUI() {
		// JLabel
		pleaseStart.setForeground(Color.BLACK);
		pleaseStart.setVisible(true);
		pleaseStart.setBounds(310, 20, 150, 20);
		add(pleaseStart);
		
		roundLabel.setForeground(Color.BLACK);
		roundLabel.setVisible(false);
		roundLabel.setBounds(325, 20, 75, 20);
		add(roundLabel);
		
		winner.setFont(result);
		winner.setForeground(Color.green);
		winner.setVisible(false);
		add(winner);
		
		draw.setBounds(340, 100, 75, 75);
		draw.setFont(result);
		draw.setForeground(Color.orange);
		draw.setVisible(false);
		add(draw);
		
		score1.setBounds(305, 55, 75, 75);
		score1.setFont(player);
		add(score1);
		
		score2.setBounds(405, 55, 75, 75);
		score2.setFont(player);
		add(score2);
		
		p1.setBounds(20, 20, 200, 75);
		p1.setFont(player);
		add(p1);
		
		p2.setBounds(500, 20, 200, 75);
		p2.setFont(player);
		add(p2);
		
		ppl1.setBounds(150, 20, 100, 75);
		ppl1.setFont(pass);
		ppl1.setForeground(Color.red);
		add(ppl1);
		ppl1.setVisible(false);
		
		ppl2.setBounds(500, 20, 100, 75);
		ppl2.setFont(pass);
		ppl2.setForeground(Color.red);
		add(ppl2);
		ppl2.setVisible(false);
		
		// JButtons
		pd1.setBounds(20, 500, 100, 30);
		add(pd1);
		pd1.addActionListener(this);
		
		pp1.setBounds(150, 500, 100, 30);
		add(pp1);
		pp1.addActionListener(this);
		
		pd2.setBounds(475, 500, 100, 30);
		add(pd2);
		pd2.addActionListener(this);
		
		pp2.setBounds(605, 500, 100, 30);
		add(pp2);
		pp2.addActionListener(this);
		
		newround.setBounds(310, 500, 100, 30);
		add(newround);
		newround.addActionListener(this);
		
		// JPanel
		pnl1.setLayout(null);
		pnl1.setPreferredSize(new Dimension(250, 1000));
		scrollpane1.setBounds(20, 150, 250, 305);
		this.add(scrollpane1);
		
		pnl2.setLayout(null);
		pnl2.setPreferredSize(new Dimension(250, 1000));
		scrollpane2.setBounds(455, 150, 250, 305);
		this.add(scrollpane2);
		
		// GUI settings
		this.setLayout(null);
		this.setSize(750, 600);
		this.setTitle("Dicegame by Oscar Lam");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setIconImage(logo.getImage());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newround) { // New round
			if(dg.lastRound() == false && dg.checkBlocked(1) && dg.checkBlocked(2)){
				panel1 = new RoundPanel();
				panel2 = new RoundPanel();
				
				panel1.setBounds(0, y1, 252, 60);
				y1 += 61;
				pnl1.add(panel1);
				
				panel2.setBounds(0, y2, 252, 60);
				y2 += 61;
				pnl2.add(panel2);
				
				this.repaint();
				dg.addRound();
				
				// Unblock
				dg.unblockPlayer(1);
				dg.unblockPlayer(2);
				
				// Unpass
				ppl1.setVisible(false);
				ppl2.setVisible(false);
				
				// Unred
				p1.setForeground(Color.black);
				p2.setForeground(Color.black);
				
				// Refresh roundLabel
				roundLabel.setText("Round " + dg.currentRound() + " " + "of " + dg.maxRounds());
			}
			
			// Sets Newround button text after first round started
			if(dg.checkStart() == false) {
				newround.setText("Next round");
				pleaseStart.setVisible(false);
				roundLabel.setVisible(true);
				dg.start();
			}
			
			// Check if round equals the max rounds, if yes set ended to true
			if(dg.lastRound()) {
				dg.end();
			}
		}else if(e.getSource() == pd1) { // Player 1 dice
			if(panel1.dices != panel1.d.length && dg.checkBlocked(1) == false) { // If player1 is not blocked
				diced = dg.dice();
				
				// Set the icons for the specific diced number
				switch(diced) {
				case 1:
					panel1.d[panel1.dices].setIcon(dice1);
					break;
				case 2:
					panel1.d[panel1.dices].setIcon(dice2);
					break;
				case 3:
					panel1.d[panel1.dices].setIcon(dice3);
					break;
				case 4:
					panel1.d[panel1.dices].setIcon(dice4);
					break;
				case 5:
					panel1.d[panel1.dices].setIcon(dice5);
					break;
				case 6:
					panel1.d[panel1.dices].setIcon(dice6);
					break;
				}
					
				// Check if diced number is even (or uneven)
				if(diced % 2 == 0) {
					dg.addToCurrent(1, diced);
				} else {
					dg.blockPlayer(1);
					dg.resetCurrent(1);
				}
				panel1.dices += 1;
				
				// Check for 5 dices
				if(panel1.dices == dg.getMaxDices()) {
					dg.blockPlayer(1);
					dg.addPoints(1);
					dg.resetCurrent(1);
				}
			}
		}else if(e.getSource() == pp1 && dg.checkBlocked(1) == false) {
			dg.blockPlayer(1);
			ppl1.setVisible(true);
			dg.addPoints(1);
			dg.resetCurrent(1);
		}else if(e.getSource() == pd2) { // Player 2 dice
			if(panel2.dices != panel2.d.length && dg.checkBlocked(2) == false) { // If player2 is not blocked
				diced = dg.dice();
				
				// Set the icons for the specific diced number
				switch(diced) {
				case 1:
					panel2.d[panel2.dices].setIcon(dice1);
					break;
				case 2:
					panel2.d[panel2.dices].setIcon(dice2);
					break;
				case 3:
					panel2.d[panel2.dices].setIcon(dice3);
					break;
				case 4:
					panel2.d[panel2.dices].setIcon(dice4);
					break;
				case 5:
					panel2.d[panel2.dices].setIcon(dice5);
					break;
				case 6:
					panel2.d[panel2.dices].setIcon(dice6);
					break;
				}
				
				// Check if diced number is even (or uneven)
				if(diced % 2 == 0) {
					dg.addToCurrent(2, diced);
				} else {
					dg.blockPlayer(2);
					dg.resetCurrent(2);
				}
				panel2.dices += 1;
				
				// Check for 5 dices
				if(panel2.dices == dg.getMaxDices()) {
					dg.addPoints(2);
					dg.resetCurrent(2);
					dg.blockPlayer(2);
				}
			}
		}else if(e.getSource() == pp2 && dg.checkBlocked(2) == false) {
			dg.blockPlayer(2);
			ppl2.setVisible(true);
			dg.addPoints(2);
			dg.resetCurrent(2);
		}		
		
		if(dg.checkBlocked(1)) {
			p1.setForeground(Color.red);
		}
		if(dg.checkBlocked(2)) {
			p2.setForeground(Color.red);
		}
		
		// Refresh score
		score1.setText(String.valueOf(dg.getPoints1()));
		score2.setText(String.valueOf(dg.getPoints2()));
		
		// End
		if(dg.checkEnd()){
			// Hide labels and buttons
			ppl1.setVisible(false);
			ppl2.setVisible(false);
			pp1.setVisible(false);
			pp2.setVisible(false);
			pd1.setVisible(false);
			pd2.setVisible(false);
			newround.setVisible(false);
			
			// Check who won or draw
			if(dg.getPoints1() > dg.getPoints2()) {
				p1.setForeground(Color.green);
				winner.setBounds(20, 90, 100, 75);
				winner.setVisible(true);
			}else if(dg.getPoints1() < dg.getPoints2()){
				p2.setForeground(Color.green);
				winner.setBounds(640, 90, 100, 75);
				winner.setVisible(true);
			}else if(dg.getPoints1() == dg.getPoints2()) {
				p1.setForeground(Color.orange);
				p2.setForeground(Color.orange);
				draw.setVisible(true);
			}
		}
	}
}