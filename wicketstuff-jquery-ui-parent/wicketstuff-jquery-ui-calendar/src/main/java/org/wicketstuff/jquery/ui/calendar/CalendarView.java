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
package org.wicketstuff.jquery.ui.calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides an enum of available calendar views
 *
 * @author Sebastien Briquet - sebfz1
 */
public enum CalendarView
{
    month,
    basicWeek,
    basicDay,
    agendaWeek,
    agendaDay,

    // ResourceViews (fork, not merged as of Aug. 2013) //
    // https://github.com/arshaw/fullcalendar/pull/99 //
    resourceDay,		// Shows a single day in calendar.
    resourceWeek,		// Shows a single week in calendar.
    resourceNextWeeks,	// Shows ongoing week and 3 weeks after that in same calendar.
    resourceMonth;		// Shows a single month in calendar.

    private static final Logger LOG = LoggerFactory.getLogger(CalendarView.class);

    /**
     * Safely get the {@link CalendarView} corresponding to the supplied view name
     *
     * @param viewName the view name
     * @return null if the view name does not correspond to a view of the enum
     */
    public static CalendarView get(String viewName)
	{
		try
	    {
	        return CalendarView.valueOf(viewName);
	    }
	    catch (IllegalArgumentException e)
		{ 
	    	if (LOG.isDebugEnabled())
	    	{
	    		LOG.debug(e.getMessage(), e);
	    	}
		}

	    return null;
    }
}
