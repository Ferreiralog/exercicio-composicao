package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");

	private Date monentDate;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items = new ArrayList<>();

	public Order() {

	}

	public Order(Date monentDate, OrderStatus status, Client client) {

		this.monentDate = monentDate;
		this.status = status;
		this.client = client;

	}

	public Date getMonentDate() {
		return monentDate;
	}

	public void setMonentDate(Date monentDate) {
		this.monentDate = monentDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem Item) {
		items.add(Item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double valorTotal() {
		double total=0;
		for (OrderItem i : items) {
			total += i.subTotal();
		}
		return total;
	}
	@Override
	public String toString() {
		StringBuilder sb =new StringBuilder();
		
		sb.append("Order moment: ");
		sb.append(sdf.format(monentDate)+ "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");		
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items: \n");
		for (OrderItem item : items) {
			sb.append(item + "\n ");
		}
		sb.append("Tota price: $");
		sb.append(String.format("%.2f", valorTotal()));
		
		
		return sb.toString();
	}

}
