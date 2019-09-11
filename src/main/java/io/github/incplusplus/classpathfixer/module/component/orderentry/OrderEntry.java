package io.github.incplusplus.classpathfixer.module.component.orderentry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.incplusplus.classpathfixer.module.component.ComponentElement;
import io.github.incplusplus.classpathfixer.module.component.orderentry.library.Library;

@JacksonXmlRootElement(localName = "orderEntry")
public class OrderEntry implements ComponentElement
{
	@JacksonXmlProperty(isAttribute = true)
	String type;
	@JacksonXmlProperty(isAttribute = true, localName = "module-name")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String moduleName;
	@JacksonXmlProperty(isAttribute = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String exported;
	@JacksonXmlProperty(isAttribute = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String forTests;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	Library library;
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getModuleName()
	{
		return moduleName;
	}
	
	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}
	
	public String getExported()
	{
		return exported;
	}
	
	public void setExported(String exported)
	{
		this.exported = exported;
	}
	
	public String getForTests()
	{
		return forTests;
	}
	
	public void setForTests(String forTests)
	{
		this.forTests = forTests;
	}
	
	public Library getLibrary()
	{
		return library;
	}
	
	public void setLibrary(Library library)
	{
		this.library = library;
	}
}
