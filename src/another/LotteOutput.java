package another;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LotteOutput {
	int printAge(String LANGUAGE, int age) {
		if (LANGUAGE.equals("KR")) {
			System.out.printf("나이 : %d살\n", age);
		} else if (LANGUAGE.equals("US")) {
			System.out.printf("Age : %d old\n", age);
		} else if (LANGUAGE.equals("ES")) {
			System.out.printf("Edad: %d años\n", age);
		}

		return 0;
	}

	int printPrice(String LANGUAGE, int finalPrice) {
		if (LANGUAGE.equals("KR")) {
			System.out.println("가격은 " + finalPrice + "원 입니다.");
		} else if (LANGUAGE.equals("US")) {
			System.out.println("The Price is " + finalPrice + " Won");
		} else if (LANGUAGE.equals("ES")) {
			System.out.println("precio " + finalPrice + "Soy Won.");
		}

		return finalPrice;
	}

	int printEnd(String LANGUAGE, int selectContinue) {
		if (LANGUAGE.equals("KR")) {
			if (selectContinue == 2) {
				System.out.printf("티켓 발권을 종료합니다. 감사합니다.\n");
			}
		} else if (LANGUAGE.equals("US")) {
			if (selectContinue == 2) {
				System.out.printf("End ticket issuance. Thank you.\n");
			}
		} else if (LANGUAGE.equals("ES")) {
			if (selectContinue == 2) {
				System.out.printf("Finaliza la emisión de billetes. Gracias.\n");
			}
		}
		return selectContinue;
	}

	List<OrderList> output(String LANGUAGE, List<OrderList> data, int totalCost) throws FileNotFoundException {
		if (LANGUAGE.equals("KR")) {
			System.out.println("\n======================롯데월드=======================");

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
			System.out.println("===================================================");
		} else if (LANGUAGE.equals("US")) {
			System.out.println("\n============================Lotte World=============================");

			for (OrderList order : data) {
				String ticketType = order.getTicketType();
				String ageGroup = order.getAgeGroup();
				int amount = order.getAmount();
				double option = order.getOption();
				int cost = order.getCost();
				totalCost = order.getTotalCost();
				String discount = null;

				if (option == 1) {
					discount = "No Discount";
				} else if (option == 0.6) {
					discount = "Disabled Man Discount";
				} else if (option == 0.5) {
					discount = "A man of national merit Discount";
				} else if (option == 0.8) {
					discount = "Multi-Child Discount";
				} else if (option == 0.85) {
					discount = "Pregnant Discount";
				}
				
				System.out.printf("%s %s X %d%s%d Won%3s%s\n", ticketType, ageGroup, amount, " ", cost, " ", discount);
			}

			System.out.printf("\nTotal Fee is %d Won.\n", totalCost);
			System.out.println("====================================================================");
		} else if (LANGUAGE.equals("ES")) {
			System.out.println("\n=============================El Mundo de Lotte==============================");

			for (OrderList order : data) {
				String ticketType = order.getTicketType();
				String ageGroup = order.getAgeGroup();
				int amount = order.getAmount();
				double option = order.getOption();
				int cost = order.getCost();
				totalCost = order.getTotalCost();
				String discount = null;

				if (option == 1) {
					discount = "No hay trato preferencial";
				} else if (option == 0.6) {
					discount = "Aplicación preferencial para personas con discapacidad";
				} else if (option == 0.5) {
					discount = "Aplicación preferencial para personas de mérito nacional";
				} else if (option == 0.8) {
					discount = "Aplicación preferencial para los niños múltiples";
				} else if (option == 0.85) {
					discount = "Aplicación preferencial para mujeres embarazadas";
				}
				
				System.out.printf("%s %s X %d%s%d Won%3s%s\n", ticketType, ageGroup, amount, " ", cost, " ", discount);
			}

			System.out.printf("\nLa tarifa de entrada total es %d wones.\n", totalCost);
			System.out.println("============================================================================");
		}
		
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