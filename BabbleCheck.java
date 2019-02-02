import java.util.*;
import java.io.*;

public class BabbleCheck {
	public static void main(String[] args){
		String filename = "my_chat_log.txt";
		if (args.length < 1) System.out.println("No file specified, reading from file: " + filename);
		if (args.length > 0) filename = args[0];
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = "";
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			// TODO: scalable performance considerations
			while ((line = br.readLine()) != null){
				String[] tokens = line.split(": ");
				if (tokens.length < 2) continue;
				String name = getName(tokens[0]);
				Integer count = getCount(tokens[1]);
				hm.put(name, hm.getOrDefault(name,0)+count);
			}
			System.out.println(hm);
		} catch (FileNotFoundException e){
			System.err.println("Sorry, couldn't find " + filename);
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public static String getName(String line){
		String[] tokens = line.split(" ");
		String name = "";
		// we know the first four tokens refer to the timestamps
		for (int i=4; i < tokens.length;i++){
			name += tokens[i] + " ";
		}
		return name;
	}
	public static Integer getCount(String line){
		String[] tokens = line.split(" ");
		return tokens.length;
	}
}