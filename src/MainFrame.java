import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame{
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane pane;
    public MainFrame() throws SQLException {
        Load load = new Load();
        ArrayList<Building> buildingList = load.getBuildings();

        String[] mezoNevek = {"id", "Település", "Cím,", "Használat", "Méret", "Ár"};
        model.setColumnIdentifiers(mezoNevek);
        
        for (Building building : buildingList) {
            Vector<String> row = new Vector<>();
            row.add(building.id.toString());
            row.add(building.city);
            row.add(building.address);
            row.add(building.usage);
            row.add(building.size.toString());
            row.add(building.price.toString());
            model.addRow(row);
        }

        this.table  = new JTable(model);
        // this.table.setModel(model);
        
        this.pane = new JScrollPane(this.table);
        this.pane.setBounds(40, 30, 700, 500);
        
        this.add(pane);
        this.setLayout(null);
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
    }
    
}