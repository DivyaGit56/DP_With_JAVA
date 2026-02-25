class Solution {
    int res =Integer.MIN_VALUE;
    public  int solve(TreeNode root ){
        // Base case
        if(root == null)return 0;
        // hypothesis
        int l = solve(root.left);
        int r = solve(root.right);

        // induction(it induced answer)
        int temp = Math.max(l,r)+1;
       
        res = Math.max(res,l+r);
        return temp;

    }
    public int diameterOfBinaryTree(TreeNode root) {
    
     solve(root);
     return res;
    }
}
