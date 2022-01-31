package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
 @Inject
 BoardService service;


 //목록 (list)
 @RequestMapping(value = "/list", method = RequestMethod.GET)
 public void getList(Model model) throws Exception {
  
	 List<BoardVO> list = null;
	 list = service.list();
	 
	 model.addAttribute("list", list);
   
 }
 
 //작성 (write)
 @RequestMapping(value = "/write", method = RequestMethod.GET)
 public void getWrite() throws Exception {
	 
}
 
 @RequestMapping(value = "/write", method = RequestMethod.POST)
 public String postWrite(BoardVO vo) throws Exception {
	 service.write(vo);
	 
	 return "redirect:/board/list";
}
 
 //조회 (view)
 @RequestMapping(value = "/view", method = RequestMethod.GET)
 public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
	BoardVO vo = service.view(bno);
	
	model.addAttribute("view", vo);
}
 
 //수정 (modify)
 @RequestMapping(value = "/modify", method = RequestMethod.GET)
 public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
	BoardVO vo = service.view(bno);
	model.addAttribute("view", vo);
}
 
//수정 post
@RequestMapping(value = "/modify", method = RequestMethod.POST)
public String postModify(BoardVO vo) throws Exception {

service.modify(vo);
 
return "redirect:/board/view?bno=" + vo.getBno();
}
 
 
}