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
		String v1 = "1.2";
		String v2 = "1.2.0.1";
		System.out.println("Version comparision result" + compareVersion(v1,v2));

	}

	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i = 0;

		int num = Math.min(v1.length, v2.length);
		while (i < num) {

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

		if (v1.length != num && Integer.parseInt(v1[num]) != 0 ) {
			return 1;
		}
		else if (v2.length != num && Integer.parseInt(v2[num]) != 0) {
			return -1;
		}
		return 0;
	}


}
