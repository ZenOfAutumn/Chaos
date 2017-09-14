package com.zen.autumn.learn.designPattern.decorator.structure;

public class Decorator implements Component {

	protected Component component;

	public void setComponent(Component component) {
		this.component = component;
	}

	@Override
	public void operation() {

		if (component != null) {
			component.operation();
		}
	}

}
