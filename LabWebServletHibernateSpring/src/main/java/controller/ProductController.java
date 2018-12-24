package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.ProductBean;
import model.ProductService;
import model.hibernate.PrimitiveNumberEditor;

@Controller
public class ProductController {
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(java.lang.Integer.class, true));

		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(java.lang.Double.class, true));
	}

	@Autowired
	private ApplicationContext context;
	@Autowired
	private ProductService productService;

	@RequestMapping(path = { "/pages/product.controller" })
	public String method(@RequestParam("id") String temp1, ProductBean bean, BindingResult bindingResult,
			String prodaction, Model model) {
		// 接收資料
		// 轉換資料
		Locale locale = LocaleContextHolder.getLocale();

		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (bindingResult != null && bindingResult.getErrorCount() != 0) {
			if (bindingResult.getFieldError("id") != null) {
				errors.put("xxx1", context.getMessage("product.id", null, locale));
			}
			if (bindingResult.getFieldError("price") != null) {
				errors.put("xxx2", context.getMessage("product.price", null, locale));
			}
			if (bindingResult.getFieldError("make") != null) {
				errors.put("xxx3", context.getMessage("product.make", null, locale));
			}
			if (bindingResult.getFieldError("expire") != null) {
				errors.put("xxx4", context.getMessage("product.expire", null, locale));
			}
		}
		if ("Insert".equals(prodaction) || "Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (temp1 == null || temp1.length() == 0) {
				errors.put("xxx1", context.getMessage("product.fail", new String[] {prodaction}, locale));
			}
		}
		if (errors != null && !errors.isEmpty()) {
			return "product.error";
		}
		
		if ("Select".equals(prodaction)) {
			List<ProductBean> result = productService.select(bean);
			model.addAttribute("select", result);
			return "product.display";

		} else if ("Insert".equals(prodaction)) {
			ProductBean result = productService.insert(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "product.error";

		} else if ("Update".equals(prodaction)) {
			ProductBean result = productService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "product.error";

		} else if ("Delete".equals(prodaction)) {
			boolean result = productService.delete(bean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "product.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "product.error";
		}

	}
}
