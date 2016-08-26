package com.example.mvpdemo.demo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvpdemo.demo.model.User;
import com.example.mvpdemo.demo.presenter.UserPresenter;
import com.example.mvpdemo.view.ILoginView;

public class MainActivity extends BaseActivity<ILoginView, UserPresenter> implements ILoginView{

	private EditText userNameEdt;
	private EditText passwordEdt;
	
	private Button loginBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		userNameEdt=(EditText) super.findViewById(R.id.username);
		passwordEdt=(EditText) super.findViewById(R.id.password);
		loginBtn=(Button) super.findViewById(R.id.login);
		
		loginBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				presenter.login();
			}
		});
		
	}

	@Override
	public UserPresenter getPresent() {
		return new UserPresenter(this);
	}


	@Override
	public void success() {
		Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void failed(String errorCode) {
		Toast.makeText(this, errorCode, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showLoading() {
		Toast.makeText(this, "登录中...", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void hideLoading() {
		Toast.makeText(this, "登录完成", Toast.LENGTH_SHORT).show();
	}

	@Override
	public User getUser() {
		return new User(userNameEdt.getText().toString().trim(), passwordEdt.getText().toString().trim());
	}

}
