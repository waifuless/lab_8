package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ClothesTable.*;

import javax.swing.*;

public class AddButton implements ActionListener {
    private ClothesTableModel clothesTableModel;
    private JFrame owner;

    public AddButton(ClothesTableModel newClothesTableModel, JFrame owner){
        clothesTableModel = newClothesTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Clothes clothes = new Factory().createClothes(owner);
        if(!clothesTableModel.addData(clothes)){
            JOptionPane.showMessageDialog(owner,
                    "Объект на записан. Вещь с таким артиклем уже существует",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        clothesTableModel.fireTableDataChanged();
    }
}
