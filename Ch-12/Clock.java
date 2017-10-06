import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.*;
import javafx.util.Duration;
import java.util.*;
public class Clock extends Application {
  public static void main(String[] args) throws Exception { launch(args); }
  public void start(final Stage stage) throws Exception {
    final Circle face     = new Circle(100, 100, 100);
    face.setId("face");
    final Label brand     = new Label("NURZHAN");
    brand.setId("brand");
    brand.layoutXProperty().bind(face.centerXProperty().subtract(brand.widthProperty().divide(2)));
    brand.layoutYProperty().bind(face.centerYProperty().add(face.radiusProperty().divide(2)));
    final Line hourHand   = new Line(0, 0, 0, -50);
    hourHand.setTranslateX(100);   hourHand.setTranslateY(100);
    hourHand.setId("hourHand");
    final Line minuteHand = new Line(0, 0, 0, -75);
    minuteHand.setTranslateX(100); minuteHand.setTranslateY(100);
    minuteHand.setId("minuteHand");
    final Line secondHand = new Line(0, 15, 0, -88);
    secondHand.setTranslateX(100); secondHand.setTranslateY(100);
    secondHand.setId("secondHand");
    final Circle spindle = new Circle(100, 100, 5);
    spindle.setId("spindle");
    Group ticks = new Group();
    for (int i = 0; i < 12; i++) {
      Line tick = new Line(0, -83, 0, -93);
      tick.setTranslateX(100); tick.setTranslateY(100);
      tick.getStyleClass().add("tick");
      tick.getTransforms().add(new Rotate(i * (360 / 12)));
      ticks.getChildren().add(tick);
    }
    final Group analogueClock = new Group(face, brand, ticks, spindle, hourHand, minuteHand, secondHand);
    final Label digitalClock = new Label();
    digitalClock.setId("digitalClock");
    Calendar calendar            = GregorianCalendar.getInstance();
    final double seedSecondDegrees  = calendar.get(Calendar.SECOND) * (360 / 60);
    final double seedMinuteDegrees  = (calendar.get(Calendar.MINUTE) + seedSecondDegrees / 360.0) * (360 / 60);
    final double seedHourDegrees    = (calendar.get(Calendar.HOUR)   + seedMinuteDegrees / 360.0) * (360 / 12) ;
    final Rotate hourRotate      = new Rotate(seedHourDegrees);
    final Rotate minuteRotate    = new Rotate(seedMinuteDegrees);
    final Rotate secondRotate    = new Rotate(seedSecondDegrees);
    hourHand.getTransforms().add(hourRotate);
    minuteHand.getTransforms().add(minuteRotate);
    secondHand.getTransforms().add(secondRotate);
    final Timeline hourTime = new Timeline(
      new KeyFrame(
        Duration.hours(12),
        new KeyValue(
          hourRotate.angleProperty(),
          360 + seedHourDegrees,
          Interpolator.LINEAR
        )
      )
    );
    final Timeline minuteTime = new Timeline(
      new KeyFrame(
        Duration.minutes(60),
        new KeyValue(
          minuteRotate.angleProperty(),
          360 + seedMinuteDegrees,
          Interpolator.LINEAR
        )
      )
    );
    final Timeline secondTime = new Timeline(
      new KeyFrame(
        Duration.seconds(60),
        new KeyValue(
          secondRotate.angleProperty(),
          360 + seedSecondDegrees,
          Interpolator.LINEAR
        )
      )
    );
    final Timeline digitalTime = new Timeline(
      new KeyFrame(Duration.seconds(0),
        new EventHandler<ActionEvent>() {
          @Override 
		  public void handle(ActionEvent actionEvent) {
            Calendar calendar            = GregorianCalendar.getInstance();
            String hourString   = pad(2, '0', calendar.get(Calendar.HOUR)   == 0 ? "12" : calendar.get(Calendar.HOUR) + "");
            String minuteString = pad(2, '0', calendar.get(Calendar.MINUTE) + "");
            String secondString = pad(2, '0', calendar.get(Calendar.SECOND) + "");
            String ampmString   = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
            digitalClock.setText(hourString + ":" + minuteString + ":" + secondString + " " + ampmString);
          }
        }
      ),
      new KeyFrame(Duration.seconds(1))
    );
    hourTime.setCycleCount(Animation.INDEFINITE);
    minuteTime.setCycleCount(Animation.INDEFINITE);
    secondTime.setCycleCount(Animation.INDEFINITE);
    digitalTime.setCycleCount(Animation.INDEFINITE);
    digitalTime.play();
    secondTime.play();
    minuteTime.play();
    hourTime.play();

    stage.initStyle(StageStyle.TRANSPARENT);
    final Glow glow = new Glow();
    analogueClock.setOnMouseEntered(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        analogueClock.setEffect(glow);
      }
    });
    analogueClock.setOnMouseExited(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        analogueClock.setEffect(null);
      }
    });
    analogueClock.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        analogueClock.setMouseTransparent(true);
        FadeTransition fade = new FadeTransition(Duration.seconds(1.2), analogueClock);
        fade.setOnFinished(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent actionEvent) {
            stage.close();
          }
        });
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
      }
    });
    final VBox layout = new VBox();
    layout.getChildren().addAll(analogueClock, digitalClock);
    layout.setAlignment(Pos.CENTER);
    final Scene scene = new Scene(layout, Color.TRANSPARENT);
    scene.getStylesheets().add(getResource("clock.css"));
    stage.setScene(scene);
    final Delta dragDelta = new Delta();
    layout.setOnMousePressed(new EventHandler<MouseEvent>() { 
	  public void handle(MouseEvent mouseEvent) {
        dragDelta.x = stage.getX() - mouseEvent.getScreenX();
        dragDelta.y = stage.getY() - mouseEvent.getScreenY();
        scene.setCursor(Cursor.MOVE);
      }
    });
    layout.setOnMouseReleased(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        scene.setCursor(Cursor.HAND);
      }
    });
    layout.setOnMouseDragged(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        stage.setX(mouseEvent.getScreenX() + dragDelta.x);
        stage.setY(mouseEvent.getScreenY() + dragDelta.y);
      }
    });
    layout.setOnMouseEntered(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        if (!mouseEvent.isPrimaryButtonDown()) {
          scene.setCursor(Cursor.HAND);
        }
      }
    });
    layout.setOnMouseExited(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        if (!mouseEvent.isPrimaryButtonDown()) {
          scene.setCursor(Cursor.DEFAULT);
        }
      }
    });
    stage.show();
  }

  private String pad(int fieldWidth, char padChar, String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length(); i < fieldWidth; i++) {
      sb.append(padChar);
    }
    sb.append(s);

    return sb.toString();
  }

  static String getResource(String path) {
    return Clock.class.getResource(path).toExternalForm();
  }
  class Delta { double x, y; }  
}