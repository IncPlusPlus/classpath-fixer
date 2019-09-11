package io.github.incplusplus.classpathfixer.module.component.orderentry.library.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.github.incplusplus.classpathfixer.module.component.orderentry.library.content.root.Root;

import java.util.List;

public abstract class AbstractLibraryElement
{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JacksonXmlProperty(localName = "root")
	List<Root> roots;
	
	public List<Root> getRoots()
	{
		return roots;
	}
	
	public void setRoots(List<Root> roots)
	{
		this.roots = roots;
	}
}
