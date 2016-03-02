package test;

import java.util.List;

public class InputTxt {
	InputTxt(){
		
	}
	
	public double  getTag(List <String> in,List <Word_fq> cherk, List<String>data_type){
		double tag=1.0;
		double weight=0.1;
		
		for(int i=0;i<in.size();i++){
			for(int j=0;j<cherk.size();j++){
//				System.out.println(in.size()+"---"+cherk.size());
				if(in.get(i).equals(cherk.get(j).getWord())){
					double te=(double)cherk.size();
					double gailv=1000*cherk.get(j).getFre()/te;
					//System.out.println(gailv+"@@@");
					tag*=gailv;
				}
			}
		}
		return tag;
	}

}
