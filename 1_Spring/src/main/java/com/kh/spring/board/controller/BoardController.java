package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.exception.BoardException;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.PageInfo;
import com.kh.spring.common.Pagination;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	@RequestMapping("blist.bo")
	public ModelAndView boardList(@RequestParam(value="page", required=false) Integer page, /*Model model*/ ModelAndView mv) {
		
		int currentPage = 1;
		
		if(page != null) {
			currentPage = page;
		}
		
		int listCount  = bService.getListCount();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Board> list = bService.selectList(pi);
		
		if(list != null) {
			// 1) 반환값이 String인 상태에서 view에 데이터 전달 : Model
//			model.addAttribute("pi", pi);
//			model.addAttribute("list", list);
			
			// 2) 반환값을 ModelAndView 로 변경한 상태에서 view에 데이터 전달
			mv.addObject("pi", pi);
			mv.addObject("list", list);
			
			mv.setViewName("boardListView");
		} else {
			throw new BoardException("게시글 전체 조회에 실패하였습니다.");
		}
		
//		return "boardListView";
		return mv;
	}
	
	@RequestMapping("binsertView.bo")
	public String boardInsertView() {
		return "boardInsertForm";
	}
	
	@RequestMapping("binsert.bo")
	public String boardInsert(@ModelAttribute Board b, @RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request) {
		// MultipartFile을 사용할 수 있도록 라이브러리를 추가해야 함
		
//		System.out.println(b);
//		System.out.println(uploadFile);
//		System.out.println(uploadFile.getOriginalFilename());
		
		// uploadFile : 파일이 들어오지 않아도 객체가 생성되므로 getOriginalFilename() 메소드를 이용해 구분하여야 함(해당 메소드의 반환값이 비어있는지 아닌지)
//		if(!uploadFile.getOriginalFilename().equals("")) {
		if(uploadFile != null && !uploadFile.isEmpty()) {
			String renameFileName = saveFile(uploadFile, request); // 저장할 폴더에 접근하기 위해서는 request가 필요함
			
			if(renameFileName != null) {
				b.setOriginalFileName(uploadFile.getOriginalFilename());
				b.setRenameFileName(renameFileName);
			}
		}
		
		int result = bService.insertBoard(b);
		
		if(result > 0) {
			return "redirect:blist.bo";
		} else {
			throw new BoardException("게시글 등록에 실패하였습니다.");
		}
	}
	
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// webapp 아래 resources에 저장
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		// buploadFiles 폴더에 저장
		String savePath = root + "/buploadFiles";
		
		File folder = new File(savePath);
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "." + originFileName.substring(originFileName.lastIndexOf(".") + 1);
		
		String renamePath = folder + "/" + renameFileName;
		try {
			file.transferTo(new File(renamePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return renameFileName;
	}
}
