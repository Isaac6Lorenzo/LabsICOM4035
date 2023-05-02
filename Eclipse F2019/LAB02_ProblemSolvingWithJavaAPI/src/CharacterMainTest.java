import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.Test;


public class CharacterMainTest {

 private ByteArrayOutputStream byteArrayOutputStream;
 private PrintStream console;
 
 private String expected1a = "false\nfalse\nfalse\n";
 private String expected1b = "false\nfalse\ntrue\n";
 private String expected1c = "false\ntrue\nfalse\n";
 private String expected1d = "true\nfalse\ntrue\n";

 private String expected2a = "false\ntrue\ne\ntrue\nE\nfalse\n";
 private String expected2b = "false\ntrue\ne\nfalse\nE\nfalse\n";
 private String expected2c = "false\nfalse\n4\nfalse\n4\ntrue\n";
 private String expected2d = "true\ntrue\nz\ntrue\nZ\nfalse\n";
 
 private String notExpected = "";

 @Before
 public void setup(){
  byteArrayOutputStream = new ByteArrayOutputStream();
  console = System.out;
 }

 @Test
 public void testSequence1() throws Exception{
  runTest('E',"CharacterMain","sequence1");
  String result1 = byteArrayOutputStream.toString().replaceAll("\r", "");
  byteArrayOutputStream = new ByteArrayOutputStream();
  runTest('e',"CharacterMain","sequence1");
  String result2 = byteArrayOutputStream.toString().replaceAll("\r", "");
  byteArrayOutputStream = new ByteArrayOutputStream();
  runTest('4',"CharacterMain","sequence1");
  String result3 = byteArrayOutputStream.toString().replaceAll("\r", "");
  byteArrayOutputStream = new ByteArrayOutputStream();
  runTest('a',"CharacterMain","sequence1");
  String result4 = byteArrayOutputStream.toString().replaceAll("\r", "");
  
  assertFalse("Remember to output the first sequence results into the console.",notExpected.equals(result1));

  assertTrue("Your first sequence did not passed the test with 'E'. Please review it.",expected1a.equals(result1));
  
  assertTrue("Your first sequence did not passed the test with 'e'. Please review it.",expected1b.equals(result2));
  
  assertTrue("Your first sequence did not passed the test with '4'. Please review it.",expected1c.equals(result3));
  
  assertTrue("Your first sequence did not passed the test with 'a'. Please review it.",expected1d.equals(result4));
 }
 @Test
 public void testSequence2() throws Exception{
  runTest('E',"CharacterMain","sequence2");
  String result1 = byteArrayOutputStream.toString().replaceAll("\r", "");
  byteArrayOutputStream = new ByteArrayOutputStream();
  runTest('e',"CharacterMain","sequence2");
  String result2 = byteArrayOutputStream.toString().replaceAll("\r", "");
  byteArrayOutputStream = new ByteArrayOutputStream();
  runTest('4',"CharacterMain","sequence2");
  String result3 = byteArrayOutputStream.toString().replaceAll("\r", "");
  byteArrayOutputStream = new ByteArrayOutputStream();
  runTest('Z',"CharacterMain","sequence2");
  String result4 = byteArrayOutputStream.toString().replaceAll("\r", "");
  
  assertFalse("Remember to output the second sequence results into the console.",notExpected.equals(result1));
  
  assertTrue("Your second sequence did not passed the test with 'E'. Please review it.",expected2a.equals(result1));
  
  assertTrue("Your second sequence did not passed the test with 'e'. Please review it.",expected2b.equals(result2));
  
  assertTrue("Your second sequence did not passed the test with '4'. Please review it.",expected2c.equals(result3));
  
  assertTrue("Your second sequence did not passed the test with 'Z'. Please review it.",expected2d.equals(result4));
 }

 private void runTest(final char data, final String className, final String methodName) throws Exception{
  try{
   System.setOut(new PrintStream(byteArrayOutputStream));

   final Class<?> cls = Class.forName(className);
   final Method meth = cls.getDeclaredMethod(methodName, char.class);
   final char params = data;
   meth.invoke(null, (Object) params);

  } finally {
   System.setOut(console);
  }
 }
}