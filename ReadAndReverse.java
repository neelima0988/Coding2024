import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadAndReverse {

	public static void main(String[] args) {
		System.out.println("I am running");
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream  is = loader.getResourceAsStream("Content.txt");
		 ArrayList<String> lines = new ArrayList<String>();
		 
		    InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.US_ASCII);
		    
		
		try ( BufferedReader br = new BufferedReader(streamReader)) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	System.out.println(line);
		    	 StringBuilder input1 = new StringBuilder();
		    	 
		         // append a string into StringBuilder input1
		         input1.append(line);
		  
		         // reverse StringBuilder input1
		         input1.reverse();
		    	lines.add(line);
		       /*for (int pos = line.indexOf("\n"); pos != -1; pos = line.indexOf("\n", pos + 1)) {
		        System.out.println("\\n at " + pos);;
		       }*/
		    }
		    
		    StringBuilder builder = new StringBuilder();
		    builder.append("Hello World");
		    
	        // reverse StringBuilder input1
		    builder.reverse();
	 
	        // print reversed String
	        System.out.println(builder);
		    builder.reverse();
		    
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		try(PrintWriter out = 
		        new PrintWriter(Files.newBufferedWriter(Paths.get("C:\\Users\\Sumit\\Neelima-JavaWS\\CITICodingTest\\src\\out.txt")))) {
		    Files.lines(Paths.get("C:\\Users\\Sumit\\Neelima-JavaWS\\CITICodingTest\\src\\Content2.txt"))
		    .flatMap(line -> Stream.of(new StringBuilder(line.toString()).reverse()))
		          .collect(Collectors.toCollection(LinkedList::new))
		         .descendingIterator()
		         .forEachRemaining(out::println);
		}catch (Exception e) {

e.printStackTrace();
		}
		
		
	}
}
