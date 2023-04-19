package another;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LotteOutput {
	int printAge(int age) {
		System.out.printf("나이 : %d살\n", age);

		return 0;
	}

	int printPrice(int finalPrice) {
		System.out.println("가격은 " + finalPrice + "원 입니다.");

		return finalPrice;
	}

	int printEnd(int selectContinue) {
		if (selectContinue == 2) {
			System.out.printf("티켓 발권을 종료합니다. 감사합니다.\n");
		}
		return selectContinue;
	}

	List<OrderList> output(List<OrderList> data, int totalCost) throws FileNotFoundException {
		
		System.out.println("\n==============롯데월드===============");

		for (OrderList order : data) {
			String ticketType = order.getTicketType();
			String ageGroup = order.getAgeGroup();
			int amount = order.getAmount();
			double option = order.getOption();
			int cost = order.getCost();
			totalCost = order.getTotalCost();
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
			
			System.out.printf("%s %s X %d%s%d원%3s%s\n", ticketType, ageGroup, amount, " ", cost, " ", discount);
		}

		System.out.printf("\n입장료 총액은 %d원 입니다.\n", totalCost);
		System.out.println("==================================");
		return null;
	}
	
	void readCsv(String filePath) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] rowData = line.split(",");
				System.out.println("Ticket type: " + rowData[0] + ", Age group: " + rowData[1] + ", Amount: "
						+ rowData[2] + ", Cost: " + rowData[3] + ", Discount: " + rowData[4]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}