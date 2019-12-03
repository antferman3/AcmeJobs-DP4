
package acme.entities.jobs;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.roles.Employer;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Job extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Column(unique = true)
	@NotBlank
	@Length(min = 5, max = 10)
	@Pattern(regexp = "[A-Z0-9]{4}-[A-Z0-9]{4}$")
	private String				reference;

	private JobStatus			status;
	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotNull
	@Valid
	private Money				salary;

	@NotBlank
	private String				description;

	@URL
	private String				moreInfo;

	private boolean				finalMode;

	//Relationships

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Employer			employer;

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Descriptor			descriptor;

	@NotNull
	@Valid
	@OneToMany
	@JoinColumn(name = "JobId")
	private List<AuditRecord>	auditRecord;
}
