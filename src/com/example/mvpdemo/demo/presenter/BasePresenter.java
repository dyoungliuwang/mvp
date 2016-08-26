package com.example.mvpdemo.demo.presenter;

import android.content.Context;
import android.os.Handler;

public abstract class BasePresenter<V> {
	/**
	 * 
	 * Created by lw on 2016/8/26.
	 */

	protected V mView;
	protected Context context;
	protected Handler mHandler=new Handler();

	public BasePresenter(Context context) {
		this.context = context;
	}

	public void attach(V v) {
		this.mView = v;
	}

	public void dettach() {
		this.mView = null;
	}

}
