package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Product;
import kr.product.mapper.ProductMapper;

@Controller
public class ProductController {
	@Autowired
	private ProductMapper productMapper;
	
	// 상품 상세 페이지 이동
	@GetMapping("/productDetail.do")
	public String productForm(@RequestParam int product_seq, Model model) {
		Product vo = productMapper.productDetail(product_seq);
		model.addAttribute("vo", vo);
		return "product/productDetail";
	}
	
	
	
	
}
