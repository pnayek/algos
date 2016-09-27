import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			String boss = lowestCommonBoss(s);
			System.out.println(boss);
		}
	}

	private static String lowestCommonBoss(String s) {
		Map<String, String> parents = new HashMap<String, String>();
		String[] vals = s.split(",");
		for (int i = 0; i < vals.length - 2; i++) {
			String[] r = vals[i].split("->");
			String e1 = r[0]; // manager
			String e2 = r[1]; // employee
			parents.put(e2, e1);
		}
		String e1 = vals[vals.length - 2];
		String e2 = vals[vals.length - 1];
		
		// find lineages of e1 and e2
		List<String> lineage1 = lineage(parents, e1);
		List<String> lineage2 = lineage(parents, e2);
		
		// find lowest common boss
		for (String l1: lineage1) {
			for (String l2: lineage2) {
				if (l1.equals(l2)) {
					return l1;
				}
			}
		}
		return null;
	}
	
	private static List<String> lineage(Map<String, String> parents, String s) {
		List<String> lineage = new ArrayList<String>();
		String e = parents.get(s);
		while (e != null) {
			lineage.add(e);
			e = parents.get(e);
		}
		return lineage;
	}
}