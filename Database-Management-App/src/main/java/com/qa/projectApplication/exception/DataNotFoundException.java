package com.qa.projectApplication.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String dataName;
    private String fieldName;
    private Object fieldValue;

    public DataNotFoundException(String dataName, String fieldName, Object fieldValue){
        super(String.format("%s not found with '%s'", dataName, fieldName, fieldValue));
        this.dataName = dataName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getDataName(){
        return dataName;
    }

    public String getFieldName(){
        return fieldName;
    }

    public Object getFieldValue(){
        return fieldValue;
    }
}
