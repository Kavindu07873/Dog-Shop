package Controller;

import Model.AllOrders;
import Model.food;
import Utill.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDetails {
    public TableColumn colOrderId;
    public TableColumn colCusid;
    public TableColumn colTime;
    public TableColumn colOr;
    public TableColumn colProductName;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableView tblOrderDetails;

    public void initialize() {

        colOrderId.setCellValueFactory(new PropertyValueFactory("Order_id"));
        colCusid.setCellValueFactory(new PropertyValueFactory("Customer_Id"));
        colTime.setCellValueFactory(new PropertyValueFactory("Time"));
        //colOr.setCellValueFactory(new PropertyValueFactory("Order_Id"));
        colProductName.setCellValueFactory(new PropertyValueFactory("product_Name"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory("Unit_Price"));

        try {
            LoadAllOrdersDetails();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
tblOrderDetails.refresh();
    }

    private void LoadAllOrdersDetails() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM orders INNER JOIN orderdetails ON (orders.Order_Id = orderdetails.Order_Id );");
        ObservableList<AllOrders> obList = FXCollections.observableArrayList();
        while (result.next()) {
            obList.add(
                    new AllOrders(
                            result.getString("Order_id"),
                            result.getString("Customer_id"),
                            result.getString("Time"),
                            result.getString("Order_Id"),
                            result.getString("product_Name"),
                            result.getInt("qty"),
                            result.getDouble("Unit_Price")


                    )
            );
        }
        tblOrderDetails.setItems(obList);
    }
}
