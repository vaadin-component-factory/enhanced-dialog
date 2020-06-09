package com.vaadin.componentfactory;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vaadin.componentfactory.theme.EnhancedDialogVariant;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.dom.Element;

/**
 * Server-side component for the <code>vcf-enhanced-dialog</code> element.
 *
 * @author Vaadin Ltd
 */
@Tag("vcf-enhanced-dialog")
@NpmPackage(value = "@vaadin-component-factory/vcf-enhanced-dialog", version = "1.0.1")
@JsModule("@vaadin-component-factory/vcf-enhanced-dialog")
@SuppressWarnings("serial")
public class EnhancedDialog extends Dialog {

	private Element headerContainer;
	private Element footerContainer;

	/**
	 * Default constructor.
	 */
	public EnhancedDialog() {
		super();

		headerContainer = new Element("div");
		getElement().appendVirtualChild(headerContainer);
		footerContainer = new Element("div");
		getElement().appendVirtualChild(footerContainer);

		getElement().getNode().addAttachListener(this::attachComponentRenderers);
	}

	/**
	 * Creates a {@code<span>} element with given text, and sets this component
	 * as dialog header
	 *
	 * @param headerText
	 *            dialog title
	 */
	public void setHeader(String headerText) {
		setHeader(new Span(headerText));
	}

	/**
	 * Replaces the header section with given components
	 *
	 * @param components
	 *            components for header section
	 */
	public void setHeader(Component... components) {
		headerContainer.removeAllChildren();
		for (Component component : components) {
			addToHeader(component);
		}
	}

	/**
	 * Adds given components to header section
	 *
	 * @param components
	 *            components for header section
	 */
	public void addToHeader(Component... components) {
		Objects.requireNonNull(components, "Components should not be null");
		for (Component component : components) {
			Objects.requireNonNull(component, "Component to add cannot be null");
			headerContainer.appendChild(component.getElement());
		}
	}

	/**
	 * Replaces the footer section with given components
	 *
	 * @param components
	 *            components for footer section
	 */
	public void setFooter(Component... components) {
		footerContainer.removeAllChildren();
		for (Component component : components) {
			addToFooter(component);
		}
	}

	/**
	 * Adds given components to footer section
	 *
	 * @param components
	 *            components for footer section
	 */
	public void addToFooter(Component... components) {
		Objects.requireNonNull(components, "Components should not be null");
		for (Component component : components) {
			Objects.requireNonNull(component, "Component to add cannot be null");
			footerContainer.appendChild(component.getElement());
		}
	}

	/**
	 * Replaces the content of dialog with given components
	 *
	 * @param components
	 *            components to add
	 */
	public void setContent(Component... components) {
		removeAll();
		add(components);
	}

	/**
	 * Sets the theme variants of this component. This method overwrites any
	 * previous set theme variants.
	 */
	public void setThemeVariants(EnhancedDialogVariant... variants) {
		getElement().getThemeList().clear();
		addThemeVariants(variants);
	}

	/**
	 * Adds the theme variants of this component.
	 */
	public void addThemeVariants(EnhancedDialogVariant... variants) {
		getElement().getThemeList().addAll(Stream.of(variants).map(EnhancedDialogVariant::getVariantName).collect(Collectors.toList()));
	}

	private void attachComponentRenderers() {
		Element template = getElement().getChild(0);
		attachComponentRendererForSlot(template, headerContainer, "header");
		attachComponentRendererForSlot(template, footerContainer, "footer");
	}
	private void attachComponentRendererForSlot(Element template, Element container, String slot) {
		String appId = UI.getCurrent().getInternals().getAppId();
		int nodeId = container.getNode().getId();
		String renderer = String.format("<flow-component-renderer appid=\"%s\" nodeid=\"%s\" slot=\"" + slot + "\"></flow-component-renderer>", appId, nodeId);
		String innerHtml = template.getProperty("innerHTML") + "\n" + renderer;
		template.setProperty("innerHTML", innerHtml);
	}

}
