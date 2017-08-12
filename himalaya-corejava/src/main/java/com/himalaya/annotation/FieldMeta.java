package com.himalaya.annotation;
/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年9月14日 上午9:29:17
* Description
*/
public @interface FieldMeta {

	/**
	 * meta annotation 
	 * @Retention 
	 * @Target 
	 * @Document 
	 * @Inherited
	 */
	// field name
	String name() default ""; 
	
	// field description
	String desc() default ""; 
	
	// field order sequence
	int order() default 0;
}
