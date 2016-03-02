package knn_train;

import java.util.Arrays;

public class Knn_getTrain {
   private int train[][];
   private int test[][];
    
	Knn_getTrain(){
		
		
	};
	public double [][] getDistance(int train_image[][],int test_image[][]){
		System.out.print(test_image.length+"  "+train_image.length);
		double [][] re_distance=re_distance=new double [test_image.length][train_image.length];
		int sum=0;
		double []result=new double[train_image.length];
		for(int i=0;i<test_image.length;i++){
			
			for(int j=0;j<train_image.length;j++){
				
				for(int k=0;k<train_image[0].length;k++){
					
					 sum+=(train_image[j][k]-test_image[i][k])*(train_image[j][k]-test_image[i][k]);
					
				}
				
				
				double n=Math.sqrt(sum);
				sum=0;
				result[j]=n; //60000个比较结果
				re_distance[i][j]=result[j]; 
				
			}
			
		}
//		for(int i=0;i<test_image.length;i++){
//			   for(int k=0;k<train_image.length;k++){
//				   System.out.println(re_distance[i][k]+"--");
//			   }
//			   System.out.println("");
//		}
//			   
			   
		return re_distance;
	}
	
	public int [] getDealTag(double [][]indata,int k,int[]labdata){
		int len=indata.length;
		double temp=0.0;
		int [] result_lab=new int [len];
		int [][]returnShuzu =new int [len][k];
		for(int j=0;j<len;j++){
			topheap th = new topheap(3,indata[j].length);
			th.getTopK(indata[j]);
			for(int i=1;i<=k;++i)
			{
				temp=th.heap[i];
//				System.out.println(temp);
//				System.out.println(j+"------"+i);
//				System.out.println(getlab_data(temp,indata[j],labdata));
				returnShuzu[j][i-1]=getlab_data(temp,indata[j],labdata);
//				System.out.print(returnShuzu[j][i-1]+" ");
			}
			
//			System.out.println("");
		}
		 
		for(int i=0;i<len;i++){
			result_lab[i]=getMAXPTag(returnShuzu[i]);
//			System.out.println(result_lab[i]);
		}
		
		
		return result_lab;
	}
	
	public int getlab_data(double chk,double []ss,int []lab){
		int tempTag=66666666;
		
		for(int m=0;m<ss.length;m++){
			if(chk==ss[m]){
//				System.out.println("*********"+lab[m]);
				return lab[m];
			}
			
		 }
		System.out.println("NOFOUNDERROR");
		return 10;
	}
	public int getMAXPTag(int[] Shuzu){
		Arrays.sort(Shuzu);
		if(Shuzu[0]==Shuzu[1]){
			return Shuzu[0];
		}
		else{
			if(Shuzu[1]==Shuzu[2]){
				return Shuzu[1];
			}
			else{
				return Shuzu[0];
			}
		}
	}
}
