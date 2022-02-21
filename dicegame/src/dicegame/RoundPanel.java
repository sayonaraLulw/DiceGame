package dicegame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RoundPanel extends JPanel{
	// Info
	int dices = 0;
	
	// JLabel
	JLabel[] d = new JLabel[5];
	private int x = 10;
	
	public RoundPanel() {
		for(int i = 0;i < d.length; i++) {
			d[i] = new JLabel("");
			d[i].setBounds(x, 10, 30, 30);
			add(d[i]);
			x += 47;
		}
		this.setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
	}
}
