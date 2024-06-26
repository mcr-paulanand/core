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
package org.wicketstuff.kendo.ui.widget.window;

import java.util.List;

/**
 * Utility class for {@link WindowButton}{@code s}
 *
 * @author Sebastien Briquet - sebfz1
 */
public class WindowButtonUtils
{
	/**
	 * Helper that applies #setDefaultFormProcessing to the list of {@link WindowButton}{@code s}<br>
	 * <br>
	 * <b>Warning:</b> the WindowButtons supplied in argument will be modified
	 *
	 * @param buttons the list of {@link WindowButton}
	 * @param processing whether the form will be validated and updated
	 */
	public static void setDefaultFormProcessing(WindowButtons buttons, boolean processing)
	{
		WindowButtonUtils.setDefaultFormProcessing(buttons.toList(), processing);
	}

	/**
	 * Helper that applies #setDefaultFormProcessing to the list of {@link WindowButton}{@code s}<br>
	 * <br>
	 * <b>Warning:</b> the WindowButtons supplied in the list argument will be modified
	 *
	 * @param buttons the list of {@link WindowButton}
	 * @param processing whether the form will be validated and updated
	 */
	public static void setDefaultFormProcessing(List<WindowButton> buttons, boolean processing)
	{
		for (WindowButton button : buttons)
		{
			button.setDefaultFormProcessing(processing);
		}
	}

	/**
	 * Utility class
	 */
	private WindowButtonUtils()
	{
	}
}
