package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.bean.Department;
import ssm.bean.Msg;
import ssm.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentSevice;

	@RequestMapping("/depts")
	@ResponseBody
	public Msg getdepts() {
		List<Department> list = departmentSevice.getDepts();

		return Msg.success().add("depts", list);

	}
}
