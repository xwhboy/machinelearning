package test;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class Spliter {
	private String[] zhongxinci={"的", "我们","要","自己","之","将","“","”","，","（","）","后","应","到","某","后","个","是","位","新","一","两","在","中","或","有","更","好"};
	private List<DataType> DDD=new ArrayList<DataType>();
	public Spliter() throws Exception {
     	Getdata gg=new Getdata();
		String [][]dat=gg.getTxtData();
		String temp;
		int kkkk=0;
		boolean ifzhong=false;
//		 for(int q=0;q<zhongxinci.length;q++){
//			 System.out.println(zhongxinci[q]);
//		 }
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				//System.out.println(dat[i][j]);
		        StringReader sr=new StringReader(dat[i][j]);  
		        IKSegmenter ik=new IKSegmenter(sr, true);  
		        Lexeme lex=null;  
		        kkkk=j;
		        List <String> fenci = new ArrayList<String>();
		        while((lex=ik.next())!=null){  
		            
		            temp=lex.getLexemeText(); 
//		            System.out.println("-------");
//            		System.out.println(temp);
//            		System.out.println("----");
		            for(int q=0;q<zhongxinci.length;q++){
		            	
		            	if(temp.equals(zhongxinci[q])){
//		            		System.out.println(temp);
		            		ifzhong=true;
		            	}
		            }
		            if(!ifzhong){
		            	fenci.add(temp);
		            }
		            ifzhong=false;
		        }
		        DataType nd=new DataType(i,j,fenci);
		        DDD.add(nd);
		    }
			
		}
//		输出
//		for (int i = 0; i < DDD.size(); i++) {
//			DataType  ddd = DDD.get(i);
//			List <String> ci = ddd.getArr();
//			System.out.print(i+"---");
//			for (int j = 0; j< ci.size(); j++){
//				String ss=ci.get(j);
//				System.out.print(ss+"|");
//				
//			}
//			System.out.println("");
//			System.out.println(""); 
//			}
	}
	public List<DataType> getDataType(){
		return DDD;
	}
	
}
