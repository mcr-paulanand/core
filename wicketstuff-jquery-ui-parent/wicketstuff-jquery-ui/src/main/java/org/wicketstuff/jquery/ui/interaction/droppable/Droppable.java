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
package org.wicketstuff.jquery.ui.interaction.droppable;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;
import org.wicketstuff.jquery.core.JQueryBehavior;
import org.wicketstuff.jquery.core.JQueryGenericContainer;
import org.wicketstuff.jquery.ui.interaction.draggable.Draggable;

/**
 * Provides a jQuery droppable area, on which {@link Draggable}{@code s} can be dropped.
 *
 * @param <T> the model object type
 * @author Sebastien Briquet - sebfz1
 */
public abstract class Droppable<T> extends JQueryGenericContainer<T> implements IDroppableListener
{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param id the markup id
	 */
	public Droppable(String id)
	{
		super(id);
	}

	/**
	 * Constructor
	 * 
	 * @param id the markup id
	 * @param model the {@link IModel}
	 */
	public Droppable(String id, IModel<T> model)
	{
		super(id, model);
	}

	// Properties //

	@Override
	public boolean isOverEventEnabled()
	{
		return false;
	}

	@Override
	public boolean isExitEventEnabled()
	{
		return false;
	}

	// Events //

	@Override
	public void onOver(AjaxRequestTarget target, Component component)
	{
		// noop
	}

	@Override
	public void onExit(AjaxRequestTarget target, Component component)
	{
		// noop
	}

	// IJQueryWidget //

	@Override
	public JQueryBehavior newWidgetBehavior(String selector)
	{
		return new DroppableBehavior(selector, this);
	}
}
