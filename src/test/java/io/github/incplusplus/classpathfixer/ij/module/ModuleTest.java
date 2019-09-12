package io.github.incplusplus.classpathfixer.ij.module;

import io.github.incplusplus.classpathfixer.ij.IntelliJUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.xmlunit.assertj.XmlAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import static io.github.incplusplus.classpathfixer.GeneralXmlUtils.xmlMapper;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModuleTest
{
	@TempDir
	static Path tempDir;
	
	@BeforeAll
	static void setUp() {
		assertTrue(Files.isDirectory(tempDir));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/clearDefaultComponentDependenciesSources.csv",numLinesToSkip = 1)
	void clearDefaultComponentDependencies(File orig, File cleared) throws IOException
	{
		//make some file that won't have an existing name
		UUID randomUuid = UUID.randomUUID();
		Path outputPath = Files.createFile(
				tempDir.resolve(randomUuid.toString()+".xml")
		);
		File output = outputPath.toFile();
		Module module = IntelliJUtils.getIJModuleForXml(orig);
		module.clearDefaultComponentDependencies();
		xmlMapper.writeValue(output, module);
		XmlAssert.assertThat(cleared).and(output).ignoreWhitespace().ignoreElementContentWhitespace().areIdentical();
	}
}