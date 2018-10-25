public interface PurchaseInterface
{
    void setId(int id);
    void setDate(String date);
    void setCollection(MultiItemCollection collection);

    int getId();
    String getDate();
    MultiItemCollection getMultiItemCollection();

    double total();

    boolean equals();
    String toString();
}
