package com.cardvalue.wechat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MerchantHelpController {
	
	@RequestMapping(value = "/merchant/page/{pageName}", method = RequestMethod.GET)
	public String showPage(@PathVariable("pageName") String pageName) {
		return "/merchant/page/" + pageName;
	}

}


