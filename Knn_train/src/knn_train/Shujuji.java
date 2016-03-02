package knn_train;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class Shujuji {
	private int[][] image_re ;
	private int[] lab_re;
	private int length;
     Shujuji(String lab,String image) throws IOException{
    		Loadimage lg=new Loadimage(lab,image);
			List<DigitImage>  item=lg.loadDigitImages();
			length=item.size();
			image_re=new int [length][784];
			lab_re=new int[length];
			  for(int i=0;i<length;i++) {   
				  DigitImage aa=item.get(i);
				  lab_re[i]=aa.getLabel();
				  byte[] jjj=aa.getImageData();
				  for(int k=0;k<jjj.length;k++){ 
					  byte[] bytes =  new byte[]{jjj[k]}; 
				       ByteArrayInputStream in = new ByteArrayInputStream(bytes);   
					   int result = in.read(); 
					   image_re[i][k]=result;
					  }
			   }   
        	
        	
        };
        public int[] getLab_sz(){
        	return lab_re;
        }
        public int [][] getImage_sz(){
        	return image_re;
        	
        }
        public int getLength(){
        	return length;
        	
        }
}
