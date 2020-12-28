package com.xworkz.login.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.login.dto.ProductDTO;

@Component
@RequestMapping("/")
public class ProductComponent {

	public ProductComponent() {
		// TODO Auto-generated constructor stub
		System.out.println("created" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/product.do", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute ProductDTO productDTO, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Invoked add product");
		System.out.println(productDTO);

		String name = req.getParameter("name");
		String quantity = req.getParameter("quantity");
		String price = req.getParameter("price");
		String brand = req.getParameter("brand");

		req.setAttribute("pn", name);
		req.setAttribute("pq", quantity);
		req.setAttribute("pp", price);
		req.setAttribute("pb", brand);

		RequestDispatcher dispatcher = req.getRequestDispatcher("cart");

		dispatcher.forward(req, resp);

		return "product";

	}

}
