package com.vaadin.componentfactory.theme;

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
