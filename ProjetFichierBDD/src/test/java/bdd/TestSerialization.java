package bdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Jason Mahdjoub
 * @version 1.0
 */
public class TestSerialization {

	@Test
	public void testNull() throws IOException, ClassNotFoundException {
		try
		{
			SerializationTools.serialize(null);
			Assert.fail("NullPointerException should be generated");
		}
		catch (NullPointerException ignored)
		{

		}
		try
		{
			SerializationTools.deserialize(null);
			Assert.fail("NullPointerException should be generated");
		}
		catch (NullPointerException ignored)
		{

		}
		try
		{
			SerializationTools.serializeFreeSpaceIntervals(null);
			Assert.fail("NullPointerException should be generated");
		}
		catch (NullPointerException ignored)
		{

		}

		try
		{
			SerializationTools.deserializeFreeSpaceIntervals(null);
			Assert.fail("NullPointerException should be generated");
		}
		catch (NullPointerException ignored)
		{

		}
	}

	@Test
	public void testSerializable() throws IOException, ClassNotFoundException {
		ArrayList<Integer> list=new ArrayList<>();
		for (int i=0;i<10;i++)
			list.add((int)(Math.random()*1000));
		byte[] data=SerializationTools.serialize(list);
		@SuppressWarnings("unchecked")
		ArrayList<Integer> list2=(ArrayList<Integer>)SerializationTools.deserialize(data);
		Assert.assertEquals(list2, list,"The serialization/deserialization does not work");
	}

	@Test
	public void testFreeSpaceInterval() throws IOException {
		TreeSet<BDD.FreeSpaceInterval> freeSpaceIntervals=new TreeSet<>();
		for (int i=0;i<10;i++)
			freeSpaceIntervals.add(new BDD.FreeSpaceInterval((int)(i*Math.random()*1000), (int)(Math.random()*10+10)));
		byte[] data=SerializationTools.serializeFreeSpaceIntervals(freeSpaceIntervals);
		Assert.assertEquals(data.length, 16*freeSpaceIntervals.size());
	}


/*
Test supplémentaire pour vérifier la serialisation et deserialisation des free spaces
	@Test
	public void testSerializableFreeSpace() throws IOException, ClassNotFoundException {
		TreeSet<BDD.FreeSpaceInterval> list=new TreeSet<BDD.FreeSpaceInterval>();
		for (int i=0;i<10;i++)
			list.add(new BDD.FreeSpaceInterval((long) ((long)i+Math.random()*100),(long)Math.random()*10));
		byte[] data=SerializationTools.serializeFreeSpaceIntervals(list);
		@SuppressWarnings("unchecked")
		TreeSet<BDD.FreeSpaceInterval> list2=(TreeSet<BDD.FreeSpaceInterval>)SerializationTools.deserializeFreeSpaceIntervals(data);
		Assert.assertEquals(list2, list,"The serialization/deserialization with freeSpaces does not work");
	}*/

}
