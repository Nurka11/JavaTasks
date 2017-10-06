import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class midterm extends Application {
    private static final double WIDTH = 400;
    private static final double HEIGHT = 400;
    private static final double LIMIT_HEIGHT = (HEIGHT / 2);
    private static double[] percent = new double[]{0.20, 0.25, 0.30, 0.40};
    private static String[] titles = new String[] {
            "project - " + String.format("%d%s", (int)(100 * percent[0]), "%"),
            "quizzes - " + String.format("%d%s", (int)(100 * percent[1]), "%"),
            "midterm - " + String.format("%d%s", (int)(100 * percent[2]), "%"),
            "final - "+ String.format("%d%s", (int)(100 * percent[3]), "%")
     };
    

    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 10, 0, 10));
        Rectangle[] bars = new Rectangle[4];

        for (int i = 0; i < bars.length; i++) {

            bars[i] = new Rectangle(
                    5 + (100 * i), 
                    LIMIT_HEIGHT - (HEIGHT * percent[i]), 
                    WIDTH / bars.length - 5, 
                    HEIGHT * percent[i]); 
            

            Text text = new Text(5 + (100 * i),LIMIT_HEIGHT - (HEIGHT * percent[i]) - 5,titles[i]);
            pane.getChildren().addAll(text, bars[i]);

        }

        primaryStage.setScene(new Scene(pane, WIDTH + 20, LIMIT_HEIGHT));
        primaryStage.show();
    }
}