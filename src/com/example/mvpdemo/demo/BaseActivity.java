package com.example.mvpdemo.demo;

import com.example.mvpdemo.demo.presenter.BasePresenter;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends Activity {

	protected T presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		presenter=getPresent();
		presenter.attach((V)this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		presenter.dettach();
	}
	
	public abstract T getPresent();
	
	

}
