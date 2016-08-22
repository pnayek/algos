package leetcode.easy;

public class CompareVersionNumbers {
	/*
	 * Compare two version numbers version1 and version2.
	 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
	 * You may assume that the version strings are non-empty and contain only digits and the . character.
	 * The . character does not represent a decimal point and is used to separate number sequences.
	 * For instance, 2.5 is not "two and a half" or "half way to version three",
	 * it is the fifth second-level revision of the second first-level revision.
	 * Here is an example of version numbers ordering:
	 * 0.1 < 1.1 < 1.2 < 13.37
	 * 
	 * Leetcode #165, Easy
	 */
	
	public int compareVersion(String version1, String version2) {
        String[] vals1 = version1.split("\\.");
        String[] vals2 = version2.split("\\.");
        for (int i = 0; i < vals1.length && i < vals2.length; i++) {
            int ver1 = Integer.parseInt(vals1[i]);
            int ver2 = Integer.parseInt(vals2[i]);
            if (ver1 < ver2) return -1;
            else if (ver1 > ver2) return 1;
        }
        if (vals1.length < vals2.length) {
            for (int i = vals1.length; i < vals2.length; i++) {
                int ver = Integer.parseInt(vals2[i]);
                if (ver != 0) return -1;
            }
        }
        else if (vals1.length > vals2.length) {
            for (int i = vals2.length; i < vals1.length; i++) {
                int ver = Integer.parseInt(vals1[i]);
                if (ver != 0) return 1;
            }
        }
        return 0;
    }
}
