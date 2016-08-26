package com.example.mvpdemo.demo.presenter;

import android.content.Context;

import com.example.mvpdemo.demo.biz.UserBiz;
import com.example.mvpdemo.demo.bizListener.OnLoginListener;
import com.example.mvpdemo.demo.model.User;
import com.example.mvpdemo.view.ILoginView;

public class UserPresenter extends BasePresenter<ILoginView> {

	private UserBiz userBiz;
	
	public UserPresenter(Context context) {
		super(context);
		userBiz=new UserBiz();
	}
	
	public void login(){
		User user=mView.getUser();
		mView.showLoading();
		userBiz.login(user.getUserName(), user.getPassword(), new OnLoginListener() {
			@Override
			public void success(User user) {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						mView.hideLoading();
						mView.success();
					}
				});

			}
			
			@Override
			public void failed(final String errorCode) {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						mView.hideLoading();
						mView.failed(errorCode);
					}
				});

			}
		});
	}

}
