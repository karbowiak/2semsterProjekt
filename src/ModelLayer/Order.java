/**
 *
 */
package ModelLayer;

import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private ArrayList<PartOrder> partOrders = new ArrayList<PartOrder>();
    private int customerID;
    private Date creationDate;
    private int orderID;
    private Date deliveryDate;
    private String DeliveryStatus;
    private boolean isActive;
    private float orderPrice;

    public Order() {
        creationDate = new Date();

        DeliveryStatus = "Oprettet";
    }

    /**
     * @return the customer
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param date the date to set
     */
    public void setCreationDate(Date date) {
        creationDate = date;
        deliveryDate = DateUtils.addDays(creationDate, 7);
    }

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the partOrders
     */
    public ArrayList<PartOrder> getPartOrders() {
        return partOrders;
    }

    public void addPartorder(int amount, String name, float price, int orderID, int productID) {
        partOrders.add(new PartOrder(amount, name, price, orderID, productID));
        orderPrice += amount * price;
    }

    public void addAllPartorders(ArrayList<PartOrder> po) {
        partOrders = po;
    }

    public void removePartorder(int i) {
        partOrders.remove(i);
    }

    /**
     * @return the isActive
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the deliveryDate
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(Date date) {
        deliveryDate = date;
    }

    /**
     * @return the deliveryStatus
     */
    public String getDeliveryStatus() {
        return DeliveryStatus;
    }

    /**
     * @param deliveryStatus the deliveryStatus to set
     */
    public void setDeliveryStatus(String deliveryStatus) {
        DeliveryStatus = deliveryStatus;
    }

    /**
     * @return the orderPrice
     */
    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float price) {
        orderPrice = price;
    }
}
