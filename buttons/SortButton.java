package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ClothesTable.*;

import javax.swing.*;

public class SortButton implements ActionListener {
    private ClothesTableModel clothesTableModel;
    private JFrame owner;

    public SortButton(ClothesTableModel newClothesTableModel, JFrame owner){
        clothesTableModel = newClothesTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        clothesTableModel.sortDataBySize();
        clothesTableModel.fireTableDataChanged();
    }
}
