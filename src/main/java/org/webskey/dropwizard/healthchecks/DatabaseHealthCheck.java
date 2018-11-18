package org.webskey.dropwizard.healthchecks;

import com.codahale.metrics.health.HealthCheck;

import io.dropwizard.db.DataSourceFactory;

public class DatabaseHealthCheck extends HealthCheck {

	private DataSourceFactory database;

	public DatabaseHealthCheck (DataSourceFactory database) {
		this.database = database;
	}

	@Override
	protected Result check() throws Exception {		
		if(database.getCheckConnectionOnConnect())
			return Result.healthy();		
		return Result.unhealthy("DB unhealthy");
	}
}
