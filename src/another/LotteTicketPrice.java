package another;

public class LotteTicketPrice {

	// 연령별 주간권 가격
	private final int DayOld = 46000;
	private final int DayAdult = 59000;
	private final int DayTeen = 52000;
	private final int DayKids = 46000;
	private final int DayBaby = 15000;

	// 연령별 야간권 가격
	private final int NightOld = 35000;
	private final int NightAdult = 47000;
	private final int NightTeen = 41000;
	private final int NightKids = 35000;
	private final int NightBaby = 15000;

	private String LANGUAGE = ""; // kor : 0, eng : 1

	public String TICKET_TYPE_QUESTION;

	public void startLanguage(String country) throws Exception {
		LotteCalcul lc = new LotteCalcul();
		LotteInput li = new LotteInput();
		LANGUAGE = country;
		try {
			while(true) {
				if (LANGUAGE.equals("KR")) {
					setLANGUAGE("KR");
					lc.calculPrice(LANGUAGE);
//					li.guideComment(LANGUAGE);
					int continueBreak = li.guideComment(LANGUAGE);
					if (continueBreak == 1) {
						continue;
					} else if (continueBreak == 2) {
						lc.deliverData(LANGUAGE);
						lc.makeCsv(LANGUAGE, lc.data);
						break;
					}
					
				} else if (LANGUAGE.equals("US")) {
					setLANGUAGE("US");
					lc.calculPrice(LANGUAGE);
//					li.guideComment(LANGUAGE);
					int continueBreak = li.guideComment(LANGUAGE);
					if (continueBreak == 1) {
						continue;
					} else if (continueBreak == 2) {
						lc.deliverData(LANGUAGE);
						lc.makeCsv(LANGUAGE, lc.data);
						break;
					}
				} else if (LANGUAGE.equals("ES")) {
					setLANGUAGE("ES");
					lc.calculPrice(LANGUAGE);
//					li.guideComment(LANGUAGE);
					int continueBreak = li.guideComment(LANGUAGE);
					if (continueBreak == 1) {
						continue;
					} else if (continueBreak == 2) {
						lc.deliverData(LANGUAGE);
						lc.makeCsv(LANGUAGE, lc.data);
						break;
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getLANGUAGE() {
		return LANGUAGE;
	}

	public void setLANGUAGE(String lANGUAGE) {
		LANGUAGE = lANGUAGE;
	}

	public int getDayOld() {
		return DayOld;
	}

	public int getDayAdult() {
		return DayAdult;
	}

	public int getDayTeen() {
		return DayTeen;
	}

	public int getDayKids() {
		return DayKids;
	}

	public int getDayBaby() {
		return DayBaby;
	}

	public int getNightOld() {
		return NightOld;
	}

	public int getNightAdult() {
		return NightAdult;
	}

	public int getNightTeen() {
		return NightTeen;
	}

	public int getNightKids() {
		return NightKids;
	}

	public int getNightBaby() {
		return NightBaby;
	}
}
