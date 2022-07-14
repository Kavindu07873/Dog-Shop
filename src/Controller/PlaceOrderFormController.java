package Controller;

import Controller.CustomerController.CustomerCrudController;
import Controller.ProductController.*;
import Model.*;
import ProductView.tm.cartTM;
import Utill.CrudUtil;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class PlaceOrderFormController {
    public JFXComboBox<String> cmbCustomerId;

    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerAddress;
    public JFXTextField txtCustomerNo;
    public ComboBox<String> cmbfoodid;
    public TextField txtItemName;
    public TextField txtItemDescription;
    public TextField txtQty;
    public TextField txtPrice;
    public ComboBox<String> cmbMedicine;
    public JFXTextField txtOwnqty;
    public TableView<cartTM> tblCart;
    public TableColumn colName;
    public TableColumn colDescription;
    public TableColumn colPrice;
    public TableColumn colQty;
    public TableColumn colTotal;
    public TableColumn colButtonFild;
    public TextField lblTotalCost;
    public ComboBox<String> cmbShampoo;
    public ComboBox<String> cmbToys;
    public ComboBox<String> cmbVitamins;
    public TextField lblDate;
    public TableColumn colcategory;
    public ComboBox<String> cmbCategory;
    public TextField txtcategory;
    public TextField lblTime;

    private String orderId;

    public void initialize() {
        Date();
        time();
        setOrderId();
        setCmbCustomerId();
        setfoodItems();
        setMedicineId();
        setShampooId();
        setToyId();
        setVitaminId();
        cmbCustomerId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setCustomerDetails(newValue);
        });
        cmbfoodid.getSelectionModel().selectedItemProperty().addListener((observable1, oldValue1, newValue1) -> {
            setfoodDetails(newValue1);
        });
        cmbMedicine.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setmedicineDetails(newValue);
        });
        cmbShampoo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setShampooDetails(newValue);
        });
        cmbToys.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setToyDetails(newValue);
        });
        cmbVitamins.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setVitaminDetails(newValue);
        });


        colName.setCellValueFactory(new PropertyValueFactory("PNAme"));
        colcategory.setCellValueFactory(new PropertyValueFactory("category"));
        colDescription.setCellValueFactory(new PropertyValueFactory("PDiscription"));
        colPrice.setCellValueFactory(new PropertyValueFactory("Price"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colTotal.setCellValueFactory(new PropertyValueFactory("totalcost"));
        colButtonFild.setCellValueFactory(new PropertyValueFactory("btn"));
        

    }

    public void Date() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd");

            lblDate.setText(LocalDateTime.now().format(formatter));

        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    public void time() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" +
                    currentTime.getMinute() + ":" +
                    currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }



    private void setOrderId() {
    }

    private void setVitaminDetails(String selectedVitamisCode) {

        try {
            vitamins_supliment M = vitaminCrudController.getVitaminDetails(selectedVitamisCode);
            if (M != null) {
                txtItemName.setText(M.getProduct_name());
                txtItemDescription.setText(M.getDescription());
                txtQty.setText(String.valueOf(M.getQty()));
                txtPrice.setText(String.valueOf(M.getPrice()));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setVitaminId() {
        try {
            ObservableList<String> SidObList = FXCollections.observableArrayList(
                    vitaminCrudController.getVitaminIds()
            );
            cmbVitamins.setItems(SidObList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    private void setToyDetails(String selectedtoyCode) {

        try {
            toy M = toyCrudController.getToyDetail(selectedtoyCode);
            if (M != null) {
                txtItemName.setText(M.getProduct_name());
                txtItemDescription.setText(M.getDescription());
                txtQty.setText(String.valueOf(M.getQty()));
                txtPrice.setText(String.valueOf(M.getPrice()));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void setToyId() {
        try {
            ObservableList<String> SidObList = FXCollections.observableArrayList(
                    toyCrudController.getToyId()
            );
            cmbToys.setItems(SidObList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////
    private void setShampooDetails(String selectedShampooCode) {

        try {
            shampoo_odours M = Shampoo_odoursCrudController.getShampooDetails(selectedShampooCode);
            if (M != null) {
                txtItemName.setText(M.getProduct_name());
                txtItemDescription.setText(M.getDescription());
                txtQty.setText(String.valueOf(M.getQty()));
                txtPrice.setText(String.valueOf(M.getPrice()));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setShampooId() {
        try {
            ObservableList<String> SidObList = FXCollections.observableArrayList(
                    Shampoo_odoursCrudController.getshampooIds()
            );
            cmbShampoo.setItems(SidObList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    ////////////////////////////////////////////////////////////////////////////////
    private void setmedicineDetails(String selectedmedicineCode) {
        try {
            medicine M = medicineCrudController.getMedicineDetails(selectedmedicineCode);
            if (M != null) {
                txtItemName.setText(M.getProduct_name());
                txtItemDescription.setText(M.getDescription());
                txtQty.setText(String.valueOf(M.getQty()));
                txtPrice.setText(String.valueOf(M.getPrice()));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setMedicineId() {
        try {
            ObservableList<String> midObList = FXCollections.observableArrayList(
                    medicineCrudController.getMedicineIds()
            );
            cmbMedicine.setItems(midObList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////
    private void setfoodDetails(String salectedfoodCode) {

        try {
            food F = FoodCrudController.getfood(salectedfoodCode);
            if (F != null) {
                txtItemName.setText(F.getProduct_name());
                txtItemDescription.setText(F.getDescription());
                txtQty.setText(String.valueOf(F.getQty()));
                txtPrice.setText(String.valueOf(F.getPrice()));

            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void setfoodItems() {
        try {

            ObservableList<String> fidObList = FXCollections.observableArrayList(
                    FoodCrudController.getFoodIds()
            );
            cmbfoodid.setItems(fidObList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    private void setCustomerDetails(String selectedCustomerId) {
        try {
            Customer c = CustomerCrudController.getCustomer(selectedCustomerId);
            if (c != null) {
                txtCustomerName.setText(c.getCusId());
                txtCustomerNo.setText(c.getCusNo());
                txtCustomerAddress.setText(c.getAddress());

            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setCmbCustomerId() {

        try {
            ObservableList<String> cIdObList = FXCollections.observableArrayList(
                    CustomerCrudController.getCustomerIds()
            );
            cmbCustomerId.setItems(cIdObList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    //////////////////////////////////////////////////////////////////////////
    ObservableList<cartTM> tmList = FXCollections.observableArrayList();
    public void onActionFood(ActionEvent actionEvent) {
        txtcategory.setText("food");
    }
    public void OnActionMedicine(ActionEvent actionEvent) {
        txtcategory.setText("medicine");
    }
    public void onActionToys(ActionEvent actionEvent) {
        txtcategory.setText("Toys");

    }
    public void OnActionShampoo(ActionEvent actionEvent) {
        txtcategory.setText("Shampoo");

    }
    public void OnActionVitamins(ActionEvent actionEvent) {
        txtcategory.setText("vitamins");

    }

    public void AddToCartOnAction(ActionEvent actionEvent) {

        double unitPrice = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtOwnqty.getText());
        double totalCost = unitPrice * qty;


        cartTM isExists = isExists(txtItemName.getText());
        if (isExists != null) {
            for (cartTM temp : tmList
            ) {
                if (temp.equals(isExists)) {
                    temp.setQty((temp.getQty()) + qty);
                    temp.setTotalcost((temp.getTotalcost() + totalCost));
                }
            }

        } else {
            Button btn = new Button("Delete");
            cartTM tm = new cartTM(
                    txtItemName.getText(),
                    txtItemDescription.getText(),
                    unitPrice,
                    qty,
                    totalCost,
                    txtcategory.getText(),
                    btn

            );

            btn.setOnAction(event -> {
                for (cartTM tempTm : tmList
                ) {
                    if (tempTm.getPNAme().equals(tm.getPNAme())) {
                        tmList.remove(tempTm);
                        CalculateTotal();
                    }
                }
            });

            tmList.add(tm);
            tblCart.setItems(tmList);

        }
        tblCart.refresh();
        CalculateTotal();

    }

    public void ClickOnActionAddCustomer(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../CustomerView/SaveCustomer.fxml"))));
        stage.show();
    }

    private cartTM isExists(String Product_Name) {
        for (cartTM tm : tmList
        ) {
            if (tm.getPNAme().equals(Product_Name)) {
                return tm;
            }
        }
        return null;
    }

    private void CalculateTotal() {
        double total = 0;
        for (cartTM tm : tmList
        ) {
            total += tm.getTotalcost();
        }
        lblTotalCost.setText(String.valueOf(total));
    }




    public void PlaceOrderOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        ResultSet set = CrudUtil.execute("SELECT Order_Id FROM Orders ORDER BY Order_Id DESC LIMIT 1");
        System.out.println("sssssssssssssssssssss");
        System.out.println(set);
            String newVersion;
            if(set.next()){
                String version = set.getString(1);
                int a = version.length();

                int i = (Integer.parseInt(version.substring(1,a))+1);
                if (i==100){
                    newVersion = "S"+i;
                }else {
                    newVersion = "S0"+i;
                }
            }else {
                newVersion = "S01";
            }
        System.out.println(newVersion);

                Order order = new Order(
                   newVersion ,
                    cmbCustomerId.getValue(),
                    lblTime.getText()
            );
            ArrayList<Order_Detail> details = new ArrayList<>();
            for (cartTM tm : tmList
            ) {
                details.add(
                        new Order_Detail(
                                newVersion,
                                tm.getPNAme(),
                                tm.getQty(),
                                tm.getTotalcost()
                        )
                );
            }


            System.out.println("details" + details.toString());

            CrudUtil.execute("INSERT INTO orders VALUES(?,?,?)",
                   order.getOrder_id(), order.getCustomer_Id(), order.getTime());
            try {

                System.out.println("ok");

                for (Order_Detail deta : details
                ) {
                    if (txtcategory.getText().equals("medicine")) {
                        System.out.println("medicine");
                        // System.out.println(details);
                        CrudUtil.execute("INSERT INTO orderdetails VALUES(?,?,?,?)",
                                deta.getOrder_Id(), deta.getProduct_Name(), deta.getQty(), deta.getUnit_Price());

                        CrudUtil.execute("UPDATE medicine SET qty = qty-? WHERE Product_name =? ", deta.getQty(), deta.getProduct_Name());
                    }
                    if (txtcategory.getText().equals("food")) {
                        System.out.println("food");
                        System.out.println(details);
                        CrudUtil.execute("INSERT INTO orderdetails VALUES(?,?,?,?)",
                                deta.getOrder_Id(),    deta.getProduct_Name(), deta.getQty(), deta.getUnit_Price());
                        CrudUtil.execute("UPDATE food SET qty = qty-? WHERE Product_name =? ", deta.getQty(), deta.getProduct_Name());

                    }
                    if (txtcategory.getText().equals("Toys")) {
                        System.out.println("Toys");
                        System.out.println(details);
                        CrudUtil.execute("INSERT INTO orderdetails VALUES(?,?,?,?)",
                                deta.getOrder_Id(),  deta.getProduct_Name(), deta.getQty(), deta.getUnit_Price());
                        CrudUtil.execute("UPDATE toys SET qty = qty-? WHERE Product_name =? ", deta.getQty(), deta.getProduct_Name());

                    }
                    if (txtcategory.getText().equals("Shampoo")) {
                        System.out.println("Shampoo");
                        System.out.println(details);
                        CrudUtil.execute("INSERT INTO orderdetails VALUES(?,?,?,?)",
                                deta.getOrder_Id(), deta.getProduct_Name(), deta.getQty(), deta.getUnit_Price());
                        CrudUtil.execute("UPDATE shampoo_odours SET qty = qty-? WHERE Product_name =? ", deta.getQty(), deta.getProduct_Name());

                    }
                    if (txtcategory.getText().equals("vitamins")) {
                        System.out.println("vitamins");
                        System.out.println(details);
                        CrudUtil.execute("INSERT INTO orderdetails VALUES(?,?,?,?)",
                                deta.getOrder_Id(), deta.getProduct_Name(), deta.getQty(), deta.getUnit_Price());
                        CrudUtil.execute("UPDATE vitamins_supliment SET qty = qty-? WHERE Product_name =? ", deta.getQty(), deta.getProduct_Name());

                    }
                }

                clearAll();
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!").showAndWait();

            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);

            }
        }

    public void btnOnActionRemove(ActionEvent actionEvent) {
        tblCart.getItems().removeAll(tmList);
        txtcategory.clear();
        txtItemName.clear();
        txtPrice.clear();
        txtQty.clear();
        txtOwnqty.clear();
        txtItemDescription.clear();
        lblTotalCost.clear();
      }
      public void clearAll(){
          tblCart.getItems().removeAll(tmList);
          txtcategory.clear();
          txtItemName.clear();
          txtPrice.clear();
          txtQty.clear();
          txtOwnqty.clear();
          txtItemDescription.clear();
          lblTotalCost.clear();
      }
}





