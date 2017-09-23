// Source: https://leetcode.com/problems/binary-search-tree-iterator/description/
// Author: xiaji
// Date: 2017-09-23
// Solution:


/**
 *
 * */

/** Mistakes:
 * A_key: when A.length << B.length, A_key is greater than A.length, we had better drop the k / 2 of B, instead of A
 * findKth(A, A_start) not (A, 0), we followed the functions arguments, instead of using exactly value!!!
 * it maybe not converge this recursion!!!
 */

public class Solution {
  public double FindMedianSortedArrays(int[] A, int[] B) {
    int len = A.length + B.length;
    if (len % 2 == 0) {
      return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    } else {
      return findKth(A, 0, B, 0, len / 2 + 1);
    }
  }

  // find kth # of two sorted array
  public static int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
    if (A_start >= A.length) return B[B_start + k - 1];
    if (B_start >= B.length) return A[A_start + k - 1];
    if (k == 1) return Math.min(A[A_start], B[B_start]);

    int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
    int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;

    if (A_key < B_key) {
      return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
    } else {
      return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
    }

  }

}
