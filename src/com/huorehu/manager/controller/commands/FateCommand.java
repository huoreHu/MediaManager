package com.huorehu.manager.controller.commands;

public enum FateCommand {
	
	ADD("add"),
	STATUS("changestatus"),
	GETLIST("getallmedia"),
	DELETE("delete");
	
	private String name;
	
	FateCommand(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
