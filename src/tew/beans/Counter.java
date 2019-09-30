package tew.beans;



public class Counter {
	
	public Counter(){}
	
	
	private int value;
	public int getIncrementedValue() {
		return ++value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
