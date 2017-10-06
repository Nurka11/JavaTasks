import java.net.*;
import java.io.*;
import java.util.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.geometry.Bounds;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.*;
import java.sql.*;
import javafx.util.*;
import javafx.collections.*;
import javafx.application.Platform;
import java.util.concurrent.*;
import javafx.concurrent.*;
public class ball extends Circle{
	public Shape getShape(){
		Circle circle = new Circle(100,100,20);
		return circle;
	}
}