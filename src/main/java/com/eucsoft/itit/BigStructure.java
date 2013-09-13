package com.eucsoft.itit;
import java.util.Iterator;


public class BigStructure<T> implements Iterator<T>{

	private Iterable<Iterator<T>> struct;
	private Iterator<T> currentIt =null;
	private Iterator<Iterator<T>> structIt =null;
	
	public void setStruct(Iterable<Iterator<T>> struct){
		this.struct = struct;
		structIt = struct.iterator();
	}
	
	@Override
	public boolean hasNext() {
		 if(currentIt!=null && currentIt.hasNext())
			 return true;
		 while(structIt.hasNext())
	        {
	            currentIt=structIt.next();
	            if(currentIt.hasNext())
	                return true;
	        }
		 
		return false;
	}

	@Override
	public T next() {
		if(currentIt!=null && currentIt.hasNext())
            return currentIt.next();
         
        while(structIt.hasNext())
        {
            currentIt=structIt.next();
            if(currentIt.hasNext())
                return currentIt.next();
        }
        return null;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Not Implemented!!!");
		
	}
	
	
	
	
	
	

}
