package simpleController18.swing.swing.binding;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

import simpleController18.swing.swing.binding.core.BeanAdapter;
import simpleController18.swing.swing.binding.core.BeanAdapterBinding;
import simpleController18.swing.swing.binding.core.Binding;
import simpleController18.swing.swing.binding.core.Property;


/**
 * @author Mario Garcia
 * 
 * This class acts as a binding group. The user can chain as many bindings as he want before binding them all
 * at once.
 * 
 * This way a chain of bindings can be created this way:
 * 
 *
 */
public class SwingBinding implements Binding<Object>{
	
	private List<Binding<?>> bindingList = new ArrayList<Binding<?>>();
	
	/* (non-Javadoc)
	 * @see org.viewaframework.binding.core.Binding#bind()
	 */
	public void bind() {
		for (Binding<?> binding : this.bindingList){
			binding.bind();
		}
	}
	
	/**
	 * @param <SS>
	 * @param <SP>
	 * @param <TS>
	 * @param <TP>
	 * @param source
	 * @param sourceProperty
	 * @param target
	 * @param targetProperty
	 * @return
	 */
	public <SS,SP,TS,TP> SwingBinding createBeanAdapterBinding(BeanAdapter<SS> source,Property<SP> sourceProperty,BeanAdapter<TS> target, Property<TP> targetProperty){
		BeanAdapterBinding<SS, SP, TS, TP> binding = 
			new BeanAdapterBinding<SS, SP, TS, TP>(
					source, sourceProperty, target, targetProperty);
		this.bindingList.add(binding);
		return this;
	}
	
	/**
	 * @param <SS>
	 * @param <SP>
	 * @param <TS>
	 * @param <TP>
	 * @param source
	 * @param sourceProperty
	 * @param target
	 * @param targetProperty
	 * @return
	 */
	public <SS,SP,TS,TP> SwingBinding createBeanAdapterBinding(SS source,Property<SP> sourceProperty,TS target, Property<TP> targetProperty){
		BeanAdapterBinding<SS, SP, TS, TP> binding = 
			new BeanAdapterBinding<SS, SP, TS, TP>(
					source, sourceProperty, target, targetProperty);
		this.bindingList.add(binding);
		return this;
	}
	
	/**
	 * @param <SP>
	 * @param <TS>
	 * @param <TP>
	 * @param source
	 * @param sourceProperty
	 * @param target
	 * @param targetProperty
	 * @return
	 */
	public <SP,TS,TP> SwingBinding createButtonBinding(JButton source,Property<SP> sourceProperty,BeanAdapter<TS> target,Property<TP> targetProperty){
		ButtonBinding<JButton, SP, TS, TP> binding = 
			new ButtonBinding<JButton, SP, TS, TP>(source, sourceProperty, target, targetProperty);
		this.bindingList.add(binding);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.binding.core.Binding#unbind()
	 */
	public void unbind() {
		for (Binding<?> binding : this.bindingList){
			binding.unbind();
		}
	}
}
