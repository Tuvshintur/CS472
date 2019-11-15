import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.*;

public class MyTag extends SimpleTagSupport {
    String color;
    String size;
    String value;

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write(String.format("<span style='color:%s; font-size:%s;'>%s</span>", color, size, value));
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
