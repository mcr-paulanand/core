/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicketstuff.jquery.ui.markup.html.link;

import org.apache.wicket.model.IModel;
import org.wicketstuff.jquery.core.IJQueryWidget;
import org.wicketstuff.jquery.core.JQueryBehavior;
import org.wicketstuff.jquery.ui.JQueryIcon;
import org.wicketstuff.jquery.ui.form.button.ButtonBehavior;

/**
 * Provides a jQuery UI button based on a built-in {@code AjaxFallbackLink}
 *
 * @param <T> the model object type
 * @author Sebastien Briquet - sebfz1
 * @since 6.19.0
 * @since 7.0.0
 */
public abstract class AjaxFallbackLink<T> extends org.apache.wicket.ajax.markup.html.AjaxFallbackLink<T> implements IJQueryWidget
{
	private static final long serialVersionUID = 1L;

	private final String icon;

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 */
	public AjaxFallbackLink(String id)
	{
		this(id, JQueryIcon.NONE);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param icon either a {@link JQueryIcon} constant or a 'ui-icon-xxx' css class
	 */
	public AjaxFallbackLink(String id, String icon)
	{
		super(id);

		this.icon = icon;
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 */
	public AjaxFallbackLink(String id, IModel<T> model)
	{
		this(id, model, JQueryIcon.NONE);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param icon either a {@link JQueryIcon} constant or a 'ui-icon-xxx' css class
	 */
	public AjaxFallbackLink(String id, IModel<T> model, String icon)
	{
		super(id, model);

		this.icon = icon;
	}

	// Events //

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(JQueryWidget.newWidgetBehavior(this));
	}

	@Override
	public void onConfigure(JQueryBehavior behavior)
	{
		behavior.setOption("disabled", !this.isEnabledInHierarchy());
	}

	@Override
	public void onBeforeRender(JQueryBehavior behavior)
	{
	}

	@Override
	public JQueryBehavior newWidgetBehavior(String selector)
	{
		return new ButtonBehavior(selector, this.icon);
	}
}
