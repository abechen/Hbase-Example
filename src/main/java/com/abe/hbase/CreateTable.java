package com.abe.hbase;

import org.apache.hadoop.hbase.*;

public class CreateTable 
{
    /**
     * 建立Table
     */
    public void create(String tableName, String[] cfs){
    	try {         
    		TableName tbName = TableName.valueOf(tableName);
    		if (!HbaseExample.admin.tableExists(tbName)){
    			HTableDescriptor tableDesc = new HTableDescriptor(tbName);
    			for(String column : cfs){
    				HColumnDescriptor columDesc = new HColumnDescriptor(column);
    				tableDesc.addFamily(columDesc);
    			}
    			HbaseExample.admin.createTable(tableDesc);
    			System.out.println("Create table " + tableName);
    		}else{
    			System.out.println("Table " + tableName + " exsist");
    		}
    	} catch (Exception e) {
    		System.out.println("Failed create of table");
    		e.printStackTrace();
        }
    }
}