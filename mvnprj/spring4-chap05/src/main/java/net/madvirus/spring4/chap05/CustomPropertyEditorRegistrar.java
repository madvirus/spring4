package net.madvirus.spring4.chap05;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

	private String datePattern;

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		CustomDateEditor propertyEditor = new CustomDateEditor(new SimpleDateFormat(datePattern), true);
		registry.registerCustomEditor(Date.class, propertyEditor);
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

}
