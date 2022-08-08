import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;

public class ZeroOneGame  implements ActionListener{
	
	private Window win;
	private JButton startBtn;
	private JButton[] btn = new JButton[27];
	private int[] legs = new int[3];
	private int initScore;
	private String inOption;
	private String outOption;
	private Score[] score = new Score[2];
	private int player;
	private String[] temPoint = {"S", "0"};
	private String[] points = new String[3];
	
	ZeroOneGame(Window win){
		this.win = win;
		this.win.gameOn(false);
		this.startBtn = win.getBtn(-1);
		this.startBtn.addActionListener(this);
		for(int i = 0; i < 27; i ++) {
			btn[i] = win.getBtn(i);
			btn[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startBtn) {
			this.legs = new int[3];
			this.legs[2] = this.win.getLegs();
			this.initScore = this.win.getInitScore();
			this.inOption = this.win.getInOption();
			this.outOption = this.win.getOutOption();
			this.player = 0;
			this.gameInit();
			this.win.gameOn(true);
		}
		for(int i = 0; i < 27; i ++) {
			if(e.getSource() == this.btn[i]) {
				switch(i) {
					case 23:
						this.temPoint[1] = "25";
						break;
					case 24:
						this.temPoint[1] = "0";
						break;
					case 25:
						if((this.temPoint[0]+this.temPoint[1]).equals("T25")) {
							JOptionPane.showMessageDialog(this.win, "No Triple Bull");
							break;
						}
						int darts = score[this.player].getDarts();
						final int RE = score[this.player].shot(this.temPoint[0]+this.temPoint[1]);
						points[darts] = this.temPoint[0]+this.temPoint[1];
						this.win.displayPoints(points);
						if(RE == -1) {
							JOptionPane.showMessageDialog(this.win, "In Option: " + inOption);
						}
						else if (RE == -2) {
							JOptionPane.showMessageDialog(this.win, "Out Option: " + outOption);
						}
						else if (RE == -3) {
							JOptionPane.showMessageDialog(this.win, "BUST");
						}
						else if (RE == 0) {
							legs[this.player] += 1;
							if(legs[this.player] < legs[2]) {
								this.player = (this.player+1)%2;
								for(int j = 0; j < 2; j ++) {
									this.score[j] = new Score(initScore, inOption, outOption);
								}
								this.gameInit();
								JOptionPane.showMessageDialog(this.win, "FINISH");
							}
							else {
								this.win.setDisplay(new String[2], new String[2], new String[2][20],this.legs, this.player);
								JOptionPane.showMessageDialog(this.win, this.win.getPlayerName(this.player)+" WIN!");
								this.gameFin();
								this.win.gameOn(false);
							}
							break;
						}
						darts = score[this.player].getDarts();
						
						if(darts == 0) {
							this.player = (this.player+1)%2;
							if(RE > 0) {
								JOptionPane.showMessageDialog(this.win, "CHANGE");
							}
							this.points = new String[3];
							this.win.displayPoints(points);
						}
						
						String[] score = {String.valueOf(this.score[0].getScore()), String.valueOf(this.score[1].getScore())};
						String[] checkOut =  {this.score[0].getCheckOut(3-darts), this.score[1].getCheckOut(3-darts),};
						String[][] history = {this.score[0].getPreScore(), this.score[1].getPreScore()};
						this.win.setDisplay(score, checkOut, history, this.legs, this.player);
						
						this.temPoint[0] = "S";
						this.temPoint[1] = "0";
						break;
					case 26:
						this.temPoint[0] = "S";
						this.temPoint[1] = "0";
						break;
					default:
						if(i < 20) {
							this.temPoint[1] = this.btn[i].getText();
						}
						else {
							this.temPoint[0] = this.btn[i].getText();
						}
				}
				break;
			}
		}
	}
	
	private void gameInit() {
		for(int i = 0; i < 2; i ++) {
			this.score[i] = new Score(initScore, inOption, outOption);
		}
		String[] score = {String.valueOf(this.score[0].getScore()), String.valueOf(this.score[1].getScore())};
		String[] checkOut =  {this.score[0].getCheckOut(3), this.score[1].getCheckOut(3)};
		String[][] history = {this.score[0].getPreScore(), this.score[1].getPreScore()};
		points = new String[3];
		this.win.displayPoints(points);
		this.win.setDisplay(score, checkOut, history, this.legs, this.player);
	}
	
	private void gameFin() {
		points = new String[3];
		this.win.displayPoints(points);
		this.win.setDisplay(new String[2], new String[2], new String[3][20], this.legs, this.player);
	}
}
