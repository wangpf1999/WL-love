package XianLiebiao;
//线性结构的分析
public interface List {

	//指定下标位置插入元素数据
	public void insert(int i,Object obj);
	//删除指定下标位置的数据结构
	public Object delete(int i);
	//替换数据元素
	public void update(int i,Object obj);
	//获取数据元素
	public Object getDate(int i);
	//获取线性表数据元素个数
	public int size();
	//判断线性表是否为空
	public boolean isEmpty();
	
}
