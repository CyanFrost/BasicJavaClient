package com.bluefrost.clientsoftware.client1.gui.resources;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class HintTextField extends JTextField implements FocusListener{

	private static final long serialVersionUID = 1L;

	private String hint;
	private boolean focussed;

	private static final class font{
		public static final Font normal = new Font("Calibri", 0, 12);
		public static final Font hint = normal.deriveFont(2);
	}

	private static final class color{
		public static final Color normal = Color.black;
		public static final Color hint = Color.gray;
	}

	public HintTextField(String hint){
		super(hint);
		setFont(font.hint);
		setForeground(color.hint);
		addFocusListener(this);
		this.hint = hint;
	}

	public String getText(){
		if(super.getText().equals(this.hint)){return "";}
		return super.getText();
	}

	public void setText(String text){
		super.setText(text);
		if(!this.focussed){focusLost(null);}
	}

	public void setHint(String hint){
		this.hint = hint;
		if(!this.focussed){super.setText(hint);}
	}

	public void focusGained(FocusEvent arg0){
		this.focussed = true;
		if(super.getText().equals(this.hint)){
			super.setText("");
			setFont(font.normal);
			setForeground(color.normal);
		}
	}

	public void focusLost(FocusEvent arg0){
		this.focussed = false;
		if(super.getText().isEmpty()){
			super.setText(this.hint);
			setFont(font.hint);
			setForeground(color.hint);
		}
	}
}
