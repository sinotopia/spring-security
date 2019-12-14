/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package samples.gae.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import samples.gae.users.GaeUser;

import java.util.Collection;
import java.util.HashSet;

/**
 * Authentication object representing a fully-authenticated user.
 *
 * @author Luke Taylor
 */
public class GaeUserAuthentication implements Authentication {
	private final GaeUser principal;
	private final Object details;
	private boolean authenticated;

	public GaeUserAuthentication(GaeUser principal, Object details) {
		this.principal = principal;
		this.details = details;
		authenticated = true;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return new HashSet<>(principal.getAuthorities());
	}

	@Override
	public Object getCredentials() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getDetails() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) {
		authenticated = isAuthenticated;
	}

	@Override
	public String getName() {
		return principal.getUserId();
	}

	@Override
	public String toString() {
		return "GaeUserAuthentication{" + "principal=" + principal + ", details="
				+ details + ", authenticated=" + authenticated + '}';
	}
}
