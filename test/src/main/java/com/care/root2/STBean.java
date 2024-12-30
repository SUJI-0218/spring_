package com.care.root2;

public class STBean {//STBean은 저장소 역할을 하고있음
	private String name;
	private int age;
	private Student st; //출력하기 위한 용도로 설정, 저장소와 출력 용도랑 연결이 되어있어야 가능함
	public void namePrint() { st.namePrint( name ); }
	public void agePrint() { st.agePrint( age ); }
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student getSt() {
		return st;
	}
	public void setSt(Student st) {
		this.st = st;
	}
	

}
