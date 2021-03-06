package dpCode;

/**
 * @description: 不同的二叉搜索树
 * @author: Damon
 * @date 2021/7/14 16:08
 */
public class Solution_numTrees {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
