import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Load {
    public ArrayList<Building> getBuildings()throws SQLException{
        ArrayList<Building>bdList = new ArrayList<>();
        String uri = "jdbc:mariadb://localhost:3306/argus";
        String name = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(uri, name, password);

        String sql="select * from buildings";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Building bd = new Building();
            bd.id= rs.getInt("id");
            bd.city= rs.getString("city");
            bd.address= rs.getString("address");
            bd.usage= rs.getString("busage");
            bd.size= rs.getDouble("size");
            bd.price= rs.getDouble("price");
            bdList.add(bd);
        }
        conn.close();
        return bdList;
    }
}
