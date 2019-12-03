/*
 * AuthenticatedConsumerRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.messageThreads;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messageThreads.MessageThread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageThreadsRepository extends AbstractRepository {

	@Query("select a from MessageThread a where a.id = ?1")
	MessageThread findOneMessageById(int id);

	@Query("select a from MessageThread a")
	Collection<MessageThread> findManyAll();

	@Query("select a from MessageThread a where messages in (SELECT b from message b where b.authenticated = ?1")
	Collection<MessageThread> findManyByMessageUserId(int messageId);

}
