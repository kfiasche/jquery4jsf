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
package org.jquery4jsf.resource.stream;

import java.util.Map;
import java.util.TreeMap;

public class JavaScriptPacker {
	//None = 0, Numeric = 10, Mid = 36, Normal = 62, HighAscii = 95
	private static String NONE = "None";
	private static Integer NONE_VALUE = new Integer(0);
	
	private static String NUMERIC = "Numeric";
	private static Integer NUMERIC_VALUE = new Integer(10);
	
	private static String MID = "Mid";
	private static Integer MID_VALUE = new Integer(36);
	
	private static String NORMAL = "Normal";
	private static Integer NORMAL_VALUE = new Integer(62);
	
	private static String HIGH_ASCII = "HighAscii";
	private static Integer HIGH_ASCII_VALUE = new Integer(95);
	
	private static String IGNORE = "$1";
	
	private Map packerEncoding;
    private Integer encoding = NORMAL_VALUE;
    private boolean fastDecode = true;
    private boolean specialChars = false;
    private boolean enabled = true;
	
	public JavaScriptPacker() {
		super();
		packerEncoding = new TreeMap();
		initPackerEncoding();
	}

	private void initPackerEncoding() {
		packerEncoding.put(NONE, NONE_VALUE);
		packerEncoding.put(NUMERIC, NUMERIC_VALUE);
		packerEncoding.put(MID, MID_VALUE);
		packerEncoding.put(NORMAL,NORMAL_VALUE);
		packerEncoding.put(HIGH_ASCII,HIGH_ASCII_VALUE);
	}

	public Integer getEncoding() {
		return encoding;
	}

	public void setEncoding(Integer encoding) {
		this.encoding = encoding;
	}

	public boolean isFastDecode() {
		return fastDecode;
	}

	public void setFastDecode(boolean fastDecode) {
		this.fastDecode = fastDecode;
	}

	public boolean isSpecialChars() {
		return specialChars;
	}

	public void setSpecialChars(boolean specialChars) {
		this.specialChars = specialChars;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
