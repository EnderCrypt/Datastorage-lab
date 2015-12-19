package se.github.datalab.model;
import javax.persistence.*;

@MappedSuperclass
public abstract class Id
{
	@javax.persistence.Id
	@GeneratedValue
	protected Long id;
	
	public Long getId()
	{
		return id;
	}
}
