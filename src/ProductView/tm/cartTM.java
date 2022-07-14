package ProductView.tm;

import javafx.scene.control.Button;

public class cartTM {
    private String PNAme;
    private String PDiscription;
    private double Price;
    private int qty;
    private double totalcost;
    private String category;
    private Button btn;
    public cartTM() {
    }

    public cartTM(String PNAme, String PDiscription, double price, int qty, double totalcost, String category, Button btn) {
        this.PNAme = PNAme;
        this.PDiscription = PDiscription;
        Price = price;
        this.qty = qty;
        this.totalcost = totalcost;
        this.category = category;
        this.btn = btn;
    }

    public String getPNAme() {
        return PNAme;
    }

    public void setPNAme(String PNAme) {
        this.PNAme = PNAme;
    }

    public String getPDiscription() {
        return PDiscription;
    }

    public void setPDiscription(String PDiscription) {
        this.PDiscription = PDiscription;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(double totalcost) {
        this.totalcost = totalcost;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "cartTM{" +
                "PNAme='" + PNAme + '\'' +
                ", PDiscription='" + PDiscription + '\'' +
                ", Price=" + Price +
                ", qty=" + qty +
                ", totalcost=" + totalcost +
                ", category='" + category + '\'' +
                ", btn=" + btn +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
