
public class Score {
	private String[] preScore = new String[20];
	private int score;
	private String inMode;
	private String outMode;
	private int darts = 0;
	private int rounds = 0;
	private boolean isIn = true;
	
	Score(int initScore, String inMode, String outMode){
		this.score = initScore;
		this.preScore[0] = String.valueOf(initScore);
		this.inMode = inMode;
		this.outMode = outMode;
	}
	
	public int shot(final String P) {
		if(!(this.isIn && this.inMode.equalsIgnoreCase("MI") && P.charAt(0) == 'S') && !(this.isIn && this.inMode.equalsIgnoreCase("DI") && P.charAt(0) != 'D'))
		{
			this.isIn = false;
			this.score -= Integer.valueOf(P.substring(1))*(P.charAt(0) == 'T' ? 3 : (P.charAt(0) == 'D' ? 2 : 1));
			if(this.score > 0)
			{
				this.darts ++;
				if(this.darts == 3)
				{
					this.darts = 0;
					this.rounds ++;
					this.preScore[this.rounds] = String.valueOf(this.score);
				}
				
				return this.score;
			}
			else if(this.score == 0){
				if((this.outMode.equalsIgnoreCase("DO") && P.charAt(0) != 'D') || (this.outMode.equalsIgnoreCase("MO") && P.charAt(0) == 'S')) {
					this.score = Integer.valueOf(this.preScore[this.rounds]);
					this.darts = 0;
					this.rounds ++;
					this.preScore[this.rounds] = String.valueOf(this.score);
					
					return -2;
				}
				else {
					this.darts ++;
					if(this.darts == 3)
					{
						this.darts = 0;
						this.rounds ++;
						this.preScore[this.rounds] = String.valueOf(this.score);
					}
					
					return 0;
				}
			}
			else {
				this.score = Integer.valueOf(this.preScore[this.rounds]);
				this.darts = 0;
				this.rounds ++;
				this.preScore[this.rounds] = String.valueOf(this.score);
				
				return -3;
			}
		}
		this.darts ++;
		if(this.darts == 3)
		{
			this.darts = 0;
			this.rounds ++;
			this.preScore[this.rounds] = String.valueOf(this.score);
			return this.score;
		}
		else
		{
			return -1;
		}
	}
	
	private String getFinishes(final int R) {
		
		final String[][] CHECKOUT4DO_3 = {
				{"170", "T20 T20 Bull"},
				{"167", "T20 T19 Bull"},
				{"164", "T20 T18 Bull"},
				{"161", "T20 T17 Bull"},
				{"160", "T20 T20 D20"},
				{"158", "T20 T20 D19"},
				{"157", "T20 T19 D20"},
				{"156", "T20 T20 D18"},
				{"155", "T20 T19 D19"},
				{"154", "T20 T18 D20"},
				{"153", "T20 T19 D18"},
				{"152", "T20 T20 D16"},
				{"151", "T20 T17 D20"},
				{"150", "T20 T18 D18"},
				{"149", "T20 T19 D16"},
				{"148", "T20 T16 D20"},
				{"147", "T20 T17 D18"},
				{"146", "T20 T18 D16"},
				{"145", "T20 T15 D20"},
				{"144", "T20 T20 D12"},
				{"143", "T20 T17 D16"},
				{"142", "T20 T14 D20"},
				{"141", "T20 T19 D12"},
				{"140", "T20 T20 D10"},
				{"139", "T20 T19 D11"},
				{"138", "T20 T18 D12"},
				{"137", "T20 T19 D10"},
				{"136", "T20 T20 D8"},
				{"135", "Bull T15 D20"},
				{"134", "T20 T14 D16"},
				{"133", "T20 T19 D8"},
				{"132", "Bull T14 D20"},
				{"131", "T20 T13 D16"},
				{"130", "T20 S20 Bull"},
				{"129", "T19 T16 D12"},
				{"128", "T18 T14 D16"},
				{"127", "T20 T17 D8"},
				{"126", "T19 T18 Bull"},
				{"125", "25 T20 D20"},
				{"124", "T20 T14 D11"},
				{"123", "T19 T16 D9"},
				{"122", "T18 T20 D4"},
				{"121", "T20 T11 D14"},
				{"120", "T20 S20 D20"},
				{"119", "T19 T12 D13"},
				{"118", "T20 S18 D20"},
				{"117", "T20 S17 D20"},
				{"116", "T20 S16 D20"},
				{"115", "T20 S15 D20"},
				{"114", "T18 S20 D20"},
				{"113", "T19 S16 D20"},
				{"112", "T20 S12 D20"},
				{"111", "T20 S11 D20"},
				{"110", "T20 S10 D20"},
				{"109", "T20 S9 D20"},
				{"108", "T18 S14 D20"},
				{"107", "T19 S10 D20"},
				{"106", "T20 S14 D16"},
				{"105", "T20 S13 D16"},
				{"104", "T19 S15 D16"},
				{"103", "T19 S10 D18"},
				{"102", "T20 S10 D16"},
				{"101", "T20 S9 D16"},
				{"100", "T20 S8 D16"},
				{"99", "T19 S10 D16"}
		};
		final String[][] CHECKOUT4DO_2 = {
				{"110", "T20 Bull"},
				{"107", "T19 Bull"},
				{"104", "T18 Bull"},
				{"101", "T17 Bull"},
				{"100", "T20 D20"},
				{"98", "T20 D19"},
				{"97", "T19 D20"},
				{"96", "T20 D18"},
				{"95", "T19 D19"},
				{"94", "T18 D20"},
				{"93", "T19 D18"},
				{"92", "T20 D16"},
				{"91", "T17 D20"},
				{"90", "T20 D15"},
				{"89", "T19 D16"},
				{"88", "T16 D20"},
				{"87", "T17 D18"},
				{"86", "T18 D16"},
				{"85", "T15 D20"},
				{"84", "T20 D12"},
				{"83", "T17 D16"},
				{"82", "T14 D20"},
				{"81", "T19 D12"},
				{"80", "T20 D10"},
				{"79", "T13 D20"},
				{"78", "T18 D12"},
				{"77", "T19 D10"},
				{"76", "T20 D8"},
				{"75", "T17 D12"},
				{"74", "T14 D16"},
				{"73", "T19 D8"},
				{"72", "T16 D12"},
				{"71", "T13 D16"},
				{"70", "T10 D20"},
				{"69", "T15 D12"},
				{"68", "T20 D4"},
				{"67", "T17 D8"},
				{"66", "T10 D18"},
				{"65", "T19 D4"},
				{"64", "T16 D8"},
				{"63", "T13 D12"},
				{"62", "T10 D16"},
				{"61", "T15 D8"},
				{"60", "S20 D20"},
				{"59", "S19 D20"},
				{"58", "S18 D20"},
				{"57", "S17 D20"},
				{"56", "S16 D20"},
				{"55", "S15 D20"},
				{"54", "S14 D20"},
				{"53", "S13 D20"},
				{"52", "S12 D20"},
				{"51", "S11 D20"},
				{"50", "S10 D20"},
				{"49", "S9 D20"},
				{"48", "S8 D20"},
				{"47", "S15 D16"},
				{"46", "S14 D16"},
				{"45", "S13 D16"},
				{"44", "S12 D16"},
				{"43", "S11 D16"},
				{"42", "S10 D16"},
				{"41", "S9 D16"},
				{"39", "S7 D16"},
				{"37", "S5 D16"},
				{"35", "S3 D16"},
				{"33", "S17 D8"},
				{"31", "S15 D8"},
				{"29", "S13 D8"},
				{"27", "S11 D8"},
				{"25", "S17 D4"},
				{"23", "S7 D8"},
				{"21", "S5 D8"},
				{"19", "S3 D8"},
				{"17", "S1 D8"},
				{"15", "S7 D4"},
				{"13", "S5 D4"},
				{"11", "S3 D4"},
				{"9", "S3 D3"},
				{"7", "S3 D2"},
				{"5", "S1 D2"},
				{"3", "S1 D1"},
		};
		final String[][] CHECKOUT4DO_1 = {
				{"40", "D20"},
				{"38", "D19"},
				{"36", "D18"},
				{"34", "D17"},
				{"32", "D16"},
				{"30", "D15"},
				{"28", "D14"},
				{"26", "D13"},
				{"24", "D12"},
				{"22", "D11"},
				{"20", "D10"},
				{"18", "D9"},
				{"16", "D8"},
				{"14", "D7"},
				{"12", "D6"},
				{"10", "D5"},
				{"8", "D4"},
				{"6", "D3"},
				{"4", "D2"},
				{"2", "D1"}
		};
		
		final String[][] CHECKOUT4MO_3 = {
				{"180", "T20 T20 T20"},
				{"177", "T20 T20 T19"},
				{"174", "T20 T19 T19"},
				{"171", "T20 T19 T18"},
				{"170", "T20 T20 Bull"},
				{"168", "T18 T19 T19"},
				{"167", "Bull T19 T20"},
				{"165", "T15 T20 T20"},
				{"164", "Bull T19 T19"},
				{"162", "T20 T20 T14"},
				{"161", "Bull T19 T18"},
				{"160", "Bull Bull T20"},
				{"159", "T19 T20 T14"},
				{"158", "Bull T18 T18"},
				{"157", "Bull Bull T19"},
				{"156", "T20 T20 D18"},
				{"155", "Bull T19 T16"},
				{"154", "Bull Bull T18"},
				{"153", "T17 T20 T14"},
				{"152", "Bull T20 T14"},
				{"151", "Bull Bull T17"},
				{"150", "Bull Bull Bull"},
				{"149", "Bull T17 T16"},
				{"148", "Bull Bull T16"},
				{"147", "Bull T19 D20"},
				{"146", "Bull T16 T16"},
				{"145", "Bull Bull T15"},
				{"144", "Bull T18 D20"},
				{"143", "Bull T19 D18"},
				{"142", "Bull Bull T14"},
				{"141", "Bull T17 D20"},
				{"140", "Bull Bull D20"},
				{"139", "T19 Bull D16"},
				{"138", "Bull Bull D19"},
				{"137", "Bull T17 D18"},
				{"136", "Bull Bull D18"},
				{"135", "Bull T15 D20"},
				{"134", "Bull Bull D17"},
				{"133", "Bull Bull T11"},
				{"132", "Bull Bull D16"},
				{"131", "Bull T19 D12"},
				{"130", "Bull Bull D15"},
				{"129", "T19 T12 D18"},
				{"128", "Bull Bull D14"},
				{"127", "T20 S17 Bull"},
				{"126", "Bull Bull D13"},
				{"125", "Bull T15 D15"},
				{"124", "Bull Bull D12"},
				{"123", "Bull T19 D8"},
				{"122", "Bull T12 D18"},
				{"121", "Bull T17 D10"},
				{"119", "Bull S19 Bull"},
				{"118", "Bull S18 Bull"},
				{"117", "Bull S17 Bull"},
				{"116", "Bull S16 Bull"},
				{"115", "Bull S15 Bull"},
				{"114", "Bull S14 Bull"},
				{"113", "Bull S13 Bull"},
				{"112", "Bull S12 Bull"},
				{"111", "Bull S11 Bull"},
				{"109", "Bull S9 Bull"},
				{"108", "Bull S8 Bull"},
				{"106", "Bull S6 Bull"},
				{"105", "Bull S5 Bull"},
				{"103", "Bull S3 Bull"},
				{"102", "Bull S2 Bull"},
		};
		final String[][] CHECKOUT4MO_2 = {
				{"120", "T20 T20"},
				{"110", "T20 Bull"},
				{"107", "Bull T19"},
				{"104", "Bull T18"},
				{"101", "Bull T18"},
				{"100", "Bull Bull"},
				{"99", "T17 T16"},
				{"98", "Bull T16"},
				{"97", "T19 D20"},
				{"96", "T16 T16"},
				{"95", "Bull T15"},
				{"94", "T18 D20"},
				{"93", "T19 D18"},
				{"92", "Bull T14"},
				{"91", "T17 D20"},
				{"90", "Bull D20"},
				{"89", "T19 D16"},
				{"88", "Bull D19"},
				{"87", "T17 D18"},
				{"86", "Bull D18"},
				{"85", "T15 D20"},
				{"84", "Bull D17"},
				{"83", "T17 D16"},
				{"82", "Bull D16"},
				{"81", "T19 D12"},
				{"80", "Bull D15"},
				{"79", "T19 D11"},
				{"78", "Bull D14"},
				{"77", "T9 Bull"},
				{"76", "Bull D13"},
				{"75", "T15 D15"},
				{"74", "Bull D12"},
				{"73", "T19 D8"},
				{"72", "T12 D18"},
				{"71", "T17 D10"},
				{"70", "S20 Bull"},
				{"69", "S19 Bull"},
				{"68", "S18 Bull"},
				{"67", "S17 Bull"},
				{"66", "S16 Bull"},
				{"65", "S15 Bull"},
				{"64", "S14 Bull"},
				{"63", "S13 Bull"},
				{"62", "S12 Bull"},
				{"61", "S11 Bull"},
				{"59", "S9 Bull"},
				{"58", "S8 Bull"},
				{"56", "S6 Bull"},
				{"55", "S5 Bull"},
				{"53", "S3 Bull"},
				{"52", "S2 Bull"},
				{"49", "S17 D16"},
				{"47", "S7 D20"},
				{"46", "S6 D20"},
				{"44", "S4 D20"},
				{"43", "S3 D20"},
				{"42", "S10 D16"},
				{"41", "S17 D12"},
				{"39", "S7 D16"},
				{"37", "S5 D16"},
				{"35", "S3 D16"},
				{"33", "S17 D8"},
				{"31", "S15 D8"},
				{"29", "S13 D8"},
				{"27", "S11 D8"},
				{"25", "S17 D4"},
				{"23", "S7 D8"},
				{"21", "S5 D8"},
				{"19", "S3 D8"},
				{"17", "S1 D8"},
				{"15", "S7 D4"},
				{"13", "S5 D4"},
				{"11", "S3 D4"},
				{"9", "S3 D3"},
				{"7", "S3 D2"},
				{"5", "S1 D2"},
				{"3", "S1 D1"},
		};
		final String[][] CHECKOUT4MO_1 = {
				{"60", "T20"},
				{"57", "T19"},
				{"54", "T18"},
				{"51", "T17"},
				{"50", "Bull"},
				{"48", "T16"},
				{"45", "T15"},
				{"40", "D20"},
				{"38", "D19"},
				{"36", "D18"},
				{"34", "D17"},
				{"32", "D16"},
				{"30", "D15"},
				{"28", "D14"},
				{"26", "D13"},
				{"24", "D12"},
				{"22", "D11"},
				{"20", "D10"},
				{"18", "D9"},
				{"16", "D8"},
				{"14", "D7"},
				{"12", "D6"},
				{"10", "D5"},
				{"8", "D4"},
				{"6", "D3"},
				{"4", "D2"},
				{"2", "D1"}
		};
		
		if(outMode.equalsIgnoreCase("DO")) {
			if(R == 3) {
				if(this.score > 1) {
					for(String[] i: CHECKOUT4DO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score >= 3){
					for(String[] i: CHECKOUT4DO_2) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score >= 102){
					for(String[] i: CHECKOUT4DO_3) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				return "NO OUT SHOT";
			}
			else if(R == 2) {
				if(this.score > 1) {
					for(String[] i: CHECKOUT4DO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score >= 3){
					for(String[] i: CHECKOUT4DO_2) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				return "NO OUT SHOT";
			}
			else if(R == 1) {
				if(this.score > 1) {
					for(String[] i: CHECKOUT4DO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				return "NO OUT SHOT";
			}
		}
		if(outMode.equalsIgnoreCase("MO")) {
			if(R == 3) {
				if(this.score > 1) {
					for(String[] i: CHECKOUT4MO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score >= 3){
					for(String[] i: CHECKOUT4MO_2) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score >= 99){
					for(String[] i: CHECKOUT4MO_3) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				return "NO OUT SHOT";
			}
			else if(R == 2) {
				if(this.score > 1) {
					for(String[] i: CHECKOUT4MO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score >= 3){
					for(String[] i: CHECKOUT4MO_2) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				return "NO OUT SHOT";
			}
			else if(R == 1) {
				if(this.score > 1) {
					for(String[] i: CHECKOUT4MO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				return "NO OUT SHOT";
			}
		}
		if(outMode.equalsIgnoreCase("OO")) {
			if(R == 3) {
				if(this.score == 1) {
					return "S1";
				}
				if(this.score > 1) {
					for(String[] i: CHECKOUT4DO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score >= 3){
					for(String[] i: CHECKOUT4DO_2) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score >= 102){
					for(String[] i: CHECKOUT4DO_3) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score > 170){
					for(String[] i: CHECKOUT4MO_3) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				return "NO OUT SHOT";
			}
			if(R == 2) {
				if(this.score == 1) {
					return "S1";
				}
				if(this.score > 1) {
					for(String[] i: CHECKOUT4DO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score > 1) {
					for(String[] i: CHECKOUT4MO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score >= 3){
					for(String[] i: CHECKOUT4DO_2) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score >= 3){
					for(String[] i: CHECKOUT4MO_2) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				return "NO OUT SHOT";
			}
			if(R == 1) {
				if(this.score == 1) {
					return "S1";
				}
				if(this.score > 1) {
					for(String[] i: CHECKOUT4DO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				if(this.score > 1) {
					for(String[] i: CHECKOUT4MO_1) {
						if(Integer.valueOf(i[0]) == this.score) {
							return i[1];
						}
					}
				}
				return "NO OUT SHOT";
			}
		}
		return "NO OUT SHOT";
	}
	
	public String[] getPreScore() {
		return this.preScore;
	}
	
	public int getScore() {
		return this.score;
	}

	public int getDarts() {
		return this.darts;
	}
	
	public int getRounds() {
		return this.rounds;
	}
	
	public String getCheckOut(final int R) {
		if(R != 0 && !getFinishes(R).equals("NO OUT SHOT"))
		{
			return getFinishes(R);
		}
		else {
			return "";
		}
	}
	
}
