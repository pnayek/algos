import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicates {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			//System.out.println(s);
			String res = removeDuplicates(s);
			System.out.println(res); 
		}
	}

	private static String removeDuplicates(String s) {
		StringBuilder sb = new StringBuilder();
		String[] vals = s.split("\\|");
		//System.out.println(vals.length);
		boolean[] drop = new boolean[vals.length];
		for (int i = 0; i < vals.length - 1; i++) {
			if (drop[i]) continue;
			String s1 = clean(vals[i]);
			for (int j = i + 1; j < vals.length; j++) {
				if (drop[j]) continue;
				String s2 = clean(vals[j]);
				if (s1.equals(s2)) {
					if (vals[i].length() <= vals[j].length()) {
						drop[j] = true;
					}
					else {
						drop[i] = true;
					}
				}
				else if (s1.contains(s2)) {
					drop[j] = true;
				}
				else if (s2.contains(s1)){
					drop[i] = true;
				}
			}
		}
		/*
		for (boolean b: drop) {
			System.out.println(b);
		}
		*/
		boolean first = true;
		for (int i = 0; i < vals.length; i++) {
			if (!drop[i]) {
				if (first) {
					sb.append(vals[i]);
					first = false;
				}
				else {
					sb.append("|");
					sb.append(vals[i]);
				}
			}
		}
		return sb.toString();
	}

	private static String clean(String s) {
		String res = s.toLowerCase().trim().replaceAll(" +", " ").replaceAll("[^a-z0-9 ]", "");
		return res;
	}
}
