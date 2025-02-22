import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class SQLReturnTypeChecker {
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=TheLongPassword";

    public static void main(String[] args) {
        if (args.length < 2 || !args[1].equals("--java")) {
            System.out.println("Usage: SQLReturnTypeChecker <sql_file> --java");
            return;
        }

        String sqlFilePath = args[0];
        try {
            String query = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            System.out.println(getQueryReturnType(query));
        } catch (IOException e) {
            System.err.println("Error reading SQL file: " + e.getMessage());
        }
    }

    public static String getQueryReturnType(String query) {
        JSONObject result = new JSONObject();
        try (Connection conn = DriverManager.getConnection(CONNECTION_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM (" + query + ") AS t LIMIT 0")) {

            ResultSetMetaData metaData = rs.getMetaData();
            JSONArray columns = new JSONArray();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                JSONObject column = new JSONObject();
                column.put("name", metaData.getColumnName(i));
                column.put("type_code", metaData.getColumnType(i));
                columns.put(column);
            }
            result.put("status", true);
            result.put("value", columns);
        } catch (SQLException e) {
            result.put("status", false);
            result.put("value", e.getMessage());
        }
        return result.toString(2);
    }
}