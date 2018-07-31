package com.zuper.tsa.springmvc;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes(value = { "sobj1", "sobj2" }, types = { String.class })
@RequestMapping("/test")
@Controller
public class TestCtrller {
	private final String SUCCESS = "success";

	@RequestMapping("/list")
	public String home() {
		return "test";
	}

	@RequestMapping("/hello")
	public String test0() {
		return "success";
	}

	// To REST
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id) {
		System.out.println("PathVariable: " + id);

		return SUCCESS;
	}

	@RequestMapping("/testCookieValue")
	public String testCookieValue(
			@CookieValue(value = "JSESSIONID", required = false) String sessionId) {
		System.out.println("JSESSIONID: " + sessionId);

		return SUCCESS;
	}

	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest req, Writer out)
			throws IOException {
		String id = req.getParameter("id");
		out.write("id: " + id);
	}

	@RequestMapping("/testPojo")
	public String testPojo(Person person) {
		System.out.println(person);
		person.setId(23);// 自动放到请求域中了
		return SUCCESS;
	}

	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView mv = new ModelAndView(SUCCESS);
		mv.addObject("date", new Date());
		return mv;
	}

	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("date", new Date());
		return SUCCESS;
	}

	@RequestMapping("/testSessionAttr")
	public String testSessionAttr(Map<String, Object> map) {
		map.put("sobj1", 1);
		map.put("sobj2", 2);
		map.put("sobj3", "3");
		return SUCCESS;
	}

	@ModelAttribute
	public void getPerson(
			@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			Person person = new Person(1, "hwc", 23);// 模拟数据库查询结果
			System.out.println("DB data: " + person);
			map.put("person", person);
		}
	}

	@RequestMapping("/testModelAttr")
	public String testModelAttr(Person person) {
		System.out.println("Merge: " + person);

		return SUCCESS;
	}
	
	@RequestMapping("/testRedirect")
	public String testRedirect() {
		System.out.println("redirect to index.jsp");
		return "redirect:/index.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/testJson")
	public Person testJson() {
		Person person = new Person(1, "hexiaowu", 25);
		return person;
	}
}
