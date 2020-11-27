module esi.project {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;       
    requires java.base;
    
    //opens esi.project to javafx.fxml;
    exports g54895.atl.project.main;
    exports g54895.atl.project.view;

}
