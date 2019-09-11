package elements.module.component.content;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "excludePattern")
public class ExcludePattern implements ContentElement
{
	@JacksonXmlProperty(isAttribute = true)
	String pattern;
	
	public String getPattern()
	{
		return pattern;
	}
	
	public void setPattern(String pattern)
	{
		this.pattern = pattern;
	}
}
