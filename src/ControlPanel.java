import java.awt.*;

import javax.swing.*;

public class ControlPanel extends JPanel{
	
	private JLabel match;
	private JLabel[] arrow = new JLabel[2];
	private JLabel[] points = new JLabel[3];
	private JButton[] btn = new JButton[27];
	
	private int[] LEGS = new int[3];
	private int PLAYER = 0;
	
	ControlPanel(Color bgCol){
		
		this.setBackground(bgCol);
		this.setLayout(null);

		
		this.match = new JLabel();
		this.match.setBounds(0, 20, 200, 60);
		this.match.setFont(new Font("Arial", Font.BOLD, 30));
		this.match.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(this.match);
		
		
		ImageIcon[] arrowIco = {new ImageIcon("./img/arrowL.png"), new ImageIcon("./img/arrowR.png")};
		for(int i = 0; i < 2; i ++) {
			this.arrow[i] = new JLabel();
			this.arrow[i].setBounds(100*i, 90, 100, 100);
			this.arrow[i].setIcon(arrowIco[i]);
			
			this.add(this.arrow[i]);
		}
		
		
		for(int j = 0; j < 3; j ++) {
			this.points[j] = new JLabel();
			this.points[j].setBounds(10+60*j, 180, 60, 60);
			this.points[j].setFont(new Font("Arial", Font.BOLD, 20));
			this.points[j].setHorizontalAlignment(JLabel.CENTER);
			this.points[j].setForeground(Color.RED);
			
			this.add(this.points[j]);
		}
		
		
		for(int k = 0; k < 23; k ++)
		{
			if(k < 20) {
				this.btn[k] = new JButton(String.valueOf(k+1));
			}
			else
			{
				switch(k) {
					case 20:
						this.btn[k] = new JButton("S");
						break;
					case 21:
						this.btn[k] = new JButton("D");
						break;
					case 22:
						this.btn[k] = new JButton("T");
						break;
				}
			}
			this.btn[k].setFont(new Font("Arial", Font.BOLD, 12));
			this.btn[k].setBounds(50*(k%4),230+30*(int)(k/4),50, 30);
			this.add(this.btn[k]);
		}
		
		this.btn[23] = new JButton("Bull");
		this.btn[23].setBounds(150, 380, 50, 30);
		this.btn[23].setFont(new Font("Arial", Font.BOLD, 9));
		
		this.add(this.btn[23]);
		
		this.btn[24] = new JButton("MISS");
		this.btn[24].setBounds(1, 410, 66, 30);
		this.btn[24].setFont(new Font("Arial", Font.BOLD, 12));
		
		this.add(this.btn[24]);
		
		this.btn[25] = new JButton("SHOT");
		this.btn[25].setBounds(67, 410, 66, 30);
		this.btn[25].setFont(new Font("Arial", Font.BOLD, 11));
		
		this.add(this.btn[25]);
		
		this.btn[26] = new JButton("RESET");
		this.btn[26].setBounds(133, 410, 66, 30);
		this.btn[26].setFont(new Font("Arial", Font.BOLD, 9));
		
		this.add(this.btn[26]);
		
	}
	
	public void setDisplay(final int[] LEGS, final int PLAYER) {
		this.LEGS = LEGS;
		this.PLAYER = PLAYER;
	}
	
	public void display() {
		this.match.setText("<html><body><center>"+"First To: "+LEGS[2]+"<br>"+LEGS[0]+" : "+LEGS[1]+"</center></body></html>");
		this.arrow[PLAYER].setVisible(true);
		this.arrow[(PLAYER+1)%2].setVisible(false);
	}
	
	public void displayPoints(String[] POINTS) {
		for(int i = 0; i < 3; i ++) {
			this.points[i].setText((POINTS[i] != null ?(POINTS[i].equals("S0") ? "MISS":(POINTS[i].equals("S25") ? "S-Bull":(POINTS[i].equals("D25") ? "D-Bull":POINTS[i]))):""));
		}
	}
	
	public JButton getBtn(final int BTNINDEX) {
		return btn[BTNINDEX];
	}
	
}
