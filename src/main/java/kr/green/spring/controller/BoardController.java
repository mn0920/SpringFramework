package kr.green.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.AccountVo;
import kr.green.spring.vo.BoardVo;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	/* bean에 등록된 Resource 중에서 id가 uploadPath를 가져옴*/
	@Resource
	private String uploadPath;
	
	@RequestMapping(value="/board/list", method = RequestMethod.GET)
	   public String boardListGet(Model model, Criteria cri) {
		  PageMaker pageMaker = boardService.getPageMaker(cri, 10);
	      
	      ArrayList list = null;
	      list = (ArrayList)boardService.getBoardLists(cri);
	      
	      model.addAttribute("list", list);
	      model.addAttribute("pageMaker", pageMaker);
	      return "board/list";
	   }
	
	@RequestMapping(value="/board/register", method=RequestMethod.GET)
		public String boardRegisterGet(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		AccountVo user = (AccountVo)session.getAttribute("user");
		if(user != null)
			model.addAttribute("author", user.getId());
			return "board/register";
	}
	@RequestMapping(value="/board/register", method=RequestMethod.POST)
	public String boardRegisterPost(BoardVo boardVo, MultipartFile files) throws IOException, Exception {
		System.out.println(files);
		//uploadFile(files.getOriginalFilename(),files.getBytes());
		String filepath = UploadFileUtils.uploadFile(uploadPath, files.getOriginalFilename(), files.getBytes());
		boardVo.setFile(filepath);
		boardService.registerBoard(boardVo);
		return "redirect:/board/list";
	}
	
//	UploadFileUtils에서 하기 때문에 없어도 된다.
//	private String uploadFile(String name, byte[] data)
//			throws Exception{
//		    /* 고유한 파일명을 위해 UUID를 이용 */
//			UUID uid = UUID.randomUUID();
//			/* UUID_파일명으로 저장을 하겠다.*/
//			String savaName = uid.toString() + "_" + name;
//			/* uploadPath 경로에, savaName위로 저장한 이름으로 저장하겠다.
//			 * - 해당파일을 빈파일로 만들고, */
//			File target = new File(uploadPath, savaName);
//			/* 여기가 실제로 저장이 되는 부분. 
//			 * - 만든 빈파일에 실 데이더를 복사해서 넣은 것 */
//			FileCopyUtils.copy(data, target);
//			return savaName;
//	}
	
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
		public String boardDetailGet(Model model, Integer num, Criteria cri) {
			if(num== null)
				return "redirect:/board/list";
			BoardVo boardVo = boardService.getBoard(num);
			model.addAttribute("board", boardVo);
			model.addAttribute("cri", cri);
			return "board/detail";
	}

	@RequestMapping(value="/board/delete", method=RequestMethod.GET)
	public String boardDeleteGet(int num) {
		boardService.deleteBoard(num);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
		public String boardModifyGet(Model model, Integer num, Integer page, String search) {
		//정상 경로로 수정페이지에 접근한게 아니면
			if(num == null) {
				return "redirect:/board/list";
			}
			if(page == null)
				page =1;
			BoardVo boardVo = boardService.getBoard(num);
			model.addAttribute("search", search);
			model.addAttribute("board", boardVo);
			model.addAttribute("page", page);
			return "board/modify";
	}
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
	public String boardModifyrPost(BoardVo boardVo, Model model, MultipartFile files) throws IOException, Exception {
		String file; 
		if(files != null) {
			file = UploadFileUtils.uploadFile(uploadPath, files.getOriginalFilename(), files.getBytes());
			boardVo.setFile(file);
		}
		boardService.updateBoard(boardVo);
		return "redirect:/board/list";
	}
	
	@ResponseBody
	@RequestMapping("/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        /*String FormatName = fileName.substring(fileName.lastIndexOf(".")+1); 벌써 get에서 해주고 있기 떄문에*/
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	
}
