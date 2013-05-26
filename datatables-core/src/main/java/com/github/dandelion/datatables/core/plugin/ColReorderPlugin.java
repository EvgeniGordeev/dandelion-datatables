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
package com.github.dandelion.datatables.core.plugin;


import com.github.dandelion.datatables.core.asset.Parameter;
import com.github.dandelion.datatables.core.asset.CssResource;
import com.github.dandelion.datatables.core.asset.JsResource;
import com.github.dandelion.datatables.core.asset.ResourceType;
import com.github.dandelion.datatables.core.constants.DTConstants;
import com.github.dandelion.datatables.core.html.HtmlTable;

/**
 * Java implementation of the DataTables ColReorder plugin.
 * 
 * @see <a href="http://datatables.net/extras/colreorder/">Reference</a>
 * @author Thibault Duchateau
 */
public class ColReorderPlugin extends AbstractPlugin {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "ColReorder";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getVersion() {
		return "1.0.6";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setup(HtmlTable table) {
		addJsResource(new JsResource(ResourceType.PLUGIN, "ColReorder", "datatables/plugins/colreorder/colreorder.min.js"));
		addCssResource(new CssResource(ResourceType.PLUGIN, "ColReorder", "datatables/plugins/colreorder/colreorder.css"));
		addParameter(new Parameter(DTConstants.DT_DOM, "R", Parameter.Mode.PREPEND));
	}	
}
