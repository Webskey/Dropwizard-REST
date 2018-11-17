package org.webskey.dropwizard.dao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

public interface TestDao {
	@SqlQuery("select name from test where id = :id")
	String findById(@Bind("id") int id);
}
