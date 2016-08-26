package com.example.mvpdemo.demo.bizListener;

import com.example.mvpdemo.demo.model.User;

public interface OnLoginListener {
	
	void success(User user);
	void failed(String errorCode);

}
