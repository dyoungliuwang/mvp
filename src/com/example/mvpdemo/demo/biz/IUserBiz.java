package com.example.mvpdemo.demo.biz;

import com.example.mvpdemo.demo.bizListener.OnLoginListener;

public interface IUserBiz {

	void login(String userName, String password,OnLoginListener listener);

}
