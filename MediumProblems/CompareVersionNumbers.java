class CompareVersionNumbers {
    public static void main(String[] args) {

    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0;
        while (i < arr1.length && i < arr2.length) {
            int v1num = Integer.parseInt(arr1[i]);
            int v2num = Integer.parseInt(arr2[i]);

            if (v1num < v2num) {
                return -1;
            }

            if (v1num > v2num) {
                return 1;
            }
            i++;
        }
        if (arr1.length == arr2.length)
            return 0;

        String[] target = arr1.length < arr2.length ? arr2 : arr1;
        int answer = arr1.length < arr2.length ? -1 : 1;
        
        for(int j = i; j < target.length; j++) {
            int targetNum = Integer.parseInt(target[j]);
            if(targetNum != 0) {
                return answer;
            }
        }
        return 0;
    }
}