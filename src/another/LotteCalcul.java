package another;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LotteCalcul {
	List<OrderList> data = new ArrayList<OrderList>();
	int totalCost = 0;

	String calculDayNightTicket(int inputSelectTicket) throws Exception { // 권종 선택
		String ticketType = "";

		if (inputSelectTicket < 1 || inputSelectTicket > 2) {
			throw new Exception("다시 선택하세요."); // 예외 처리
		}

		if (inputSelectTicket == 1) {
			ticketType = "주간권";
			return ticketType;
		} else if (inputSelectTicket == 2) {
			ticketType = "야간권";
			return ticketType; // 주간권/야간권 리턴
		}
		return "";
	}

	String[] calculSocialNumber(String socialNumber) throws Exception { // 주민번호 입력받아 나이,성별 구하기 
		LotteOutput lo = new LotteOutput();
		int birthYear = 0, age;
		String ageGroup = null, gender = null;

		if (socialNumber.length() == 13) {
			int yearPreFix = Integer.parseInt(socialNumber.substring(0, 2));
			int genderDigit = Character.getNumericValue(socialNumber.charAt(6));
			if (genderDigit == 1 || genderDigit == 2) {
				birthYear = 1900 + yearPreFix;
			} else {
				birthYear = 2000 + yearPreFix;
			}
		} else {
			throw new Exception("주민등록번호는 13자리입니다."); // 예외 처리
		}

		age = 2023 - birthYear + 1; // 나이계산
		if (age < 1 || age > 105) {
			throw new Exception("잘못된 나이입니다."); // 예외 처리
		}

		lo.printAge(age); // 나이 출력

		ageGroup = getAgeGroup(age);
		gender = judgeFemale(socialNumber);
		String[] ageGender = { ageGroup, gender };
		return ageGender; // 연령대, 성별 리턴
	}

	String getAgeGroup(int age) { // 나이 받아서 연령대 리턴
		if (age >= 65) {
			return "노인";
		} else if (age >= 20 && age <= 64) {
			return "성인";
		} else if (age >= 13 && age <= 19) {
			return "청소년";
		} else if (age >= 3 && age <= 12) {
			return "어린이";
		} else if (age >= 1 && age <= 2) {
			return "유아";
		} else {
			return "error";
		}
	}

	String judgeFemale(String socialNumber) { // 성별 판단
		String gender = "";
		int genderDigit = Character.getNumericValue(socialNumber.charAt(6));
		if (genderDigit == 2 || genderDigit == 4) {
			gender = "여성";
			return gender;
		} else if (genderDigit == 1 || genderDigit == 3) {
			gender = "남성";
		}
		return "";
	}

	int calculCountNumbers(int numberOfOrders) throws Exception { // 티켓 개수 계산
		if (numberOfOrders > 10 || numberOfOrders < 0) {
			throw new Exception("주문 가능 개수는 1인당 1개에서 최대 10개 입니다.\n"); // 예외 처리
		}

		return numberOfOrders;
	}

	double calculTreatment(int specificCase) throws Exception { // 우대사항
		double discount = 0;

		if (specificCase < 1 || specificCase > 5) {
			throw new Exception("우대사항은 1번에서 5번 사이로 골라주세요"); // 예외 처리
		}

		switch (specificCase) {
		case 1:
			discount = 1; // 없음
			return discount;
		case 2:
			discount = 0.6; // 장애인
			return discount;
		case 3:
			discount = 0.5; // 국가유공자
			return discount;
		case 4:
			discount = 0.8; // 다자녀
			return discount;
		case 5:
			discount = 0.85; // 임산부
			return discount;
		}
		return discount;
	}

	int calculPrice() throws Exception { // 권종, 연령대, 성별, 티켓 개수 리턴받아 최종 가격 계산
		LotteInput li = new LotteInput();
		LotteTicketPrice ltp = new LotteTicketPrice();
		LotteOutput lo = new LotteOutput();
		String ticketType, ageGroup, gender;
		String[] ageGender;
		int ticketNumbers, temporaryPrice = 0, finalPrice;
		double discountRate;

		ticketType = li.choiceDayNight(); // 권종
		li.removeEnter();
		ageGender = li.inputSocialNumber(); // 배열 ageGender (연령대, 성별포함)
		ticketNumbers = li.countNumber(); // 티켓 개수
		discountRate = li.treatment(); // 우대사항
		ageGroup = ageGender[0]; // 연령대
		gender = ageGender[1]; // 성별

		if (discountRate == 0.85) { // 임산부 예외처리
			if (!ageGroup.equals("성인") || !gender.equals("여성")) {
				throw new Exception("임산부 우대사항은 성인 여성에게만 적용됩니다."); // 예외 처리
			}
		}

		switch (ticketType) {
		case "주간권":
			switch (ageGroup) {
			case "노인":
				if (discountRate == 1) {
					temporaryPrice = ltp.getDayOld();
				} else if (discountRate == 0.6) {
					temporaryPrice = (int) (ltp.getDayOld() * discountRate);
				} else if (discountRate == 0.5) {
					temporaryPrice = (int) (ltp.getDayOld() * discountRate);
				} else if (discountRate == 0.8) {
					temporaryPrice = (int) (ltp.getDayOld() * discountRate);
				}
				break;
			case "성인":
				if (discountRate == 1) {
					temporaryPrice = ltp.getDayAdult();
				} else if (discountRate == 0.6) {
					temporaryPrice = (int) (ltp.getDayAdult() * discountRate);
				} else if (discountRate == 0.5) {
					temporaryPrice = (int) (ltp.getDayAdult() * discountRate);
				} else if (discountRate == 0.8) {
					temporaryPrice = (int) (ltp.getDayAdult() * discountRate);
				} else if (discountRate == 0.85) {
					temporaryPrice = (int) (ltp.getDayAdult() * discountRate);
				}
				break;
			case "청소년":
				if (discountRate == 1) {
					temporaryPrice = ltp.getDayTeen();
				} else if (discountRate == 0.6) {
					temporaryPrice = (int) (ltp.getDayTeen() * discountRate);
				} else if (discountRate == 0.5) {
					temporaryPrice = (int) (ltp.getDayTeen() * discountRate);
				} else if (discountRate == 0.8) {
					temporaryPrice = (int) (ltp.getDayTeen() * discountRate);
				}
				break;
			case "어린이":
				if (discountRate == 1) {
					temporaryPrice = ltp.getDayKids();
				} else if (discountRate == 0.6) {
					temporaryPrice = (int) (ltp.getDayKids() * discountRate);
				} else if (discountRate == 0.5) {
					temporaryPrice = (int) (ltp.getDayKids() * discountRate);
				} else if (discountRate == 0.8) {
					temporaryPrice = (int) (ltp.getDayKids() * discountRate);
				}
				break;
			case "유아":
				if (discountRate == 1) {
					temporaryPrice = ltp.getDayBaby();
				} else if (discountRate == 0.6) {
					temporaryPrice = (int) (ltp.getDayBaby() * discountRate);
				} else if (discountRate == 0.5) {
					temporaryPrice = (int) (ltp.getDayBaby() * discountRate);
				} else if (discountRate == 0.8) {
					temporaryPrice = (int) (ltp.getDayBaby() * discountRate);
				}
				break;
			}
			break;
		case "야간권":
			switch (ageGroup) {
			case "노인":
				if (discountRate == 1) {
					temporaryPrice = ltp.getNightOld();
				} else if (discountRate == 0.6) {
					temporaryPrice = (int) (ltp.getNightOld() * discountRate);
				} else if (discountRate == 0.5) {
					temporaryPrice = (int) (ltp.getNightOld() * discountRate);
				} else if (discountRate == 0.8) {
					temporaryPrice = (int) (ltp.getNightOld() * discountRate);
				}
				break;
			case "성인":
				if (discountRate == 1) {
					temporaryPrice = ltp.getNightAdult();
				} else if (discountRate == 0.6) {
					temporaryPrice = (int) (ltp.getNightAdult() * discountRate);
				} else if (discountRate == 0.5) {
					temporaryPrice = (int) (ltp.getNightAdult() * discountRate);
				} else if (discountRate == 0.8) {
					temporaryPrice = (int) (ltp.getNightAdult() * discountRate);
				} else if (discountRate == 0.85) {
					temporaryPrice = (int) (ltp.getNightAdult() * discountRate);
				}
				break;
			case "청소년":
				if (discountRate == 1) {
					temporaryPrice = ltp.getNightTeen();
				} else if (discountRate == 0.6) {
					temporaryPrice = (int) (ltp.getNightTeen() * discountRate);
				} else if (discountRate == 0.5) {
					temporaryPrice = (int) (ltp.getNightTeen() * discountRate);
				} else if (discountRate == 0.8) {
					temporaryPrice = (int) (ltp.getNightTeen() * discountRate);
				}
				break;
			case "어린이":
				if (discountRate == 1) {
					temporaryPrice = ltp.getNightKids();
				} else if (discountRate == 0.6) {
					temporaryPrice = (int) (ltp.getNightKids() * discountRate);
				} else if (discountRate == 0.5) {
					temporaryPrice = (int) (ltp.getNightKids() * discountRate);
				} else if (discountRate == 0.8) {
					temporaryPrice = (int) (ltp.getNightKids() * discountRate);
				}
				break;
			case "유아":
				if (discountRate == 1) {
					temporaryPrice = ltp.getNightBaby();
				} else if (discountRate == 0.6) {
					temporaryPrice = (int) (ltp.getNightBaby() * discountRate);
				} else if (discountRate == 0.5) {
					temporaryPrice = (int) (ltp.getNightBaby() * discountRate);
				} else if (discountRate == 0.8) {
					temporaryPrice = (int) (ltp.getNightBaby() * discountRate);
				}
				break;
			}
			break;
		}

		finalPrice = temporaryPrice * ticketNumbers; // 최종 가격 = 임시가격 * 티켓 개수

		totalCost += finalPrice; // 토탈 가격 = 최종가격 누적합
		saveData(ticketType, ageGroup, gender, ticketNumbers, discountRate, finalPrice, totalCost); // savedata에 parameter 전달

		return lo.printPrice(finalPrice);
	}

	int decideContinue(int selectContinue) throws Exception {
		LotteOutput lo = new LotteOutput();
		if (selectContinue < 1 && selectContinue > 2) {
			throw new Exception("error"); // 예외 처리
		}
		return lo.printEnd(selectContinue); // LotteOutput의 PrintEnd에 selecContinue를 parameter로 리턴
	}

	void saveData(String ticketType, String ageGroup, String gender, int amount, double option, int cost,
			int totalCost) {

		// 6개의 변수를 parameter로 받는 OrderList 객체 ol 선언
		OrderList ol = new OrderList(ticketType, ageGroup, amount, option, cost, totalCost);
		data.add(ol); // data에 ol 추가
	}

	List<OrderList> deliverData() throws FileNotFoundException {
		LotteOutput lo = new LotteOutput();
		return lo.output(data, totalCost);
	}

	void kiosk() throws Exception {
		LotteInput li = new LotteInput();
		while (true) {
			calculPrice();
			int continueBreak = li.guideComment();

			if (continueBreak == 1) {
				continue;
			} else if (continueBreak == 2) {
				deliverData();
				makeCsv(data);
				break;
			}
		}
	}

	void makeCsv(List<OrderList> data) {
		LotteOutput lo = new LotteOutput();
		String filePath = "C:\\Users\\Bino\\Desktop\\user.csv";
		String charsetName = "UTF-8"; // 인코딩 방식 설정
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath), charsetName)) {
			System.out.println("starting write user.csv file: " + filePath);
			writeCsv(writer, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("starting read user.csv file");
		lo.readCsv(filePath);
	}

	void writeCsv(Writer writer, List<OrderList> data) throws IOException {
		writer.write("ticketType,ageGroup,amount,cost,discount\n");
		for (OrderList csvList : data) {
			double option = csvList.getOption();
			String discount = null;
			if (option == 1) {
				discount = "우대적용 없음";
			} else if (option == 0.6) {
				discount = "장애인 우대적용";
			} else if (option == 0.5) {
				discount = "국가유공자 우대적용";
			} else if (option == 0.8) {
				discount = "다자녀 우대적용";
			} else if (option == 0.85) {
				discount = "임산부 우대적용";
			}

			writer.write(csvList.getTicketType() + ",");
			writer.write(csvList.getAgeGroup() + ",");
			writer.write(csvList.getAmount() + ",");
			writer.write(csvList.getCost() + ",");
			writer.write(discount + "\n");
		}
	}
}