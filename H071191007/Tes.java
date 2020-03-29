import java.nio.file.*;; 
public class Tes { 
  public static String readFileAsString(String fileName)throws Exception { 
    String data = ""; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  } 
  
  public static void main(String[] args) throws Exception 
  { 
    String data = readFileAsString("D:\\VisualStudioCode\\Java\\Semester_2\\OOP_Class\\Lecture\\MidTest\\text.txt"); 
    System.out.println(data); 
  } 
} 
