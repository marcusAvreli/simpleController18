package simpleController18.swing.swing.binding.core;

/**
 * Abstract implementation of the SelectionBinding interface.
 * 
 * @author Mario Garcia
 *
 * @param <SS> Source
 * @param <TS> Target
 */
//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/swing/src/main/java/org/viewaframework/swing/binding/core/AbstractSelectionBinding.java#L12
public abstract class AbstractSelectionBinding<SS,SP,TS,TP> implements SelectionBinding<SS, SP, TS, TP>{

	private BeanAdapter<SS> source;
	private AbstractBindingListener<TS, TP, SP> sourceListener;
	private Property<SP> sourceProperty;
	private BeanAdapter<TS> target;
	private AbstractBindingListener<SS, SP, TP> targetListener;
	private Property<TP> targetProperty;
	
	/**
	 * Here is a BeanAdapter as a source but implementations should hide this from the user and allow them
	 * to introduce any kind of JavaBean, the constructors will do something like new BasicBeanAdapter<SS>(source).
	 * 
	 * @param source Source.
	 * @param sourceProperty Source property
	 * @param target Target
	 * @param targetProperty Target property
	 */
	public AbstractSelectionBinding(BeanAdapter<SS> source,Property<SP> sourceProperty,BeanAdapter<TS> target,Property<TP> targetProperty){
		this.source = source;
		this.sourceProperty = sourceProperty;
		this.target = target;
		this.targetProperty = targetProperty;
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.binding.core.Binding#getSource()
	 */
	public BeanAdapter<SS> getSource() {
		return source;
	}

	/**
	 * @return
	 */
	public AbstractBindingListener<TS, TP, SP> getSourceListener() {
		return sourceListener;
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.binding.core.Binding#getSourceProperty()
	 */
	public Property<SP> getSourceProperty() {
		return sourceProperty;
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.binding.core.Binding#getTarget()
	 */
	public BeanAdapter<TS> getTarget() {
		return target;
	}

	/**
	 * @return
	 */
	public AbstractBindingListener<SS, SP, TP> getTargetListener() {
		return targetListener;
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.binding.core.Binding#getTargetProperty()
	 */
	public Property<TP> getTargetProperty() {
		return targetProperty;
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.binding.core.Binding#setSource(org.viewaframework.binding.core.BeanAdapter)
	 */
	public void setSource(BeanAdapter<SS> source) {
		this.source = source;
	}

	/**
	 * @param sourceListener
	 */
	public void setSourceListener(AbstractBindingListener<TS, TP, SP> sourceListener) {
		this.sourceListener = sourceListener;
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.binding.core.Binding#setSourceProperty(org.viewaframework.binding.core.Property)
	 */
	public void setSourceProperty(Property<SP> sourceProperty) {
		this.sourceProperty = sourceProperty;
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.binding.core.Binding#setTarget(org.viewaframework.binding.core.BeanAdapter)
	 */
	public void setTarget(BeanAdapter<TS> target) {
		this.target = target;
	}

	/**
	 * @param targetListener
	 */
	public void setTargetListener(AbstractBindingListener<SS, SP, TP> targetListener) {
		this.targetListener = targetListener;
	}
	
	/* (non-Javadoc)
	 * @see org.viewaframework.binding.core.Binding#setTargetProperty(org.viewaframework.binding.core.Property)
	 */
	public void setTargetProperty(Property<TP> targetProperty) {
		this.targetProperty = targetProperty;
	}
}