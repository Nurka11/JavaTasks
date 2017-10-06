import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.*;
import javafx.util.Duration;
import java.util.*;
public class Calendar extends Application{
	int y=2017;
	int m=4;
	public void start(Stage gui){
		Pane pane = new Pane();
		BorderPane bpane=new BorderPane();
		TextArea text=new TextArea();
		text.setText(printMonth(y,m));
		pane.getChildren().add(text);
		Button next=new Button("next");
		Button prior=new Button("prior");
		next.setOnAction(e->{
			text.setText(null);
			text.setText(printMonth(y,m+1));
			m++;
			if(m>11)m=1;
		});
		prior.setOnAction(e->{
			text.setText(printMonth(y,m-1));
			m--;
			if(m<1)m=12;
		});
		Pane btp=new HBox();
		btp.getChildren().addAll(next,prior);
		bpane.setCenter(text);
		bpane.setBottom(btp);
		Scene scene=new Scene(bpane,400,400);
		gui.setScene(scene);
		gui.show();
		System.out.println(printMonth(y,m-1));
	}
	public String printMonth(int year, int month) {  
		return(printMonthTitle(year, month)+printMonthBody(year, month)); 
	} 
		public String printMonthTitle(int year, int month) {
			String h="";
			h+=("         " + getMonthName(month)+ " " + year);
			h+="\n";
			h+=(" Sun Mon Tue Wed Thu Fri Sat \n"); 
			return h;
		} 
		public  String getMonthName(int month) { 
			String monthName = ""; 
			switch (month) { 
			case 1: monthName = "January"; break;
			case 2: monthName = "February"; break; 
			case 3: monthName = "March"; break; 
			case 4: monthName = "April"; break; 
			case 5: monthName = "May"; break; 
			case 6: monthName = "June"; break; 
			case 7: monthName = "July"; break; 
			case 8: monthName = "August"; break; 
			case 9: monthName = "September"; break; 
			case 10: monthName = "October"; break; 
			case 11: monthName = "November"; break; 
			case 12: monthName = "December"; 
			}
			return monthName; 
		} 

		public  String printMonthBody(int year, int month) { 
			String yi="";
			int startDay = getStartDay(year, month);

			int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month); 
			int i = 0; 
			for (i = 0; i < startDay; i++) 
				yi+=("    "); 
			for (i = 1; i <= numberOfDaysInMonth; i++){ 
				yi+=String.format("%4d", i); 
			if ((i + startDay) % 7 == 0) 
				yi+=("\n"); 
			}      
			yi+=("\n");
				return yi;
		} 

		public  int getStartDay(int year, int month) { 
			final int START_DAY_FOR_JAN_1_1800 = 3; 
			int totalNumberOfDays = getTotalNumberOfDays(year, month); 
			// Return the start day for month/1/year 
			return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;    } 
			/** Get the total number of days since January 1, 1800 */ 
			public  int getTotalNumberOfDays(int year, int month) { 
				int total = 0; 
				// Get the total days from 1800 to 1/1/year 
				for (int i = 1800; i < year; i++) 
					if (isLeapYear(i)) 
						total = total + 366; 
					else
						total = total + 365;
				// Add days from Jan to the month prior to the calendar month 
				for (int i = 1; i < month; i++)
					total = total + getNumberOfDaysInMonth(year, i); 
				return total; 
				} 
			/** Get the number of days in a month */ 
			public  int getNumberOfDaysInMonth(int year, int month) {
				if (month == 1 || month == 3 || month == 5 || month == 7 ||   month == 8 || month == 10 || month == 12)
					return 31; 
				if (month == 4 || month == 6 || month == 9 || month == 11) 
					return 30; 
				if (month == 2) 
					return isLeapYear(year) ? 29 : 28;
				return 0; 
				// If month is incorrect    
				} 
				/** Determine if it is a leap year */ 
				public  boolean isLeapYear(int year) { 
				return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);  }
}
