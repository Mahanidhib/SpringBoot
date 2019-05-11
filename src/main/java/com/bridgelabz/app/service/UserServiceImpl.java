package com.bridgelabz.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.app.model.User;
import com.bridgelabz.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRep;

	@Override
	public String login(User user) {

		List<User> usrlst = userRep.findByEmailAndPassword(user.getEmail(), user.getPassword());
		System.out.println("SIZE : " + usrlst.size());

		if (usrlst.size() > 0 && usrlst != null) {
			System.out.println("Sucessful login");

			return "Welcome " + usrlst.get(0).getName();
		} else {
			System.out.println("wrong emailid or password");
			return "wrong emailid or password";
		}
	}

	@Override
	public User userReg(User user) {
		return userRep.save(user);
	}

}