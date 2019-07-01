package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import java.lang.Math;

import java.io.IOException;
import java.util.Random;

public class MainController {
	@FXML
	private Label myMessage;
	@FXML
	private Label output;
	@FXML
	private Label error;
	@FXML
	private TextField start;
	@FXML
	private TextField end;
	@FXML
	private TextField x_coef;
	@FXML
	private TextField x_coef2;
	@FXML
	private TextField x_coef3;
	@FXML
	private TextField number;
	@FXML
	private TextField xl;
	@FXML
	private LineChart chart;
	
	public void mainx1(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/x1.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		//Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Stage window = new Stage();
		window.setTitle("First Degree Polynomial");
		
		window.setScene(tableViewScene);
		window.show();
	}
	
	public void mainx2() throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/x2.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		//Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Stage window = new Stage();
		window.setTitle("Second Degree Polynomial");
		window.setScene(tableViewScene);
		window.show();
	}
	
	public void mainx3(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/x3.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		//Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Stage window = new Stage();
		window.setTitle("Third Degree Polynomial");
		
		window.setScene(tableViewScene);
		window.show();
	}
	
	public void back(ActionEvent event) throws IOException {
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	
	public void first (ActionEvent event) {
		double coef1,constant, starts,ends;
		String result;
		XYChart.Series<Number,Number> series = new XYChart.Series<Number, Number>();
		try {
			starts = Double.parseDouble(start.getText());
			ends = Double.parseDouble(end.getText());
			coef1 = Double.parseDouble(x_coef.getText());
			constant = Double.parseDouble(number.getText());
			if (coef1 == 0){
				output.setText("coefisien of x cannot be 0");
				return;
			}
			First_Polynomial first = new First_Polynomial(coef1, constant, starts, ends);
			result = first.root();
			output.setText(result);
			first.generate_series();
			series = first.get_series();
			chart.getData().clear();
			chart.getData().add(series);
			chart.setCreateSymbols(false);
		}
		catch (Exception e){
			output.setText("Check inputs");
		}
	}
	
	public void second (ActionEvent event) {
		double coef2,coef1,constant, starts,ends;
		String root,result,turn_point;
		XYChart.Series<Number,Number> series = new XYChart.Series<Number, Number>();
		try {
			starts = Double.parseDouble(start.getText());
			ends = Double.parseDouble(end.getText());
			coef2 = Double.parseDouble(x_coef2.getText());
			coef1 = Double.parseDouble(x_coef.getText());
			constant = Double.parseDouble(number.getText());
			if (coef2 == 0) {
				output.setText("coefisien of x^2 cannot be 0");
				return;
			}
			Second_Polynomial second = new Second_Polynomial(coef2,coef1,constant,starts,ends);
			if (coef1 == 0 && coef2 == 1) {
				root = second.root(true);
			}
			else {
				root = second.root();			
			}
			turn_point = second.turn_point();
			result = root + turn_point;
			output.setText(result);
			second.generate_series();
			series = second.get_series();
			chart.getData().clear();
			chart.getData().add(series);
			chart.setCreateSymbols(false);
	
		}
		catch (Exception e){
			output.setText("Check inputs");
				
			}
	}
	public void third (ActionEvent event){
		double coef3,coef2,coef1,constant, starts,ends,x;
		String root,result,turn_point;
		XYChart.Series<Number,Number> series = new XYChart.Series<Number, Number>();
		try {
			starts = Double.parseDouble(start.getText());
			ends = Double.parseDouble(end.getText());
			x = Double.parseDouble(xl.getText());
			coef3 = Double.parseDouble(x_coef3.getText());
			coef2 = Double.parseDouble(x_coef2.getText());
			coef1 = Double.parseDouble(x_coef.getText());
			constant = Double.parseDouble(number.getText());
			if (coef3 == 0) {
				output.setText("coefisien of x^3 cannot be 0");
				return;
			}
			Third_Polynomial third = new Third_Polynomial(coef3,coef2,coef1,constant,starts,ends,x);
			third.generate_series();
			series = third.get_series();
			chart.getData().clear();
			chart.getData().add(series);
			chart.setCreateSymbols(false);
			root = third.root();
			turn_point = third.turn_point();
			result = root + turn_point;	
			output.setText(result);
			chart.setLegendVisible(false);
	
		}
		catch (Exception e){
			output.setText("check inputs");
			}

	}
}
