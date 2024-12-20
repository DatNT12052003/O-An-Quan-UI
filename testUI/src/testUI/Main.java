package testUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml")); // Đảm bảo tệp FXML có tên đúng
        Scene scene = new Scene(root);

        primaryStage.setTitle("JavaFX Animation Example");
        primaryStage.setScene(scene);
        primaryStage.show();
//    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/testUI/View.fxml"));
//    	Parent root = loader.load();
//    	Controller controller = loader.getController();
//    	controller.init(); // Phải gọi thủ công
//      Scene scene = new Scene(root);
//
//      primaryStage.setTitle("JavaFX Animation Example");
//      primaryStage.setScene(scene);
//      primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
