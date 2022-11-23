module com.example.loginpage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loginpage to javafx.fxml;
    exports com.example.loginpage;
}