package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.awt.*;
import java.sql.Time;
import java.text.ParseException;

public class ball {
    Circle b = new Circle();
    int speedX,speedY;
    int x,y;
    public ball()
    {
        speedX = 2;
        speedY = -2;
        b.setRadius(25);
        b.setCenterX(400);
        b.setCenterY(300);
        b.setFill(Color.RED);
    }

    public void moveY()
    {
        b.setTranslateY(b.getTranslateY()+speedY);
    }
    public void moveX()
    {
        b.setTranslateX(b.getTranslateX()+speedX);
    }
}