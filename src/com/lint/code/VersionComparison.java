package com.lint.code;

/*
 * Compare two version numbers version1 and version1.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class VersionComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String v1 = "1.0.1";
		String v2 = "1";
		System.out.println("Version comparision result" + compareVersions(v1, v2));

	}

	//Better approach
	public static int compareVersions(String version1, String version2)
	{
		String[] levels1 = version1.split("\\.");
		String[] levels2 = version2.split("\\.");

		int length = Math.max(levels1.length, levels2.length);
    	for(int i = 0; i<length;i++)
		{
			Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			if (compare != 0)
			return compare;
		}
    	return 0;
    }


	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i = 0;

		int diff = v1.length - v2.length;

        if (diff > 0) {
            v2 = paddwithzero(v2, diff);
        }
        else if (diff < 0) {
            diff = diff *-1;
            v1 = paddwithzero(v1, diff);
        }
        int length = v1.length;
		while (i < length) {

				if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
					return 1;
				}
				else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
					return -1;
				}
				else {
					i++;
				}
			
			
		}
		return 0;
	}

    private static String[] paddwithzero(String[] v2, int diff) {

        int new_size = v2.length + diff;
        String[] v = new String[new_size];
        int i = 0;
        while(i< v2.length) {
            v[i] = v2[i];
            i++;
        }
        while (i < new_size) {
            v[i] ="0";
            i++;
        }
        return v;
    }


}
