# Component Factory Enhanced Dialog for Vaadin 14

[Live Demo ↗](https://incubator.app.fi/enhanced-dialog-demo/enhanced-dialog)

[&lt;enhanced-dialog&gt;](https://www.npmjs.com/package/@vaadin-component-factory/vcf-enhanced-dialog) is a Vaadin Dialog extension with header, footer and scrolling content area.

# What does the component do?

Enhanced Dialog supports all the same features as Vaadin Dialog but also brings header and footer sections.

### Vaadin Prime
This component is part of Vaadin Prime. Still, open source you need to have a valid CVAL license in order to use it. Read more at: vaadin.com/pricing

## Basic Usage
```java
EnhancedDialog dialog = new EnhancedDialog();
dialog.setHeader("Example Header");
dialog.setContent(new Span("Content"));
dialog.setFooter(new Button("Close", evt -> dialog.close()));
dialog.open();
```

# How to run the demo?

The Demo can be run by going to the project enhanced-dialog-demo and executing the maven goal:

```mvn jetty:run```

After server startup, you'll be able find the demo at [http://localhost:8080/enhanced-dialog](http://localhost:8080/enhanced-dialog)


## License & Author

This Add-on is distributed under [Commercial Vaadin Add-on License version 3](http://vaadin.com/license/cval-3) (CVALv3). For license terms, see LICENSE.txt.

Component Factory Enhanced Dialog is written by Vaadin Ltd.


## Setting up for development:

Clone the project in GitHub (or fork it if you plan on contributing)

```
git clone git@github.com:vaadin-component-factory/enhanced-dialog.git
```

to install project to your maven repository run
 
```mvn install```