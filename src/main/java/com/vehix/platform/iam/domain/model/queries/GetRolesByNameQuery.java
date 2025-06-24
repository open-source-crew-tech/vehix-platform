package com.vehix.platform.iam.domain.model.queries;

import com.vehix.platform.iam.domain.model.valueobjects.Roles;

/**
 * Get roles by name query
 * <p>
 *     This class represents the query to get roles by their name.
 * </p>
 * @param name the name of the role
 * @see Roles
 */
public record GetRolesByNameQuery(Roles name) {
}
