
package acme.entities.messageThreads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.framework.entities.Authenticated;
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

	@OneToMany(fetch = FetchType.EAGER)
	@NotNull
	@Valid
	private Collection<Message>	messages;


	@Transient
	private List<Authenticated> getUser() {

		List<Message> res = new ArrayList<>();

		res.addAll(this.messages);

		return res.stream().map(x -> x.getAuthenticated()).collect(Collectors.toList());

	}
}
