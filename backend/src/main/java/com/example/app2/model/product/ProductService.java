package com.example.app2.model.product;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app2.model.member.MemberVO;

@Service
public class ProductService {
	@Autowired
	private ProductRepository rep;
	private String path = "C:\\Users\\Playdata\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\";

	public void addProduct(ProductFile pf) {
		System.out.println(pf.getP());
		System.out.println("start test");
		rep.save(pf.getP());
		System.out.println("test");
		Product p = rep.save(pf.getP());
		String fname = pf.getF().getOriginalFilename();
		String f_end = fname.substring(fname.lastIndexOf("."));
		String name = p.getNum() + f_end;
		File f = new File(path + name);
		try {
			pf.getF().transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setImg("/img/" + name);
		editProduct(p);
		System.out.println(p);
	}
	

	public void editProduct(Product p) {
		rep.save(p);
	}

	public void delProduct(int num) {
		rep.deleteById(num);
	}

	public Product getByNum(int num) {
		return rep.getOne(num);
	}

	public List<Product> getAll() {
		return rep.findAll();
	}

	public List<Product> getByName(String name) {
		return rep.findByNameLike("%" + name + "%");
	}

	public List<Product> getBySeller(MemberVO seller) {
		return rep.findBySeller(seller);
	}
}
