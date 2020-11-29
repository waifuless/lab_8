package ClothesTable;

public enum Size {
    XS(1), S(2), M(3), L(4), XL(5), XXL(6);

    int number;

    Size(int sizeNumb){
        this.number=sizeNumb;
    }

    public int getNumber() {
        return number;
    }
}
