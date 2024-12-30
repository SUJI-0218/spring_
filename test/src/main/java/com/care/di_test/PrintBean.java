package com.care.di_test;

public class PrintBean {
	private String Print = "아무거나";
//	private PrintString ps;
    private PrintString ps =  new PrintString();
	
	public void Print() { ps.printString(Print); }

	public String getPrint() {
		return Print;
	}

	public void setPrint(String print) {
		Print = print;
	}

	public PrintString getPs() {
		return ps;
	}

	public void setPs(PrintString ps) {
		this.ps = ps;
	}
	
	
	
	

}

