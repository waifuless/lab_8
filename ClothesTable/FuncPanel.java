package ClothesTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FuncPanel extends JPanel {
    private JButton addButton;
    private JButton delButton;
    private JButton redactButton;
    private JButton searchButton;
    private JButton sortButton;
    public FuncPanel(ClothesTableModel clothesTableModel, JFrame owner){
        setLayout(new GridLayout(1,5,50,0));
        addButton = new JButton("Добавить");
        delButton = new JButton("Удалить");
        redactButton = new JButton("Изменить");
        searchButton = new JButton("Найти записи");
        sortButton = new JButton("Отсортировать записи по размеру");
        addButton.addActionListener(new buttons.AddButton(clothesTableModel, owner));
        delButton.addActionListener(new buttons.DelButton(clothesTableModel, owner));
        redactButton.addActionListener(new buttons.RedactButton(clothesTableModel, owner));
        searchButton.addActionListener(new buttons.SearchButton(clothesTableModel, owner));
        sortButton.addActionListener(new buttons.SortButton(clothesTableModel, owner));
        this.add(addButton);
        this.add(delButton);
        this.add(redactButton);
        this.add(searchButton);
        this.add(sortButton);
    }
}
