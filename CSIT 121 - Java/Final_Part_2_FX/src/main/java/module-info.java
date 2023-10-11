module com.example.assignment2fx2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment2fx2 to javafx.fxml;
    exports com.example.assignment2fx2;
}