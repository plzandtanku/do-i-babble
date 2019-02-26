import java.io.*;
import java.util.Random;

public class MakeBabble {
	public static String[] characters = {
		"Susan McDuffy",
		"Ricky McRickyRIck",
		"Mr. Cheese",
	};
	public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public static char[] alphaArray = alphabet.toCharArray();

	public static void main(String[] args){
		try {
			String fileName = "freshBabble.txt";
			if (args.length > 0) {
				fileName = args[0];
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			StringBuilder log = new StringBuilder();
			for (int i=0;i<10;i++){
				log.append(makeLine());
				log.append("\r\n");
			}
			bw.write(log.toString());
			bw.close();
		}
		// Yea I know this is lazy
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String makeLine(){
		Random ran = new Random();
		int index = ran.nextInt(characters.length);
		StringBuilder line = new StringBuilder("5 25 2000 314PM ");
		line.append(characters[index]); line.append(": ");
		int numberWords = ran.nextInt(30);
		while (numberWords > 0) {
			line.append(makeGibberishWord());
			line.append(" ");
			numberWords--;
		}
		return line.toString();
	}
	public static String makeGibberishWord() {
		Random ran = new Random();
		int length = ran.nextInt(13);
		StringBuilder sb = new StringBuilder();
		while (length > 0){
			sb.append(alphaArray[ran.nextInt(alphaArray.length)]);
			length--;
		}
		return sb.toString();
	}
}
