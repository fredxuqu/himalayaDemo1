package com.himalaya.collection;

import java.util.AbstractCollection;
import java.util.Iterator;

import com.himalaya.collection.entity.UserEntity;

public class MyCollection extends AbstractCollection<UserEntity>{

	private UserEntity[] users = null;
	
	MyCollection(){
		users = new UserEntity[10];
		users[0] = new UserEntity("1","fred",30);
		users[1] = new UserEntity("2","fred",30);
		users[2] = new UserEntity("3","fred",30);
	}
	@Override
	public Iterator<UserEntity> iterator() {
		return new Iterator<UserEntity>(){
			private int index = 0;
			public boolean hasNext() {
				
				return index < users.length && users[index]!=null;
			}

			public UserEntity next() {
				return users[index++];
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public int size() {
		return users.length;
	}

	public static void main(String[] args) {
		MyCollection users = new MyCollection();
		System.out.println(users.size());
		Iterator it = users.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
