package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Product;
import kr.product.mapper.ProductMapper;

@Controller
public class PageMoveController {
	@Autowired
	private ProductMapper productMapper;
	
	@GetMapping("/product.do")
	public String productForm(Model model) {
		List<Product> p_dao = productMapper.showProducts();
		model.addAttribute("p_dao", p_dao);
		return "product/product";
	}
	
	@GetMapping("/shoppingCart.do")
	public String shoppingCart() {
		return "product/shoppingCart";
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Product> p_dao = productMapper.showProducts();
		model.addAttribute("p_dao", p_dao);
		return "index";
	}
	
	@RequestMapping("/inquiry.do")
	public String inquiry() {
		return "board/inquiry";
	}
	
	@RequestMapping("/admin.do")
	public String admin() {
		return "admin";
	}
	
	// 로그인 페이지로 이동
	@GetMapping("/login.do")
	public String login() {
		return "user/login";
	}
	
	// 회원가입 페이지로 이동
	@GetMapping("/joinPage.do")
	public String joinPage() {
		return "user/joinPage";
	}
	
	// 회원가입 페이지로 이동
	@RequestMapping("/jusoPopup.do")
	public String jusoPopup() {
		return "jusoPopup";
	}
	

	
	
}
