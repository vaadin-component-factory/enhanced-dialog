package com.vaadin.componentfactory.demo;

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

import com.vaadin.componentfactory.EnhancedDialog;
import com.vaadin.componentfactory.theme.EnhancedDialogVariant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

/**
 * Server-side component Example for the <code>vcf-enhanced-dialog</code>
 * element.
 *
 * @author Vaadin Ltd
 */
@Route("enhanced-dialog")
public class EnhancedDialogView extends DemoView {

	private static String LONG_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum hendrerit, libero vel suscipit" + "finibus, sapien mi luctus ligula, in placerat sapien lacus a ex. Quisque arcu mauris, porta in "
			+ "interdum ac, gravida at odio. Integer in aliquet metus, sed pulvinar lectus. Suspendisse potenti. " + "Pellentesque sed urna quis ligula lacinia aliquet. Phasellus iaculis sapien nulla, vitae lobortis "
			+ "libero mollis sed. Ut suscipit porta odio id interdum. Aliquam id ipsum nisi. Nam et condimentum eros, " + "id facilisis mauris. Nulla maximus at tortor sodales auctor. Cras facilisis, enim vitae dapibus "
			+ "ultrices, tortor neque feugiat risus, vel gravida odio tortor eu odio. Nulla non diam pellentesque, " + "eleifend lacus ullamcorper, sodales nibh. Etiam pellentesque maximus ligula. Cras mattis dui non "
			+ "lectus finibus molestie. Fusce posuere rhoncus finibus. Mauris imperdiet elit eu diam finibus " + "bibendum. Fusce vestibulum egestas nisl vitae mattis. Donec tincidunt est non mauris egestas viverra. "
			+ "Nulla dignissim purus dui, ac tincidunt velit molestie id. Mauris nec quam rhoncus, faucibus ipsum " + "ultrices, lobortis ex. Mauris maximus nisi non tortor rutrum, non dictum arcu finibus. Curabitur "
			+ "malesuada mauris eu ligula bibendum sollicitudin. Nulla facilisi. Aenean at ante sapien. Nulla ac " + "lorem sit amet risus sollicitudin fringilla. Proin pulvinar congue augue non feugiat. In a arcu in "
			+ "libero maximus varius sit amet ac est. Duis vel commodo metus, vehicula gravida orci. Vestibulum " + "posuere nibh vel vehicula consequat. Vestibulum consequat odio nec mauris scelerisque porttitor. Orci "
			+ "varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec id purus sed " + "risus venenatis porttitor quis ultrices eros. Praesent malesuada quis ipsum sit amet tempor. Nulla "
			+ "interdum ac dolor eu euismod. Fusce venenatis sodales ipsum ut efficitur. Fusce maximus malesuada " + "turpis, nec mattis nisl sagittis sit amet. Ut malesuada dictum diam, in venenatis nulla consectetur "
			+ "id. Sed interdum tortor risus, a vestibulum mauris luctus a. Aenean tempor finibus ligula, eget " + "volutpat massa egestas eget. In molestie lobortis scelerisque. In lectus orci, hendrerit eleifend "
			+ "sodales sed, lobortis quis quam. Fusce ullamcorper enim vitae nunc commodo, sit amet pretium lectus " + "facilisis. Nulla aliquam dapibus commodo. Sed nec tincidunt purus. Morbi nisl risus, fringilla eget "
			+ "turpis sit amet, imperdiet fringilla velit. In dictum vitae neque eu vulputate. Quisque pharetra " + "pretium consectetur. Vestibulum finibus ut elit ut consectetur. Morbi at ante nec felis viverra "
			+ "elementum. Curabitur ullamcorper malesuada sem id tristique. Phasellus placerat sapien eu ornare " + "vehicula. In tempus ac metus et euismod. Integer eleifend imperdiet turpis, nec cursus justo lobortis "
			+ "eu. Praesent vel facilisis nisl. Curabitur posuere, tellus ut lobortis consectetur, metus felis " + "efficitur nulla, in mollis urna erat in nulla. Nullam efficitur semper tortor, nec interdum neque "
			+ "ornare vehicula. Fusce quis imperdiet mi, eget ultrices neque. Vivamus placerat nec neque non " + "accumsan. Fusce et dolor vitae magna accumsan congue ac ut erat.";
	@Override
	protected void initView() {
		exampleHeaderContentFooter();
		exampleSizeThemes();
		exampleModelessDraggableResizable();
	}

	private void exampleHeaderContentFooter() {
		// begin-source-example
		// source-example-heading: Header Content Footer
		EnhancedDialog dialog = new EnhancedDialog();
		dialog.setHeader("Example Header");
		dialog.setContent(new Paragraph(LONG_TEXT));
		dialog.setFooter(new Button("Cancel", evt -> dialog.close()));
		Button openDialogButton = new Button("Open Dialog", evt -> dialog.open());
		// end-source-example
		addCard("Header Content Footer", openDialogButton);
	}

	private void exampleSizeThemes() {
		// begin-source-example
		// source-example-heading: Size Themes
		EnhancedDialog dialog = new EnhancedDialog();
		dialog.setHeader("Size Themes");
		dialog.setContent(new Span("Content"));
		dialog.setFooter(new Button("Cancel", evt -> dialog.close()));
		Button small = new Button("small", evt -> {
			dialog.setThemeVariants(EnhancedDialogVariant.SIZE_SMALL);
			dialog.open();
		});
		Button medium = new Button("medium", evt -> {
			dialog.setThemeVariants(EnhancedDialogVariant.SIZE_MEDIUM);
			dialog.open();
		});
		Button large = new Button("large", evt -> {
			dialog.setThemeVariants(EnhancedDialogVariant.SIZE_LARGE);
			dialog.open();
		});
		// end-source-example
		addCard("Size Themes", new HorizontalLayout(small, medium, large));
	}

	private void exampleModelessDraggableResizable() {
		// begin-source-example
		// source-example-heading: Modeless Draggable Resizable
		EnhancedDialog dialog = new EnhancedDialog();
		dialog.setModal(false);
		dialog.setDraggable(true);
		dialog.setResizable(true);
		dialog.setHeader(new H3("Modeless Draggable Resizable Dialog"));
		dialog.setContent(new Span("Drag me around and resize me!"));
		dialog.setFooter(new Button("Cancel", evt -> dialog.close()));
		Button openDialogButton = new Button("Open Dialog", evt -> dialog.open());
		// end-source-example
		addCard("Modeless Draggable Resizable", openDialogButton);
	}

}
