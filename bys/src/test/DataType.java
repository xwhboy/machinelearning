package test;

import java.util.ArrayList;
import java.util.List;

public class DataType {
     private int num1;
     private int num2;
     private List <String> fenci;
     
     DataType(int numa,int numb,List <String> fen){
    	 this.num1=numa;
    	 this.num2=numb;
    	 this.fenci=fen;
     }
     
     public int getnum1(){
    		return num1;
    	}
     public int getnum2(){
 		return num2;
 	}
     public List <String>  getArr(){
 		return fenci;
 	}
}

