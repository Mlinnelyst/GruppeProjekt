module com.mycompany.worldofzuulgui {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.worldofzuulgui to javafx.fxml;
    exports com.mycompany.worldofzuulgui;
}