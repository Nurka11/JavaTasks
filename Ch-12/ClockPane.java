import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.application.Application;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
public class ClockPane extends Pane {
 
    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;
    private Timeline timeline;
    private double w = 250, h = 250;
    public ClockPane() {
        setPrefHeight(h);
        setPrefWidth(w);
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        setCurrentTime();
    }
    public ClockPane(int hour, int minute, int second) {
        this();
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
    }

    public ClockPane(int hour, int minute, int second, double width, double height) {
        this(hour, minute, second);
        this.w = width;
        this.h = height;
        paintClock();
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }
    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }
    public double getW() {
        return w;
    }
    public void setW(double w) {
        this.w = w;
        paintClock();
    }
    public double getH() {
        return h;
    }
    public void setH(double h) {
        this.h = h;
        paintClock();
    }
    public boolean isHourHandVisible() {
        return hourHandVisible;
    }
    public void setHourHandVisible(boolean hourHandVisible) {
        this.hourHandVisible = hourHandVisible;
        paintClock();
    }
    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }
    public void setMinuteHandVisible(boolean minuteHandVisible) {
        this.minuteHandVisible = minuteHandVisible;
        paintClock();
    }
    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }
    public void setSecondHandVisible(boolean secondHandVisible) {
        this.secondHandVisible = secondHandVisible;
        paintClock();
    }
    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock(); 
    }

    private void paintClock() {
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;
        Point2D center = new Point2D(centerX, centerY);
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text[] texts = new Text[12];
        for (int i = 0; i < 12; i++) {
            int time = (i + 3 > 12) ? i + 3 - 12 : i + 3;
            Point2D b = new Point2D(
                    centerX + clockRadius * Math.cos(i * 2 * Math.PI / 12),
                    centerY + clockRadius * Math.sin(i * 2 * Math.PI / 12));
            b = getPointBCloserToA(center, b, 0.82);
            texts[i] = new Text(b.getX() - (clockRadius * 0.03125), b.getY() + (clockRadius * 0.025), "" + time);
        }
        Line[] dashes = new Line[60];
        for (int i = 0; i < dashes.length; i++) {
            Point2D start = new Point2D(
                    centerX + clockRadius * Math.cos(i * 2 * Math.PI / 60),
                    centerY + clockRadius * Math.sin(i * 2 * Math.PI / 60));
            double coefficient = (i % 5 == 0) ? 0.91 : 0.955;
            Point2D end = getPointBCloserToA(center,start, coefficient);
            dashes[i] = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        }
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength *
                Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength *
                Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);
        sLine.setVisible(isSecondHandVisible());
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *
                Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
                Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);
        mLine.setVisible(isMinuteHandVisible());
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);
        hLine.setVisible(isHourHandVisible());
        String s = "" + getHour() + ":" + getMinute() + ":" + getSecond();
        Text timeText = new Text(getW() * 0.4, getH() - 10, s);
        getChildren().clear();
        ObservableList<Node> list = getChildren();
        list.add(circle);
        Collections.addAll(list, dashes);
        Collections.addAll(list, texts);
        list.addAll(sLine, mLine, hLine, timeText);
    }

    public void start(){
        timeline.play();
    }

    public void stop(){
        timeline.pause();
    }

    private void update(){
        setCurrentTime();
        paintClock();
    }

    private Point2D getPointBCloserToA(Point2D a, Point2D b, double coefficient) {

        double deltaX = b.getX() - a.getX();
        double deltaY = b.getY() - a.getY();

        return new Point2D(
                a.getX() + coefficient * deltaX,
                a.getY() + coefficient * deltaY);
    }
}