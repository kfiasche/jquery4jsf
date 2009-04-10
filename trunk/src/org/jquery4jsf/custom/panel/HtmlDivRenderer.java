package org.jquery4jsf.custom.panel;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

public class HtmlDivRenderer extends Renderer {


    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", component);
        writer.writeAttribute("id", component.getClientId(context), "clientId");
        //writer.writeAttribute("class", component.getAttributes().get("styleclass"),"styleclass");
        writer.flush();
    }

    public void encodeEnd(FacesContext context,UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("div");
        writer.flush();
    }

    public void decode(FacesContext context, UIComponent component) {
        return;
    }


}

