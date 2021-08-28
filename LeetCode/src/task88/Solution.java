package task88;

class Solution {
    public int[] mergeFunction(int[] nums1, int n, int[] nums2, int m) {
        int[] result = new int[n + m];

        for (int i = 0, j1 = 0, j2 = 0; i < n + m; i++) {
            if (j1 == n || j2 == m) {
                if (j1 == n) {
                    for (int j = i; j < n + m && j2 < m; j++) {
                        result[j] = nums2[j2];
                        j2++;
                    }
                } else {
                    for (int j = i; j < n + m && j1 < n; j++) {
                        result[j] = nums1[j1];
                        j1++;
                    }
                }
                break;
            }
            if (nums1[j1] < nums2[j2]) {
                result[i] = nums1[j1];
                j1++;
            } else {
                result[i] = nums2[j2];
                j2++;
            }
        }
        return result;
    }

    public void merge(int[] nums1, int n, int[] nums2, int m) {
        if (m == 0) {
            return;
        }
        int[] result = mergeFunction(nums1, n, nums2, m);
        if (n + m >= 0) System.arraycopy(result, 0, nums1, 0, n + m);
    }
}