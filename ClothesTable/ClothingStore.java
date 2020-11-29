package ClothesTable;

import javax.swing.*;
import java.awt.*;

public class ClothingStore extends JFrame{ //основной фрейм, в него будут добавляться 4 панели
    ClothingStore(){
        try {
            setTitle("Clothing store");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLayout(new BorderLayout());

            ScrollTablePanel tablePanel = new ScrollTablePanel(this);
            add(tablePanel, BorderLayout.CENTER);
            setVisible(true);
        }catch(Exception ex){System.out.println("It`s in store"+ ex);}
    }
    public static void main(String args[]) {
        new ClothingStore();
    }
}
