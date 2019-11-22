package edu.mum.cs.cs472.dao;
import java.util.Date;
import java.util.List;

public class Order {
	private int orderId;
	private int totalAmount;
	private Date created;
	private int status;
	private User user;
	private List<Food> foods;
	private List<Item> items;
	
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	public Order() {
		super();
	}
	
	public Order(int totalAmount, Date created, int status, User user, List<Item> items) {
	
		this.totalAmount = totalAmount;
		this.created = created;
		this.status = status;
		this.user = user;
		this.items = items;
	}
	public Order(int totalAmount, int status, List<Food> foods, User user, Date date) {
		this.totalAmount = totalAmount;
		this.created = date;
		this.status = status;
		this.user = user;
		this.foods = foods;
	}
	public Order(int orderId, int totalAmount, Date created, int status, User user, List<Food> foods) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.created = created;
		this.status = status;
		this.user = user;
		this.foods = foods;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalAmount=" + totalAmount + ", created=" + created + ", status="
				+ status + ", user=" + user + ", foods=" + foods + "]";
	}
	
}
