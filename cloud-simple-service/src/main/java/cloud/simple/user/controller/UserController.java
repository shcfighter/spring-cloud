package cloud.simple.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cloud.simple.user.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import cloud.simple.user.dao.UserMapper;
import cloud.simple.user.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Resource
	private UserMapper userMapper;
	@Resource
	private IUserService userService;
	
	@GetMapping(value="/getUser/{id}")
	public User getUser(HttpServletRequest request, HttpServletResponse response,
			@PathVariable Long id){
		return userMapper.selectByPrimaryKey(id);
	}

	@GetMapping(value="/getUserList")
	public List<User> getUserList(HttpServletRequest request, HttpServletResponse response){
		List<User> list = userMapper.selectByExample(null);
		return list.stream().sorted(Comparator.comparing(User::getUserNo)).collect(Collectors.toList());
	}

	@PostMapping(value = "/saveUser")
	public boolean saveUser(HttpServletRequest request, HttpServletResponse response,
							@RequestBody User user, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			logger.error("参数错误：");
			return false;
		}
		userMapper.insertSelective(user);
		return true;
	}

	@GetMapping(value = "/insertUser")
	public boolean insertUser(HttpServletRequest request, HttpServletResponse response){
		User user = new User();
		user.setEmail("aaaaaaa@163.com");
		user.setIsDeleted("Y");
		user.setNickName(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)));
		user.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)));
		user.setPhone(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)));
		user.setRealName(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)));
		user.setUserName(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)));
		user.setUserNo("123456");
		user.setUserType(Byte.decode("1"));
		userService.insertUser(user);
		return true;
	}

	@GetMapping(value = "batchInsertUser")
	public boolean batchInsertUser(HttpServletRequest request, HttpServletResponse response){
		User user = null;
		for (int i = 0; i < 300000000; i++){
			user = new User();
			user.setEmail(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)) + "@163.com");
			user.setIsDeleted("Y");
			user.setNickName(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)));
			user.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)));
			user.setPhone(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)));
			user.setRealName(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)));
			user.setUserName(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(10)));
			user.setUserNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, new Random().nextInt(2)));
			user.setUserType(Byte.decode("1"));
			userMapper.insertSelective(user);
		}
		return true;
	}

	private static String[] str = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "v", "w", "x", "y", "z",
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
			"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

}
