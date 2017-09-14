package com.zen.autumn.learn.base.collection;

import java.util.WeakHashMap;

public class CanonicalMapping{
	
	public static void main(String[] args) {
		int size = 1000;
		
		Key[] keys = new Key[size];
		
		WeakHashMap<Key, Value> map = new WeakHashMap<Key,Value>();
		
		for(int i=0;i<size;i++){
			map.put(new Key(String.valueOf(i)),new Value(String.valueOf(i)));
		}
		
		System.gc();
	}
	
}


class Key extends Element{

	public Key(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
}

class Value extends Element{

	public Value(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
}

 class Element {
	
	private String id;
	
	public Element(String id){
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Element [id=" + id + "]";
	}
	
	@Override
	protected void finalize(){
		System.out.println(getClass().getSimpleName()+id);
		
	}
	
	
	
	

}
