package elements.module.component.orderentry.library;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "properties")
public class LibraryProperties
{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JacksonXmlProperty(localName = "maven-id",isAttribute = true)
	String mavenId;
}
