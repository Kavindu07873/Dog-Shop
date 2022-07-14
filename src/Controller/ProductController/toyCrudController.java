package Controller.ProductController;

import Model.shampoo_odours;
import Model.toy;
import Utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class toyCrudController {
    public static ArrayList<String> getToyId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT Product_id FROM toys");
        ArrayList<String> ids = new ArrayList<>();
        while (result.next()) {
            ids.add(result.getString(1));
        }
        return ids;
    }
    public static toy getToyDetail(String Product_id) throws SQLException,ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM toys WHERE Product_id=?",Product_id);
        if(result.next()){
            return new toy(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getDouble(5)
            );
        }
        return null;
    }
}