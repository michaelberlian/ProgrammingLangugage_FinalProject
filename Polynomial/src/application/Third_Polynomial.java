package application;

import javafx.scene.chart.XYChart;

public class Third_Polynomial extends Second_Polynomial{
	protected double coef3;
	private double root,x;
	Third_Polynomial(double coef3, double coef2, double coef1, double cons, double starts, double ends,double x) {
		super(coef2, coef1, cons, starts, ends);
		this.coef3 = coef3;
		this.x = x;
	}
	public void generate_series() {
		double i = starts;
		while (i < ends) {
			series.getData().add(new XYChart.Data<Number, Number>(i,(i*i*i*coef3)+(i*i*coef2)+(i*coef1)+constant));
			i = i + 0.1;
		}
	}
	public double f(double x) {
		return (x*x*x*coef3) + (x*x*coef2) + (x*coef1) + constant;
	}
	public double df(double x) {
		double h = 0.00001 ;
		double dfx = (f(x+h) - f(x-h)) / (2*h);
		return dfx;
	}
	public double d2f(double x) {
		double h = 0.00001 ;
		double dfx = (f(x-h) - 2*f(x) + f(x+h)) / (h*h);
		return dfx;
	}
	public String root() {
		String result;
		while (true) {
			if ( Math.abs(f(x)) < Math.pow(0.1, 6)) {
				root = x;
				result = "root = " + Double.toString(root).substring(0,7) + "\n";
				break;
			}
			else {
				x = x - ( f(x) / df(x) ); 
				if (df(x) == 0) {
					result = "no root found. please input another xl";
					break;
				}
			}
		}
		return result;
	}
	public String turn_point() {
		double turn_point;
		String result;
		while (true) {
			if ( Math.abs(df(x)) < Math.pow(0.1, 6)) {
				turn_point = x;
				result = "turn point = (" + Double.toString(turn_point).substring(0,5) + "," + Double.toString(f(turn_point)).substring(0,5) +")\n" ;
				break;
			}
			else {
				x = x - ( df(x) / d2f(x) ); 
				if (d2f(x) == 0) {
					result = "no turn point found.";
					break;
				}
			}
		}
		
		return result;
	}
}
