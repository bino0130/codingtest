package another;

public class OrderList {
	private String ticketType;
	private String ageGroup;
	private int amount;
	private double option;
	private int cost;
	private int totalCost;

	public OrderList(String ticketType, String ageGroup, int amount, double option, int cost, int totalCost) {
		this.ticketType = ticketType;
		this.ageGroup = ageGroup;
		this.amount = amount;
		this.option = option;
		this.cost = cost;
		this.totalCost = totalCost;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getOption() {
		return option;
	}

	public void setOption(double option) {
		this.option = option;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
}