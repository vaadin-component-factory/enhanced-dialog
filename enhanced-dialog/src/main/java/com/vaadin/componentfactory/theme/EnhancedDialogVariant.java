package com.vaadin.componentfactory.theme;

/*-
 * #%L
 * Enhanced Dialog
 * %%
 * Copyright (C) 2020 Vaadin Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

public enum EnhancedDialogVariant {
	SIZE_SMALL("small"), SIZE_MEDIUM("medium"), SIZE_LARGE("large");

	private final String variant;

	EnhancedDialogVariant(String variant) {
		this.variant = variant;
	}

	public String getVariantName() {
		return variant;
	}
}
