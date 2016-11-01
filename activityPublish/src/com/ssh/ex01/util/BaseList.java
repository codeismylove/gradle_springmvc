package com.ssh.ex01.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.json.JSONObject;

public class BaseList {
	public static JSONObject typeList() {
		List<String> list=new ArrayList<>();
		JSONObject dataJson = new JSONObject();
		list.add("学生");
		list.add("班级");
		list.add("学院");
		list.add("社团");
		list.add("其他组织");
		dataJson.put("list", list);
		return dataJson;
	}

	public static String typeString(String typeName) {
		String type = "0";
		switch (typeName) {
		case "学生":
			type = "1";
			break;
		case "班级":
			type = "2";
			break;
		case "学院":
			type = "3";
			break;
		case "社团":
			type = "4";
			break;
		default:
			type = "5";
			break;
		}
		return type;
	}
	
	public static String typeNumber(String number) {
		String type = "其它";
		switch (number) {
		case "1":
			type = "学生";
			break;
		case "2":
			type = "班级";
			break;
		case "3":
			type = "学院";
			break;
		case "4":
			type = "社团";
			break;
		default:
			type = "其它";
			break;
		}
		return type;
	}
	
	public static JSONObject subjectTypeList() {
		List<String> list=new ArrayList<>();
		JSONObject dataJson = new JSONObject();
		list.add("艺术类");
		list.add("科学类");
		list.add("教育类");
		list.add("户外运动类");
		list.add("其他类");
		dataJson.put("list", list);
		return dataJson;
	}
	
	public static String subjectTypeString(String typeName) {
		String type = "0";
		switch (typeName) {
		case "艺术类":
			type = "1";
			break;
		case "科学类":
			type = "2";
			break;
		case "教育类":
			type = "3";
			break;
		case "户外运动类":
			type = "4";
			break;
		default:
			type = "5";
			break;
		}
		return type;
	}
	
	public static String subjectTypeNumber(String number) {
		String type = "其它";
		switch (number) {
		case "1":
			type = "艺术类";
			break;
		case "2":
			type = "科学类";
			break;
		case "3":
			type = "教育类";
			break;
		case "4":
			type = "户外运动类";
			break;
		default:
			type = "其它";
			break;
		}
		return type;
	}
}
