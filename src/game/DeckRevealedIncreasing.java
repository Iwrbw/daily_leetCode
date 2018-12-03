package game;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author yangshunfan 2018/12/2 12:48
 * 题号：950
 * 牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
 * 最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。
 * 现在，重复执行以下步骤，直到显示所有卡牌为止：
 * 从牌组顶部抽一张牌，显示它，然后将其从牌组中移出.
 * 如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
 * 如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
 *
 * uwi的解法
 */
public class DeckRevealedIncreasing {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                q.addFirst(q.pollLast());
            }
            q.addFirst(deck[i]);
        }
        int p = 0;
        int[] ret = new int[n];
        for (int x : q) {
            ret[p++] = x;
        }
        return ret;
    }

    public static void main(String[] args) {
        DeckRevealedIncreasing di = new DeckRevealedIncreasing();
        int[] deck = {17,13,11,2,3,5,7};
        int[] ret = di.deckRevealedIncreasing(deck);
        for (Integer i : ret) {
            System.out.print(i + " ");
        }
    }
}
