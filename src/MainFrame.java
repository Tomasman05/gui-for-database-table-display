import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame{
    JTable table = new JTable();
    DefaultTableModel model= new DefaultTableModel();
    JScrollPane pane;
    public MainFrame() throws SQLException{
        ArrayList<Building> bdList= new Load().getBuildings();
        Vector<String> row= new Vector<>();
        for (Building building : bdList) {
            row.add(building.id.toString());
            row.add(building.city);
            row.add(building.address);
            row.add(building.usage);
            row.add(building.size.toString()); 
            row.add(building.price.toString());
            model.addRow(row);
        }
        String[] mezonevek = {"id","city","address","usage","size","price"};
        this.model.setColumnIdentifiers(mezonevek);
        this.table.setModel(model);
        this.table = new JTable();
        this.pane = new JScrollPane(this.table);
        this.pane.setBounds(40,10,700,300);
        this.add(pane);
        this.setLayout(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setVisible(true);

    }
}