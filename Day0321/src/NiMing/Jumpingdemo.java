package NiMing;
//测试类
public class Jumpingdemo {
	public static void main(String[] args) {
		//接口操作对象
		JumpingOperator jo = new JumpingOperator();
		//创建一个猫的对象
		Jumping j = new Cat();
		//接口操作对象调用
		jo.method(j);
		
		
		//匿名类部类
		System.out.println("-------------");

		jo.method(new Jumping() {			
			@Override
			public void Jump() {
			   System.out.println("贝贝更喜欢蹦蹦跳跳");
			}
		});
		jo.method(new Jumping() {
			@Override
			public void Jump() {
				System.out.println("紫霞仙子and猴子大王");
			}
		});
	}

}
