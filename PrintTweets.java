import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;
import java.lang.reflect.Field;


public class PrintTweets {

  public static void main(String[] args) throws Exception {

    Scanner in = new Scanner(new FileReader("tweet-template.html"));

    String template = "";
    while(in.hasNext()) {
      template += in.nextLine() + "\n";
    }

    PrintWriter writer;
    
    ExamplesTweet et = new ExamplesTweet();

    Field[] fields = ExamplesTweet.class.getDeclaredFields();

    for(Field f: fields) {
      if(f.getName().indexOf("html") == 0 && f.getName().length() > 4) {
        String filename = f.getName().substring(4) + ".html";
        writer = new PrintWriter(filename, "UTF-8");
        String studentHTML = (String)f.get(et);
        String withStudentHTML = template.replace("{{TWEET}}", studentHTML);
        writer.println(withStudentHTML);
        writer.close();
        System.out.println("Generated file: " + filename);
      }
    }

  }

}
