// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain;

import org.dddappp.suiinscription.specialization.CommandType;

public interface Command {

    String COMMAND_TYPE_CREATE = CommandType.CREATE;

    String COMMAND_TYPE_MERGE_PATCH = CommandType.MERGE_PATCH;

    String COMMAND_TYPE_DELETE = CommandType.DELETE;

    String COMMAND_TYPE_REMOVE = CommandType.REMOVE;

    String getCommandType();

    void setCommandType(String commandType);

    String getCommandId();

    void setCommandId(String commandId);

    String getRequesterId();

    void setRequesterId(String requesterId);

    java.util.Map<String, Object> getCommandContext();

}


