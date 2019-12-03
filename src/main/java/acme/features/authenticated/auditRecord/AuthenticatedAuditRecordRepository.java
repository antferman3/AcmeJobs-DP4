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

package acme.features.authenticated.auditRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuditRecordRepository extends AbstractRepository {

	@Query("select a from AuditRecord a where a.id = ?1")
	AuditRecord findOneAuditById(int id);

	@Query("select a from AuditRecord a where a.auditor.id = ?1")
	Collection<AuditRecord> findManyByAuditorId(int auditorId);

	@Query("select a from AuditRecord a")
	Collection<AuditRecord> findManyAll();

	@Query("select a from AuditRecord a where a.AuditRecord.id = ?1 and a.finalMode = true")
	Collection<AuditRecord> findManyAuditsReferedToAuditRecord(int AuditRecordId);

}
