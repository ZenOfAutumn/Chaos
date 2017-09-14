package com.zen.autumn.learn.base.io.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class Worm implements Serializable {
	
	private static final int HELLO =3; 
	
	private Random rand = new Random(47);

	private Data[] d = { new Data(rand.nextInt(10)), new Data(rand.nextInt(10)), new Data(rand.nextInt(10)) };

	private Worm next;

	private char c;

	public Worm(int i, char c) {
		this.c = c;
		if (--i > 0) {
			this.next = new Worm(i, (char) (c + 1));
		}
	}

	public Worm() {
		System.out.println("Default");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(":");
		builder.append(c);
		builder.append("(");
		for (Data dat : d) {
			builder.append(dat);
		}
		builder.append(")");
		if (next != null) {
			builder.append(next);
		}
		
		builder.append(HELLO);
		
		return builder.toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Worm w = new Worm(6,'a');
		System.out.println("w"+w);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
		out.writeObject("worm \n");
		out.writeObject(w);
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
		String s= (String)in.readObject();
		Worm w2 = (Worm)in.readObject();
		
		System.out.println(s);
		System.out.println(w2);

		ByteArrayOutputStream byteout =new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(byteout);
		out2.writeObject("worm \n");
		out2.writeObject(w);
		out2.flush();
		
		ObjectInputStream input2=  new ObjectInputStream(new ByteArrayInputStream(byteout.toByteArray()));
		String ss= (String)input2.readObject();
		Worm w22 = (Worm)input2.readObject();
		
		System.out.println(ss);
		System.out.println(w22);
		
	}
	
}
