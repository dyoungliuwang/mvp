package com.example.mvpdemo.view;

import com.example.mvpdemo.demo.model.User;

public interface ILoginView {
	
	User getUser();
	
	void success();
	
	void failed(String errorCode);
	
	void showLoading();
	
	void hideLoading();
}
