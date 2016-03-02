package knn_train;

 
public class DigitImage {
	
	private int label=0;
	private byte[] ImageData=null;
	DigitImage(int lab,byte[] data)
	{
		label=lab;
		ImageData=data;
		
	};
	public int getLabel(){
		return label;
	}
	public byte[] getImageData(){
		return ImageData;
	}
}
