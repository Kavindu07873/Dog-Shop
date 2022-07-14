package Model;

public class AllOrders {
    private String Order_id;
    private String Customer_Id;
    private String Time;
    private String Order_Id;
    private String product_Name;
    private int qty;
    private Double Unit_Price;

    public AllOrders() {
    }

    public AllOrders(String order_id, String customer_Id, String time, String order_Id, String product_Name, int qty, Double unit_Price) {
        Order_id = order_id;
        Customer_Id = customer_Id;
        Time = time;
        Order_Id = order_Id;
        this.product_Name = product_Name;
        this.qty = qty;
        Unit_Price = unit_Price;
    }

    public String getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(String order_id) {
        Order_id = order_id;
    }

    public String getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        Customer_Id = customer_Id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getOrder_Id() {
        return Order_Id;
    }

    public void setOrder_Id(String order_Id) {
        Order_Id = order_Id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getUnit_Price() {
        return Unit_Price;
    }

    public void setUnit_Price(Double unit_Price) {
        Unit_Price = unit_Price;
    }

    @Override
    public String toString() {
        return "AllOrders{" +
                "Order_id='" + Order_id + '\'' +
                ", Customer_Id='" + Customer_Id + '\'' +
                ", Time='" + Time + '\'' +
                ", Order_Id='" + Order_Id + '\'' +
                ", product_Name='" + product_Name + '\'' +
                ", qty=" + qty +
                ", Unit_Price=" + Unit_Price +
                '}';
    }
}
