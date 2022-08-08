import java.awt.*;

import javax.swing.*;

public class StartPanel extends JPanel{
	
	private JLabel firstTo;
	private JSpinner legs;
	private JLabel initScore;
	private JComboBox<Integer> zeroOneGame;
	private ButtonGroup[] btnGroup = new ButtonGroup[2];
	private JLabel inOption;
	private JRadioButton[] inMode = new JRadioButton[3];
	private JLabel outOption;
	private JRadioButton[] outMode = new JRadioButton[3];
	private JButton startBtn;
	
	StartPanel(Color bgCol){
		
		this.setBackground(bgCol);
		this.setLayout(null);
		
		
		this.firstTo = new JLabel();
		this.firstTo.setBounds(20, 50, 100, 30);
		this.firstTo.setFont(new Font("Arial", Font.BOLD, 20));
		this.firstTo.setHorizontalAlignment(JLabel.CENTER);
		this.firstTo.setText("First To: ");
		
		this.add(this.firstTo);
		
		
		this.legs = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
		this.legs.setBounds(120, 50, 50, 30);
		((JSpinner.DefaultEditor)legs.getEditor()).getTextField().setHorizontalAlignment(JTextField.CENTER);
		
		this.add(this.legs);
		
		
		this.initScore = new JLabel();
		this.initScore.setBounds(15, 100, 90, 30);
		this.initScore.setFont(new Font("Arial", Font.BOLD, 20));
		this.initScore.setHorizontalAlignment(JLabel.CENTER);
		this.initScore.setText("01Game: ");
		
		this.add(this.initScore);
		
		
		Integer[] games = {301, 501, 701, 901, 1101, 1501};
		this.zeroOneGame = new JComboBox<Integer>();
		this.zeroOneGame.setBounds(115, 100, 70, 30);
		for(int i: games) {
			this.zeroOneGame.addItem(i);
		}
		((JLabel)this.zeroOneGame.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		
		this.add(this.zeroOneGame);
		
		
		this.inOption = new JLabel();
		this.inOption.setBounds(50, 150, 100, 15);
		this.inOption.setFont(new Font("Arial", Font.BOLD, 15));
		this.inOption.setHorizontalAlignment(JLabel.CENTER);
		this.inOption.setText("In Option: ");
		
		this.add(this.inOption);
		
		
		btnGroup[0] = new ButtonGroup();
		
		String[] in = {"OI", "DI", "MI"};
		
		for(int j = 0; j < 3; j ++) {
			this.inMode[j] = new JRadioButton(in[j]);
			this.inMode[j].setBounds(10+60*j, 180, 60, 30);
			this.inMode[j].setHorizontalAlignment(JRadioButton.CENTER);
			this.inMode[j].setActionCommand(in[j]);
			
			btnGroup[0].add(inMode[j]);
			
			this.add(inMode[j]);
		}
		this.inMode[0].setSelected(true);
		
		
		this.outOption = new JLabel();
		this.outOption.setBounds(50, 230, 100, 15);
		this.outOption.setFont(new Font("Arial", Font.BOLD, 15));
		this.outOption.setHorizontalAlignment(JLabel.CENTER);
		this.outOption.setText("Out Option: ");
		
		this.add(this.outOption);
		
		
		btnGroup[1] = new ButtonGroup();
		
		String[] out = {"OO", "DO", "MO"};
		
		for(int k = 0; k < 3; k ++) {
			this.outMode[k] = new JRadioButton(out[k]);
			this.outMode[k].setBounds(10+60*k, 260, 60, 30);
			this.outMode[k].setHorizontalAlignment(JRadioButton.CENTER);
			this.outMode[k].setActionCommand(out[k]);
			
			btnGroup[1].add(outMode[k]);
			
			this.add(outMode[k]);
		}
		this.outMode[0].setSelected(true);
		
		
		this.startBtn = new JButton("START");
		this.startBtn.setBounds(50, 330, 100, 30);
		
		this.add(startBtn);
	}
	
	public JButton getStartBtn() {
		return this.startBtn;
	}
	
	public int getLegs() {
		return (int)this.legs.getValue();
	}
	
	public int getInitScore() {
		return (int)this.zeroOneGame.getSelectedItem();
	}
	
	public String getInOption() {
		return (String)this.btnGroup[0].getSelection().getActionCommand();
	}
	
	public String getOutOption() {
		return (String)this.btnGroup[1].getSelection().getActionCommand();
	}
}
