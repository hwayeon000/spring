package kr.board.entity;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
	
	private int product_seq;
	private int cate_seq;
	private int photo_seq;
	private String product_name;
	private int product_price;
	private String product_content;
	private Timestamp product_date;
	private int product_have;
	private int product_rent;
	private int product_rest;
	private String photo_b_name;
	private String photo_s_name;
	private String photo_extension;
	private String photo_path;
	private String photo_size;
	private Timestamp photo_date;
	
	private int cate_depth1;
	
}
