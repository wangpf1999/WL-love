package Democlass;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class Demo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();//接口对象
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		//添加，删除，查询，插入，修改，迭代器遍历
		
		//一般遍历方法
//		for(int i=0;i<=list.size()-1;i++) {
//			System.out.println("list["+i+"]="+list.get(i));	
//		}
		//迭代法遍历
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println("list["+obj+"]");
		}	
			
		System.out.println("-------");
		
		//删除
		list.remove(2);
		Iterator it1 = list.iterator();
		while(it1.hasNext()) {
			Object obj = it1.next();
			System.out.println("list["+obj+"]");
		}	
		
		System.out.println("-------");
			
		//查询
		list.size();
		System.out.println(list.size());
		
		System.out.println("-------");
		
		//修改
		list.set(0, "aa");
		Iterator it2 = list.iterator();
		while(it2.hasNext()) {
			Object obj = it2.next();
			System.out.println("list["+obj+"]");
		}	
		
		System.out.println("-------");
		
		System.out.println(list.contains("aa"));
		
	}
}
