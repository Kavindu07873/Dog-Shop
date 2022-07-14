package Controller.ProductController;

import Model.food;
import Utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodCrudController {
    public  static ArrayList<String>  getFoodIds() throws SQLException, ClassNotFoundException {

        ResultSet result = CrudUtil.execute("SELECT Product_id FROM food");
        ArrayList<String> ids = new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
return ids;
    }
public static food getfood(String Product_id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM food WHERE Product_id=?",Product_id);
if(result.next()){
    return new food(
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
