module esi.project {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;       
    requires java.base;
    
    opens g54895.atl.project.main to javafx.controls, javafx.graphics, java.desktop, java.base;
    opens g54895.atl.project.view to javafx.controls, javafx.graphics, java.desktop, java.base;
    exports g54895.atl.project.main;
    exports g54895.atl.project.view;

}
