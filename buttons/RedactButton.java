package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ClothesTable.*;

import javax.swing.*;

public class RedactButton implements ActionListener {
    private ClothesTableModel clothesTableModel;
    private JFrame owner;

    public RedactButton(ClothesTableModel newClothesTableModel, JFrame owner){
        clothesTableModel = newClothesTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String article = (String)JOptionPane.showInputDialog(
                owner,
                "Введите артикль вещи, которую надо изменить",
                "Редактирование",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "артикль");
        if(article.equals("")){
            return;
        }
        String chosenField = (String)JOptionPane.showInputDialog(
                owner,
                "Выберите поле для редактирования",
                "Редактирование",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Clothes.getNames(),
                "Наименование");
        if(chosenField.equals("")){
            return;
        }
        String newStr = (String)JOptionPane.showInputDialog(
                owner,
                "Введите новые данные",
                "Редактирование",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "новые данные");
        if(newStr.equals("")){
            return;
        }
        if(!clothesTableModel.redactData(article, chosenField, newStr)){
            JOptionPane.showMessageDialog(owner,
                    "Такой записи не было найдено",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        clothesTableModel.fireTableDataChanged();
    }
}
