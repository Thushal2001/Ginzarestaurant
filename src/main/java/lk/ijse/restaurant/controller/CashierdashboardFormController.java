package lk.ijse.restaurant.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class CashierdashboardFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Label lbldateandtime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd      hh:mm");
        Date date = new Date();
        lbldateandtime.setText(simpleDateFormat.format(date));
    }

    @FXML
    private void managecustomersOnAction(ActionEvent event) throws IOException {
        setUI("managecustomers_form");
    }

    @FXML
    private void managestoreOnAction(ActionEvent event) throws IOException {
        setUI("managestore_form");
    }

    @FXML
    private void manageordersOnAction(ActionEvent event) throws IOException {
        setUI("manageorders_form");
    }

    @FXML
    private void deliveryOnAction(ActionEvent event) throws IOException {
        setUI("delivery_form");
    }

    @FXML
    private void logoutOnAction(ActionEvent event) {

    }

    private void setUI(String URL) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/" + URL + ".fxml"));
        Stage stage = (Stage) root.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle(URL);
        stage.setResizable(false);
        stage.show();
    }
}
