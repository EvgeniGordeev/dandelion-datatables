/*
 * [The "BSD licence"]
 * Copyright (c) 2012 Dandelion
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 3. Neither the name of Dandelion nor the names of its contributors 
 * may be used to endorse or promote products derived from this software 
 * without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.dandelion.datatables.core.configuration;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.dandelion.datatables.core.constants.SystemConstants;
import com.github.dandelion.datatables.core.generator.javascript.StandardJavascriptGenerator;
import com.github.dandelion.datatables.core.i18n.StandardLocaleResolver;

public class DatatablesConfiguratorTest {

	@Before
	public void before(){
		System.clearProperty(SystemConstants.DANDELION_DT_CONFLOADER_CLASS);
	}
	
	@Test
	public void should_use_StandardConfigurationLoader_by_default() {
		assertThat(DatatablesConfigurator.getConfigurationLoader()).isInstanceOf(StandardConfigurationLoader.class);
	}
	
	@Test
	public void should_use_another_configution_loader_using_system_property(){
		System.setProperty(SystemConstants.DANDELION_DT_CONFLOADER_CLASS, "com.github.dandelion.datatables.core.configuration.FakeConfigurationLoader");
		assertThat(DatatablesConfigurator.getConfigurationLoader()).isInstanceOf(FakeConfigurationLoader.class);
		System.clearProperty(SystemConstants.DANDELION_DT_CONFLOADER_CLASS);
	}
	
	@Test
	public void should_return_StandardLocaleResolver_from_default_configuration(){
		assertThat(DatatablesConfigurator.getLocaleResolver()).isInstanceOf(StandardLocaleResolver.class);
	}
	
	@Test
	public void should_return_default_locale_resolver(){
		assertThat(DatatablesConfigurator.getLocaleResolver()).isInstanceOf(StandardLocaleResolver.class);
	}
	
	@Test
	public void should_return_StandardJavascriptGenerator_from_default_configuration(){
		assertThat(DatatablesConfigurator.getJavascriptGenerator()).isInstanceOf(StandardJavascriptGenerator.class);
	}
	
	@Test
	public void should_use_another_javascript_generator_using_system_property(){
		System.setProperty(SystemConstants.DANDELION_DT_JS_GEN_CLASS, "com.github.dandelion.datatables.core.configuration.FakeJavascriptGenerator");
		assertThat(DatatablesConfigurator.getJavascriptGenerator()).isInstanceOf(FakeJavascriptGenerator.class);
		System.clearProperty(SystemConstants.DANDELION_DT_JS_GEN_CLASS);
	}
	
	@After
	public void after(){
		DatatablesConfigurator.clear();
	}
}