class CompareVersionNumbers {
    public static void main(String[] args) {

    }

    public int compareVersion(String version1, String version2) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < version1.length() || p2 < version1.length()) {
            int dot1 = version1.indexOf(".", p1);
            int dot2 = version2.indexOf(".", p2);

            String subVer1 = dot1 == -1 ? "0" : version1.substring(p1, dot1);
            String subVer2 = dot2 == -1 ? "0" : version2.substring(p2, dot2);

            int ver1Num = Integer.parseInt(subVer1);
            int ver2Num = Integer.parseInt(subVer2);

            if (ver1Num < ver2Num) {
                return -1;
            } else if (ver1Num > ver2Num) {
                return 1;
            }

            p1 = dot1 == -1 ? p1 : dot1 + 1;
            p2 = dot2 == -1 ? p2 : dot2 + 1;

        }
        return 0;
    }
}