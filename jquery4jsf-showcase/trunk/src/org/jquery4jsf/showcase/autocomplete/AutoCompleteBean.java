package org.jquery4jsf.showcase.autocomplete;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteBean {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public List completeAlgo(String query){
		System.out.println(query);
        List qualcosa = new ArrayList();
        for(int i = 0; i < 11; i++)
        {
            String a = query + i;
            qualcosa.add(a);
        }
        return qualcosa;
	}
	
}
