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
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.dom.Element;

/**
 * Server-side component for the <code>vcf-enhanced-dialog</code> element.
 *
 * @author Vaadin Ltd
 */
@Tag("vcf-enhanced-dialog")
@NpmPackage(value = "@vaadin-component-factory/vcf-enhanced-dialog", version = "1.0.4")
@JsModule("@vaadin-component-factory/vcf-enhanced-dialog")
@SuppressWarnings("serial")
public class EnhancedDialog extends Dialog {

	private Element headerContainer;
	private Element footerContainer;
	private Div dialogContent;

	/**
	 * Default constructor.
	 */
	public EnhancedDialog() {
		super();

		headerContainer = new Element("header");
		headerContainer.getClassList().add("enhanced-dialog-header");
		getElement().appendVirtualChild(headerContainer);

		dialogContent = new Div();
		dialogContent.setClassName("enhanced-dialog-content");
		super.add(dialogContent);

		footerContainer = new Element("footer");
		footerContainer.getClassList().add("enhanced-dialog-footer");
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
		setHeader(new H3(headerText));
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
	 * Adds given components to the dialog content
	 *
	 * @param components
	 *            components to add
	 */
	@Override
	public void add(Component... components) {
		dialogContent.add(components);
	}

	@Override
	public void remove(Component... components) {
		Objects.requireNonNull(components, "Components should not be null");
		for (Component component : components) {
			Objects.requireNonNull(component, "Component to remove cannot be null");

			if (dialogContent.getElement().equals(component.getElement().getParent())) {
				dialogContent.getElement().removeChild(component.getElement());
			} else {
				throw new IllegalArgumentException("The given component (" + component + ") is not a child of this component");
			}
		}
	}

	@Override
	public void removeAll() {
		dialogContent.removeAll();
	}

	/**
	 * Adds given components to the dialog content at the given index.
	 *
	 * @param index
	 *            the index, where the component will be added.
	 *
	 * @param component
	 *            the component to add
	 */
	@Override
	public void addComponentAtIndex(int index, Component component) {
		Objects.requireNonNull(component, "Component should not be null");
		if (index < 0) {
			throw new IllegalArgumentException("Cannot add a component with a negative index");
		}
		// The case when the index is bigger than the children count is handled
		// inside the method below
		dialogContent.getElement().insertChild(index, component.getElement());
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
