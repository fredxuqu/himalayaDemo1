package org.apache.commons.dbcp;
/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年12月23日 上午11:53:24
* Description
*/
public class EncryptBasicDataSource extends BasicDataSource {

    /** 
     * <p>Sets the {@link #password}.</p>
     * <p>
     * Note: this method currently has no effect once the pool has been
     * initialized.  The pool is initialized the first time one of the
     * following methods is invoked: <code>getConnection, setLogwriter,
     * setLoginTimeout, getLoginTimeout, getLogWriter.</code></p>
     * 
     * @param password new value for the password
     */
    public void setPassword(String password) {
    	
    	System.out.println("========================Set Password=========================");
        this.password = password;
        System.out.println("========================Set Password=========================");
    }
}
