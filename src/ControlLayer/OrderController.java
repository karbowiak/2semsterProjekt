package ControlLayer;

import DBLayer.GetMax;
import DBLayer.OrderDB;
import ModelLayer.Order;
import ModelLayer.PartOrder;
import ModelLayer.Person;
import ModelLayer.Product;

import java.util.ArrayList;
import java.util.Date;

public class OrderController {
    private ProductController prController;
    private PersonController pController;
    private OrderDB orderDB;
    private Order tempOrder;

    /**
     *
     */
    public OrderController() {
        prController = new ProductController();
        orderDB = new OrderDB();
        createNewOrder();
    }

    private Order createNewOrder() {
        tempOrder = new Order();
        int nextID = GetMax.getMaxId("Select max(orderID) from orders");
        tempOrder.setOrderID(nextID);
        return tempOrder;
    }

    public Order findOrder(int orderID) {
        orderDB = new OrderDB();
        Order o = orderDB.findOrder(orderID);

        return o;
    }

    public void setStatus(String status, int orderID) {
        orderDB = new OrderDB();
        Order o = orderDB.findOrder(orderID);
        o.setDeliveryStatus(status);
        orderDB.setStatus(o);
    }

    public ArrayList<PartOrder> findPartOrder(int orderID) {
        orderDB = new OrderDB();
        Order o = findOrder(orderID);
        ArrayList<PartOrder> allPartOrders = new ArrayList<PartOrder>();
        allPartOrders = orderDB.getAllPartOrders(o.getOrderID());
        o.addAllPartorders(allPartOrders);
        return allPartOrders;
    }

    public ArrayList<Order> findAllOrders() {
        orderDB = new OrderDB();
        ArrayList<Order> allOrders = new ArrayList<Order>();
        allOrders = orderDB.getAllOrders();
        for (Order o : allOrders) {
            findPartOrder(o.getOrderID());
        }

        return allOrders;
    }

    public void insertNewPartOrder(int productID, int amount) throws Exception {
        Product product = prController.findProduct(productID);
        tempOrder.addPartorder(amount, product.getName(), product.getSalesPrice(), tempOrder.getOrderID(), productID);
        PartOrder po = tempOrder.getPartOrders().get(tempOrder.getPartOrders().size() - 1);

    }

    public void removePartOrder(int index) throws Exception {
        tempOrder.removePartorder(index);
    }

    public void endOrder(String phoneNumber) {
        tempOrder.setActive(true);
        pController = new PersonController();
        Person p = pController.findPerson(phoneNumber);
        tempOrder.setCustomerID(p.getId());
        tempOrder.setCreationDate(new Date());
        try {
            orderDB.addOrder(tempOrder);
            for (PartOrder po : tempOrder.getPartOrders()) {
                orderDB.addPartOrder(po);
            }
            createNewOrder();
        } catch (Exception e) {

        }

    }
}
