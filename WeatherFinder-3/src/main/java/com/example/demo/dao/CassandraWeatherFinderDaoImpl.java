package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.example.demo.domain.CassandraDaoUtil;
import com.example.demo.domain.User;

@Repository
public class CassandraWeatherFinderDaoImpl implements CassandraWeatherFinderDao {
	CassandraDaoUtil cdaoutil = new CassandraDaoUtil();
	private PreparedStatement statement;

	String node = "localhost";
	int port = 9042;

	@Override
	public void insertUser(User user) {
		System.out.println("CassandraWeatherFinderDaoImpl -insertUser()");

		System.out.println("connecting............");
		cdaoutil.connect(node, port);
		System.out.println("connected");

		Session session = cdaoutil.getSession();

		System.out.println(user.getUserid());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getOrderNouuid());
		System.out.println("got session and executing query");

		String cql = "insert into connectkeyspace.Usertable(userid,insertionDate,orderNouuid,password,username)values(?,?,?,?,?);";

		statement = session.prepare(cql);
		System.out.println("calling execute method");
		session.execute(statement.bind(user.getUserid(), user.getInsertionDate(), user.getOrderNouuid(),
				user.getPassword(), user.getUsername()));

		System.out.println("record inserted successfully");

	}

	@Override
	public List<User> listAllUsers() {

		System.out.println("CassandraWeatherFinderDaoImpl -insertUser()");

		System.out.println("connecting...listAllUsers().........");
		cdaoutil.connect(node, port);
		System.out.println("connected");

		Session session = cdaoutil.getSession();

		System.out.println("got session and executing query");

		System.out.println("calling execute method");
		ResultSet result = session.execute("select * from connectkeyspace.Usertable;");

		List<Row> results = result.all();

		System.out.println(results);

		User user = null;

		List<User> users = new ArrayList<User>();
		for (Row row : results) {
			user = new User();
			user.setUserid(row.getInt("userid"));
			user.setOrderNouuid(row.getUUID("orderNouuid"));
			user.setPassword(row.getString("password"));
			user.setUsername(row.getString("username"));
			users.add(user);

		}

		Iterator<User> it = users.iterator();
		while (it.hasNext()) {

			System.out.println("list values ::**********" + it.next());

		}

		return users;
	}

	@Override
	public User getDataByUserId(User userid) {

		System.out.println("PASSED USERID >>>>>>>>" + userid.getUserid());

		System.out.println("CassandraWeatherFinderDaoImpl -getDataByUserId()");

		System.out.println("connecting...getDataByUserId().........");
		cdaoutil.connect(node, port);
		System.out.println("connected");

		Session session = cdaoutil.getSession();

		System.out.println("got session and executing udapte query");

		System.out.println("calling execute method");
		// ResultSet rs = session.execute("select * from connectkeyspace.Usertable where
		// userid=?;");
		// Row result = rs.one();

		statement = session.prepare("select username, password from  connectkeyspace.Usertable where userid=?;");
		System.out.println("calling execute method");
		ResultSet rs = session.execute(statement.bind(userid.getUserid()));
		Row result = rs.one();

		System.out.println("record received successfully" + result);

		return userid;

	}

}
