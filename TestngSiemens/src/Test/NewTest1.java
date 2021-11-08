package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest1 {
  @Test
  public void test1() {
	  System.out.println("hello");
  }
  
  @Test(enabled=false) // bu hata alan testti ve ben bunu kapattım enabled yaptım mesela
  public void test2() {
	  AssertJUnit.assertTrue(false);
  }
  
  @Test
  public void test3() {
	  AssertJUnit.assertTrue(true);
  }
}
