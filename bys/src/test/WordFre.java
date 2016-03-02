package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WordFre {
	private  String [][] re_shuju;
	   List<String> data_type1=new ArrayList<String>();
	   List<String> data_type2=new ArrayList<String>();
	   List<String> data_type3=new ArrayList<String>();
	   List<String> data_type4=new ArrayList<String>();
	   List<String> data_type5=new ArrayList<String>();
	   List<String> data_type6=new ArrayList<String>();
	   List<String> data_type7=new ArrayList<String>();
	   List<String> data_type8=new ArrayList<String>();
	   List<String> data_type9=new ArrayList<String>();
	   List<String> data_type10=new ArrayList<String>();
	   
	   List<Word_fq> wf1=new ArrayList<Word_fq>();
	   List<Word_fq> wf2=new ArrayList<Word_fq>();
	   List<Word_fq> wf3=new ArrayList<Word_fq>();
	   List<Word_fq> wf4=new ArrayList<Word_fq>();
	   List<Word_fq> wf5=new ArrayList<Word_fq>();
	   List<Word_fq> wf6=new ArrayList<Word_fq>();
	   List<Word_fq> wf7=new ArrayList<Word_fq>();
	   List<Word_fq> wf8=new ArrayList<Word_fq>();
	   List<Word_fq> wf9=new ArrayList<Word_fq>();
	   List<Word_fq> wf10=new ArrayList<Word_fq>();
	   
       WordFre( List<DataType> Shuju){
    	   
    	   //统计频率
    	  
    	   
    	   Iterator<DataType> iter = Shuju.iterator();  
    	   while(iter.hasNext()){  
    	       DataType s = iter.next();  
    	       if(s.getnum2()==9){  
    	           iter.remove();  
    	       }  
    	   }  
    	 
    	   
    	
    	   re_shuju=new String [Shuju.size()][];
    	   for (int i = 0; i < Shuju.size(); i++) {
   			DataType  ddd = Shuju.get(i);
   			List <String> ci = ddd.getArr();
   			//System.out.println(i+"###");
   			for (int j = 0; j< ci.size(); j++){
   				re_shuju[i]=new String [ci.size()];
   				re_shuju[i][j]=ci.get(j);
   				if(0<=i&&i<8){
   					data_type1.add(re_shuju[i][j]);  
   				}
   				if(0<=(i+9)&&i<(8+9)){
   					data_type2.add(re_shuju[i][j]);  
   				}
   				if(0<=(i+18)&&i<(8+18)){
   					data_type3.add(re_shuju[i][j]);  
   				}
   				if(0<=(i+27)&&i<(8+27)){
   					data_type4.add(re_shuju[i][j]);  
   				}
   				if(0<=(i+36)&&i<(8+36)){
   					data_type5.add(re_shuju[i][j]);  
   				}
   				if(0<=(i+45)&&i<(8+45)){
   					data_type6.add(re_shuju[i][j]);  
   				}
   				if(0<=(i+54)&&i<(8+54)){
   					data_type7.add(re_shuju[i][j]);  
   				}
   				if(0<=(i+63)&&i<(8+63)){
   					data_type8.add(re_shuju[i][j]);  
   				}
   				if(0<=(i+72)&&i<(8+72)){
   					data_type9.add(re_shuju[i][j]);  
   				}
   				if(0<=(i+81)&&i<(8+81)){
   					data_type10.add(re_shuju[i][j]);  
   				}
   				
   			//System.out.print(re_shuju[i][j]+"|");
   				
   			}
   			//System.out.println("|");
    	  }
    	
    	
    	   
    	  
//    	   for(int i=0;i<data_type1.size();i++){
//		    	System.out.println(data_type1.get(i));
//		    }
    	   System.out.println("&&&"+"--");
    	   wf1=getFF(data_type1);
    	   wf2=getFF(data_type2);
    	   wf3=getFF(data_type3);
    	   wf4=getFF(data_type4);
    	   wf5=getFF(data_type5);
    	   wf6=getFF(data_type6);
    	   wf7=getFF(data_type7);
    	   wf8=getFF(data_type8);
    	   wf9=getFF(data_type9);
    	   wf10=getFF(data_type10);
    	
    	   
//    	   System.out.println(wf1.size());
//    			   for(int i=0;i<wf1.size();i++){
//    			    	System.out.println(wf1.get(i).getWord()+":"+wf1.get(i).getFre());
//    			    }
//    	   
       }
       public   List<Word_fq>  getFF( List<String> indata){
    	   int count=0; 
    	   List<Word_fq> data_type1 =new ArrayList<Word_fq>();
    	   List<String> tt =new ArrayList<String>();
    		tt.add("的");
    	   for(int j=0;j<indata.size();j++){
    		   String temp=indata.get(j);
    		   for(int i=0;i<indata.size();i++){
       	    	if(temp.equals(indata.get(i))){
       	    		count++;
       	    	}
       	    }
    		   
    		  int co=0;
               for(int m=0;m<tt.size();m++){
            	  //System.out.println(temp+"****"+tt.get(m));
    			   if(temp.equals(tt.get(m))){
    				   
    			   }
    			   else{
    				  co++;
    				   
    			   }
    		   }
              // System.out.println("+co"+co);
               if(co==tt.size()){
            	   Word_fq nnn1=new Word_fq(count,temp);
		       	   data_type1.add(nnn1);
		       	   count=0; 
		       // 	System.out.println("+1");
		        	tt.add(temp);
               }
               else{
            	   count=0; 
               }
              
       	   
    	   }
    	   return data_type1;
       }
}
