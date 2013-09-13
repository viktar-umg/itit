package com.eucsoft.itit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;

import org.testng.annotations.Test;


public class BigStructureTest {
	
	@Test
	public void hasNextEmptyTest() {
		BigStructure<String> bs = new BigStructure<>();
		bs.setStruct(new ArrayList<Iterator<String>>());
		assertFalse(bs.hasNext());
	}

	@Test
	public void hasNextNotEmptyTest() {
		BigStructure<String> bs = new BigStructure<>();
		List<Iterator<String>> struct = new ArrayList<Iterator<String>>();
		List<String> child = new ArrayList<>();
		child.add("Test");
		struct.add(child.iterator());
		bs.setStruct(struct);
		assertTrue(bs.hasNext());
	}
	
	@Test
	public void combined4ItemsTest() {
		BigStructure<String> bs = new BigStructure<>();
		List<Iterator<String>> struct = new ArrayList<Iterator<String>>();
		List<String> child = new ArrayList<>();
		child.add("Test");
		struct.add(child.iterator());
		
		child = new ArrayList<>();
		child.add("Test");
		child.add("Test");
		struct.add(child.iterator());
		
		child = new ArrayList<>();
		child.add("Test");
		struct.add(child.iterator());
		
		bs.setStruct(struct);
		
		int count = 0;
		while(bs.hasNext()){
			count++;
			bs.next();
		}
		assertEquals(count, 4);
	}
	
	
	@Test
	public void combinedEmptyInMiddleTest() {
		BigStructure<String> bs = new BigStructure<>();
		List<Iterator<String>> struct = new ArrayList<Iterator<String>>();
		List<String> child = new ArrayList<>();
		child.add("Test");
		struct.add(child.iterator());
		struct.add(new ArrayList<String>().iterator());
		child = new ArrayList<>();
		child.add("Test");
		struct.add(child.iterator());
		
		bs.setStruct(struct);
		
		int count = 0;
		while(bs.hasNext()){
			count++;
			bs.next();
		}
		assertEquals(count, 2);
	}
}
