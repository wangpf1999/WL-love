package Pritice;
public class NameComparator {
	private String name= "紫霞仙子";
	public void Mate(){
		class Inner{
			public void show() {
				System.out.println(name);
			}			
		}
		Inner i = new Inner();
		i.show();
		
	}
	
}
