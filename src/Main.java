import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			String sentence = reconstruct(s);
			System.out.println(sentence);
		}
	}
	
	private static String reconstruct(String s) {
		return s.replaceAll("\\([A-Z]+", "").replaceAll("\\)", "").replaceAll(" +", " ").trim();
	}
}
