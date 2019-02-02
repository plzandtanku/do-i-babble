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
			HashMap<String, List<String>> results = new HashMap<String, List<String>>();

			// TODO: scalable performance considerations
			while ((line = br.readLine()) != null){
				String[] tokens = line.split(": ");
				if (tokens.length < 2) continue;

				String name = getName(tokens[0]);
				String[] words = getWords(tokens[1]);
				Integer count = words.length;
				hm.put(name, hm.getOrDefault(name,0)+count);

				List<String> arr = new ArrayList<String>();
				for (String word : words) arr.add(word);
				if (results.containsKey(name)){
					List<String> existing = results.get(name);
					for (String word : arr) existing.add(word);
					results.put(name, existing);
				}
				else {
					results.put(name, arr);
				}
			}
			System.out.println(hm);
		} catch (FileNotFoundException e){
			System.err.println("Sorry, couldn't find " + filename);
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void interpretResults(HashMap<String, Integer> results){
		for (String key : results.keySet()) {

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
	public static String[] getWords(String line){
		String[] tokens = line.split(" ");
		return tokens;
	}
}