package com.example.mvpdemo.demo.biz;

import com.example.mvpdemo.demo.bizListener.OnLoginListener;
import com.example.mvpdemo.demo.model.User;

public class UserBiz implements IUserBiz {

	@Override
	public void login(final String userName, final String password, final OnLoginListener listener) {
		new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(2*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(userName.equals("lw")&& password.equals("123")){
					listener.success(new User(userName, password));
				}else{
					listener.failed("登录失败");
				}
				
			}
			
		}.start();
	}

}
