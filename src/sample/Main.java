package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    Group m = new Group();
    boolean second_wins=false;
    boolean first_wins = false;
    ball b = new ball();
    desk d1 = new desk();
    desk d2 = new desk();
    ScoreLabel space = new ScoreLabel(650,255);
    int count1 = 0,count2=0;
    Timeline moving;
    AudioClip stuk = new AudioClip(this.getClass().getResource("huh.wav").toExternalForm());
    AudioClip end = new AudioClip(this.getClass().getResource("end.mp3").toExternalForm());
    @Override
    public void start(Stage primaryStage) throws Exception{
        stuk.setCycleCount(1);
        end.setCycleCount(1);
        space.setText("Press space");
        space.setOpacity(1);
        d2.b.setTranslateX(780);
        ScoreLabel score1 = new ScoreLabel(550,15);
        ScoreLabel score2 = new ScoreLabel(850,15);
        m.getChildren().addAll(b.b,d1.b,d2.b,score1,score2);
        Scene scene = new Scene(m,800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode k = event.getCode();
                if(k == KeyCode.SPACE && second_wins==true)
                {
                    m.getChildren().removeAll(space);
                    init_game();
                    b.speedX = -b.speedX;
                }
                else   if(k == KeyCode.SPACE && first_wins==true)
                {
                    m.getChildren().removeAll(space);
                    init_game();
                }
                else if(k == KeyCode.W){d1.moveUP();}
                else if(k == KeyCode.S){d1.moveBot();}
                else if(k == KeyCode.UP){d2.moveUP();}
                else if(k == KeyCode.DOWN){d2.moveBot();}
            }
        });
        moving = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(b.b.getTranslateX()<-360 && b.b.getTranslateY()+300>=d1.b.getTranslateY() && b.b.getTranslateY()+300<=d1.b.getTranslateY()+150)
                {
                    stuk.play();
                    b.speedX = -b.speedX;
                    System.out.println(d2.b.getTranslateY());
                }
                if(b.b.getTranslateX()>360 && b.b.getTranslateY()+300>=d2.b.getTranslateY() && b.b.getTranslateY()+300<=d2.b.getTranslateY()+150)
                {
                    stuk.play();
                    b.speedX = -b.speedX;
                    System.out.println(d2.b.getTranslateY());
                }
                if(b.b.getTranslateY()<-300 || b.b.getTranslateY()>300)b.speedY = -b.speedY;
                b.b.setTranslateX(b.b.getTranslateX()+b.speedX);
                b.b.setTranslateY(b.b.getTranslateY()+b.speedY);
                if(b.b.getTranslateX()<-400)
                {
                    end.play();
                    second_wins = true;
                    count2++;
                    score2.setText(""+count2);
                    moving.stop();
                    m.getChildren().addAll(space);
                }
                if(b.b.getTranslateX()>400)
                {
                    end.play();
                    first_wins = true;
                    count1++;
                    score1.setText(""+count1);
                    moving.stop();
                    m.getChildren().addAll(space);
                }
            }
        }));
        moving.setCycleCount(-1);
        moving.play();
    }
    public void init_game()
    {
        moving.play();
        b.b.setTranslateY(0);
        b.b.setTranslateX(0);
        b.speedX = -2;
        b.speedY = -2;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
