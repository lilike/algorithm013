学习笔记

本周的学习内容主要包括有:

## 01字典树和并查集.

字典树这种新的数据结构主要还是通过数组+链表实现的.

主要是用来字符串的前缀匹配以及自动补全等上面.

并查集是一种跳跃式的数据结构.

这个数据结构很有意思.

主要是解决朋友圈问题.同时每一个朋友圈都有一个朋友圈老大.

主要要下面三个方法

new UnionFind(n) 创建一个朋友圈

find(x) 找到x的老大

union(x,y) 把 x 和 y划分到同一个朋友圈里面.


## 02 高级搜索

我们之前学习的搜索主要是BFS和DFS.

BFS通常也是用来找最短距离.之前的模板已经有总结,下面是双向BFS的模板,可以提高效率


```

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 返回结果,总步长
        int ladderLength = 1;

        // 为了让查询时间复杂度是O(1)
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // 其实就是BFS的队列
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);


        // 记录已经访问过的单词
        Set<String> visited = new HashSet<>();

        while (beginSet.size() > 0 && endSet.size() > 0) {

            // 优先从较小的地方进行扩散
            if (beginSet.size() > endSet.size())  {
                Set<String> temp = endSet;
                endSet = beginSet;
                beginSet = temp;
            }

            Set<String> nextVisited = new HashSet<>();

            for (String word : beginSet) {
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    for (char j = 'a'; j <= 'z' ; j++) {
                        char tempChar = wordChars[i];
                        wordChars[i] = j;
                        String newWords = new String(wordChars);
                        if (endSet.contains(newWords)) {
                            return ladderLength + 1;
                        }
                        if (!visited.contains(newWords) && wordSet.contains(newWords)) {
                            nextVisited.add(newWords);
                            visited.add(newWords);
                        }
                        wordChars[i] = tempChar;
                    }
                }
            }
            ladderLength++;
            beginSet = nextVisited;

        }
        return 0;
    }
 
```

但是由于启发式搜索,A*搜索基本没有搞懂,老师主要讲解的都是python代码

### 03 红黑树和AVL

这一课程老师主要是将思路.主要是面试的时候用到,具体更加深入的可以自己去课外拓展.

AVL树追求更加严格的平衡.

会有一个平衡因子{-1,0,1}

如果超过了这个就会进行平衡旋转操作.

主要有左旋,右旋,左右旋,右左旋.

因为每一个节点保存高度和平衡因子,所以存储空间消耗比较多.

并且增删的话,旋转比较多,所以增删效率很低,所以适合数据库这种比较经常查询的操作.

但是对于增删比较多的话,适合使用红黑树,Java里面的TreeMap是用红黑树实现的.

有下面几个原则:

1. 根节点是黑色的

2. 只有红色和黑色

3. 叶子节点是黑色的,并且是nil的

4. 每一条路径的黑色节点相同

5. 树的高度差不超过2倍

红黑树是适合进行大量的插入操作的,但是查询效率没有AVL那么的高.

红黑树有一个属性是用bit存的,表示当前的树是红色还是黑色.






