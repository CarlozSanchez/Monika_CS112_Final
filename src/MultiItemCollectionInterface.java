public interface MultiItemCollectionInterface
{
    MultiItem getMultiItemArray();
    int getIndexUsed();

    boolean addMultiItem(MultiItem multiItem);
    boolean addMultiItem(MultiItem[] multiItem);
    MultiItem removeLastItem();
    MultiItem removeMultiItem(MultiItem multiItem);
    void clearAll();
    double total();

    boolean equals();
    String toString();
}
