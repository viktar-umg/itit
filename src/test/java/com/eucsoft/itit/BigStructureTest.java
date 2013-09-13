package com.eucsoft.itit;
import java.util.ArrayList;
import java.util.Iterator;

import static org.testng.Assert.*;

import org.testng.annotations.Test;


public class BigStructureTest {
	
	@Test
	public void hasNextEmptyTest() {
		BigStructure<String> bs = new BigStructure<>();
		bs.setStruct(new ArrayList<Iterator<String>>());
		assertFalse(bs.hasNext());
		
		
	}

}
