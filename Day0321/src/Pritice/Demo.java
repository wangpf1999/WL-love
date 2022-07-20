package Pritice;
import java.util.HashMap;
import java.util.Map;
public class Demo {
	public static void main(String[] args) {
//		//调用内部类的格式
//		NameComparator.Mate mate = new NameComparator().new Mate();
//		
		
		NameComparator o = new NameComparator();
		o.Mate();
		
		Map demains = new HashMap();
		
		//put(k key, V value)
		//将指定键值添加到map集合中
		demains.put("com", "工商企业");
		demains.put("net", "网络服务商");
		demains.put("org", "非营利组织");
		demains.put("edu", "教研机构");
		demains.put("gov", "政府部门 ");
		//通过键值获取
		String op = (String)demains.get("edu");
		System.out.println("edu国际域名对应的含义为："+op);
		//判断是否包含某一个键
		System.out.println("demains键值对集合中是否包含gov"+demains.containsKey("gov"));
		//删除键值对
		demains.remove("gov");
		System.out.println("删除后集合中是否包含gov："+demains.containsKey("gov"));
		//输出全部键值对
		System.out.println(demains);
	}

}
