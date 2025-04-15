/**
 * Copyright 2014-2025 eQ-3 AG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.eq3.plugin.serialization;

import java.util.Arrays;

import de.eq3.plugin.documentation.TypeDocumentation;
import de.eq3.plugin.domain.Body;
import de.eq3.plugin.domain.config.ConfigTemplateRequest;
import de.eq3.plugin.domain.config.ConfigTemplateResponse;
import de.eq3.plugin.domain.config.ConfigUpdateRequest;
import de.eq3.plugin.domain.config.ConfigUpdateResponse;
import de.eq3.plugin.domain.control.ControlRequest;
import de.eq3.plugin.domain.control.ControlResponse;
import de.eq3.plugin.domain.control.HmipSystemRequest;
import de.eq3.plugin.domain.control.HmipSystemResponse;
import de.eq3.plugin.domain.discover.DiscoverRequest;
import de.eq3.plugin.domain.discover.DiscoverResponse;
import de.eq3.plugin.domain.error.ErrorResponse;
import de.eq3.plugin.domain.inclusion.ExclusionEvent;
import de.eq3.plugin.domain.inclusion.InclusionEvent;
import de.eq3.plugin.domain.plugin.PluginStateRequest;
import de.eq3.plugin.domain.plugin.PluginStateResponse;
import de.eq3.plugin.domain.status.HmipSystemEvent;
import de.eq3.plugin.domain.status.StatusEvent;
import de.eq3.plugin.domain.status.StatusRequest;
import de.eq3.plugin.domain.status.StatusResponse;
import de.eq3.plugin.domain.system.SystemInfoRequest;
import de.eq3.plugin.domain.system.SystemInfoResponse;
import de.eq3.plugin.domain.user.message.CreateUserMessageRequest;
import de.eq3.plugin.domain.user.message.CreateUserMessageResponse;
import de.eq3.plugin.domain.user.message.DeleteUserMessageRequest;
import de.eq3.plugin.domain.user.message.DeleteUserMessageResponse;
import de.eq3.plugin.domain.user.message.ListUserMessagesRequest;
import de.eq3.plugin.domain.user.message.ListUserMessagesResponse;
import de.eq3.plugin.domain.user.message.UserMessageAcknowledgementEvent;

import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Getter
@FieldNameConstants(onlyExplicitlyIncluded = true)
@TypeDocumentation(
		description = "Enumerated type of messages sent by Home Control Unit or plugin. The type is included "
				+ "in every message and defines the structure of the message body.")
public enum PluginMessageType {
	@FieldNameConstants.Include
	ERROR_RESPONSE(ErrorResponse.class),

	@FieldNameConstants.Include
	PLUGIN_STATE_REQUEST(PluginStateRequest.class),

	@FieldNameConstants.Include
	PLUGIN_STATE_RESPONSE(PluginStateResponse.class),

	@FieldNameConstants.Include
	SYSTEM_INFO_REQUEST(SystemInfoRequest.class),

	@FieldNameConstants.Include
	SYSTEM_INFO_RESPONSE(SystemInfoResponse.class),

	@FieldNameConstants.Include
	CONFIG_TEMPLATE_REQUEST(ConfigTemplateRequest.class),

	@FieldNameConstants.Include
	CONFIG_TEMPLATE_RESPONSE(ConfigTemplateResponse.class),

	@FieldNameConstants.Include
	CONFIG_UPDATE_REQUEST(ConfigUpdateRequest.class),

	@FieldNameConstants.Include
	CONFIG_UPDATE_RESPONSE(ConfigUpdateResponse.class),

	@FieldNameConstants.Include
	DISCOVER_REQUEST(DiscoverRequest.class),

	@FieldNameConstants.Include
	DISCOVER_RESPONSE(DiscoverResponse.class),

	@FieldNameConstants.Include
	INCLUSION_EVENT(InclusionEvent.class),

	@FieldNameConstants.Include
	EXCLUSION_EVENT(ExclusionEvent.class),

	@FieldNameConstants.Include
	CONTROL_REQUEST(ControlRequest.class),

	@FieldNameConstants.Include
	CONTROL_RESPONSE(ControlResponse.class),

	@FieldNameConstants.Include
	STATUS_REQUEST(StatusRequest.class),

	@FieldNameConstants.Include
	STATUS_RESPONSE(StatusResponse.class),

	@FieldNameConstants.Include
	STATUS_EVENT(StatusEvent.class),

	@FieldNameConstants.Include
	HMIP_SYSTEM_REQUEST(HmipSystemRequest.class),

	@FieldNameConstants.Include
	HMIP_SYSTEM_RESPONSE(HmipSystemResponse.class),

	@FieldNameConstants.Include
	HMIP_SYSTEM_EVENT(HmipSystemEvent.class),

	@FieldNameConstants.Include
	CREATE_USER_MESSAGE_REQUEST(CreateUserMessageRequest.class),

	@FieldNameConstants.Include
	CREATE_USER_MESSAGE_RESPONSE(CreateUserMessageResponse.class),

	@FieldNameConstants.Include
	DELETE_USER_MESSAGE_REQUEST(DeleteUserMessageRequest.class),

	@FieldNameConstants.Include
	DELETE_USER_MESSAGE_RESPONSE(DeleteUserMessageResponse.class),

	@FieldNameConstants.Include
	LIST_USER_MESSAGES_REQUEST(ListUserMessagesRequest.class),

	@FieldNameConstants.Include
	LIST_USER_MESSAGES_RESPONSE(ListUserMessagesResponse.class),

	@FieldNameConstants.Include
	USER_MESSAGE_ACK_EVENT(UserMessageAcknowledgementEvent.class);

	private final Class<? extends Body> mappingClazz;

	PluginMessageType(Class<? extends Body> mappingClazz) {
		this.mappingClazz = mappingClazz;
	}

	public static PluginMessageType fromClazz(Class<? extends Body> mappingClazz) {
		return Arrays.stream(values())
				.filter(pluginMessageType -> pluginMessageType.getMappingClazz().equals(mappingClazz))
				.findFirst()
				.orElse(null);
	}
}
