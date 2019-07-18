package com.zhc.commonjava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author zhangchi02
 * @date 2019年3月6日
 */
public class PokerDemo {

	public static void main(String[] args) {
		// 存储每张扑克牌的索引
		ArrayList<Integer> itemList = new ArrayList<Integer>();
		// 存储每张扑克牌以及索引
		HashMap<Integer, String> poker = new HashMap<Integer, String>();

		// 花色
		String[] color = { "♥", "♠", "♣", "♦" };
		// 数字
		String[] number = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };

		// 创建扑克牌饼存储索引
		int index = 0;
		for (String num : number) {
			for (String col : color) {
				poker.put(index, col.concat(num));
				itemList.add(index);
				index++;
			}
		}
		poker.put(index, "小王");
		itemList.add(index);
		index++;
		poker.put(index, "大王");
		itemList.add(index);
		
		//洗牌
		Collections.shuffle(itemList);

		TreeSet<Integer> player1 = new TreeSet<Integer>();
		TreeSet<Integer> player2 = new TreeSet<Integer>();
		TreeSet<Integer> player3 = new TreeSet<Integer>();
		TreeSet<Integer> dipai = new TreeSet<Integer>();

		// 发牌
		for (int x=0 ;x< itemList.size();x++) {
			if (x >= itemList.size()-3) {
				dipai.add(itemList.get(x));
			} else if (x % 3 == 0) {
				player1.add(itemList.get(x));
			} else if (x % 3 == 1) {
				player2.add(itemList.get(x));
			} else if (x % 3 == 2) {
				player3.add(itemList.get(x));
			}
		}

		// 看牌
		lookPoker("player1", player1, poker);
		lookPoker("player2", player2, poker);
		lookPoker("player3", player3, poker);
		lookPoker("dipai", dipai, poker);
	}

	public static void lookPoker(String name, TreeSet<Integer> player, HashMap<Integer, String> poker) {
		System.out.print(name + "的牌：");
		for (Integer item : player) {
			System.out.print(poker.get(item)+" ");
		}
		System.out.println();
	}
}
