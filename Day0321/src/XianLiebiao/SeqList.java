package XianLiebiao;

public class SeqList implements List{

	//默认线性表程度
	final int defaultSize = 10;
	//线性表长度
	int maxSize;
	//线性表中现有的元素个数
	int size;
	//用对象数组存储线性表
	Object[] listArray;
	
	
	//无参构造方法
	public SeqList() {
		// TODO Auto-generated constructor stub
	}
	
	//带线性表的构造方法
	public SeqList(int size) {
		super();
		this.size = size;
	}


	//初始化方法，设置线性表长度、现有元素个数和初始化元素数组
	public void initiate(int sz) {
		maxSize = sz;
		size = 0;
		listArray = new Object[sz];
	}


	@Override
	public void insert(int i, Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object delete(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(int i, Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getDate(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
