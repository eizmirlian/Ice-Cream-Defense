module CS2340 {
	requires javafx.controls;
	requires javafx.graphics;
  requires org.junit.jupiter.api;
requires javafx.base;
requires junit;
requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
