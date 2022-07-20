package NiMing;
public  class Outer{
	public void method() {
		//匿名类部类。实质是一个接口或者抽象方法的对象
		Innter i =new Innter () {
			@Override
			public void show() {
				System.out.println("紫霞仙子and猴子大王");
			}		
		};
		i.show();	
	}
	
}
