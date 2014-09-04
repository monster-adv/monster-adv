package com.example.digitalsignage;

import java.util.ArrayList;
import java.io.*;

import android.util.Log;

public class AdvSyncList 
{
	private static ArrayList<String> mArrayList;
	private BufferedWriter writer;
	private BufferedReader reader;
	private File file;
	
	public AdvSyncList()
	{
		file = new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/synclist.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void add(String item){
		try {
			writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(item);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void delete(String item){
		int i;
		String buf;
		
		mArrayList = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(file));
			
			try {
				writer = new BufferedWriter(new FileWriter(file));
				while((buf = reader.readLine()) != null){
					if(buf.compareTo(item) == 0)
						continue;
					else
						mArrayList.add(buf);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			for(i=0;i<mArrayList.size();i++){
				writer.write(mArrayList.get(i));
				writer.write("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean search(String item){
		String buf;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			try {
				while((buf = reader.readLine()) != null){
					if(buf.compareTo(item) == 0){
						reader.close();
						return true;
					}
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
