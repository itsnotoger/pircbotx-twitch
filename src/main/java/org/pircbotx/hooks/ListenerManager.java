/**
 * Copyright (C) 2010 Leon Blakey <lord.quackstar at gmail.com>
 *
 * This file is part of PircBotX.
 *
 * PircBotX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PircBotX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PircBotX.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pircbotx.hooks;

import java.util.Set;
import org.pircbotx.PircBotX;

/**
 * Manages everything about Listeners: adding, removing, and dispatching events
 * to appropriate listeners.
 * <p>
 * An important job of all methods in this class is to absorb and report <u>any</u> 
 * exceptions or errors before they reach {@link PircBotX}. Failure to do so
 * could break many internal long running operations. It is therefor recommended
 * to catch {@link Throwable} and report with {@link PircBotX#logException(java.lang.Throwable) }
 * <p>
 * Performance is another important job in implementations. Events can be dispatched
 * very quickly at times (eg a /WHO on all joined channels) so lots of expensive
 * calls can hurt performance of the entire bot. Therefor important methods like 
 * {@link #dispatchEvent(org.pircbotx.hooks.Event) } should be as fast as possible
 * 
 * @author Leon Blakey <lord.quackstar at gmail.com>
 */
public interface ListenerManager {
	/**
	 * Sends event to all appropriate listeners.
	 * <p>
	 * <b>For implementations:</b> Please read {@link ListenerManager important information} 
	 * on exception handling and performance.
	 * @param event The event to send
	 */
	public void dispatchEvent(Event event);

	/**
	 * Adds an I listener to the list of listeners for an event.
	 * <p>
	 * <b>For implementations:</b> Please read {@link ListenerManager important information} 
	 * on exception handling and performance.
	 * @param listener The listener to add
	 */
	public void addListener(Listener listener);

	/**
	 * Removes an I Listener from the list listeners for an event
	 * <p>
	 * <b>For implementations:</b> Please read {@link ListenerManager important information} 
	 * on exception handling and performance.s
	 * @param listener
	 */
	public void removeListener(Listener listener);

	/**
	 * Gets all the listeners to an event
	 * <p>
	 * <b>For implementations:</b> Please read {@link ListenerManager important information} 
	 * on exception handling and performance.
	 * @return An <b>Immutable set</b> of I listeners
	 */
	public Set<Listener> getListeners();
}