package com.example.osc;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.*;

import java.io.IOException;
import java.util.Hashtable;

public class HelloApplication extends Application {
FileWriter fileWriter=new FileWriter();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {


        launch();
    }

    @Override
    public void stop() throws Exception {
        fileWriter.write(LoginHandler.getInstance().getCustomerMap());
    }
}