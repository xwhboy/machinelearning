package knn_train;

public class topheap {
	//ȡlen����������С��k��Ԫ�أ�ά��һ����Ԫ�����Ķѣ����ö����������
	double heap[];
	int k;//top k
	int len;//��len������
	topheap(int kk,int ll)
	{
		k = kk;
		len = ll;
		heap = new double[k+1];
	}
	
	/*
	 * ��data[pos]��data[end]�����ݽ���	
	 */
	public void toheap(int pos,int end,double h[])
	{
		int i = pos;
		int j=i;
		double value = h[i];
		while(true)
		{
			if(2*i>end)
				break;
			double l = h[2*i];
			j = 2*i;
			double max = l;
			if(2*i+1 <= end)
			{
				double r = h[2*i+1];
				if(l<r)
				{
					max = r;
					j = 2*i+1;
				}
			}
			if(value<h[j])
			{
				h[i] = h[j];
				i = j;
			}
			else
			{
				break;
			}
		}
		h[i] = value;
	}
	
	/*
	 * ��ǰk�����ݽ��ɶ�
	 */
	public void kheap(double data[])
	{
		if(k>data.length)
		{
			System.out.println("����Ԫ�ظ�������K��");
			return ;
		}
		//��data�е�ǰk��Ԫ�ؽ��ɶ�
		for(int i=0;i<k;++i)
		{
			heap[i+1] = data[i];
		}
		for(int i=k/2;i>0;--i)
		{
			toheap(i,k,heap);
		}
	}
	
	/*
	 * �����������飬��Top K
	 */
	public void getTopK(double data[])
	{
		//��ǰk�����ݽ���
		kheap(data);
		//��K֮����������ζ���
		for(int i=k;i<data.length;++i)
		{
			getTopKoneByone(data[i]);
		}
	}
	
	/*
	 * ���ζ������ݣ���Top K
	 */
	public void getTopKoneByone(double data)
	{
		//ֻ�����������ݱȶѶ�Ԫ��Сʱ�Ÿ���heap
		if(data<heap[1])
		{
			heap[1] = data;
			toheap(1,k,heap);
		}
	}
}