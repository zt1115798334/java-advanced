package com.demo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2019/7/24 13:29
 * description:
 */
public class SortDemo {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println("排序前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
//        DirectInsertSort(a);
//        BinaryInsertSort(a);
//        ShellSort(a);
//        DirectSelectSort(a);
//        BubbleSort(a);
//        QuickSort(a);
        MergeSort(a);
        System.out.println();
        System.out.println("排序后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }

    /**
     * 直接排序
     * 基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
     * 复杂度分析
     * <p>
     * ①插入排序的时间复杂度 就是判断比较次数有多少，而比较次数与 待排数组的初始顺序有关，当待排数组有序时，没有移动操作（第8行for不成立），此时复杂度为O(N)，当待排数组是逆序时，比较次数达到最大--对于下标 i 处的元素，需要比较 i-1 次。总的比较次数：1+2+...+N-1 ，故时间复杂度为O(N^2)
     * <p>
     * ①可以看出，算法中只用到了一个临时变量（第6行），故空间复杂度为O(1)
     * <p>
     * 其实，插入排序的比较次数与数组的逆序数相关，因为插入排序在将某个元素插入到合适位置时（代码第12行），其实就是消除这个元素的逆序数。
     * <p>
     * 由定理：N个互异数的数组的平均逆序数是 N(N-1)/4，可知：基于相邻元素之间的比较和交换的算法的时间复杂度的一个下界为O(N^2)
     * <p>
     * 比较冒泡排序啊。。。。它采用的思路是：相邻两个元素比较，将小的放在前头。故冒泡排序的时间复杂度为O(N^2)。。。
     * <p>
     * 基于上面这个定理，另外一个排序算法：希尔排序，采用了增量序列。因此，它可能获得一个更好的时间复杂度。
     * <p>
     * 比如，当希尔排序使用Hibbard增量序列时，它的最坏运行时间为O(N3/2)
     */
    private static void DirectInsertSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            //temp为本次循环待插入有序列表中的数
            int tmp = a[i]; //保存当前位置p的元素，其中[0,p-1]已经有序
            int j;
            //寻找temp插入有序列表的正确位置
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > tmp) {
                    //元素后移，为插入temp做准备
                    a[j + 1] = a[j]; //后移一位
                } else {
                    break;
                }
            }
            //插入temp
            a[j + 1] = tmp;
        }
    }

    /**
     * 二分法插入排序
     * 基本思想：二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，这里是按二分法找到合适的位置，可以减少比较的次数。
     */
    private static void BinaryInsertSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int tmp = a[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (tmp < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }
            if (left != i) {
                a[left] = tmp;
            }
        }

    }

    /**
     * 希尔排序
     * 基本思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。
     * 所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，取第二个增量d2
     */
    private static void ShellSort(int[] a) {
        int d = a.length / 2;
        //r 为记录右边的值  l 记录左边的值 k记录循环次数
        int r, l, k = 1;
        while (d >= 1) {
            for (int i = d; i < a.length; i++) {
                r = a[i];   //获取到右边的值
                l = i - d; //获取到左边值的下标
                while (l >= 0 && a[l] > r) {//比较左右两边的值 如果左边的大于右边的 将两者互换 左边
                    a[l + d] = a[l];
                    l = l - d;
                }
                a[l + d] = r;
            }
            d = d / 2;
            System.out.println("第" + k++ + "趟：" + Arrays.toString(a));
        }
    }

    /**
     * 直接选择排序
     * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    private static void DirectSelectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];//记录最小的数值
            int n = i; //记录最小的数值的下标
            //遍历记录数值的后面 的寻找最小的数值
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {//如果查询到有比最小的还小的数值
                    min = a[j];//将查询到的最小的数值交给最小数值
                    n = j;//记录最小数值的下标
                }
            }
            a[n] = a[i];//当前数值和遍历导地最小数值交换
            a[i] = min;
        }
    }

    /**
     * https://www.cnblogs.com/chengxiao/p/6129630.html
     * 堆排序
     * 堆排序是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序。首先简单了解下堆结构。
     * 堆
     *
     * 　　堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。如下图：
     * 该数组从逻辑上讲就是一个堆结构，我们用简单的公式来描述一下堆的定义就是：
     *
     * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     *
     * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
     * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
     *
     * 　　b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
     *
     * 　　c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
     *
     * 代码实现
     */
    private static void HeapSort(int[] a) {
        int arrayLength = a.length;
        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            // 建堆
            buildMaxHeap(a, arrayLength - 1 - i);
            // 交换堆顶和最后一个元素
            swap(a, 0, arrayLength - 1 - i);
            System.out.println(Arrays.toString(a));
        }
    }

    // 对data数组从0到lastIndex建大顶堆
    private static void buildMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 交换他们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    // 交换
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    /**
     * 冒泡排序
     * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，
     * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
     * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     */
    /**
     * 假如有几个数字int score[] = {67, 69, 75, 88};  按照从大到小排序。
     * <p>
     * 有2种思路，第一种，score[j] 和 score[j+1] 比较 如果 前者比后者小，把前者和后者调换顺序，两两调换后一轮下来 最小的会被排到最后去。每一轮j都从0开始，当i轮排序，就有最后面的i个数字因为他是最小的，所以后面的每轮都不用理他了，也就是 score.length-1-i  往后的数不用管了，如上，第一轮有4个数字 i为0 ，那么score.length-1-i  为3，也就是下标是3以后的可以不用管，3往后没有数字，所以第一轮所有的数字都要参加比较，第二轮I=1  score.length-1-i  为2 也就是说 下标2后面的 下标为3的数字不用比了，因为两两比较厚，67会到 score[3],实现代码如下
     * ---------------------
     * 作者：Jackwang@1992
     * 来源：CSDN
     * 原文：https://blog.csdn.net/shuaizai88/article/details/73250615
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     *
     * @param a
     */
    private static void BubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 第二种思路，用88 和 75 比较，在和69 比较 在和 67 比较，发现88是最大的，吧他排到第一位(index=0的位置)，然后i=1,也就是第二轮，就不用看下标为0的88了因为他是老大，然后接着比较。；
     *
     * @param a
     */
    private static void BubbleSort2(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = (a.length - 2); j >= i; j--) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,
     * 一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     * 高快省的排序算法
     * <p>
     * 有没有既不浪费空间又可以快一点的排序算法呢？那就是“快速排序”啦！光听这个名字是不是就觉得很高端呢。
     * <p>
     * 假设我们现在对“6  1  2 7  9  3  4  5 10  8”这个10个数进行排序。首先在这个序列中随便找一个数作为基准数（不要被这个名词吓到了，就是一个用来参照的数，待会你就知道它用来做啥的了）。为了方便，就让***个数6作为基准数吧。接下来，需要将这个序列中所有比基准数大的数放在6的右边，比基准数小的数放在6的左边，类似下面这种排列：
     * <p>
     * 3  1  2 5  4  6  9 7  10  8
     * <p>
     * 在初始状态下，数字6在序列的第1位。我们的目标是将6挪到序列中间的某个位置，假设这个位置是k。现在就需要寻找这个k，并且以第k位为分界点，左边的数都小于等于6，右边的数都大于等于6。想一想，你有办法可以做到这点吗？
     * <p>
     * 排序算法显神威
     * <p>
     * 方法其实很简单：分别从初始序列“6  1  2 7  9  3  4  5 10  8”两端开始“探测”。先从右往左找一个小于6的数，再从左往右找一个大于6的数，然后交换他们。这里可以用两个变量i和j，分别指向序列最左边和最右边。我们为这两个变量起个好听的名字“哨兵i”和“哨兵j”。刚开始的时候让哨兵i指向序列的最左边（即i=1），指向数字6。让哨兵j指向序列的最右边（即=10），指向数字。
     * <p>
     * 首先哨兵j开始出动。因为此处设置的基准数是最左边的数，所以需要让哨兵j先出动，这一点非常重要（请自己想一想为什么）。哨兵j一步一步地向左挪动（即j--），直到找到一个小于6的数停下来。接下来哨兵i再一步一步向右挪动（即i++），直到找到一个数大于6的数停下来。***哨兵j停在了数字5面前，哨兵i停在了数字7面前。
     * <p>
     * 现在交换哨兵i和哨兵j所指向的元素的值。交换之后的序列如下：
     * <p>
     * 6  1  2  5  9 3  4  7  10  8
     * <p>
     * 到此，***次交换结束。接下来开始哨兵j继续向左挪动（再友情提醒，每次必须是哨兵j先出发）。他发现了4（比基准数6要小，满足要求）之后停了下来。哨兵i也继续向右挪动的，他发现了9（比基准数6要大，满足要求）之后停了下来。此时再次进行交换，交换之后的序列如下：
     * <p>
     * 6  1  2 5  4  3  9  7 10  8
     * <p>
     * 第二次交换结束，“探测”继续。哨兵j继续向左挪动，他发现了3（比基准数6要小，满足要求）之后又停了下来。哨兵i继续向右移动，糟啦！此时哨兵i和哨兵j相遇了，哨兵i和哨兵j都走到3面前。说明此时“探测”结束。我们将基准数6和3进行交换。交换之后的序列如下：
     * <p>
     * 3  1 2  5  4  6  9 7  10  8
     * <p>
     * 到此***轮“探测”真正结束。此时以基准数6为分界点，6左边的数都小于等于6，6右边的数都大于等于6。回顾一下刚才的过程，其实哨兵j的使命就是要找小于基准数的数，而哨兵i的使命就是要找大于基准数的数，直到i和j碰头为止。
     * <p>
     * OK，解释完毕。现在基准数6已经归位，它正好处在序列的第6位。此时我们已经将原来的序列，以6为分界点拆分成了两个序列，左边的序列是“3  1 2  5  4”，右边的序列是“9  7  10  8”。接下来还需要分别处理这两个序列。因为6左边和右边的序列目前都还是很混乱的。不过不要紧，我们已经掌握了方法，接下来只要模拟刚才的方法分别处理6左边和右边的序列即可。现在先来处理6左边的序列现吧。
     * <p>
     * 左边的序列是“3  1  2 5  4”。请将这个序列以3为基准数进行调整，使得3左边的数都小于等于3，3右边的数都大于等于3。好了开始动笔吧
     * <p>
     * 如果你模拟的没有错，调整完毕之后的序列的顺序应该是：
     * <p>
     * 2  1  3  5  4
     * <p>
     * OK，现在3已经归位。接下来需要处理3左边的序列“2 1”和右边的序列“5 4”。对序列“2 1”以2为基准数进行调整，处理完毕之后的序列为“1 2”，到此2已经归位。序列“1”只有一个数，也不需要进行任何处理。至此我们对序列“2 1”已全部处理完毕，得到序列是“1 2”。序列“5 4”的处理也仿照此方法，***得到的序列如下：
     * 1  2  3 4  5  6 9  7  10  8
     * <p>
     * 对于序列“9  7  10  8”也模拟刚才的过程，直到不可拆分出新的子序列为止。最终将会得到这样的序列，如下
     * <p>
     * 1  2  3 4  5  6  7  8 9  10
     * <p>
     * 到此，排序完全结束。细心的同学可能已经发现，快速排序的每一轮处理其实就是将这一轮的基准数归位，直到所有的数都归位为止，排序就结束了。下面上个霸气的图来描述下整个算法的处理过程。
     */
    private static void QuickSort(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);    //左边
            quickSort(a, middle + 1, high); //右边
        }
    }

    private static int getMiddle(int[] a, int low, int high) {
        int tmp = a[low];//获取基准元素
        while (low < high) {
            //左右同时遍历找到

            while (low < high && a[high] >= tmp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= tmp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = tmp;
        return low;
    }

    /**
     * 并归排序
     * 基本思想:归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
     * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
     * 归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。从上文的图中可看出，每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。总的平均时间复杂度为O(nlogn)。而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
     */
    private static void MergeSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }

    }

    private static void merge(int[] num, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i < mid && j <= high) {
            if (num[i] < num[j]) {
                tmp[k++] = num[i++];
            } else {
                tmp[k++] = num[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            tmp[k++] = num[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            tmp[k++] = num[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < tmp.length; k2++) {
            num[k2 + low] = tmp[k2];
        }
    }

    /**
     * 基数排序
     * 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
     * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
     *
     * @param a
     */
    private static void BaseSort(int[] a) {
        // 找到最大数，确定要排序几趟
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        // 判断位数
        int times = 0;
        while (max > 0) {
            max = max / 10;
            times++;
        }
        // 建立十个队列
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList queue1 = new ArrayList();
            queue.add(queue1);
        }
        // 进行times次分配和收集
        for (int i = 0; i < times; i++) {
            // 分配
            for (int j = 0; j < a.length; j++) {
                int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList queue2 = queue.get(x);
                queue2.add(a[j]);
                queue.set(x, queue2);
            }
            // 收集
            int count = 0;
            for (int j = 0; j < 10; j++) {
                while (queue.get(j).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(j);
                    a[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }
}
