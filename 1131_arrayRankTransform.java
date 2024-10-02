import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
                // Priority Queue to sort pairs of (value, index) in ascending order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Push elements of the array into the priority queue
        for (int i = 0; i < arr.length; i++) {
            pq.offer(new int[]{arr[i], i});
        }

        int count = 0;
        int prevEle = Integer.MIN_VALUE;
        int[] rank = new int[arr.length];
        Arrays.fill(rank, -1); // Initialize ranks with -1

        // Process the priority queue
        while (!pq.isEmpty()) {
            int[] it = pq.poll();

            // Increment count if the current element is greater than the previous
            if (it[0] != prevEle) {
                count++;
            }

            rank[it[1]] = count; // Assign rank
            prevEle = it[0];     // Update previous element
        }

        return rank;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {20, 10, 30};
        int[] res = solution.arrayRankTransform(arr);
        System.out.println(Arrays.toString(res));
    }
}