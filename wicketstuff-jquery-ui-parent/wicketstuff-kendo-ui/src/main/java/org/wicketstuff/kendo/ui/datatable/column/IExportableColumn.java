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
package org.wicketstuff.kendo.ui.datatable.column;

import org.apache.wicket.model.IModel;

/**
 * Specifies that a {@link IColumn} has an export capability
 *
 * @author Sebastien Briquet - sebfz1
 */
public interface IExportableColumn extends IColumn
{
	/**
	 * Gets a new {@link IModel} of the data represented by this {@link IExportableColumn}, for the supplied row model
	 *
	 * @param rowModel the row model
	 * @return a new {@code IModel} of the data represented by this {@link IExportableColumn}
	 */
	IModel<Object> newDataModel(IModel<?> rowModel);
}