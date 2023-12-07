module com.example.scoregui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scoregui to javafx.fxml;
    exports com.example.scoregui;
    exports com.example.scoregui.BTNS;
    opens com.example.scoregui.BTNS to javafx.fxml;
    exports com.example.scoregui.BTNS.Items;
    opens com.example.scoregui.BTNS.Items to javafx.fxml;
}