package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScoreLabel extends Pane {

    Text status = new Text("0");
    public ScoreLabel(double x, double y) {
        setPrefHeight(50);
        setPrefWidth(150);
        setTranslateX(x - 310);
        setTranslateY(y + 10);
        setStyle("-fx-background-color: white;");
        setOpacity(0.1);
        getChildren().addAll(status);
        status.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 22));
    }

    public void setText(String message) {
        status.setText(message);

    }
}
