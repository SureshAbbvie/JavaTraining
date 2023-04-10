package com.dal;

interface Additionn{
	public int add(int a, int b);
	//public int sub(int a, int b);
}
public class Java8eg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Additionn sum =(a,b)->{
	return a+b;
};

System.out.println(sum.add(10, 2));
	}

}
