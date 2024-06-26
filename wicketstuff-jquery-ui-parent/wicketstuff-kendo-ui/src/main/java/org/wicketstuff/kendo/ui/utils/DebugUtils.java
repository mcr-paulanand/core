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
package org.wicketstuff.kendo.ui.utils;

/**
 * Utility class for Kendo UI debug within Wicket Debug Window
 *
 * @author Sebastien Briquet - sebfz1
 */
public class DebugUtils
{
	/** error callback */
	public static final String errorCallback = "function (xhr, error) { var dw = Wicket.Ajax.DebugWindow; if (typeof dw !== 'undefined') { dw.logError(kendo.stringify(xhr)); } }";

	/**
	 * Utility class
	 */
	private DebugUtils()
	{
		// noop
	}
}
