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

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.util.io.IClusterable;
import org.wicketstuff.kendo.ui.widget.menu.item.IMenuItem;

/**
 * Event listener shared by the {@link Menu} widget and the {@link MenuBehavior}
 *
 * @author Sebastien Briquet - sebfz1
 * @since 6.15.0
 */
public interface IMenuListener extends IClusterable
{
	/**
	 * Triggered when a menu-item is clicked
	 *
	 * @param target the {@link AjaxRequestTarget}
	 * @param item the {@link IMenuItem}
	 */
	void onClick(AjaxRequestTarget target, IMenuItem item);
}
