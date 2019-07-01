package application;

import javafx.scene.chart.XYChart;

public class Second_Polynomial extends First_Polynomial{
	protected double coef2;
	private double root1,root2;
	Second_Polynomial(double coef2, double coef1, double cons, double starts, double ends) {
		super(coef1, cons, starts, ends);
		this.coef2 = coef2;
	}
	public void generate_series() {
		double i = starts;
		while (i < ends) {
			series.getData().add(new XYChart.Data<Number, Number>(i,(i*i*coef2)+(i*coef1)+constant));
			i = i + 0.1;
		}
	}
	public String root(Boolean x) {
		if (x) {
			root1 = Math.sqrt(constant);
			root2 = -1 * Math.sqrt(constant);
			String result = result(root1, root2);
			return result;
		}
		else {
			return root();
		}
	}
	public String root() {
		String result;
		if ( (coef1*coef1) - (4 * coef2 * constant) > 0) {
			root1 = ((coef1*-1) + Math.sqrt((coef1*coef1) - (4*coef2*constant)))/ (2*coef2);
			root2 = ((coef1*-1) - Math.sqrt((coef1*coef1) - (4*coef2*constant)))/ (2*coef2);
			result = result(root1,root2);
		}
		else if ((coef1*coef1) - (4 * coef2 * constant) == 0) {
			root1 = ((coef1*-1) + Math.sqrt((coef1*coef1) - (4*coef2*constant)))/ (2*coef2);
			return "root = " + Double.toString(root1) +"\n";
		}
		else {
			result = "no root available.\n";
		}
		return result;
	}
	public String turn_point() {
		double x = -1 * coef1 / (2 * coef2);
		double y = (x*x*coef2) + (x*coef1) + constant;
		String x_res = Double.toString(x);
		String y_res = Double.toString(y);
		if (x_res.length() > 5) {
			x_res = x_res.substring(0,5);
		}
		if (y_res.length() > 5) {
			y_res = y_res.substring(0,5);
		}
		String result = "turn point = (" + x_res + "," + y_res + ")\n";   
		return result;
	}
	public String result(double root1, double root2){ 
		String result = "root 1 = " + Double.toString(root1) + "\nroot 2 = " + Double.toString(root2) + "\n" ;
		return result;
	}
}
