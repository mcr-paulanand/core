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
package org.wicketstuff.jquery.ui.widget.tabs;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.tabs.ITab;

/**
 * Adapter class for {@link ITabsListener}
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public class TabsAdapter implements ITabsListener
{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isCreateEventEnabled()
	{
		return true;
	}

	@Override
	public boolean isActivateEventEnabled()
	{
		return true;
	}

	@Override
	public boolean isActivatingEventEnabled()
	{
		return false;
	}

	@Override
	public void onActivate(AjaxRequestTarget target, int index, ITab tab)
	{
		// noop
	}

	@Override
	public void onActivating(AjaxRequestTarget target, int index, ITab tab)
	{
		// noop
	}
}
