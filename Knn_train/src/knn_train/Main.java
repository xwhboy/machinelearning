package knn_train;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.stream.FileImageOutputStream;

public class Main {
	   public static void main(String[] args) throws IOException
		{
			String labelFileName="t10k-labels.idx1-ubyte";
			String imageFileName="t10k-images.idx3-ubyte";
			String trainLabelName="train-labels.idx1-ubyte";
			String trainImageName="train-images.idx3-ubyte";
			
			
		    Shujuji tr=new Shujuji(trainLabelName,trainImageName);
			int train_len=tr.getLength();
			int train_lab_sz[]=tr.getLab_sz();
			int train_img_sz[][]=tr.getImage_sz();
			
			Shujuji sj=new Shujuji(labelFileName,imageFileName);
			int len=sj.getLength();
			int lab_sz[]=sj.getLab_sz();
			int img_sz[][]=sj.getImage_sz();
			System.out.println(train_len+"-------"+len);
			
			long start = System.currentTimeMillis();	// 记录起始时间
		
			int feng_sz1[][]=new int [1000][img_sz[0].length];
			int feng_sz2[][]=new int [1000][img_sz[0].length];
			int feng_sz3[][]=new int [1000][img_sz[0].length];
			int feng_sz4[][]=new int [1000][img_sz[0].length];
			int feng_sz5[][]=new int [1000][img_sz[0].length];
			int feng_sz6[][]=new int [1000][img_sz[0].length];
			int feng_sz7[][]=new int [1000][img_sz[0].length];
			int feng_sz8[][]=new int [1000][img_sz[0].length];
			int feng_sz9[][]=new int [1000][img_sz[0].length];
			int feng_sz10[][]=new int [1000][img_sz[0].length];
			for(int i=0;i<1000;i++){
				for(int j=0;j<img_sz[0].length;j++)
				{
					feng_sz1[i][j]=img_sz[i][j];
					feng_sz2[i][j]=img_sz[i+1000][j];
					feng_sz3[i][j]=img_sz[i+2000][j];
					feng_sz4[i][j]=img_sz[i+3000][j];
					feng_sz5[i][j]=img_sz[i+4000][j];
					feng_sz6[i][j]=img_sz[i+5000][j];
					feng_sz7[i][j]=img_sz[i+6000][j];
					feng_sz8[i][j]=img_sz[i+7000][j];
					feng_sz9[i][j]=img_sz[i+8000][j];
					feng_sz10[i][j]=img_sz[i+9000][j];
				
				}
				//System.out.println("");
			}
		
//			System.out.println("ok");
			
		   int []shuchu=new int[len];
		   int []temp1=new int[1000];
		   int []temp2=new int[1000];
		   int []temp3=new int[1000];
		   int []temp4=new int[1000];
		   int []temp5=new int[1000];
		   int []temp6=new int[1000];
		   int []temp7=new int[1000];
		   int []temp8=new int[1000];
		   int []temp9=new int[1000];
		   int []temp10=new int[1000];
		   
		   
		   
		   Knn_getTrain ks=new Knn_getTrain();
		   double [][]kk=ks.getDistance( train_img_sz,feng_sz1);
		   temp1=ks.getDealTag(kk, 3,train_lab_sz);
		   kk=ks.getDistance( train_img_sz,feng_sz2);
		   temp2=ks.getDealTag(kk, 3,train_lab_sz);
		   kk=ks.getDistance( train_img_sz,feng_sz3);
		   temp3=ks.getDealTag(kk, 3,train_lab_sz);
		   kk=ks.getDistance( train_img_sz,feng_sz4);
		   temp4=ks.getDealTag(kk, 3,train_lab_sz);
		   kk=ks.getDistance( train_img_sz,feng_sz5);
		   temp5=ks.getDealTag(kk, 3,train_lab_sz);
		   kk=ks.getDistance( train_img_sz,feng_sz6);
		   temp6=ks.getDealTag(kk, 3,train_lab_sz);
		   kk=ks.getDistance( train_img_sz,feng_sz7);
		   temp7=ks.getDealTag(kk, 3,train_lab_sz);
		   kk=ks.getDistance( train_img_sz,feng_sz8);
		   temp8=ks.getDealTag(kk, 3,train_lab_sz);
		   kk=ks.getDistance( train_img_sz,feng_sz9);
		   temp9=ks.getDealTag(kk, 3,train_lab_sz);
		   kk=ks.getDistance( train_img_sz,feng_sz10);
		   temp10=ks.getDealTag(kk, 3,train_lab_sz);
		   
			for(int i=0;i<1000;i++){
				shuchu[i]=temp1[i];
				shuchu[i+1000]=temp2[i];
				shuchu[i+2000]=temp3[i];
				shuchu[i+3000]=temp4[i];
				shuchu[i+4000]=temp5[i];
				shuchu[i+5000]=temp6[i];
				shuchu[i+6000]=temp7[i];
				shuchu[i+7000]=temp8[i];
				shuchu[i+8000]=temp9[i];
				shuchu[i+9000]=temp10[i];
			
			}
		   int numm=0;
			for(int i=0;i<len;i++){
//				System.out.print(shuchu[i]);
				if(shuchu[i]!=lab_sz[i]){
					numm++;
				}
			
			}
			System.out.println("-----------------------------");
			
			//double nummm=(double)numm;
			//double xianshi=numm/10000;
			System.out.println(numm);
////		   显示数据
//		   for(int i=0;i<kk.length;i++){
//			   for(int k=0;k<kk[0].length;k++){
//				   System.out.println(kk[i][k]+"--");
//			   }
//			   System.out.println("");
//		   }
		   

		   
		//误差是295个   
			long end = System.currentTimeMillis();		// 记录结束时间
			System.out.println("程序运行时间"+(end-start));				// 相减得出运行时间
		

		}
	   public static void byte2image(byte[] data,String path){
		    if(data.length<3||path.equals("")) return;//判断输入的byte是否为空
		    try{
		    FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));//打开输入流
		    imageOutput.write(data, 0, data.length);//将byte写入硬盘
		    imageOutput.close();
		    System.out.println("Make Picture success,Please find image in " + path);
		    } catch(Exception ex) {
		      System.out.println("Exception: " + ex);
		      ex.printStackTrace();
		    }
		  }
	   
}
