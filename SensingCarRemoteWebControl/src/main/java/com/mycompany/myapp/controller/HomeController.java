package com.mycompany.myapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("cameraUrl", "http://192.168.3.42:50001?action=stream");
		return "controlpanel";
	}

	@RequestMapping("/camera")
	public void home(String command, String leftright, String updown, HttpServletResponse response) throws IOException {
		logger.info(command);
		logger.info(leftright);
		logger.info(updown);

		JSONObject jsonObject = new JSONObject();	
		jsonObject.put("result", "success");
		jsonObject.put("leftright", leftright);
		jsonObject.put("updown", updown);
		String json = jsonObject.toString();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}
}
