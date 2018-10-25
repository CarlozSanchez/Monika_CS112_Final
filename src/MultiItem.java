public interface MultiItem
{
    void setItem(Item item);
    void setCount(int count);

    Item getItem();
    int getCount();

    double getSubtotal();

    boolean equals();
    String toString();
}
