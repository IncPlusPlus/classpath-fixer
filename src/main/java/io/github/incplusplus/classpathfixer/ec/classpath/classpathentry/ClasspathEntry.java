package io.github.incplusplus.classpathfixer.ec.classpath.classpathentry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.incplusplus.classpathfixer.ec.classpath.classpathentry.attr.Attribute;

import java.util.List;

@JacksonXmlRootElement(localName = "classpathentry")
public class ClasspathEntry
{
	@JacksonXmlProperty(isAttribute = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String excluding;
	@JacksonXmlProperty(isAttribute = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String kind;
	@JacksonXmlProperty(isAttribute = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String path;
	@JacksonXmlProperty(isAttribute = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String including;
	@JacksonXmlProperty(isAttribute = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String exported;
	@JacksonXmlProperty(isAttribute = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String combineaccessrules;
//	@JacksonXmlProperty(localName = "attributes")
	@JacksonXmlElementWrapper
	@JsonInclude(JsonInclude.Include.NON_NULL)
	List<Attribute> attributes;
	
	public String getExcluding()
	{
		return excluding;
	}
	
	public void setExcluding(String excluding)
	{
		this.excluding = excluding;
	}
	
	public String getKind()
	{
		return kind;
	}
	
	public void setKind(String kind)
	{
		this.kind = kind;
	}
	
	public String getPath()
	{
		return path;
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public String getIncluding()
	{
		return including;
	}
	
	public void setIncluding(String including)
	{
		this.including = including;
	}
	
	public String getExported()
	{
		return exported;
	}
	
	public void setExported(String exported)
	{
		this.exported = exported;
	}
	
	public String getCombineaccessrules()
	{
		return combineaccessrules;
	}
	
	public void setCombineaccessrules(String combineaccessrules)
	{
		this.combineaccessrules = combineaccessrules;
	}
	
	public List<Attribute> getAttributes()
	{
		return attributes;
	}
	
	public void setAttributes(List<Attribute> attributes)
	{
		this.attributes = attributes;
	}
}
