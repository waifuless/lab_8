package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ClothesTable.*;

import javax.swing.*;

public class DelButton implements ActionListener {
    private ClothesTableModel clothesTableModel;
    private JFrame owner;

    public DelButton(ClothesTableModel newClothesTableModel, JFrame owner){
        clothesTableModel = newClothesTableModel;
        this.owner = owner;
    }

    public void actionPerformed(ActionEvent e){
        String article = (String)JOptionPane.showInputDialog(
                owner,
                "Введите артикль",
                "Удаление",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "артикль");
        if(article.equals("")){
            return;
        }
        if(!clothesTableModel.removeData(article)){
            JOptionPane.showMessageDialog(owner,
                    "Такой записи не было найдено",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        clothesTableModel.fireTableDataChanged();
    }
}
