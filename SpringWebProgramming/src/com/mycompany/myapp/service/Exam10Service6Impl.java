package com.mycompany.myapp.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.mycompany.myapp.dao.Exam10Dao3;

@Component
public class Exam10Service6Impl implements Exam10Service6 {
	//@Autowired -Type을 기준으로 객체를 주입하기 때문에 보다 정확하게 주입할 객체 이름을 지정해줄 필요가 있다.
	@Resource(name="exam10Dao3ImplA")
	private Exam10Dao3 exam10Dao;
	
	@Override
	public void join() {
		System.out.println("Exam10Service5Impl --- join() 실행");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("Exam10Service5Impl --- login() 실행");
		exam10Dao.select();
	}

}
