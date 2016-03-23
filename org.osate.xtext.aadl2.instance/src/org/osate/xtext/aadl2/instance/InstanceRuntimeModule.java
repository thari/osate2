/*
 * generated by Xtext
 */
package org.osate.xtext.aadl2.instance;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.osate.xtext.aadl2.properties.valueconversion.PropertiesValueConverter;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class InstanceRuntimeModule extends org.osate.xtext.aadl2.instance.AbstractInstanceRuntimeModule {
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return org.osate.xtext.aadl2.naming.Aadl2QualifiedNameConverter.class;
	}
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return PropertiesValueConverter.class;
	}
}