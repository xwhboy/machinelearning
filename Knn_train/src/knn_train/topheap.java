package knn_train;

public class topheap {
	//取len个数据中最小的k个元素，维护一个顶元素最大的堆，不用对这个堆排序
	double heap[];
	int k;//top k
	int len;//共len个数据
	topheap(int kk,int ll)
	{
		k = kk;
		len = ll;
		heap = new double[k+1];
	}
	
	/*
	 * 将data[pos]到data[end]的数据建堆	
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
	 * 将前k个数据建成堆
	 */
	public void kheap(double data[])
	{
		if(k>data.length)
		{
			System.out.println("数组元素个数不足K个");
			return ;
		}
		//将data中的前k个元素建成堆
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
	 * 读入整个数组，求Top K
	 */
	public void getTopK(double data[])
	{
		//将前k个数据建堆
		kheap(data);
		//对K之后的数据依次读入
		for(int i=k;i<data.length;++i)
		{
			getTopKoneByone(data[i]);
		}
	}
	
	/*
	 * 依次读入数据，求Top K
	 */
	public void getTopKoneByone(double data)
	{
		//只有在输入数据比堆顶元素小时才更新heap
		if(data<heap[1])
		{
			heap[1] = data;
			toheap(1,k,heap);
		}
	}
}