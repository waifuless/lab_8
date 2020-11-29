package ClothesTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Factory {

    public Clothes createClothes(JFrame owner){
        JLabel labName = new JLabel("Наименование ");
        JTextField textName = new JTextField(50);
        JLabel labArt = new JLabel("Артикул ");
        JTextField textArt = new JTextField(50);
        JLabel labModel = new JLabel("Модель ");
        JTextField textModel = new JTextField(50);
        JLabel labProduser = new JLabel("Производитель ");
        JTextField textProduser = new JTextField(50);
        JLabel labColor = new JLabel("Цвет ");
        JTextField textColor = new JTextField(50);
        JLabel labSize = new JLabel("Размер (XS, S, M, L, XL, XXL)");
        JTextField textSize = new JTextField(50);
        JLabel labDate = new JLabel("Дата ");
        JTextField textDate = new JTextField(50);
        JLabel labPrice = new JLabel("Цена ");
        JTextField textPrice = new JTextField(50);
        JButton completeButton = new JButton("Добавить");
        JLabel labRes =  new JLabel ("Впишите данные");

        Clothes mainClothes = new Clothes();

        JDialog dialog = new JDialog(owner,"Окно добавления записи" , Dialog.ModalityType.DOCUMENT_MODAL);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(500, 350);
        dialog.setLayout(new GridLayout(11,2,10,7));
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textName.getText().equals("")||textArt.getText().equals("")||textModel.getText().equals("")||
                        textProduser.getText().equals("")||textColor.getText().equals("")||textSize.getText().equals("")||
                        textDate.getText().equals("")|| textPrice.getText().equals("")){
                    labRes.setText("Необходимо ввести все данные!");
                }
                else{
                    mainClothes.setName(textName.getText());
                    mainClothes.setArticle(textArt.getText());
                    mainClothes.setModel(textModel.getText());
                    mainClothes.setProducer(textProduser.getText());
                    mainClothes.setColor(textColor.getText());
                    mainClothes.setSize(textSize.getText());
                    mainClothes.setDate(textDate.getText());
                    mainClothes.setPrice(Double.parseDouble(textPrice.getText()));
                    dialog.dispose();
                }
            }
        });
        dialog.add(labName);
        dialog.add(textName);
        dialog.add(labArt);
        dialog.add(textArt);
        dialog.add(labModel);
        dialog.add(textModel);
        dialog.add(labProduser);
        dialog.add(textProduser);
        dialog.add(labColor);
        dialog.add(textColor);
        dialog.add(labSize);
        dialog.add(textSize);
        dialog.add(labDate);
        dialog.add(textDate);
        dialog.add(labPrice);
        dialog.add(textPrice);
        dialog.add(labRes);
        dialog.add(completeButton);
        dialog.setVisible(true);
        return mainClothes;
    }
}
