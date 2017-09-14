package com.zen.autumn.learn.base.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ReversibleArrayList<E> extends ArrayList<E> {
	
	public ReversibleArrayList(Collection<E> c){
		super(c);
	}
	
	
	public Iterable<E> reversed(){
		return new Iterable<E>() {

			@Override
			public Iterator<E> iterator() {
				return new Iterator<E>() {
					
					int current = size()-1;

					@Override
					public boolean hasNext() {
						return  current>-1;
					}

					@Override
					public E next() {
						return get(current--);
					}			
					
				};
			}
		};
	}

}
