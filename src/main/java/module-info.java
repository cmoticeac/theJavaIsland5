module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;


    opens TheJavaIslandProd5 to javafx.fxml;
    exports TheJavaIslandProd5;
}