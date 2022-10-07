package end2end.mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

  public static void main(String[] args) throws SQLException {
    // format URL baze   "jdbc:mysql://"+host+":"+port+"/databaseName"

    String host = "localhost";
    String port = "3306";
    String dataBase = "dbz";

    //Kreiranje veze sa bazom
    Connection conectBase = DriverManager.getConnection(
      "jdbc:mysql://" + host + ":" + port + "/" + dataBase,
      "root",
      "l*JNRu*,)+t7r${DzX"
    );
    //Kreiranje Statement tj puta
    Statement s = conectBase.createStatement();

    //kreiranje upita

    ResultSet rs = s.executeQuery(
      "select * from EmployeeInfo where location = 'LA'"
    );
    //vadjenje vrednosti
    while (rs.next()) {
      System.out.println(rs.getString("name"));
      System.out.println(rs.getString("location"));
      System.out.println(rs.getInt("age"));
    }
  }
}
