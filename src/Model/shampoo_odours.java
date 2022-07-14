package Model;

public class shampoo_odours {
    private String Product_id;
    private String Product_name;
    private String Description;
    private int qty;
    private Double Price;

    public shampoo_odours() {
    }

    public shampoo_odours(String product_id, String product_name, String description, int qty, Double price) {
        Product_id = product_id;
        Product_name = product_name;
        Description = description;
        this.qty = qty;
        Price = price;
    }

    public String getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(String product_id) {
        Product_id = product_id;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "shampoo_odours{" +
                "Product_id='" + Product_id + '\'' +
                ", Product_name='" + Product_name + '\'' +
                ", Description='" + Description + '\'' +
                ", qty=" + qty +
                ", Price=" + Price +
                '}';
    }
    /*
    public shampoo_odours() {
    }

    public shampoo_odours(String product_id, String product_name, String description, String qty, String price) {
        Product_id = product_id;
        Product_name = product_name;
        Description = description;
        this.qty = qty;
        Price = price;
    }

    public String getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(String product_id) {
        Product_id = product_id;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "shampoo_odours{" +
                "Product_id='" + Product_id + '\'' +
                ", Product_name='" + Product_name + '\'' +
                ", Description='" + Description + '\'' +
                ", qty='" + qty + '\'' +
                ", Price='" + Price + '\'' +
                '}';
    }

 */
}
