package de.dhbwka.application;

public class CalculationBean {
	
	private double celcius = 0.0;
	private double farenheit;
	private boolean calcError = false;
	
	public double getCelcius() {
		return celcius;
	}
	public void setCelcius(double celcius) {
		this.celcius = celcius;
	}
	public double getFarenheit() {
		return farenheit;
	}
	public void setFarenheit(double farenheit) {
		this.farenheit = farenheit;
	}
	public boolean isCalcError() {
		return calcError;
	}
	public void setCalcError(boolean calcError) {
		this.calcError = calcError;
	}
	

	
}
