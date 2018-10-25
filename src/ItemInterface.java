public interface ItemInterface
{
    // Setters

    /***
     * DESCRIPTION: item ID Setter, sets ID to Unique Non Negative Number
     * PRECONDITION: the ID must be unique to this item, ID cannot be used by another Item collection.
     * POSTCONDITION: The items ID number will be updated to given value if id number is valid.
     * @param id The ID to set this item to.
     */
    void setID(int id);

    /***
     * DESCRIPTION: item name setter, sets name for this item.
     * PRECONDITION: Should avoid using numbers or symbols as much as possible. (-_,") are allowed, numbers are allowed
     * if the first characters is a Letter.
     * POSTCONDITION: The Items names is set to given string.
     * @param name The name to set this item to.
     */
    void setName(String name);

    /***
     * DESCRIPTION: item price setter, sets price for this item.
     * PRECONDITION: The price must be a non negative double up to hundredths place.
     * POSTCONDITION: The items price is set to given value if value is valid.
     * @param price
     */
    void setPrice(double  price);

    /***
     * DESCRIPTION: accessor for ID, returns the id number associated with this item.
     * PRECONDITION: none
     * POSTCONDITION: returns the a unique ID associated with this item.
     * @return an integer representing the unit ID of this item.
     */
    int getID();

    /***
     * DESCRIPTION: accessor for name, returns the name of this item.
     * PRECONDITION: none
     * POSTCONDITION: returns a string representing the name of this item.
     * @return a String representing the name of this item.
     */
    String getName();


    /***
     * DESCRIPTION: accessor for price, returns the price of this item.
     * PRECONDITION: non
     * POSTCONDITION: returns a double representing the price of this item.
     * @return a double representing the price of this item.
     */
    double getPrice();


    // Overrides

    /***
     * DESCRIPTION: override toString() method,  describes the current state of this class.
     * PRECONDITION: none
     * POSTCONDITION: Describes the current state of this item by returning id, name, and price.
     * @return A String description of this item class, with id, name and price included.
     */
    String toString();

    /***
     * DESCRIPTION: override equals() method, checks unique ID for equality.
     * PRECONDITION: none.
     * POSTCONDITION:  Returns true if this items Unique ID equals other objects Unique ID
     * @return boolean true if this item equals other, false otherwise.
     */
    boolean equals(Object other);
}
