package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Message {

	public static void showMsg(AlertType type, String msg, String tytle, String header) {
		Alert alert = new Alert(type);
		alert.setTitle(tytle);
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.show();
	}
}
