package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import com.kh.practice.set.model.compare.SortedLottery;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<Lottery>();
	private HashSet<Lottery> win = new HashSet<Lottery>();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}

	public boolean deleteObject(Lottery l) {
		if(lottery.remove(l)) {
			if(win != null) {
				win.remove(l);
			}
			return true;
		}
		return false;
	}

	public HashSet<Lottery> winObject() {
		ArrayList<Lottery> list = new ArrayList<Lottery>(lottery);
		if(lottery.size() < 4) {
			return null;
		} else {
			while(win.size() != 4) {
				int num = (int)(Math.random() * lottery.size());
				win.add(list.get(num));
			}
			return win;
		}
	}

	public TreeSet<Lottery> sortedWinObject() {
		if(win != null) {
			TreeSet<Lottery> sort = new TreeSet<Lottery>(new SortedLottery());
			sort.addAll(win);
			return sort;
		}
		return null;
	}

	public boolean searchWinner(Lottery l) {
		Iterator<Lottery> it = win.iterator();
		while(it.hasNext()) {
			if(it.next().equals(l)) {
				return true;
			}
		}
		return false;
	}
	
	
}
