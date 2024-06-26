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
package org.wicketstuff.jquery.core;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.wicketstuff.jquery.core.utils.JQueryUtils;

/**
 * Provides an {@link AjaxCallListener} that detaches an element from the dom before an ajax call
 *
 * @author Sebastien Briquet - sebfz1
 * @since 6.25.0
 */
public class DetachAjaxCallListener extends AjaxCallListener
{
	private static final long serialVersionUID = 1L;

	private final String selector;

	public DetachAjaxCallListener(String selector)
	{
		this.selector = selector;
	}

	@Override
	public CharSequence getBeforeSendHandler(Component component)
	{
		return JQueryUtils.detach(this.selector);
	}
}
