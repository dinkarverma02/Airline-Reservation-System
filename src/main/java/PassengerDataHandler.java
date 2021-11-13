import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PassengerDataHandler extends DataHandler {

    PassengerDataHandler(DatabaseConnector databaseConnector) {
        super(databaseConnector, "users");
    }

    public void fetchPassengersIntoApp(PassengerManager passengerManager) {
        ArrayList<Map<String, String>> data = this.loadData();

        for (Map<String, String> row : data) {
            passengerManager.addPassenger(row.get("name"), row.get("email"), row.get("number"), Integer.parseInt(row.get("password")));
        }
    }

    public void addPassenger(String name, String email, String number, String password) {
        String values = "('" + name +
                "', '" + email +
                "', '" + number +
                "', '" + password + "');";

        databaseConnector.runQuery("INSERT INTO " + databaseConnector.getTableName(tableName) +
                "(\"name\", \"email\", \"number\", \"password\") VALUES " + values);
    }
}