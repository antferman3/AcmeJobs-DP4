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

package acme.features.auditor.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select a from Job a where a.id = ?1")
	Job findOneById(int id);

	@Query("select a from Job a join a.auditRecord r where r.auditor.id= ?1")
	Collection<Job> findManyJob(int id);

	@Query("select a from Job a join a.auditRecord r where not r.auditor.id= ?1")
	Collection<Job> findNotMyJob(int id);

	/*
	 * @Query("select a from Job a where a.auditRecord.auditor.id=?1")
	 * Collection<Job> findManyJobByAuditorId(int auditorId);
	 */

}
