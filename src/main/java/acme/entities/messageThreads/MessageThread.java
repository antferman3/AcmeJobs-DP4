
package acme.entities.messageThreads;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MessageThread extends DomainEntity {

	private static final long	serialVersionUID	= 1L;
	@NotBlank
	private String				title;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;
	@NotBlank
	private String				users;

	@OneToMany
	@NotNull
	@Valid
	private List<Message>		messages;
}
