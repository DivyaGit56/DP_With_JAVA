class Solution {
    int  res = Integer.MIN_VALUE;
    public  int solve(TreeNode root){
        // Base Case
        if(root == null){
            return 0;
        }
        // Hypothesis
        int l = solve(root.left);
        int r = solve(root.right);

        // Ignore negative paths
        l = Math.max(0, l);
        r = Math.max(0, r);

        // Best downward path (return to parent)
        int temp = Math.max(l, r) + root.val;

        // Best path passing through node
        int ans = l + r + root.val;

        res = Math.max(res, ans);

        return temp;
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return res;
        
    }
}
