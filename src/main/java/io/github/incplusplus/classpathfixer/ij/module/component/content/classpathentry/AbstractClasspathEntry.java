package io.github.incplusplus.classpathfixer.ij.module.component.content.classpathentry;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.github.incplusplus.classpathfixer.ij.module.component.content.ContentElement;

public abstract class AbstractClasspathEntry implements ContentElement
{
	@JacksonXmlProperty(isAttribute = true)
	String url;
	
	public String getUrl()
	{
		return url;
	}
	
	public void setUrl(String url)
	{
		this.url = url;
	}
}
