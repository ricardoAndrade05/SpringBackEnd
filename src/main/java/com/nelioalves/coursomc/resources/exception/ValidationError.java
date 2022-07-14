package com.nelioalves.coursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status,String msg,Long timesStamp) {
		super(status,msg,timesStamp);
	}

	public List<FieldMessage> getList() {
		return errors;
	}

	public void setList(List<FieldMessage> list) {
		this.errors = list;
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName,messagem));
	}
	
}
