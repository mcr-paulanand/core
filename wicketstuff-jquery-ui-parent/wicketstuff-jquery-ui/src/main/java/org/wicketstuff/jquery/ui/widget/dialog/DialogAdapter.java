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
package org.wicketstuff.jquery.ui.widget.dialog;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.core.request.handler.IPartialPageRequestHandler;

/**
 * Adapter class for {@link IDialogListener}
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public class DialogAdapter implements IDialogListener
{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isDefaultCloseEventEnabled()
	{
		return false;
	}

	@Override
	public boolean isEscapeCloseEventEnabled()
	{
		return false;
	}

	@Override
	public void onClick(AjaxRequestTarget target, DialogButton button)
	{
		// noop
	}

	@Override
	public void onClose(IPartialPageRequestHandler handler, DialogButton button)
	{
		// noop
	}
}
