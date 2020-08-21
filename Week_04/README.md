学习笔记

## 学而时习之

学---> 模仿
习---> 刻意练习

技能是学不会的,需要不断的模仿 + 刻意练习才能真正掌握技能.

模仿就是别人怎么做,我就照着怎么做.

练习就是给自己反馈,我是否真正的掌握了这个技能.

记录下二分查找的模板:

```javascript
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
```

DFS的模板,通过递归来实现
```javascript
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }
```

BFS的模板,通过队列来实现,这个模板是层序遍历的,还有不层序遍历的那种
```javascript
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```



使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

找中间无序的地方,其实就是找最小值的位置是一样.

1. 依然是使用二分查找法
2. left = 0; right = nums.length - 1 ,middle 
3. 如果nums[left] <= nums[middle] 说明最小值在右边 left = middle + 1;
4. 反之, right = middle;因为最小值还有可能是中间值
5. 如果找到了数组最小值的索引,就相当于是找到了中间无序的地方.
