package application;

import javafx.scene.chart.XYChart;

public class First_Polynomial extends Polynomial{
	protected double coef1;
	private double root;
	First_Polynomial(double coef1, double cons, double starts, double ends) {
		super(cons,starts,ends);
		this.coef1 = coef1;
	}
	public void generate_series() {
		double i = starts;
		while (i < ends) {
			series.getData().add(new XYChart.Data<Number, Number>(i,(i*coef1)+constant));
			i = i + 0.1;
		}
	}
	public String root() {
		root = (-1 * constant) / coef1; 
		String ret = "root = " + Double.toString(root);
		return ret;
	}
}
