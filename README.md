# ssm
总结： 

1.前端界面采用bootstrap搭建 

2.前端发送请求执行顺序 

	1)前端发送请求到tomcat 
  
	2)请求被SpringMVC前端控制器获取，
  
	若能处理，则执行controller，controller调用service层处理，若进行数据库的交互，
  
  则service调用dao层组件，dao层调用mybatis，  mapper组件调用crud；
  
		mapper文件接口由mbg生成，若有复杂查询，则在mapper文件基础之上，定义一下新的方法；
    
		mybatis mapper可以使用是因为项目启动时mapper的实现被扫描进ioc容器中；
    
		所以组件间使用@Autowired实现自动装配;
    
	否则交给tomcat服务器处理
  
	3)最终会将请求的响应信息返回给用户
  
3.页面大量使用ajax进行crud

4.页面将ajax处理的结果返回一个json串，使用js解析json并将处理结果显示在页面上

5.整个项目用maven进行依赖管理和构建(打包成war包，部署到服务器)

6.新增和修改的时候引入数据的校验，包括前端和后端校验;

7.删除时包括单个删除和多选删除也进行了数据的校验

8.使用mybatis反向生成工具generator生成mapper文件、dao接口，bean类

9.SpringMVC处理页面中的ajax请求只需设置一个@ResponseBody注解
