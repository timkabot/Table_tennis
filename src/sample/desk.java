package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by Timkabo on 28.04.2016.
 */
public class desk {
    Rectangle b = new Rectangle();
    int speedX,speedY;

    public desk()
    {
        speedX = 2;
        speedY = -2;
        b.setTranslateX(0);
        b.setWidth(20);
        b.setHeight(150);
        b.setTranslateY(0);
        b.setFill(Color.BLUE);
        b.setStyle("-fx-background : green");
    }

    public void moveUP()
    {
      if(b.getTranslateY()>0)b.setTranslateY(b.getTranslateY()-10);
    }
    public void moveBot()
    {
        if(b.getTranslateY()<450)b.setTranslateY(b.getTranslateY()+10);
    }
}
