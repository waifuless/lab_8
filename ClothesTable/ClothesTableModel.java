package ClothesTable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;

public class ClothesTableModel extends AbstractTableModel {

    private int colls;
    private ArrayList<Clothes> arrayList;
    private Object[] collNames;

    public ClothesTableModel(Object []newCollNames){
        colls = newCollNames.length;
        arrayList = new ArrayList<>();
        collNames = newCollNames.clone();
    }

    @Override
    public int getRowCount() {
        return arrayList.size();
    }

    @Override
    public int getColumnCount() {
        return collNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return arrayList.get(rowIndex).getSomeInfo(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex){
        return String.valueOf(collNames[columnIndex]);
    }

    public boolean addData(Clothes newData){ //программа ищет место, чтобы вставить сразу в алфавитном порядке
        int i=0;
        Clothes clothes;
        ListIterator<Clothes> iterator = arrayList.listIterator();
        while(iterator.hasNext()){
            clothes = (Clothes) iterator.next();
            if(newData.getArticle().equals(clothes.getArticle()))
                return false;
        }
        iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){
            clothes = (Clothes) iterator.next();
            if(newData.getName().compareTo(clothes.getName())<0)
                break;
        }
        arrayList.add(i, newData);
        return true;
    }

    public boolean removeData(String articleToDel){
        int i=0;
        Clothes clothes;
        boolean chekFound=false;
        ListIterator<Clothes> iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){
            clothes = (Clothes) iterator.next();
            if(articleToDel.equals(clothes.getArticle())) {
                chekFound = true;
                break;
            }
        }
        if(!chekFound){
            return false;
        }
        arrayList.remove(i);
        return true;
    }

    public boolean redactData(String articleToRedact, String chosenField, String newStr){
        int i=0;
        Clothes clothes;
        boolean chekFound=false;
        ListIterator<Clothes> iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){
            clothes = (Clothes) iterator.next();
            if(articleToRedact.equals(clothes.getArticle())) {
                chekFound = true;
                break;
            }
        }
        if(!chekFound){
            return false;
        }
        clothes = arrayList.get(i);
        switch (chosenField){
            case "Наименование": clothes.setName(newStr);
            break;
            case "артикул":   clothes.setArticle(newStr);
            break;
            case "модель": clothes.setModel(newStr);
            break;
            case "производитель": clothes.setProducer(newStr);
            break;
            case "цвет":  clothes.setColor(newStr);
            break;
            case "размер": clothes.setSize(newStr);
            break;
            case "дата выпуска": clothes.setDate(newStr);
            break;
            case "цена": clothes.setPrice(Double.parseDouble(newStr));
            break;
            default: break;
        }
        arrayList.set(i, clothes);
        return true;
    }

    public boolean searchData(String name, JFrame owner){
        int i=0;
        Clothes clothes;
        boolean chekFound=false;
        ListIterator<Clothes> iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){
            clothes = (Clothes) iterator.next();
            if(name.equals(clothes.getName())) {
                chekFound = true;
                JOptionPane.showMessageDialog(owner,
                        clothes.toString(),
                        "Вывод назденный записей",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
        return chekFound;
    }

    public void sortDataBySize(){
        Collections.sort(arrayList);
    }
}
