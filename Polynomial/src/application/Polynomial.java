package application;

import javafx.scene.chart.XYChart;

public class Polynomial {
	protected double starts,ends;
	protected double constant;
	protected XYChart.Series<Number,Number> series;
	Polynomial(double cons, double starts, double ends) {
		this.starts = starts;
		this.ends = ends;
		constant = cons;
		this.series = new XYChart.Series<Number, Number>();
	}
	public String root() {
		return "";
	}
	public XYChart.Series<Number,Number> get_series (){
		return series;
	}
}
