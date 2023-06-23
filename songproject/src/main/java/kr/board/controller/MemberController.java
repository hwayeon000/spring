package kr.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	private MemberMapper memberMapper;
	
	// 회원프로필사진 등록 /imageUpdate.do
	@PostMapping("imageUpdate.do")
	public String imageUpdate(HttpServletRequest request, HttpSession session, RedirectAttributes rttr) {
		// 파일업로드 API (cos.jar) cos는 리소스안에 파일을 업로드하는 기능만 있다 서버는 별도로 해줘야한다.
		MultipartRequest multi = null;
		
		// MultipartRequest 객체 생성하기 위해서는 매개변수가 필요
		// 1. 요청객체 (request)
		// 2. 이미지를 저장할 폴더의 경로
		// 3. 허용가능한 크기
		// 4. 파일 이름에 대한 인코딩
		// 5. 중복이름 안되게 해주는 객체
		
		String savePath = request.getRealPath("resources/upload");
		int fileMaxSize = 10 * 1024 * 10 * 100 ; // 100MB
		String enc = "UTF-8";
		DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();
		
		// 기존 가지고 있는 해당 프로필 이미지 삭제 (멀티파트리퀘스트 객체가 생성과 동시에 사진이 저장되기 때문에 이미지를 먼저 삭제해야한다
		String memID = ((Member)session.getAttribute("mvo")).getMemID();
		String oldImg = memberMapper.getMember(memID).getMemProfile();
		File oldFile = new File(savePath+"/"+oldImg); // 기존에 저장해놓은 파일을 객체로 불러오는 것
		if(oldFile.exists()) {
			System.out.println(oldFile);
			oldFile.delete();
		}
		
		
		try {
			multi = new MultipartRequest(request, savePath, fileMaxSize, enc, dfrp);
			
		} catch (IOException e) {
			rttr.addFlashAttribute("msgType","실패 메시지");
			rttr.addFlashAttribute("msg","파일의 크기는 10MB를 넘을 수 없습니다.");
			return "redirect:/imageForm.do";
		}
		
		// img 파일인지 아닌지 판별하기
		String newProfile = "";
		
		File file = multi.getFile("memProfile"); //이미지 폼에 있는 업로드된 멤버프로필 파일을 가져올 수 있다
		
		if(file != null) {
			// 여기 안에 왔다는 것은 파일을 올렸다는 것을 의미한다
			System.out.println("파일이름 : "+file.getName());
			
			// 확장자 가져오기
			String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
			// 대문자로 통일
			ext = ext.toUpperCase();
			
			
			boolean extResult = ext.equals("JPG")|| ext.equals("PNG")|| ext.equals("GIF");
			if(!extResult) {
				// 이미지파일이 아닐때
				if(file.exists()) {
					file.delete();
					rttr.addFlashAttribute("msgType","실패 메시지");
					rttr.addFlashAttribute("msg","이미지 파일만 가능합니다(PNG, JPG, GIF)");
					return "redirect:/imageForm.do";
				}
			}
		}
		
		// 새로운 이미지를 테이블에 저장
		newProfile = multi.getFilesystemName("memProfile");
		// Mapper에 넣기 위한 객체 생성
		// 기본생성자를 만든 다음 거기에 프로필과 id 값이 들어간 vo를 또 만들어준 것
		Member vo = new Member();
		vo.setMemProfile(newProfile);
		vo.setMemID(memID);
		memberMapper.profileUpdate(vo); // 이미지 새로이 업데이트
		
		// DB에서 회원의 정보를 다시 불러와서 session에 저장
		
		Member mvo = memberMapper.getMember(memID);
		
		session.setAttribute("mvo", mvo);
		
		rttr.addFlashAttribute("msgType","성공 메시지");
		rttr.addFlashAttribute("msg","이미지 변경이 성공했습니다.");
		return "redirect:/";
		
	}
	
	// 회원프로필등록페이지 이동 /imageForm.do
	@GetMapping("/imageForm.do")
	public String imageForm() {
		return "member/imageForm";
	}
	
	
	// 회원정보수정기능 /update.do
	@PostMapping("/update.do")
	public String update(Member m, HttpSession sessoin, RedirectAttributes rttr) {
		// 문제.
		// 회원수정할 정보를 입력받아 아이디가 일치하는 회원의
		// 비밀번호, 이름, 나이, 성별, 이메일을 수정해주세요
		
		// 조건
		// 1.하나라도 누락된 데이터가 존재한다면 회원정보수정 페이지로 이동한 후에
		// 	 "모든 내용을 입력하세요"라는 글자를 모달창으로 띄워주기
		// 2.혹시 회원정보수정이 실패한다면 마찬가지로 회원정보수정 페이지로 이동한 후에
		//   "회원정보수정이 실패했습니다." 라는 글자를 모달창으로 띄워주기
		// 3.회원정보수정 성공 시 수정된 회원의 정보를 세션에 다시 저장한 후
		//   메인 페이지로 이동한 다음에 "회원정보수정이 성공했습니다."라는 글자를 모달창으로 띄워주기
		if(m.getMemPassword() == null || m.getMemPassword().equals("")
				|| m.getMemName() == null || m.getMemName().equals("")
				|| m.getMemAge() == 0
				|| m.getMemGender() == null || m.getMemGender().equals("")
				|| m.getMemEmail() == null || m.getMemEmail().equals("")) {
			// 회원정보 수정이 불가능한 상황 (미입력 데이터 존재)
			System.out.println("회원정보수정실패");
			rttr.addFlashAttribute("msgType","실패 메시지");
			rttr.addFlashAttribute("msg","모든 내용을 입력하세요.");
			return "redirect:/updateForm.do";
		}else {
			// 회원정보수정이 가능한 상황
			m.setMemProfile(memberMapper.getMember(m.getMemID()).getMemProfile());
			int cnt = memberMapper.update(m);
		
			if(cnt == 1) {
				// 회원정보 수정 성공
				rttr.addFlashAttribute("msgType","성공 메시지");
				rttr.addFlashAttribute("msg","회원정보 수정에 성공했습니다.");
				
				sessoin.setAttribute("mvo", m);
				return "redirect:/";
			}else {
				// 회원정보 수정 실패
				rttr.addFlashAttribute("msgType","실패 메시지");
				rttr.addFlashAttribute("msg","회원정보 수정에 실패했습니다.");
				
				return "redirect:/updateForm.do";
			}
	}
	}
	
	// 회원정보수정 페이지 이동 / updateForm.do
	@GetMapping("/updateForm.do")
	public String updateForm() {
		return "member/updateForm";
	}
	
	// 로그인 기능 /login.do
	@PostMapping("/login.do")
	public String login(Member m, HttpSession session, RedirectAttributes rttr) {
		// 문제
		// 로그인기능 구현
		// 입력한 아이디와 비밀번호 일치하는 회원을 검색하여서
		// 로그인 성공 시 
		// - session에 mvo이름으로 회원의 정보를 저장 index.jsp에서 로그인에 성공했습니다 모달창
		// 로그인 실패 시
		// - loginForm.jsp 이동 후 아이디와 비밀번호를 다시 입력해주세요 모달창
		
		Member mvo = memberMapper.login(m);
		System.out.println(m);
		if(mvo !=null) {
			session.setAttribute("mvo", mvo);
			rttr.addFlashAttribute("msgType","성공 메시지");
			rttr.addFlashAttribute("msg","로그인에 성공했습니다.");
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("msgType","실패 메시지");
			rttr.addFlashAttribute("msg","아이디와 비밀번호를 확인하세요.");
			return "redirect:/loginForm.do";
		}
	}
	
	// 로그인 페이지 이동 /loginForm.do
	@GetMapping("/loginForm.do")
	public String StringloginForm() {
		return "member/loginForm";
	}
	
	// 로그아웃 기능 /logout.do
	@GetMapping("/logout.do")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		
		session.invalidate();
		rttr.addFlashAttribute("msgType","로그아웃 메시지");
		rttr.addFlashAttribute("msg","정상적으로 로그아웃 되었습니다.");
		return "redirect:/";
	}
	
	
	// 회원아이디 중복체크 기능 / registerCheck.do
	@GetMapping("/registerCheck.do")
	public @ResponseBody int registerCheck(@RequestParam("memID")String memID) {
		
		Member m = memberMapper.registerCheck(memID);
		
		if(memID.equals("") || m != null) {
			return 0; // 이미 존재하거나 아이디를 아예 입력 X
		}else {
			return 1; // 사용할 수 있음
		}
	}
	
	// 회원가입 페이지 이동 /joinForm.do
	@GetMapping("/joinForm.do")
	public String joinForm() {
		return "member/joinForm"; // 멤버 폴더 안에 있는 조인 폼을 가져온다.
	}
	
	// 회원가입기능 / join.do
	@PostMapping("/join.do")
	public String join(Member m, HttpSession sessoin, RedirectAttributes rttr) {// 매개변수에 필요한 객체를 적어줘서 DI함
		
		// RedirectAttributes
		// - Redirect 방식으로 페이지를 이동할때 전달할 데이터가 있는데
		// Request에 담자니 데이터가 사라지고 Session에 담자니 뭔가 너무 아깝고 할때
		// 딱 한번만 데이터를 저장해서 뿌려주는 저장소(객체)
		
		if(m.getMemID() == null || m.getMemID().equals("")
				|| m.getMemPassword() == null || m.getMemPassword().equals("")
				|| m.getMemName() == null || m.getMemName().equals("")
				|| m.getMemAge() == 0
				|| m.getMemEmail() == null || m.getMemEmail().equals("")) {
			System.out.println("리턴턴턴");
			rttr.addFlashAttribute("msgType","실패 메시지");
			rttr.addFlashAttribute("msg","모든 내용을 입력하세요.");
			// 회원가입이 불가능한 상황 (미입력 데이터 존재)
			return "redirect:/joinForm.do";
		}else {
			// 회원가입이 가능한 상황
			m.setMemProfile("");
			int cnt = memberMapper.join(m);
			
			if(cnt == 1) {
				// 회원가입 성공
				rttr.addFlashAttribute("msgType","성공 메시지");
				rttr.addFlashAttribute("msg","회원가입에 성공했습니다.");
				
				sessoin.setAttribute("mvo", m);
				return "redirect:/";
			}else {
				// 회원가입 실패
				rttr.addFlashAttribute("msgType","실패 메시지");
				rttr.addFlashAttribute("msg","회원가입에 실패했습니다.");
				
				return "redirect:/joinForm.do";
			}
		}
		
	}
	
	
	
}
