package Model;

public class Order_Detail {
    private String Order_Id;
    private String product_Name;
    private int qty;
    private Double Unit_Price;

    public Order_Detail() {
    }

    public Order_Detail(String order_Id, String product_Name, int qty, Double unit_Price) {
        Order_Id = order_Id;
        this.product_Name = product_Name;
        this.qty = qty;
        Unit_Price = unit_Price;
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
        return "Order_Detail{" +
                "Order_Id='" + Order_Id + '\'' +
                ", product_Name='" + product_Name + '\'' +
                ", qty=" + qty +
                ", Unit_Price=" + Unit_Price +
                '}';
    }
}
