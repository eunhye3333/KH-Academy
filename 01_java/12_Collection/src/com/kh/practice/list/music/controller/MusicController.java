package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<Music>();

	public int addList(Music music) {
		if(list.add(music)) {
			return 1;
		} else {
			return 0;
		}
	}

	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	}

	public List<Music> printAll() {
		return list;
	}

	public Music searchMusic(String title) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				return list.get(i);
			}
		}
		return null;
	}

	public Music removeMusic(String title) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				return list.remove(i);
			}
		}
		return null;
	}

	public Music setMusic(String title, Music music) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				list.add(i, music);
				return list.remove(i+1);
			}
		}
		return null;
	}

	public int ascTitle() {
		Collections.sort(list, new AscTitle());
		return 1;
	}

	public int descSinger() {
		Collections.sort(list);
		return 1;
	}
}
