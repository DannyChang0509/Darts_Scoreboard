import java.awt.*;
import java.util.Optional;

import javax.swing.*;

public class Window extends JFrame{ 
	
	private PlayerPanel[] playerPanel = new PlayerPanel[2];
	private StartPanel startPanel;
	private ControlPanel controlPanel;
	
	Window(){
		 
		this.setTitle("Darts Scoreboard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("./img/icon.png").getImage());
		this.setResizable(false);
		this.setSize(720, 480);
		this.setLayout(null);
		
		
		this.playerPanel[0] = new PlayerPanel(new Color(154, 220, 255));
		this.playerPanel[0].setBounds(0, 0, 260, 480);
		
		this.add(this.playerPanel[0]);
		
		
		this.playerPanel[1] = new PlayerPanel(new Color(255, 138, 174));
		this.playerPanel[1].setBounds(460, 0, 260, 480);
		
		this.add(this.playerPanel[1]);
		
		
		this.startPanel = new StartPanel(new Color(255, 248, 154));
		this.startPanel.setBounds(260, 0, 200, 480);

		this.add(this.startPanel);
		
		
		this.controlPanel = new ControlPanel(new Color(255, 248, 154));
		this.controlPanel.setBounds(260, 0, 200, 480);

		this.add(this.controlPanel);
		
		
		this.setVisible(true);
	}
	
	public void gameOn(final boolean B) {
		this.startPanel.setVisible(!B);
		this.controlPanel.setVisible(B);
		this.playerPanel[0].editPlayerName(!B);
		this.playerPanel[1].editPlayerName(!B);
	}
	
	public String getPlayerName(final int PLAYER) {
		return this.playerPanel[PLAYER].getPlayerName();
	}
	
	public void setDisplay(final String[] SCORE, final String[] CHECKOUT, final String[][] HISTORY, final int[] LEGS, final int PLAYER) {
		for(int i = 0; i < 2; i ++) {
			this.playerPanel[i].setDisplay(SCORE[i], CHECKOUT[i], HISTORY[i]);
			this.playerPanel[i].display();
		}
		this.controlPanel.setDisplay(LEGS, PLAYER);
		this.controlPanel.display();
	}
	
	public void displayPoints(String[] POINTS) {
		this.controlPanel.displayPoints(POINTS);
	}
	
	public JButton getBtn(final int BTNINDEX) {
		if(BTNINDEX == -1) {
			return this.startPanel.getStartBtn();
		}
		else {
			return this.controlPanel.getBtn(BTNINDEX);
		}
	}
	
	public int getLegs() {
		return this.startPanel.getLegs();
	}
	
	public int getInitScore() {
		return this.startPanel.getInitScore();
	}
	
	public String getInOption() {
		return this.startPanel.getInOption();
	}
	
	public String getOutOption() {
		return this.startPanel.getOutOption();
	}
}
