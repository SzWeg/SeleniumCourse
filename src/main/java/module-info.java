module pl.coderslab.seleniumcourse {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.coderslab.seleniumcourse to javafx.fxml;
    exports pl.coderslab.seleniumcourse;
}