package com.gnomesys.aerospike.service;

import java.util.Calendar;
import java.util.UUID;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import com.gnomesys.aerospike.domain.User;

/**
 * Just a simple UserService which persist User information in Aerospike, update
 * existing records and query the existing data.
 */
public class UserService {

	// Here are some hardcoded values, please modify to have better code quality
	private final static String AERO_HOST = "127.0.0.1";
	private final static int AERO_PORT = 3000;
	private final static String NAMESPACE = "test";
	private final static String SET_NAME = "users";

	private AerospikeClient aerospikeClient = null;

	public UserService() {
		// We will initialize aerospikeClient here but some basic settings
		ClientPolicy clientPolicy = new ClientPolicy();
		clientPolicy.timeout = 500;
		this.aerospikeClient = new AerospikeClient(clientPolicy, AERO_HOST, AERO_PORT);
	}

	public void save(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);

		Key userKey = new Key(NAMESPACE, SET_NAME, userId);
		Bin binUserId = new Bin("user_id", userId);
		Bin binEmail = new Bin("email", user.getEmail());
		Bin binName = new Bin("name", user.getName());
		Bin binHeroes = new Bin("heroes", user.getPreferredHeroes());

		long time = Calendar.getInstance().getTimeInMillis();

		Bin binCreatedDate = new Bin("created_date", time);
		Bin binUpdatedDate = new Bin("updated_date", time);

		WritePolicy writePolicy = new WritePolicy();
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;

		this.aerospikeClient.put(writePolicy, userKey, binUserId, binEmail, binName, binHeroes, binCreatedDate,
				binUpdatedDate);
	}
}
