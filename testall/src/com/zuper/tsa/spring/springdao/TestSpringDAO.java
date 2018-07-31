package com.zuper.tsa.spring.springdao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class TestSpringDAO {
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	private NamedParameterJdbcTemplate nJdbcTemplate = null;
	{
		ctx = new ClassPathXmlApplicationContext("config/spring/dataSource.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		nJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("nJdbcTemplate");
	}
	
	/***************NamedParameterJdbcTemplate*********************/
	@Test
	public void testNamedParameterJdbcTemplate(){
		//使用Map
		String sql = "update student a set a.remark=:remark where a.id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("remark", "testNamePJdbcTemplate");
		paramMap.put("id", 1);
		nJdbcTemplate.update(sql, paramMap);
		
		//使用bean
		String sql1 = "insert into student(name, gender, age) values(:name, :gender, :age)";
		Student stu = new Student("chenrd", "1", 25);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(stu);
		nJdbcTemplate.update(sql1, paramSource);
	}
	
	/***************JdbcTemplate*********************/
	@Test
	public void testGetRss() {
		String sql = "select a.name, a.age from student a where a.id>?";
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql, 1);
		for(Map<?, ?> map:mapList){
			System.out.println("name: " + map.get("name"));
			System.out.println("age: " + map.get("age"));
		}
		
		SqlRowSet rss = jdbcTemplate.queryForRowSet(sql, 1);
		while(rss.next()){
			System.out.println("name: " + rss.getString("name"));
			System.out.println("age: " + rss.getInt("age"));
		}
	}

	@Test
	public void testGetOneAttr() {
		String sql = "select a.name from student a where a.id=?";
		String name = jdbcTemplate.queryForObject(sql, String.class, 1);
		System.out.println(name);
		
		String sql2 = "select count(1) from student a where a.id>?";
		int count = jdbcTemplate.queryForObject(sql2, Integer.class, 1);
		System.out.println(count);
		
		String sql3 = "select a.name from student a where a.id>?";
		List<String> names = jdbcTemplate.queryForList(sql3, String.class, 1);
		System.out.println(names); //<< [zhaozq, hux, luy, qiuzw, guoxt]
	}

	@Test
	public void testGetObjs() {
		String sql = "select a.id, id, a.name name, a.age age from student a where a.id>?";

		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(
				Student.class);
		List<Student> stus = jdbcTemplate.query(sql, rowMapper, 1);
		System.out.println(stus.size());
	}

	@Test
	public void testGetOneObj() {
		String sql = "select a.id, id, a.name name, a.age age from student a where a.id=?";

		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(
				Student.class);
		Student stu = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(stu);
	}

	@Test
	public void testBatchIns() {
		String sql = "insert into student(name, gender, age, remark ) values(?, ?, ?, ?)";

		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[] { "luy", "1", 25, "000" });
		batchArgs.add(new Object[] { "qiuzw", "1", 25, "000" });
		batchArgs.add(new Object[] { "guoxt", "1", 25, "000" });

		jdbcTemplate.batchUpdate(sql, batchArgs);
	}

	@Test
	public void testUpdOne2() {
		String sql = "update student a set a.remark=? where a.id=?";
		int rsc = jdbcTemplate.update(sql, new Object[] { "testUpdOne2", 3 });
		System.out.println(rsc);
	}

	@Test
	public void testUpdOne() {
		String sql = "update student a set a.remark=? where a.id=?";
		int rsc = jdbcTemplate.update(sql, "testUpdOne", 3);
		System.out.println(rsc);
	}

	@Test
	public void testDataSource() {
		System.out.println(jdbcTemplate.getDataSource());
	}

}
