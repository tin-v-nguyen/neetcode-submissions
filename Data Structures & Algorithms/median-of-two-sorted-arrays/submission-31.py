class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2
        total = len(A) + len(B)
        half = (total + 1) // 2

        # Ensure A is the smaller array
        if len(B) < len(A):
            A, B = B, A

        l, r = 0, len(A)
        while l <= r:
            i = (l + r) // 2  # Partition index for A
            j = half - i  # Partition index for B

            Aleft = A[i - 1] if i > 0 else float("-inf")
            Aright = A[i] if i < len(A) else float("inf")
            Bleft = B[j - 1] if j > 0 else float("-inf")
            Bright = B[j] if j < len(B) else float("inf")

            if Aleft <= Bright and Bleft <= Aright:
                if total % 2 != 0:
                    return max(Aleft, Bleft)
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2.0
            elif Aleft > Bright:
                r = i - 1
            else:
                l = i + 1

        return -1  # Should never reach here