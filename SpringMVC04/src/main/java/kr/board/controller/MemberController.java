package kr.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.board.entity.Member;
import kr.member.mapper.MemberMapper;

@Controller
public class MemberController {
	@Autowired
	private MemberMapper memberMapper;
	
	// 회원 프로필 사진 등록  /imageUpdate.do
	@PostMapping("/imageUpdate.do")
	public String imageUpdate(HttpServletRequest request, HttpSession session, RedirectAttributes rttr){
		// 파일 업로드 API (cos.jar -> 서버에 이미지 저장용)
		// DB 저장은 MemberMapper가 할거임ㅎ
		MultipartRequest multi = null;
		
		// MultipartRequest 객체 생성을 위한 매개변수 필요
		// 1. 요청객체 ( request )
		// 2. 이미지 저장할 폴더 경로
		// 3. 허용 가능한 크기
		// 4. 인코딩 (파일명에 대한, 한글일 수 도 있음)
		// 5. 중복이름 안 되도록 도와주는 객체
		
		String savePath = request.getRealPath("resources/upload");
		int fileMaxSize = 10*1024*10*100; // 10MB
		String enc = "UTF-8";
		DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();
		
		// 기존 가지고 있는 해당 프로필 이미지 삭제
		String memID = ((Member)session.getAttribute("mvo")).getMemID();
		String oldImg = memberMapper.getMember(memID).getMemProfile();
		
		// 기존 내가 저장한 사진을 파일 객체로 불러옴 (경로!)
		File oldFile = new File(savePath+"/"+oldImg);
		// 기존 파일이 존재한다면, 삭제
		if (oldFile.exists()) oldFile.delete(); 
		
		try {
			// Error : savePath : 경로가 없을 경우에 대한 예외처리 필요 -> try-catch
			// 객체 생성하자마자 파일에 저장됨! -> 그 전 내 프로필 사진 삭제 필요
			multi = new MultipartRequest(request, savePath, fileMaxSize, enc, dfrp);
			
		} catch (IOException e) {
			// 실패했다면
			e.printStackTrace();
			rttr.addFlashAttribute("msgType","실패 메세지");
			rttr.addFlashAttribute("msg","파일의 크기는 10MB를 넘을 수 없습니다.");
			return "redirect:/imageForm.do";
		}
		
		// img 파일인지 아닌지 판별하기
		String newProfile = "";
		File file = multi.getFile("memProfile");
		if (file != null) {
			// 파일을 올렸다는 것!
			// 확장자 가져오가기
			String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
			ext = ext.toUpperCase();
			boolean extResult = ext.equals("JPG") || ext.equals("PNG") || ext.equals("GIF");
			if (!extResult) {
				// 이미지 파일이 아닐 때
				if (file.exists()) {
					file.delete();
					rttr.addFlashAttribute("msgType","실패 메세지");
					rttr.addFlashAttribute("msg","이미지 파일만 가능합니다.(png, gif, jpg)");
					return "redirect:/imageForm.do";
				}
			}
		}
		// 이미지 파일 판별 끝
		
		// 세로운 이미지를 테이블에 저장
		newProfile = multi.getFilesystemName("memProfile");
		// Mapper에 넣기 위한 객체 생성
		Member vo = new Member();
		vo.setMemProfile(newProfile);
		vo.setMemID(memID);
		
		// 이미지 새로 업데이트
		memberMapper.profileUpdate(vo);
		
		// session에 기존 이미지 이름이 있을 것임
		// DB에서 회원 정보를 다시 불러와서 session에 저장
		Member newMvo = memberMapper.getMember(memID);
		session.setAttribute("mvo", newMvo);
		
		rttr.addFlashAttribute("msgType","성공 메세지");
		rttr.addFlashAttribute("msg","이미지 변경에 성공하였습니다.");
		
		return "redirect:/";
	}
	
	
	// 회원정보 수정 기능 /update.do
	@PostMapping("/update.do")
	public String update(Member m, HttpSession session, RedirectAttributes rttr) {
		// 문제
		// 회원 수정할 정보 입력받아 일치하는 회원의 비번, 이름, 나이, 성별, 이메일 수정
		System.out.println(m);
		// 회원수정 불가능한 상활
		// 1. 하나라도 누락된 정보가 존재한다면 회원정보 페이지 수정 후 모든 내용 입력하세요 모달창 띄우기
		if (m.getMemID()==null || m.getMemID().equals("") 
				||m.getMemPassword()==null || m.getMemPassword().equals("")
				|| m.getMemName()==null || m.getMemName().equals("")
				|| m.getMemAge()==0
				|| m.getMemEmail()==null || m.getMemEmail().equals("")) {
			
			rttr.addFlashAttribute("msgType","실패 메세지");
			rttr.addFlashAttribute("msg","모든 내용을 입력해주세요.");
			
			return "redirect:updateForm.do";
			
		} else {
			// profile null로 담지 않기 위해 공백처리
			m.setMemProfile(m.getMemProfile());
			// 3. 회원수정 성공 시 수정된 회원 정보 session에 다시 저장 후 메인 페이지 이동 후 회원 정보 수정이 성공했습니다. 모달창
			int cnt = memberMapper.update(m);
			
			if (cnt>0) {
				// 회원수정 성공
				rttr.addFlashAttribute("msgType","성공 메세지");
				rttr.addFlashAttribute("msg","회원정보 수정에 성공하였습니다.");
				
				session.setAttribute("mvo", m);
				
				return "redirect:/";
			}else {
				// 2. 혹시 회원정보 수정 실패시 마찬가지로 회원정보 수정 페이지 이동 후 모달창 "회원 수정이실패하였습니다."
				rttr.addFlashAttribute("msgType","실패 메세지");
				rttr.addFlashAttribute("msg","회원정보 수정에 실패했습니다.");
				return "redirect:updateForm.do";
			}
			
		}
		
		
	}
	
	
	// 회원 프로필 등록 페이지 이동 /imageForm.do
	@GetMapping("/imageForm.do")
	public String imageForm(){
		 return "member/imageForm";
	}
	
	// 회원 정보 수정 페이지 이동  /updateForm.do
	@GetMapping("/updateForm.do")
	public String updateForm(){
		return "member/updateForm";
	}
	
	// 로그인 페이지 이동  /loginForm.do
	@GetMapping("/loginForm.do")
	public String loginForm(){
		return "member/loginForm";
	}
	
	
	// 로그인기능 /login.do
	@PostMapping("/login.do")
	public String login(Member m, HttpSession session, RedirectAttributes rttr) {
		// 로그인 성공시 mvo 이름으로 session 회원 정보 저장, index.jsp 로그인 성공 모달
		// 로그인 실패시 loginForm.jsp 이돋ㅇ 후 아이디 비번 다시 입력해달란 모달
		
		Member mvo = memberMapper.login(m);
		if (mvo==null) {
			rttr.addFlashAttribute("msgType","실패 메세지");
			rttr.addFlashAttribute("msg","로그인에 실패했습니다.");
			
			return "redirect:loginForm.do";
		} else {

			session.setAttribute("mvo", mvo);
			
			rttr.addFlashAttribute("msgType","성공 메세지");
			rttr.addFlashAttribute("msg","정상적으로 로그인에 성공했습니다.");
			
			return "redirect:/";
		}
	}
	
	
	// 로그아웃 기능
	@GetMapping("/logout.do")
	public String Logout(HttpSession session, RedirectAttributes rttr) {
		session.invalidate();
		
		rttr.addFlashAttribute("msgType","로그아웃 메세지");
		rttr.addFlashAttribute("msg","정상적으로 로그아웃에 성공하였습니다.");
		
		return "redirect:/";
	}
	
	
	// 회원가입 페이지 이동  /joinForm.do
	@GetMapping("/joinForm.do")
	public String joinFrom() {
		return "member/joinForm";
	}
	
	// 회원아이디 중복 체크 기능  /registerCheck.do
	@GetMapping("/registerCheck.do")
	public @ResponseBody int registerCheck(@RequestParam("memID")String memID) {
		Member m = memberMapper.registerCheck(memID);
		
		if (memID.equals("") || m != null) {
			return 0;
		} else {
			return 1;
		}
		
	}
	
	// 회원가입 기능  /join.do
	@PostMapping("/join.do")
	public String join(Member m, HttpSession session, RedirectAttributes rttr) {
		
		// RedirectAttributes
		// - Redirect 방식으로 페이지를 이동할 때 전달할 데이터가 있는데
		// Request에 담자니 데이터가 사라지고 Session에 담자니 뭔가 너무 아깝다..
		// 딱 한번만 데이터를 저장해서 뿌려주는 저장소 (객체) : page영역
		
		System.out.println(m);
		// 회원가입이 불가능한 상활
		if (m.getMemID()==null || m.getMemID().equals("")
				|| m.getMemPassword()==null || m.getMemPassword().equals("")
				|| m.getMemName()==null || m.getMemName().equals("")
				|| m.getMemAge()==0
				|| m.getMemEmail()==null || m.getMemEmail().equals("")) {
			
			rttr.addFlashAttribute("msgType","실패 메세지");
			rttr.addFlashAttribute("msg","모든 내용을 입력해주세요.");
			
			return "redirect:joinForm.do";
			
		} else {
			// 회원가입이 가능한 상황
			m.setMemProfile("");
			int cnt = memberMapper.join(m);
			
			if (cnt>0) {
				// cnt==1, 회원가입 성공 => 로그인까지 해줄게~ㅎ
				rttr.addFlashAttribute("msgType","성공 메세지");
				rttr.addFlashAttribute("msg","회원가입에 성공하였습니다.");
				
				session.setAttribute("mvo", m);
				
				return "redirect:/";
			}else {
				// 회원가입 실패
				rttr.addFlashAttribute("msgType","실패 메세지");
				rttr.addFlashAttribute("msg","회원가입에 실패했습니다.");
				return "redirect:joinForm.do";
			}
			
		}
	}
	
	
}
