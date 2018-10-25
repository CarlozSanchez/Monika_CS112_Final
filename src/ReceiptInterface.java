public interface ReceiptInterface
{
    int getID();
    String getDate();
    Purchase getPurchase();

    void print();

    boolean equals();
    String toString();
}
