package com.example.digitalsignage;

import java.io.Serializable;

import android.app.Application;

public class Flag extends Application
{
	boolean flag = true;
	
	public Flag()
	{
		this.flag = true;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}
