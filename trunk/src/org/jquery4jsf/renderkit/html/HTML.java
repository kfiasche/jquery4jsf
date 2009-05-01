/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.jquery4jsf.renderkit.html;

public class HTML {

	public static final String TAG_A = 			"a";
	public static final String TAG_ABBR = 		"abbr";
	public static final String TAG_ACRONYM = 	"acronym";
	public static final String TAG_ADDRESS = 	"address";
	public static final String TAG_CDATA_OPEN = 		"<![CDATA[";
	public static final String TAG_CDATA_CLOSE = 		"//]]>";
	public static final String TAG_CODE = 		"code";
	public static final String TAG_DIV = 		"div";
	public static final String TAG_H3 = 		"h3";
	public static final String TAG_LINK = 		"link";
	public static final String TAG_LI = 		"li";
	public static final String TAG_P = 			"p";
	public static final String TAG_PRE = 		"pre";
	public static final String TAG_SCRIPT = 	"script";
	public static final String TAG_SPAN =	 	"span";
	public static final String TAG_UL = 		"ul";
	public static final String TAG_INPUT = 		"input";
	
	public static final String STYLE_CLASS	= "styleClass";	
	public static final String STYLE	= "style";     
	public static final String TITLE	= "title";     
	public static final String DIR		= "dir";    
	public static final String ID		= "id";    
	public static final String LANG		= "lang";      
	public static final String XML_LANG	= "xml:lang";   
	public static final String ACCESS_KEY	= "accesskey"; 
	public static final String TAB_INDEX	= "tabindex";
	
	public static final String[] HTML_STD_ATTR = new String[] {
																STYLE_CLASS,
																STYLE,     
																TITLE,     
																DIR,       
																LANG,      
																XML_LANG,   
																ACCESS_KEY, 
																TAB_INDEX
	}; 
	
	
	public static final String ONCLICK		=		"onclic";
	public static final String ONDBLCLICK	=		"ondblclick";
	public static final String ONKEYDOWN	=		"onkeydown";
	public static final String ONKEYPRESS	=		"onkeypress";
	public static final String ONKEYUP		=		"onkeyup";
	public static final String ONMOUSEDOWN	=		"onmousedown";
	public static final String ONMOUSEMOVE	=		"onmousemove";
	public static final String ONMOUSEOUT	=		"onmouseout";
	public static final String ONMOUSEOVER	=		"onmouseover";
	public static final String ONMOUSEUP	=		"onmouseup";
	
	public static final String[] HTML_JS_STD_ATTR = new String[]{ONCLICK,  
		ONDBLCLICK,
		ONKEYDOWN, 
		ONKEYPRESS,
		ONKEYUP,   
		ONMOUSEDOWN,
		ONMOUSEMOVE,
		ONMOUSEOUT,
		ONMOUSEOVER,
		ONMOUSEUP};
	
	public static final String ONBLUR = "onblur";
	public static final String ONCHANGE = "onchange";
	public static final String ONFOCUS = "onfocus";
	
	public static final String []HTML_JS_ELEMENT_ATTR = new String[]{
		ONBLUR,
		ONCHANGE,
		ONFOCUS
	};
	
	public static final String CHARSET		=	"charset";
	public static final String COORDS		=	"coords";
	public static final String HREF			=	"href";
	public static final String HREF_LANG		=	"hreflang";
	public static final String NAME			=	"name";
	public static final String REL			=	"rel";
	public static final String REV			=	"rev";
	public static final String SHAPE		=	"shape";
	public static final String TARGET		=	"target";

	public static final String[] HTML_A_TAG_ATTR = new String[]{
		CHARSET,	
		COORDS,
		HREF,
		HREF_LANG,
		NAME,
		REL,
		REV,
		SHAPE,
		TARGET	        
	};

	public static final String TYPE = "type";
	public static final String LANGUAGE = "language";
	public static final String SRC = "src";
	public static final String DEFER = "defer";
	
	public static final String[] HTML_SCRIPT_TAG_ATTR = new String[]{
		TYPE,	
		LANGUAGE,
		DEFER,
		CHARSET,
		SRC	        
	};
	
	public static final String MEDIA = "media";

	public static final String[] HTML_LINK_TAG_ATTR = new String[]{
		TYPE,	
		REL,
		HREF,
		MEDIA
	};
	
	public static final String ALT = "alt";
	public static final String DISABLED = "disabled";	
	public static final String VALUE = "value";
	
	public static final String[] HTML_INPUT_COMMAND_TAG_ATTR = new String[]{
		TYPE,	
		ALT,
		DISABLED,
		VALUE,
		SRC
	};
	
	
	
	
	

	
}
