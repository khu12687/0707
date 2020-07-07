package controller.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.company.DeptDAO;
import model.company.EmpDAO;
import model.company.MemberService;

@Controller
public class MemberController {
	// 서비스 모델 객체에게 일 시키자!
	private MemberService memberService;
	// 생성자 주입, setter 주입!!

	@RequestMapping(value = "/member/regist", method = RequestMethod.GET)
	public String regist() {
		// Stirng으로 반환하면 View 객체를 이용하는 것과 같다
		memberService.regist();
		return "member/result";
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
