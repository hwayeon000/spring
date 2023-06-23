package kr.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Product;

@Mapper
public interface ProductMapper {

	public List<Product> showProducts();

	public Product productDetail(int product_seq);
	
}
