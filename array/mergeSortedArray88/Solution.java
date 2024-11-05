package array.mergeSortedArray88;
/*
For this problem, we need three pointers, each pointing to the last element of the respective arrays.
Since these are sorted arrays, we only need to compare the last values. If nums2 still has some values
left unmerged, we place them at the beginning of the merged array.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            }else{
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        while(p2 >= 0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }

    }
}
