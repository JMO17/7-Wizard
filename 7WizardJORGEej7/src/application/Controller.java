package application;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller {

	@FXML
	private AnchorPane panel1;

	@FXML
	private AnchorPane panel2;

	@FXML
	private AnchorPane panel3;

	@FXML
	private Label contadorLabel;

	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	public void initialize() {
		translateAnimation(0.5, panel2, 600);
		translateAnimation(0.5, panel3, 600);
	}

	int showSlide = 0;

	@FXML
	void nextAction() {

		if (showSlide == 0) {
			translateAnimation(0.5, panel2, -600);
			showSlide++; // showSlide=1
			contadorLabel.setText("2/3");
		} else if (showSlide == 1) {

			translateAnimation(0.5, panel3, -600);
			showSlide++; // showSlide=2
			contadorLabel.setText("3/3");

		} else {
			mensajeNN();
		}

	}

	@FXML
	void backAction() {

		if (showSlide == 0) {
			mensajeNN();
		} else if (showSlide == 1) {
			translateAnimation(0.5, panel2, 600);
			showSlide--; // showSlide=0
			contadorLabel.setText("1/3");
		} else if (showSlide == 2) {
			translateAnimation(0.5, panel3, 600);
			showSlide--; // showSlide=1
			contadorLabel.setText("2/3");
		}

	}

	void mensajeNN() {
		System.out.println("No hay mas slides");
	}

}
