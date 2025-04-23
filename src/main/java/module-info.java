module edu.lk.ijse.gdse.orm.ormassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.lk.ijse.gdse.orm.ormassignment to javafx.fxml;
    exports edu.lk.ijse.gdse.orm.ormassignment;
    exports edu.lk.ijse.gdse.orm.ormassignment.controller;
    opens edu.lk.ijse.gdse.orm.ormassignment.controller to javafx.fxml;
}