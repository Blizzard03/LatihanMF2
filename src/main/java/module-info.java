module com.mariq.rasyid.latihanmf2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mariq.rasyid.latihanmf2 to javafx.fxml;
    exports com.mariq.rasyid.latihanmf2;
}
