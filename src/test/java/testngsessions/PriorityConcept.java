package testngsessions;

import org.testng.annotations.Test;

// Priority keyword is used to define the priority of test cases.
// Datatype of priority is integer. Hence it can accept positive,0 and negative values. Practically we never use negative or 0 priority.
// If priority is not given it will be by default 0. And 2 methods having same priorities  will be executed as per alphabetical order.
// If mix of without priority and priority methods then first methods having negative priority, then 0 priority , 
//then non priority methods(will take 0 as default) in alphabetical order and then positive priority methods as per priority.

public class PriorityConcept {
	
	@Test
	public void a_test() {
		System.out.println("a test");
	}
	
	@Test(priority=-1)
	public void b_test() {
		System.out.println("b test");
	}
	
	@Test(priority=0)
	public void c_test() {
		System.out.println("c test");
	}
	
	@Test(priority=2)
	public void d_test() {
		System.out.println("d test");
	}
	
	@Test(priority=5)
	public void e_test() {
		System.out.println("e test");
	}

}
