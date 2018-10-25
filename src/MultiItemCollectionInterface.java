public interface MultiItemCollectionInterface
{
    MultiItem getMultiItemArray();
    int getCount();

    boolean addMultiItem(MultiItem multiItem);
    boolean addMultiItem(MultiItem[] multiItem);
    MultiItem removeLastItem();
    MultiItem removeMultiItem(MultiItem multiItem);
    void clearAll();
    double total();

    boolean equals();
    String toString();
}
