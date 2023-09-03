package online.salon.booking.system.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseDTO implements DropDownListDTO,Comparable<BaseDTO>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected long id;
	
	
	
	@Override
	public int compareTo(BaseDTO o) {
		
		return getValue().compareTo(o.getKey());
	}

}
