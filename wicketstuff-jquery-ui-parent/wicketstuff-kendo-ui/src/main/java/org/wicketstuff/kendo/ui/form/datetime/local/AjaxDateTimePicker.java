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
package org.wicketstuff.kendo.ui.form.datetime.local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

import org.apache.wicket.core.request.handler.IPartialPageRequestHandler;
import org.apache.wicket.model.IModel;
import org.wicketstuff.jquery.core.JQueryBehavior;
import org.wicketstuff.jquery.core.Options;
import org.wicketstuff.jquery.core.ajax.IJQueryAjaxAware;
import org.wicketstuff.jquery.core.ajax.JQueryAjaxPostBehavior;
import org.wicketstuff.jquery.core.event.IValueChangedListener;
import org.wicketstuff.kendo.ui.ajax.OnChangeAjaxBehavior;
import org.wicketstuff.kendo.ui.form.datetime.DatePickerBehavior;
import org.wicketstuff.kendo.ui.form.datetime.TimePickerBehavior;

/**
 * Provides a datetime-picker based on a {@link AjaxDatePicker} and a {@link AjaxTimePicker}<br>
 * This ajax version will post both components, using a {@link JQueryAjaxPostBehavior}, when the 'change' javascript method is called.
 *
 * @author Sebastien Briquet - sebfz1
 */
public class AjaxDateTimePicker extends DateTimePicker implements IValueChangedListener // NOSONAR
{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 */
	public AjaxDateTimePicker(String id)
	{
		super(id);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param locale the {@code Locale}
	 */
	public AjaxDateTimePicker(String id, Locale locale)
	{
		super(id, locale);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param datePattern the SimpleDateFormat pattern for the date
	 * @param timePattern the SimpleDateFormat pattern for the time
	 */
	public AjaxDateTimePicker(String id, String datePattern, String timePattern)
	{
		super(id, datePattern, timePattern);
	}

	/**
	 * constructor
	 *
	 * @param id the markup id
	 * @param locale the {@code Locale}
	 * @param datePattern the SimpleDateFormat pattern for the date
	 * @param timePattern the SimpleDateFormat pattern for the time
	 */
	public AjaxDateTimePicker(String id, Locale locale, String datePattern, String timePattern)
	{
		super(id, locale, datePattern, timePattern);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the date {@code IModel}
	 */
	public AjaxDateTimePicker(String id, IModel<LocalDateTime> model)
	{
		super(id, model);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the date {@code IModel}
	 * @param locale the {@code LocalDate}
	 */
	public AjaxDateTimePicker(String id, IModel<LocalDateTime> model, Locale locale)
	{
		super(id, model, locale);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the date {@code IModel}
	 * @param datePattern the SimpleDateFormat pattern for the date
	 * @param timePattern the SimpleDateFormat pattern for the time
	 */
	public AjaxDateTimePicker(String id, IModel<LocalDateTime> model, String datePattern, String timePattern)
	{
		super(id, model, datePattern, timePattern);
	}

	/**
	 * Main constructor
	 *
	 * @param id the markup id
	 * @param model the date {@code IModel}
	 * @param locale the {@code Locale}
	 * @param datePattern the SimpleDateFormat pattern for the date
	 * @param timePattern the SimpleDateFormat pattern for the time
	 */
	public AjaxDateTimePicker(String id, IModel<LocalDateTime> model, Locale locale, String datePattern, String timePattern)
	{
		super(id, model, locale, datePattern, timePattern);
	}

	// Events //

	/**
	 * Triggered when the validation failed (ie, not input provided)
	 *
	 * @param handler the {@link IPartialPageRequestHandler}
	 */
	protected void onError(IPartialPageRequestHandler handler)
	{
		// noop
	}

	@Override
	public void onValueChanged(IPartialPageRequestHandler handler)
	{
		// noop
	}

	// Factories //

	@Override
	protected DatePicker newDatePicker(String id, IModel<LocalDate> model, Locale locale, String datePattern, Options options)
	{
		return new AjaxDatePicker(id, model, locale, datePattern, options) { // NOSONAR

			private static final long serialVersionUID = 1L;

			// events //

			@Override
			protected void onConfigure()
			{
				super.onConfigure();

				this.setEnabled(AjaxDateTimePicker.this.isEnabled());
			}

			// methods //

			@Override
			public void convertInput()
			{
				// lets DateTimePicker handling the conversion
			}

			// factories //

			@Override
			public JQueryBehavior newWidgetBehavior(String selector)
			{
				final IValueChangedListener listener = new IValueChangedListener() {

					private static final long serialVersionUID = 1L;

					@Override
					public void onValueChanged(IPartialPageRequestHandler handler)
					{
						AjaxDateTimePicker.this.processInput();

						if (AjaxDateTimePicker.this.hasErrorMessage())
						{
							AjaxDateTimePicker.this.onError(handler);
						}
						else
						{
							AjaxDateTimePicker.this.onValueChanged(handler);
						}
					}
				};

				return new DatePickerBehavior(selector, this.options, listener) { // NOSONAR

					private static final long serialVersionUID = 1L;

					@Override
					protected JQueryAjaxPostBehavior newOnChangeAjaxBehavior(IJQueryAjaxAware source)
					{
						return new OnChangeAjaxBehavior(source, AjaxDateTimePicker.this.datePicker, AjaxDateTimePicker.this.timePicker);
					}
				};
			}
		};
	}

	@Override
	protected TimePicker newTimePicker(String id, IModel<LocalTime> model, Locale locale, String timePattern, Options options)
	{
		return new AjaxTimePicker(id, model, locale, timePattern, options) { // NOSONAR

			private static final long serialVersionUID = 1L;

			// events //

			@Override
			protected void onConfigure()
			{
				super.onConfigure();

				this.setEnabled(AjaxDateTimePicker.this.isEnabled() && AjaxDateTimePicker.this.isTimePickerEnabled());
			}

			// methods //

			@Override
			public void convertInput()
			{
				// lets DateTimePicker handling the conversion
			}

			// factories //

			@Override
			public JQueryBehavior newWidgetBehavior(String selector)
			{
				final IValueChangedListener listener = new IValueChangedListener() {

					private static final long serialVersionUID = 1L;

					@Override
					public void onValueChanged(IPartialPageRequestHandler handler)
					{
						AjaxDateTimePicker.this.processInput();

						if (AjaxDateTimePicker.this.hasErrorMessage())
						{
							AjaxDateTimePicker.this.onError(handler);
						}
						else
						{
							AjaxDateTimePicker.this.onValueChanged(handler);
						}
					}
				};

				return new TimePickerBehavior(selector, this.options, listener) { // NOSONAR

					private static final long serialVersionUID = 1L;

					@Override
					protected JQueryAjaxPostBehavior newOnChangeAjaxBehavior(IJQueryAjaxAware source)
					{
						return new OnChangeAjaxBehavior(source, AjaxDateTimePicker.this.datePicker, AjaxDateTimePicker.this.timePicker);
					}
				};
			}
		};
	}
}
