package com.example.demo.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Book;
import com.example.demo.models.Book_Discount;
import com.example.demo.models.Discount;
import com.example.demo.responsity.BookResponsitory;
import com.example.demo.responsity.Book_DiscountRes;
import com.example.demo.responsity.DiscountResponsitory;

@Controller
public class DiscountController {
	@RequestMapping("discount/delete")
	public String delete() {
		
		return "/discount/list";
	}
	@RequestMapping("discount/add")
	public String add(Model model) throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		List<Book> books = bImpl.getAll();
		model.addAttribute("books" , books);
		int type1 = bImpl.getCountType("Sách Chính trị – pháp luật");
		int type2 = bImpl.getCountType("Sách Khoa học công nghệ – Kinh tế");
		int type3 = bImpl.getCountType("Sách Văn học nghệ thuật");
		int type4 = bImpl.getCountType("Sách Văn hóa xã hội – Lịch sử");
		int type5 = bImpl.getCountType("Sách Giáo trình");
		int type6 = bImpl.getCountType("Sách Truyện, tiểu thuyết");
		int type7 = bImpl.getCountType("Sách Tâm lý, tâm linh, tôn giáo");
		int type8 = bImpl.getCountType("Sách Thiếu nhi");
		model.addAttribute("type1" , type1);
		model.addAttribute("type2" , type2);
		model.addAttribute("type3" , type3);
		model.addAttribute("type4" , type4);
		model.addAttribute("type5" , type5);
		model.addAttribute("type6" , type6);
		model.addAttribute("type7" , type7);
		model.addAttribute("type8" , type8);
		return "discount/add";
	}
	@RequestMapping("discount/detail/{id}")
	public String detail(Model model,@PathVariable String id) throws SQLException {
		DiscountResponsitory dImpl = new DiscountResponsitory();
		Book_DiscountRes bdImpl = new Book_DiscountRes();
		BookResponsitory bImpl = new BookResponsitory();
		List<Book> books = new ArrayList<>();
		List<Book> cbooks = bImpl.getAll();
		String allBook = "false";
		bdImpl.getByDiscountId(id).forEach(bd->{
			try {
				Book book = bImpl.getByBarcode(bd.getBarcode());
				books.add(book);
			} catch (SQLException e) {}
			
		});
		if(cbooks.size() == books.size()) {
			allBook = "true";
		}
		Discount discount = dImpl.getById(id);
		List<String> types = dImpl.getListType(id);
		model.addAttribute("types", types);
		model.addAttribute("discount", discount);
		model.addAttribute("books", books);
		model.addAttribute("allBook", allBook);
		return "discount/detail";
	}
	@RequestMapping("discount/edit/{id}")
	public String edit(Model model,@PathVariable String id) throws SQLException {
		DiscountResponsitory dImpl = new DiscountResponsitory();
		Book_DiscountRes bdImpl = new Book_DiscountRes();
		BookResponsitory bImpl = new BookResponsitory();
		List<Book> bookDiscounts = new ArrayList<>();
		List<Book> books = bImpl.getAll();
		String allBook = "false";
		bdImpl.getByDiscountId(id).forEach(bd->{
			try {
				Book book = bImpl.getByBarcode(bd.getBarcode());
				bookDiscounts.add(book);
			} catch (SQLException e) {}
			
		});
		String listBarcode = bookDiscounts.get(0).getBarcode();
		if(bookDiscounts.size() > 1) {
			for(int i=1 ; i < bookDiscounts.size(); i++) {
				listBarcode = listBarcode + "," + bookDiscounts.get(i).getBarcode();
			}
		}
		if(bookDiscounts.size() == books.size()) {
			allBook = "true";
		}
		Discount discount = dImpl.getById(id);
		List<String> types = dImpl.getListType(id);
		String listType = types.get(0);
		if(types.size()>1) {
			for(int i = 1; i < types.size(); i++) {
				listType = listType+ ";" + types.get(i);
			}
		}
		int type1 = bImpl.getCountType("Sách Chính trị – pháp luật");
		int type2 = bImpl.getCountType("Sách Khoa học công nghệ – Kinh tế");
		int type3 = bImpl.getCountType("Sách Văn học nghệ thuật");
		int type4 = bImpl.getCountType("Sách Văn hóa xã hội – Lịch sử");
		int type5 = bImpl.getCountType("Sách Giáo trình");
		int type6 = bImpl.getCountType("Sách Truyện, tiểu thuyết");
		int type7 = bImpl.getCountType("Sách Tâm lý, tâm linh, tôn giáo");
		int type8 = bImpl.getCountType("Sách Thiếu nhi");
		model.addAttribute("discount", discount);
		model.addAttribute("books" , books);
		model.addAttribute("bookDiscounts", bookDiscounts);
		model.addAttribute("listBarcode", listBarcode);
		model.addAttribute("listType", listType);
		model.addAttribute("allBook", allBook);
		model.addAttribute("type1" , type1);
		model.addAttribute("type2" , type2);
		model.addAttribute("type3" , type3);
		model.addAttribute("type4" , type4);
		model.addAttribute("type5" , type5);
		model.addAttribute("type6" , type6);
		model.addAttribute("type7" , type7);
		model.addAttribute("type8" , type8);
		model.addAttribute("types", types);
		return "discount/edit";
	}
	@RequestMapping("discount/list")
	public String list(Model model) throws SQLException {
		DiscountResponsitory dImpl = new DiscountResponsitory();
		List<Discount> discounts = dImpl.getAll();
		int size = discounts.size();
		model.addAttribute("discounts", discounts);
		model.addAttribute("size", size);
		return "discount/list";
	}
	@RequestMapping("discount/create")
	public String create(@RequestParam String discountName, @RequestParam int discountValue, @RequestParam String discountUnit
			, @RequestParam String discountMethod, @RequestParam String discountBooks, @RequestParam String discountTypes
			,@RequestParam String discountStart, @RequestParam String discountEnd) throws SQLException {
		DiscountResponsitory dImpl = new DiscountResponsitory();
		Book_DiscountRes bdImpl = new Book_DiscountRes();
		List<Discount> discounts = dImpl.getAll();
		String maKM = "KM" + (discounts.size()+1);
		Discount discount = new Discount(maKM,discountName,discountStart,discountEnd,discountMethod,discountValue,discountUnit);
		dImpl.insert(discount);
		if(!discountBooks.equals("")) {
			if(discountBooks.equals("all")) {
				BookResponsitory bImpl = new BookResponsitory();
				bImpl.getAll().forEach(book->{
					Book_Discount bd = new Book_Discount(maKM,book.getBarcode());
					try {
						bdImpl.insert(bd);
					} catch (SQLException e) {}
				});
			}
			else {
				String arr[] = discountBooks.split(",");
				for(int i = 0; i < arr.length; i++) {
					Book_Discount bd = new Book_Discount(maKM,arr[i]);
					bdImpl.insert(bd);
				}
			}
		}
		else {
			BookResponsitory bImpl = new BookResponsitory();
			String arr[] = discountTypes.split(";");
			for(int i = 0; i < arr.length; i++) {
				bImpl.getByType(arr[i]).forEach(book->{
					Book_Discount bd = new Book_Discount(maKM,book.getBarcode());
					try {
						bdImpl.insert(bd);
					} catch (SQLException e) {}
				});
			}
		}
		return "redirect:/discount/detail/"+discount.getId();
	}
	@RequestMapping("discount/save")
	public String save(@RequestParam String discountId, @RequestParam String discountName, @RequestParam int discountValue, 
			@RequestParam String discountUnit, @RequestParam String discountMethod, @RequestParam String discountBooks, 
			@RequestParam String discountTypes,@RequestParam String discountStart, @RequestParam String discountEnd) throws SQLException {
		DiscountResponsitory dImpl = new DiscountResponsitory();
		Book_DiscountRes bdImpl = new Book_DiscountRes();
		Discount discount = new Discount(discountId,discountName,discountStart,discountEnd,discountMethod,discountValue,discountUnit);
		dImpl.update(discount);
		bdImpl.deleteByDiscountID(discountId);
		if(!discountBooks.equals("")) {
			if(discountBooks.equals("all")) {
				BookResponsitory bImpl = new BookResponsitory();
				bImpl.getAll().forEach(book->{
					Book_Discount bd = new Book_Discount(discountId,book.getBarcode());
					try {
						bdImpl.insert(bd);
					} catch (SQLException e) {}
				});
			}
			else {
				String arr[] = discountBooks.split(",");
				for(int i = 0; i < arr.length; i++) {
					Book_Discount bd = new Book_Discount(discountId,arr[i]);
					bdImpl.insert(bd);
				}
			}
		}
		else {
			BookResponsitory bImpl = new BookResponsitory();
			String arr[] = discountTypes.split(";");
			for(int i = 0; i < arr.length; i++) {
				bImpl.getByType(arr[i]).forEach(book->{
					Book_Discount bd = new Book_Discount(discountId,book.getBarcode());
					try {
						bdImpl.insert(bd);
					} catch (SQLException e) {}
				});
			}
		}
		return "redirect:/discount/detail/"+discount.getId();
	}
}
