package controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.CustomerBean;
import model.CustomerService;

@Controller
public class LoginController {
	@Autowired
	private ApplicationContext context;
	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = { "/secure/login.controller" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String method(String username, String password, Model model, HttpSession session) {
		// 接收資料
		// 驗證資料
		Locale locale = LocaleContextHolder.getLocale();

		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (username == null || username.trim().length() == 0) {
			errors.put("username", context.getMessage("login.username.required", null, locale));
		}
		if (password == null || password.trim().length() == 0) {
			errors.put("password", context.getMessage("login.password.required", null, locale));
		}
		if (errors != null && !errors.isEmpty()) {
			return "login.error";
		}
		// 呼叫model
		CustomerBean bean = customerService.login(username, password);
		// 根據model執行結果呼叫view元件
		if (bean == null) {
			errors.put("password", context.getMessage("login.fail", null, locale));
			return "login.error";
		} else {
//			HttpSession session = request.getSession();
			session.setAttribute("user", bean);

			// response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			// response.setHeader("Location", "/LabWebServletJdbc/index.jsp");

//			String path = request.getContextPath();
//			response.sendRedirect(path + "/index.jsp");
			return "login.success";
		}
		

	}
}
