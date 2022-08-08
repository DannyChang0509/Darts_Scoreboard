import java.awt.*;

import javax.swing.*;

public class PlayerPanel extends JPanel{
	
	private static int playerNum = 0;
	private JTextField playerName;
	private JLabel score;
	private JLabel checkOut;
	private JLabel[] history = new JLabel[2];
	
	private String SCORE;
	private String CHECKOUT;
	private String[] HISTORY = new String[20];
	
	
	PlayerPanel(Color bgCol){
		
		this.setBackground(bgCol);
		this.setLayout(null);
		
		
		playerNum ++;
		
		
		this.playerName = new JTextField();
		this.playerName.setPreferredSize(new Dimension(200, 50));
		this.playerName.setBounds(30, 30, 200, 50);
		this.playerName.setBackground(bgCol);
		this.playerName.setBorder(null);
		this.playerName.setFont(new Font("Arial", Font.BOLD, 25));
		this.playerName.setHorizontalAlignment(JTextField.CENTER);
		this.playerName.setText("Player "+String.valueOf(playerNum));

		this.add(this.playerName);
		
		
		this.score = new JLabel();
		this.score.setBounds(0, 90, 260, 100);
		this.score.setFont(new Font("Arial", Font.BOLD, 100));
		this.score.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(this.score);
		
		
		this.checkOut = new JLabel();
		this.checkOut.setBounds(0, 180, 260, 50);
		this.checkOut.setFont(new Font("Arial", Font.BOLD, 20));
		this.checkOut.setHorizontalAlignment(JLabel.CENTER);
		this.checkOut.setForeground(Color.GRAY);
		
		this.add(this.checkOut);
		
		
		for(int i = 0; i < 2; i ++) {
			this.history[i] = new JLabel();
			this.history[i].setBounds(75+60*i, 180, 50, 290);
			this.history[i].setFont(new Font("Arial", Font.PLAIN, 15));
			this.history[i].setHorizontalAlignment(JLabel.CENTER);
			this.history[i].setForeground(Color.GRAY);
			
			this.add(this.history[i]);
		}
		
	}
	
	public void editPlayerName(final boolean B) {
		this.playerName.setEditable(B);
	}
	
	public String getPlayerName() {
		return this.playerName.getText();
	}
	
	public void setDisplay(final String SCORE, final String CHECKOUT, final String[] HISTORY) {
		this.SCORE = SCORE;
		this.CHECKOUT = CHECKOUT;
		this.HISTORY = HISTORY;
	}
	
	public void display() {
		this.score.setText(SCORE);
		this.checkOut.setText(CHECKOUT);
		String[] history = {"<html><body><center>", "<html><body><center>"};
		for(int i = 0; i < 20; i ++) {
			history[i/10] += (HISTORY[i] != null ? HISTORY[i] : "") + "<Br>";
			if((i+1)%10 == 0) {
				history[i/10] += "</center></body><html>";
				this.history[i/10].setText(history[i/10]);
			}
		}
	}
	
}
