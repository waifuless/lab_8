package ClothesTable;

import ClothesTable.ClothesTableModel;
import ClothesTable.FuncPanel;

import javax.swing.*;
import java.awt.*;

public class ScrollTablePanel extends JPanel{
    ClothesTableModel clothesTableModel;
    public ScrollTablePanel(JFrame owner) {
        try {
            this.setLayout(new BorderLayout());
            clothesTableModel = new ClothesTableModel(Clothes.getNames());
            JTable table = new JTable(clothesTableModel);
            JScrollPane scrollTable = new JScrollPane(table);
            scrollTable.setPreferredSize(new Dimension(400,400));
            FuncPanel funcPanel = new FuncPanel(clothesTableModel, owner);
            this.add(scrollTable, BorderLayout.CENTER);
            this.add(funcPanel, BorderLayout.SOUTH);
        }catch(Exception ex){System.out.println("It`s in scrol table panel "+ex); throw(ex);}
    }
}


