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
package org.wicketstuff.kendo.ui.widget.menu;

import java.util.Map;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.CallbackParameter;
import org.apache.wicket.util.lang.Args;
import org.wicketstuff.jquery.core.JQueryEvent;
import org.wicketstuff.jquery.core.Options;
import org.wicketstuff.jquery.core.ajax.IJQueryAjaxAware;
import org.wicketstuff.jquery.core.ajax.JQueryAjaxBehavior;
import org.wicketstuff.jquery.core.utils.RequestCycleUtils;
import org.wicketstuff.kendo.ui.KendoUIBehavior;
import org.wicketstuff.kendo.ui.widget.menu.item.IMenuItem;

/**
 * Provides a Kendo UI menu widget
 *
 * @author Sebastien Briquet - sebfz1
 * @since 6.15.0
 */
public abstract class MenuBehavior extends KendoUIBehavior implements IJQueryAjaxAware
{
	private static final long serialVersionUID = 1L;
	public static final String METHOD = "kendoMenu";

	private final IMenuListener listener;
	private JQueryAjaxBehavior onSelectAjaxBehavior;

	/**
	 * Constructor
	 *
	 * @param selector the html selector (ie: "#myId")
	 * @param listener the {@link IMenuListener}
	 */
	public MenuBehavior(String selector, IMenuListener listener)
	{
		this(selector, METHOD, new Options(), listener);
	}

	/**
	 * Constructor
	 *
	 * @param selector the html selector (ie: "#myId")
	 * @param listener the {@link IMenuListener}
	 */
	MenuBehavior(String selector, String method, IMenuListener listener)
	{
		this(selector, method, new Options(), listener);
	}

	/**
	 * Constructor
	 *
	 * @param selector the html selector (ie: "#myId")
	 * @param options the {@link Options}
	 * @param listener the {@link IMenuListener}
	 */
	public MenuBehavior(String selector, Options options, IMenuListener listener)
	{
		this(selector, METHOD, options, listener);
	}

	/**
	 * Constructor
	 *
	 * @param selector the html selector (ie: "#myId")
	 * @param options the {@link Options}
	 * @param listener the {@link IMenuListener}
	 */
	MenuBehavior(String selector, String method, Options options, IMenuListener listener)
	{
		super(selector, method, options);
		
		this.listener = Args.notNull(listener, "listener");
	}

	// Properties //

	/**
	 * Gets the reference map of hash/menu-item.<br>
	 *
	 * @return the non-null {@link Map}
	 */
	protected abstract Map<String, IMenuItem> getMenuItemMap();

	// Methods //

	@Override
	public void bind(Component component)
	{
		super.bind(component);

		this.onSelectAjaxBehavior = this.newOnSelectAjaxBehavior(this);
		component.add(this.onSelectAjaxBehavior);
	}

	// Events //

	@Override
	public void onConfigure(Component component)
	{
		this.setOption("select", this.onSelectAjaxBehavior.getCallbackFunction());

		super.onConfigure(component);
	}

	@Override
	public void onAjax(AjaxRequestTarget target, JQueryEvent event)
	{
		if (event instanceof SelectEvent)
		{
			IMenuItem item = this.getMenuItemMap().get(((SelectEvent) event).getHash());

			if (item != null)
			{
				item.onClick(target);
				this.listener.onClick(target, item);
			}
		}
	}

	// Factories //

	/**
	 * Gets a new {@link JQueryAjaxBehavior} that will be wired to the 'select' event
	 *
	 * @param source the {@link IJQueryAjaxAware}
	 * @return a new {@code OnSelectAjaxBehavior} by default
	 */
	protected JQueryAjaxBehavior newOnSelectAjaxBehavior(IJQueryAjaxAware source)
	{
		return new OnSelectAjaxBehavior(source);
	}

	// Ajax classes //

	/**
	 * Provides a {@link JQueryAjaxBehavior} that aims to be wired to the 'select' event
	 */
	protected static class OnSelectAjaxBehavior extends JQueryAjaxBehavior
	{
		private static final long serialVersionUID = 1L;

		public OnSelectAjaxBehavior(IJQueryAjaxAware source)
		{
			super(source);
		}

		@Override
		protected CallbackParameter[] getCallbackParameters()
		{
			return new CallbackParameter[] { CallbackParameter.context("e"), // lf
					CallbackParameter.resolved("hash", "e.item.id") };
		}

		@Override
		protected JQueryEvent newEvent()
		{
			return new SelectEvent();
		}
	}

	// Event objects //

	/**
	 * Provides an event object that will be broadcasted by the {@link OnSelectAjaxBehavior} callback
	 */
	protected static class SelectEvent extends JQueryEvent
	{
		private final String hash;

		/**
		 * Constructor
		 */
		public SelectEvent()
		{
			super();

			this.hash = RequestCycleUtils.getQueryParameterValue("hash").toString();
		}

		/**
		 * Gets the menu's id-hash
		 *
		 * @return the id-hash
		 */
		public String getHash()
		{
			return this.hash;
		}
	}
}
