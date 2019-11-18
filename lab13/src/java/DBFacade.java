import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBFacade {

    private DBConnection dbConnection;

    public DBFacade() {
        this.dbConnection = new DBConnection();
    }

    public List<Person> getPerson(String searchQuery) {
        List<Person> list = new ArrayList<Person>();
        try {
            PreparedStatement preparedStatement = this.dbConnection.getConnection().prepareStatement("select * from MOCK_DATA where first_name like ? or last_name like ?");
            preparedStatement.setString(1, "%" + searchQuery + "%");
            preparedStatement.setString(2, "%" + searchQuery + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Person(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getString("gender"), resultSet.getString("ip_address")));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
