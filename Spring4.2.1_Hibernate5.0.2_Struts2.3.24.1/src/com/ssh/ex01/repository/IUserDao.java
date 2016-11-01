package com.ssh.ex01.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ssh.ex01.entity.User;

@Repository//("userDao2")
public interface IUserDao extends PagingAndSortingRepository<User,Long> 
{
	
	//PagingAndSortingRepository继承CrudRepository接口 提供的方法(自动生成)
//	T save(T obj);
//	Iterable<T> list save(Iterable<T> list);
//	
//	void delete(T obj);
//	void delete(Long id);
//	void delete(Iterable<T> list);
//	void deleteAll();
//	
//	Iterable<T> list findAll();
//	T findOne(Long id);
//	
//	int count(); //查询出当前对象表一共多少条记录
//	boolean exists(Long id);
	
//  PagingAndSortingRepository扩展了CrudRepository接口的方法:
	
//	Iterable<T> list findAll(Iterable<Long> list);
//	Page<T> 		 findAll(Pageable pageable);	//分页条件对象Pageable,第几条开始,每页一共多少条,一共多少条记录,一共几页,第几页,结果集...
//	Iterable<T> list findAll(Sort sort);			//分页排序对象Sort 按照那个字段排序,升降序
	
	//自己扩展其他操作:
}
