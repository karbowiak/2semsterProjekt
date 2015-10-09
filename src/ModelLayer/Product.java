/**
 *
 */
package ModelLayer;

/**
 * @author S�ren
 */
public class Product {

    private String name;
    private float purchasePrice;
    private float salesPrice;
    private float rentPrice;
    private String countryOfOrigin;
    private int minStock;
    private int id;
    private int type;
    private int supplierID;
    private int isActive;

    /**
     *
     */
    public Product() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the purchasePrice
     */
    public float getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * @param purchasePrice the purchasePrice to set
     */
    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * @return the salesPrice
     */
    public float getSalesPrice() {
        return salesPrice;
    }

    /**
     * @param salesPrice the salesPrice to set
     */
    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    /**
     * @return the rentPrice
     */
    public float getRentPrice() {
        return rentPrice;
    }

    /**
     * @param rentPrice the rentPrice to set
     */
    public void setRentPrice(float rentPrice) {
        this.rentPrice = rentPrice;
    }

    /**
     * @return the countryOfOrigin
     */
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    /**
     * @param countryOfOrigin the countryOfOrigin to set
     */
    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    /**
     * @return the minStock
     */
    public int getMinStock() {
        return minStock;
    }

    /**
     * @param minStock the minStock to set
     */
    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the supplierID
     */
    public int getSupplierID() {
        return supplierID;
    }

    /**
     * @param supplierID the supplierID to set
     */
    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int isActive() {
        return isActive;
    }

    /**
     * @param isActive2 the isActive to set
     */
    public void setActive(int isActive2) {
        this.isActive = isActive2;
    }

}
