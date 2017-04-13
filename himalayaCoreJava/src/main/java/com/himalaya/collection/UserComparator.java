package com.himalaya.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.himalaya.collection.entity.UserEntity;

public class UserComparator implements Comparator<UserEntity> {

	/**
	 * when arg0 > arg1 equals a positive value then sorting result is asc.
	 * when arg0 < arg1 equals a negative value then sorting result is desc.
	 */
	public int compare(UserEntity arg0, UserEntity arg1) {

		if (arg0.getAge() == arg1.getAge()) {
			return 0;
		}else if(arg0.getAge() > arg1.getAge()) {
			return 1;
		}else {
			return -1;
		} 
	}
	
	public static void main(String[] args) {
		
		String a = "a";
		String b = "b";
		System.out.println(a.compareTo(b));
		
		List<UserEntity> users = new ArrayList<UserEntity>();
		users.add(new UserEntity("11","aa",19));
		users.add(new UserEntity("12","aa",12));
		users.add(new UserEntity("13","aa",1));
		users.add(new UserEntity("14","aa",15));
		Collections.sort(users,new UserComparator());
		for (UserEntity userEntity : users) {
			System.out.println(userEntity);
		}
		
		Collections.sort(users,new Comparator<UserEntity>(){

			public int compare(UserEntity arg0, UserEntity arg1) {
				if (arg0.getAge() == arg1.getAge()) {
					return 0;
				}else if(arg0.getAge() > arg1.getAge()) {
					return 1;
				}else {
					return -1;
				}
			}			
		});
		for (UserEntity userEntity : users) {
			System.out.println(userEntity);
		}
	}
}


