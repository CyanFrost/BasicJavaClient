package com.bluefrost.clientsoftware.client1.gui.resources;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/*
 * Created for the purpose of MinecraftConsole 
 */

public class ViewPanel extends JTextPane {

	private static final long serialVersionUID = 1L;

	public static final Color Black = new Color(0, 0, 0);
	public static final Color DarkBlue = new Color(0, 0, 170);
	public static final Color DarkGreen = new Color(0, 170, 0);
	public static final Color DarkAqua = new Color(0, 170, 170);
	public static final Color DarkRed = new Color(170, 0, 0);
	public static final Color DarkPurple = new Color(170, 0, 170);
	public static final Color Orange = new Color(255, 170, 0);
	public static final Color Gray = new Color(170, 170, 170);
	public static final Color DarkGray = new Color(85, 85, 85);
	public static final Color Blue = new Color(85, 85, 255);
	public static final Color LightGreen = new Color(85, 255, 85);
	public static final Color LightBlue = new Color(85, 255, 255);
	public static final Color LightRed = new Color(255, 85, 85);
	public static final Color Pink = new Color(255, 85, 255);
	public static final Color LightYellow = new Color(255, 255, 85);
	public static final Color White = new Color(255, 255, 255);

	private StyleContext styleContext;
	private StyledDocument content;
	private Style style;

	public ViewPanel(){
		setBackground(Color.BLACK);
		setEditable(false);

		this.styleContext = new StyleContext();
		this.content = new DefaultStyledDocument(this.styleContext);
		setDocument(this.content);


		this.style = this.styleContext.getStyle("default");
		StyleConstants.setAlignment(this.style, 0);
		StyleConstants.setFontFamily(this.style, "Consolas");
		StyleConstants.setFontSize(this.style, 13);
	}

	public ViewPanel setItalic(boolean b){StyleConstants.setItalic(this.style, b);return this;}

	public ViewPanel setBold(boolean b){StyleConstants.setBold(this.style, b);return this;}

	public ViewPanel setStrikeThrough(boolean b){StyleConstants.setStrikeThrough(this.style, b);return this;}
	
	public ViewPanel setUnderline(boolean b){StyleConstants.setUnderline(this.style, b);return this;}
	
	public void reset(){
		this.setItalic(false);
		this.setBold(false);
		this.setStrikeThrough(false);
		this.setUnderline(false);
		StyleConstants.setForeground(this.style, Color.white);
	}
	
	public ViewPanel setColor(Color c){
		if(c == null){return this;}
		reset();
		StyleConstants.setForeground(this.style, c);
		return this;
	}

	public ViewPanel append(String s){
		try{
			this.content.insertString(this.content.getLength(), s, this.style);
		}catch (BadLocationException e){e.printStackTrace();}
		return this;
	}

	public ViewPanel prepend(String s){
		try{
			this.content.insertString(0, s, this.style);
		}catch (BadLocationException e){e.printStackTrace();}
		return this;
	}

	public static Color getColor(char c){
		switch (c){
		case '0': return Black;
		case 'r': return Black;
		case '1': return DarkBlue;
		case '2': return DarkGreen;
		case '3': return DarkAqua;
		case '4': return DarkRed;
		case '5': return DarkPurple;
		case '6': return Orange;
		case '7': return Gray;
		case '8': return DarkGray;
		case '9': return Blue;
		case 'a': return LightGreen;
		case 'b': return LightBlue;
		case 'c': return LightRed;
		case 'd': return Pink;
		case 'e': return LightYellow;
		case 'f': return Gray;
		}
		return null;
	}

}
