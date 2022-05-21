package com.laptrinhjavaweb.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.ABC.UserABC;

@RestController
public class UserApi {
	@GetMapping("/(id)")
	public List<UserABC> getStaff(@PathVariable("id") Long id){
		List<UserABC>  result = new ArrayList<>();
		return result;
	}

}
