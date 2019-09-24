package dad.adivinaApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinaApp extends Application {

	private TextField numeroText;
	private Button comprobarButton;
	private Label fraseLabel;
	int random = (int) ((Math.random() * 100 - 1) + 1);
	int intentos = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println(random);
		fraseLabel = new Label("Introduce un número del 1 al 100");

		numeroText = new TextField();
		numeroText.setPromptText("0");
		numeroText.setMaxWidth(150);

		comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(event -> onComprobarButtonAction(event));

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(fraseLabel, numeroText, comprobarButton);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("AdivinaApp");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onComprobarButtonAction(ActionEvent event) {

		String numero = numeroText.getText();
		int num;
		Alert alerta;

		try {

			num = Integer.parseInt(numero);

			if (num == random) {

				alerta = new Alert(AlertType.INFORMATION);
				alerta.setTitle("AdivinaApp");
				alerta.setHeaderText("¡HAS GANADO!");
				alerta.setContentText("Solo haz necesitado " + intentos + " intentos.");
				alerta.showAndWait();

			} else if (num != random) {

				alerta = new Alert(AlertType.WARNING);
				alerta.setTitle("AdivinaApp");
				alerta.setHeaderText("¡HAS FALLADO!");
				if (num > random) {
					alerta.setContentText("El numero introducido es menor " + num);
					alerta.showAndWait();
					intentos++;
				}
				else {
					
					alerta.setContentText("El numero introducido es mayor " + num);
					alerta.showAndWait();
					intentos++;
					
				}
			}

		} catch (NumberFormatException e) {

			alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("AdivinaApp");
			alerta.setHeaderText("¡ERROR!");
			alerta.showAndWait();

		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
