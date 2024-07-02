package com.addItems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class itemDBUtil {
	
	private static final String INSERT_USERS_SQL = "INSERT INTO items2" + "  ( itemName, description, startingPrice, `condition`, duration) VALUES " +
	        " (?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id, itemName, description, startingPrice, `condition`, duration from items2 where id =?";
	private static final String SELECT_ALL_USERS = "select * from items2";
	private static final String DELETE_USERS_SQL = "delete from items2 where id = ?;";
	private static final String UPDATE_USERS_SQL = "update items2 set itemName = ?, description = ?, startingPrice = ?, `condition` = ?, duration = ? where id = ?;";
	
	
	public void insertItem(Items item) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        
        try (Connection conn = DBConnect.getConnection();PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL)) {
        	
            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setString(3, item.getStartingPrice());
            preparedStatement.setString(4, item.getCondition());
            preparedStatement.setString(5, item.getDuration());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }
	
	public boolean updateItem(Items item) throws SQLException {
        boolean rowUpdated;
        try (Connection conn = DBConnect.getConnection(); PreparedStatement statement = conn.prepareStatement(UPDATE_USERS_SQL);) {
        	 statement.setString(1, item.getItemName());
             statement.setString(2, item.getDescription());
             statement.setString(3, item.getStartingPrice());
             statement.setString(4, item.getCondition());
             statement.setString(5, item.getDuration());
             statement.setInt(6, item.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
	
	public Items selectItem(int id) {
    	
		Items item = null;
        
        try (Connection conn = DBConnect.getConnection();
        		
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID);) {
        	
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            

            while (rs.next()) {
                String itemName = rs.getString("itemName");
                String description = rs.getString("description");
                String startingPrice = rs.getString("startingPrice");
                String image = rs.getString("condition");
                String duration = rs.getString("duration");

                item = new Items(id, itemName, description, startingPrice, image, duration);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return item;
    }
	
	public List < Items > selectAllitems() {
		
		
	     List < Items > items = new ArrayList < > ();
	
	     try (Connection conn = DBConnect.getConnection();
	
	         PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_USERS);) {
	         System.out.println(preparedStatement);
	
	         ResultSet rs = preparedStatement.executeQuery();
	
	         
	         while (rs.next()) {
	             int id = rs.getInt("id");
	             String itemName = rs.getString("itemName");
	                String description = rs.getString("description");
	                String startingPrice = rs.getString("startingPrice");
	                String image = rs.getString("condition");
	                String duration = rs.getString("duration");
	
	             items.add(new Items(id, itemName, description, startingPrice, image, duration));
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return items;
	 }
	
	public boolean deleteitem(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection conn = DBConnect.getConnection(); PreparedStatement statement = conn.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

}
