import java.util.ArrayList;
import java.util.List;

import classe.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    public static List<Conta> accounts = new ArrayList<>();
    public static List<Cliente> users = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader= new FXMLLoader(getClass()
        .getResource("gui/Menu Empresa.fxml"));

        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Menu Empresa");
        primaryStage.setScene(tela);
        primaryStage.show();
    }
}