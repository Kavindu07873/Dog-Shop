import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/View/DashBoard.fxml"));
        Scene scene = new Scene(root);
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
//public class AppInitializer {
//    public AppInitializer() {
//    }
//
//    public void start(Stage primaryStage) throws Exception {
//        AnchorPane root = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/View/DashBoard.fxml"));
//        Scene scene = new Scene(root);
//        primaryStage.centerOnScreen();
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//}
