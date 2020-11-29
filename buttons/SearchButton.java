package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ClothesTable.*;

import javax.swing.*;

public class SearchButton implements ActionListener {
    private ClothesTableModel clothesTableModel;
    private JFrame owner;

    public SearchButton(ClothesTableModel newClothesTableModel, JFrame owner){
        clothesTableModel = newClothesTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = (String)JOptionPane.showInputDialog(
                owner,
                "Введите наименование",
                "Поиск",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "наименование");
        if(name.equals("")){
            return;
        }
        if(!clothesTableModel.searchData(name, owner)){
            JOptionPane.showMessageDialog(owner,
                    "Такой записи не было найдено",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        clothesTableModel.fireTableDataChanged();
    }
}
