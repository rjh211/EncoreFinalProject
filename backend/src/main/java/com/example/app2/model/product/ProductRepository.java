package com.example.app2.model.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app2.model.member.MemberVO;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByNameLike(String name);
//	List<Product> findBySeller(Shop_Member seller);
	List<Product> findBySeller(MemberVO seller);
}
