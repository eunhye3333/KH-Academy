package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

public class AscTitle implements Comparator<Music> {

	@Override
	public int compare(Music o1, Music o2) {
		int result = o1.getTitle().compareTo(o2.getTitle());
		
		if(result == 0) {
			return o1.getSinger().compareTo(o2.getSinger());
		} else {
			return result;
		}
	}

}
