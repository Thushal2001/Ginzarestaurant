package lk.ijse.restaurant.model;

import lk.ijse.restaurant.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderModel {

    public static String getNextOrderId() throws SQLException {
        String sql = "SELECT id FROM Orders ORDER BY id DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);

        if (resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private static String splitOrderId(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("Or0");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "Or0" + id;
        }
        return "Or01";
    }

    public static boolean save(String oId, String cusId) throws SQLException {
        String sql = "INSERT INTO Orders(id, customerId) VALUES(?, ?)";
        Integer affectedRows = CrudUtil.execute(sql, oId, cusId);
        return affectedRows > 0;
    }
}
