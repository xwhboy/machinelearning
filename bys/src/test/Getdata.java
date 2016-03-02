package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Getdata {
	private String[][] shuchu=new String [10][10];
	
	public Getdata() throws Exception{
		String path1="I://Sample/C000007/";
		String path2="I://Sample/C000008/";
		String path3="I://Sample/C000010/";
		String path4="I://Sample/C000013/";
		String path5="I://Sample/C000014/";
		String path6="I://Sample/C000016/";
		String path7="I://Sample/C000020/";
		String path8="I://Sample/C000022/";
		String path9="I://Sample/C000023/";
		String path10="I://Sample/C000024/";
		
		
	    shuchu[0]=getTxt(path1);
	    shuchu[1]=getTxt(path2);
	    shuchu[2]=getTxt(path3);
	    shuchu[3]=getTxt(path4);
	    shuchu[4]=getTxt(path5);
	    shuchu[5]=getTxt(path6);
	    shuchu[6]=getTxt(path7);
	    shuchu[7]=getTxt(path8);
	    shuchu[8]=getTxt(path9);
	    shuchu[9]=getTxt(path10);
		
	
		
		
	}
	
	public String [] getTxt(String path) throws IOException{
		String []TxtData=new String [10];
		for(int i=10;i<20;i++){
			File fs=new File(path+i+".txt");
		    FileReader reader = new FileReader(fs);
		    int fileLen = (int)fs.length();
		    char[] chars = new char[fileLen];
		    reader.read(chars);
		        String txt = String.valueOf(chars);
		        TxtData[i-10]=txt;
//		        System.out.println(TxtData[i-10]);
		}
		return TxtData;
	}
    public String [][] getTxtData(){
    	return shuchu;
    }
}
