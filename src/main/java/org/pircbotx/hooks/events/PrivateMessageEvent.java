/**
 * Copyright (C) 2010-2014 Leon Blakey <lord.quackstar at gmail.com>
 *
 * This file is part of PircBotX.
 *
 * PircBotX is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * PircBotX is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * PircBotX. If not, see <http://www.gnu.org/licenses/>.
 */
package org.pircbotx.hooks.events;

import org.jetbrains.annotations.Nullable;

import lombok.*;
import org.pircbotx.User;
import org.pircbotx.hooks.Event;
import org.pircbotx.PircBotX;
import org.pircbotx.UserHostmask;
import org.pircbotx.hooks.types.GenericMessageEvent;

import com.google.common.collect.ImmutableMap;

/**
 * This event is dispatched whenever a private message is sent to us.
 *
 * @author Leon Blakey
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PrivateMessageEvent extends Event implements GenericMessageEvent {
	/**
	 * The user hostmask who sent the private message.
	 */
	@Getter(onMethod_={@Override})
	protected final UserHostmask userHostmask;
	/**
	 * The user who sent the private message.
	 */
	@Getter(onMethod_={@Override,@Nullable})
	protected final User user;
	/**
	 * The actual message.
	 */
	@Getter(onMethod_={@Override})
	protected final String message;
	
	/**
	 * The IrcV3 tags
	 */
	@Getter
	protected final ImmutableMap<String, String> tags;

	public PrivateMessageEvent(PircBotX bot, @NonNull UserHostmask userHostmask, User user, @NonNull String message, ImmutableMap<String, String> tags) {
		super(bot);
		this.userHostmask = userHostmask;
		this.user = user;
		this.message = message;
		this.tags = tags;
	}

	/**
	 * Respond with a private message to the user that sent the message
	 *
	 * @param response The response to send
	 */
	@Override
	public void respond(String response) {
		respondWith(response);
	}
	
	@Override
	public void respondWith(String fullLine) {
		getUser().send().message(fullLine);
	}

	@Override
	public void respondPrivateMessage(String message) {
		respond(message);
	}
}
