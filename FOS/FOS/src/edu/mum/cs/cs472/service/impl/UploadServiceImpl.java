package edu.mum.cs.cs472.service.impl;

import edu.mum.cs.cs472.dao.Image;
import edu.mum.cs.cs472.dao.Role;
import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.UploadService;
import edu.mum.cs.cs472.util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class UploadServiceImpl implements UploadService {

    private DBConnection dbConnection;

    @Override
    public Image saveImage(String path) {
        String queryString = "insert into images(path, created) values (?, current_timestamp)";
        try {
            PreparedStatement preparedStatement = this.getDbConnection().getConnection().prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, path);
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return new Image(generatedKeys.getInt(1), path, new Date());
                } else {
                    throw new SQLException("Creating image failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.getDbConnection().disconnect();
        }
        return null;
    }

    public Image getImage(int imageId) {
        String queryString = "select image_id, path, created from images where image_id=?";
        Image image = null;
        try {
            PreparedStatement preparedStatement = this.getDbConnection().getConnection().prepareStatement(queryString);
            preparedStatement.setInt(1, imageId);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                image = new Image(
                        resultSet.getInt("image_id"),
                        resultSet.getString("path"),
                        resultSet.getDate("created")
                );
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.getDbConnection().disconnect();
        }
        return image;
    }

    public DBConnection getDbConnection() {
        return dbConnection != null ? this.dbConnection : (this.dbConnection = new DBConnection());
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
