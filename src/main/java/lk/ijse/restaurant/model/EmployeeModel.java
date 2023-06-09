package lk.ijse.restaurant.model;

import lk.ijse.restaurant.dto.Employee;
import lk.ijse.restaurant.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {

    public static int save(Employee employee) throws SQLException {

        String sql = "INSERT INTO employees VALUES (?,?,?,?,?,?)";

        return CrudUtil.execute(
                sql,
                employee.getId(),
                employee.getName(),
                employee.getContact(),
                employee.getJobrole(),
                employee.getUsername(),
                employee.getPassword()
        );

    }

    public static Employee search(String id) throws SQLException {

        String sql = "SELECT * FROM employees WHERE id=?";

        ResultSet resultSet = CrudUtil.execute(sql, id);

        if (resultSet.next()) {
            return new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }

    public static int update(Employee employee) throws SQLException {

        String sql = "UPDATE employees SET name=? , contact=? , jobrole=? , username=? , password=? WHERE id=?";

        return CrudUtil.execute(
                sql,
                employee.getName(),
                employee.getContact(),
                employee.getJobrole(),
                employee.getUsername(),
                employee.getPassword(),
                employee.getId()
        );
    }

    public static int delete(String id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        return CrudUtil.execute(sql, id);
    }

    public static List<Employee> getAll() throws SQLException {

        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            Employee employee = new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            employeeList.add(employee);
        }
        return employeeList;
    }
}
