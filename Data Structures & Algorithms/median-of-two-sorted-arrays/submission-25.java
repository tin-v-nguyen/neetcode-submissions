// public class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int[] A = nums1;
//         int[] B = nums2;
//         int total = A.length + B.length;
//         // number of elements in left partition
//         int half = total / 2;

//         if (A.length > B.length) {
//             int[] temp = A;
//             A = B;
//             B = temp;
//         }
//         /*
//         half = 1
//         A = [3]; B = [1, 2]
//         l = 0, r = 0;
//         i = 0;
//         j = 1 - 1 = 0
//         Aleft = 3
//         Aright = INF
//         Bleft = 1
//         Bright = 2
//         r = -1
//         l = 0
//         */

//         int l = 0;
//         int r = A.length;

//         while (true) {
//             // index of left partition in A
//             int i = (l + r) / 2;
//             // index of left partition in B
//             int j = half - (i + 1);

//             int Aleft = (i >= 0) ? A[i] : Integer.MIN_VALUE;
//             int Aright = (i + 1 < A.length) ? A[i + 1] : Integer.MAX_VALUE;
//             int Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
//             int Bright = (j + 1< B.length) ? B[j + 1] : Integer.MAX_VALUE;

//             if (Aleft <= Bright && Bleft <= Aright) {
//                 if (total % 2 != 0) {
//                     return Math.min(Aright, Bright);
//                 }
//                 return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
//             } else if (Aleft > Bright) {
//                 r = i - 1;
//             } else {
//                 l = i + 1;
//             }
//         }
//     }
// }

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        int total = A.length + B.length;
        int half = total / 2;

        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0, r = A.length - 1;
        while (true) {
            int i = Math.floorDiv(l + r, 2);
            int j = half - i - 2;

            int Aleft = (i >= 0) ? A[i] : Integer.MIN_VALUE;
            int Aright = (i + 1 < A.length) ? A[i + 1] : Integer.MAX_VALUE;
            int Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
            int Bright = (j + 1 < B.length) ? B[j + 1] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return Math.min(Aright, Bright);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }
}

