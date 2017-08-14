package ssm.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.bean.Department;
import ssm.bean.Employee;
import ssm.dao.DepartmentMapper;
import ssm.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper deptmapper;
	@Autowired
	EmployeeMapper employeemapper;
	@Autowired
	SqlSession sqlsession;
	@Test
	public void test(){
//		System.out.println(deptmapper);
		
//		deptmapper.insertSelective(new Department(null,"开发部"));
//		deptmapper.insertSelective(new Department(null,"测试部"));
		
//		employeemapper.insertSelective(new Employee(null,"jerry","M","jery@163.com",3));
		
		EmployeeMapper mapper = sqlsession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 100; i++) {
			String uuid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uuid,"M",uuid+"@163.com",4));
		}
		for (int i = 0; i < 100; i++) {
			String uuid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uuid,"M",uuid+"@163.com",3));
		}
		for (int i = 0; i < 100; i++) {
			String uuid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uuid,"F",uuid+"@163.com",4));
		}
		for (int i = 0; i < 100; i++) {
			String uuid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uuid,"F",uuid+"@163.com",3));
		}
	}
}
