package test;

import java.util.ArrayList;
import java.util.List;

public class Mainapp {
	public static void main(String []args) throws Exception{
		long start = System.currentTimeMillis();	// ��¼��ʼʱ��
		
		
		Spliter sp=new Spliter();
		List<DataType> shujuji=sp.getDataType();
		List <String> jx=new ArrayList<String>();
		jx=shujuji.get(29).getArr();//�����ļ������
//		System.out.println(shujuji.size()+"&&&");
		WordFre fre=new WordFre(shujuji);
		
		for (int j = 0; j< jx.size(); j++){
			String ss=jx.get(j);
			System.out.print(ss+"|");
			}

		InputTxt px=new InputTxt();
		double r1=px.getTag(jx, fre.wf1,fre.data_type1);
		double r2=px.getTag(jx, fre.wf2,fre.data_type2);
		double r3=px.getTag(jx, fre.wf3,fre.data_type3);
		double r4=px.getTag(jx, fre.wf4,fre.data_type4);
		double r5=px.getTag(jx, fre.wf5,fre.data_type5);
		double r6=px.getTag(jx, fre.wf6,fre.data_type6);
		double r7=px.getTag(jx, fre.wf7,fre.data_type7);
		double r8=px.getTag(jx, fre.wf8,fre.data_type8);
		double r9=px.getTag(jx, fre.wf9,fre.data_type9);
		double r10=px.getTag(jx, fre.wf10,fre.data_type10);
		
		System.out.println("---"+r1+"---");
		System.out.println("---"+r2+"---");
		System.out.println("---"+r3+"---");
		System.out.println("---"+r4+"---");
		System.out.println("---"+r5+"---");
		System.out.println("---"+r6+"---");
		System.out.println("---"+r7+"---");
		System.out.println("---"+r8+"---");
		System.out.println("---"+r9+"---");
		System.out.println("---"+r10+"---");
		
		long end = System.currentTimeMillis();		// ��¼����ʱ��
		System.out.println("��������ʱ��"+(end-start));				// ����ó�����ʱ��
	}

}
