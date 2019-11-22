package edu.mum.cs.cs472.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import edu.mum.cs.cs472.dao.Food;

import edu.mum.cs.cs472.dao.Image;
import edu.mum.cs.cs472.dao.Item;
import edu.mum.cs.cs472.dao.Order;
import edu.mum.cs.cs472.dao.Role;
import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.OrderService;
import edu.mum.cs.cs472.util.DBConnection;

public class OrderServiceImpl implements OrderService {
	private DBConnection dbConnection;

	@Override
	public List<Order> getAllOrder() {
		String queryOrders = "select a.order_id,a.totalAmount,a.created,a.status,a.user_id,a.status," +
				"b.first_name,b.last_name,b.password,b.email,b.role,b.created as userCreated,b.image_id,b.address_id,b.status as userStatus" +
				" from orders a INNER JOIN users b ON a.user_id=b.user_id WHERE a.status='ordered'";
		List<Order> orderList = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = this.getDbConnection().getConnection().prepareStatement(queryOrders);
			ResultSet resultOrder = preparedStatement.executeQuery();
			while (resultOrder.next()) {
				List<Food> foodList = new ArrayList<>();
				String queryOrderFoods = "select b.food_id,b.name,b.type,b.description,b.created,b.price,b.calories,b.image_id,b.order_count,c.path" +
						" from orders_has_foods a INNER JOIN foods b ON a.food_id=b.food_id LEFT JOIN images c ON c.image_id=b.image_id WHERE a.order_id=?";
				try {
					System.out.println(resultOrder.getString("order_id"));
					PreparedStatement preparedStatement2 = this.getDbConnection().getConnection().prepareStatement(queryOrderFoods);
					preparedStatement2.setString(1, resultOrder.getString("order_id"));
					ResultSet resultOrderFood = preparedStatement2.executeQuery();
					while (resultOrderFood.next()) {
						foodList.add(new Food(
								resultOrderFood.getInt("food_id"),
								resultOrderFood.getString("name"),
								resultOrderFood.getInt("calories"),
								resultOrderFood.getString("description"),
								resultOrderFood.getString("type"),
								resultOrderFood.getDouble("price"),
								resultOrderFood.getInt("image_id"),
								resultOrderFood.getString("path"),
								resultOrderFood.getInt("order_count"),
								new Date(resultOrderFood.getDate("created").getTime())
						));
					}
					System.out.println("Food List : ");
					System.out.println(foodList);

					orderList.add(new Order(
							resultOrder.getInt("order_id"),
							resultOrder.getInt("totalAmount"),
							new Date(resultOrder.getDate("created").getTime()),
							(resultOrder.getString("status") == "ordered" ? 1 : 0),
							new User(
									resultOrder.getInt("user_id"),
									resultOrder.getString("first_name"),
									resultOrder.getString("last_name"),
									resultOrder.getString("email"),
									(resultOrder.getString("role") == "client" ? Role.client : Role.admin),
									(new Date()),
									resultOrder.getInt("userStatus"),
									resultOrder.getString("password")
							),
							foodList
					));

				} catch (SQLException e) {
					System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				}
			}
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.getDbConnection().disconnect();
		}
		System.out.println(orderList.size());
		return orderList;
	}

	@Override
	public List<Order> getOrderByUserId(int userId) {
		return null;
	}

	@Override
	public Order getOrderById(int orderId) {
		return null;
	}

	@Override
	public String addOrder(Order newOrder) {
		System.out.println("OrderServiceImpl.addOrder order object=>" + newOrder.toString());
		try {			
			String queryString = "insert into fos.orders(totalAmount, status, created , user_id) values (?,?,current_timestamp,?)";
			PreparedStatement pstmt = this.getDbConnection().getConnection().prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
			pstmt.setLong(1, newOrder.getTotalAmount());
			pstmt.setInt(2, newOrder.getStatus());
			pstmt.setLong(3, newOrder.getUser().getUser_id());
			pstmt.executeUpdate();
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int insertedId = generatedKeys.getInt(1);
                    System.out.println("Generated key" + insertedId);
                    
                    if(newOrder.getItems()!=null) {
    					List<Item> items = newOrder.getItems();
    					for (Item item : items) {
    						String insertOrderedFood = "insert into fos.orders_has_foods(order_id, food_id, quantity) values (?,?,?)";
    						PreparedStatement insertPstmt = this.getDbConnection().getConnection().prepareStatement(insertOrderedFood);
    						insertPstmt.setLong(1, insertedId);
    						insertPstmt.setInt(2, item.getFood().getFoodId());
    						insertPstmt.setInt(3, item.getQuantity());
    						insertPstmt.executeUpdate();
        				}
                    }
    				return "SUCCESS";
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
			
		} catch (SQLException e) {
			System.err.println(e);
		}
		return "Oops.. Something went wrong there..!";
	}

	@Override
	public String changeStatus(int orderId){
		String queryString = "update orders set status='delivered' where order_id=?";
		try{
			PreparedStatement preparedStatement = this.getDbConnection().getConnection().prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, orderId);
			preparedStatement.executeUpdate();
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return "SUCCESS";
				} else {
					throw new SQLException("Creating order failed, no ID obtained.");
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return "Oops.. Something went wrong there..!";
	}

	public DBConnection getDbConnection() {
		return dbConnection != null ? this.dbConnection : (this.dbConnection = new DBConnection());
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
}
