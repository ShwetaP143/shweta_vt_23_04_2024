package com.assignment.enums;

public enum PermissionsEnum {
	AllowRead("AllowRead"),
    AllowWrite("AllowWrite"),
    AllowUpdate("AllowUpdate");
	
	  private final String permission;

	    PermissionsEnum(String permission) {
	        this.permission = permission;
	    }

	    @Override
	    public String toString() {
	        return permission;
	    }
}
