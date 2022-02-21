package dicegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Nickname extends JFrame implements ActionListener {
	
	// Logo
	private ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("logo.png"));
	
	// JLabel
	private JLabel text = new JLabel("Please type in your desired nicknames");
	private JLabel p1 = new JLabel("Player 1");
	private JLabel p2 = new JLabel("Player 2");
	
	// JTextField
	private JTextField input1 = new JTextField("");
	private JTextField input2 = new JTextField("");
	
	// JButtons
	private JButton next = new JButton("Next");
	
	public Nickname() {
		text.setBounds(10, 10, 250, 15);
		add(text);
		
		p1.setBounds(10, 50, 50, 15);
		add(p1);
		
		p2.setBounds(200, 50, 50, 15);
		add(p2);
		
		input1.setBounds(10, 75, 125, 20);
		add(input1);
		
		input2.setBounds(200, 75, 125, 20);
		add(input2);
		
		next.setBounds(125, 120, 75, 20);
		add(next);
		next.addActionListener(this);
		
		// GUI settings
		this.setLayout(null);
		this.setSize(355, 200);
		this.setTitle("Select your nicknames");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setIconImage(logo.getImage());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == next) {
			this.setVisible(false);
			GUI g = new GUI();
			g.p1.setText(input1.getText());
			g.p2.setText(input2.getText());
			
			// If the input is empty, set name to unknown
			if(input1.getText().isEmpty()) {
				g.p1.setText("Unknown");
			}
			if(input2.getText().isEmpty()) {
				g.p2.setText("Unknown");
			}
		}
	}
}
