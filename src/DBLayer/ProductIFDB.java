package DBLayer;

import java.util.ArrayList;

import ModelLayer.Product;

public interface ProductIFDB {
    public Product findProduct(int productID);

    public ArrayList<Product> getAllProducts(boolean b);

    public int updateProduct(Product prod);

    public void insertProduct(Product prod);

    public void deleteProduct(Product prod);
}
