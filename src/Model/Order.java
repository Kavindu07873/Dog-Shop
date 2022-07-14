package Model;

public class Order {
private String Order_id;
    private String Customer_Id;
     private String Time;

    public Order() {
    }

    public Order(String order_id, String customer_Id, String time) {
        Order_id = order_id;
        Customer_Id = customer_Id;
        Time = time;
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

    @Override
    public String toString() {
        return "Order{" +
                "Order_id='" + Order_id + '\'' +
                ", Customer_Id='" + Customer_Id + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
