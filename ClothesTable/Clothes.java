package ClothesTable;

import java.util.Calendar;

public class Clothes implements Comparable<Clothes>{
    private String name;
    private String article;
    private String model;
    private String producer;
    private String color;
    private Size size;
    private String date;
    private double price;

    public static Object[] getNames(){
        return new Object[]{"Наименование", "артикул", "модель", "производитель", "цвет", "размер", "дата выпуска", "цена"};
    }

    public String getName() {
        return name;
    }

    public String getArticle() {
        return article;
    }

    public String getModel() {
        return model;
    }

    public String getProducer() {
        return producer;
    }

    public String getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String str) {
        switch (str){
            case "XS" : size = Size.XS;
                break;
            case "S" : size = Size.S;
                break;
            case "M" : size = Size.M;
                break;
            case "L" : size = Size.L;
                break;
            case "XL" : size = Size.XL;
                break;
            case "XXl" : size = Size.XXL;
                break;
            default: size = Size.M;
                break;
        }
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSomeInfo(int indexOfField){
        switch(indexOfField){
            case 0 : return name;
            case 1 : return article;
            case 2: return model;
            case 3: return producer;
            case 4: return color;
            case 5: return String.valueOf(size);
            case 6: return date;
            case 7: return String.valueOf(price);
            default: return "error(no field)";
        }
    }

    public String toString(){
        return "Наименование : "+name+"\nАртикул : "+article+"\nМодель : "+model+"\nПроизводитель : "+producer+
                "\nЦвет : "+color+"\nРазмер : "+size+"\nДата выпуска : "+date+
                "\nЦена : "+price;
    }

    @Override
    public int compareTo(Clothes clothes) {
        if(clothes.size.getNumber()>this.size.getNumber())
            return 1;
        if(clothes.size.getNumber()<this.size.getNumber())
            return -1;
        return 0;
    }
}
