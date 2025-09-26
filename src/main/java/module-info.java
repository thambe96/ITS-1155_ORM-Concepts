module edu.lk.ijse.gdse.orm.ormassignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires static lombok;
    requires java.naming;
    requires modelmapper;
    requires jbcrypt;


    opens edu.lk.ijse.gdse.orm.ormassignment to javafx.fxml;
    exports edu.lk.ijse.gdse.orm.ormassignment;

    exports edu.lk.ijse.gdse.orm.ormassignment.controller;
    opens edu.lk.ijse.gdse.orm.ormassignment.entity;
    opens edu.lk.ijse.gdse.orm.ormassignment.dto;
    opens edu.lk.ijse.gdse.orm.ormassignment.dto.tm;

    opens edu.lk.ijse.gdse.orm.ormassignment.controller to javafx.fxml;
}