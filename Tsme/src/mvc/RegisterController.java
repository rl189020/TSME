package mvc;

import logic.register.RegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tsme.table.supervisor.bean.SUPERVISOR;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	@Qualifier("registerService")
	private RegisterService registerService;
	
	@RequestMapping("/abc")
	public ModelAndView test(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test");
		return mav;
	}
	
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(SUPERVISOR su){
		ModelAndView mav = new ModelAndView();
		su.setCreate_time(System.currentTimeMillis());
		su.setDepartment("应用开发");
		su.setEmpno("01");
		su.setGender(false);
		su.setIntroduction("测试");
		su.setName("张三");
		su.setUsername("xiaoming");
		su.setPassword("123123");
		su.setId("dfdf");
		su.setDepartment_id("aa");
		int result = registerService.save(su);
		mav.addObject("result", result);
		mav.setViewName("register");
		return mav;
	}
	@RequestMapping("/targetRegister")
	public ModelAndView register(){
		ModelAndView mav = new ModelAndView();
		SUPERVISOR su = new SUPERVISOR();
		mav.setViewName("register/targetregister");
		return mav;
	}
}
