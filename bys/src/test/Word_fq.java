package test;

public class Word_fq {
	private int fre;
	private String word;
	
	Word_fq(int fre,String  word){
		this.fre=fre;
		this.word=word;
	}
  public int  getFre(){
	  return fre;
  }
  public String getWord(){
	  return word;
  }
}
