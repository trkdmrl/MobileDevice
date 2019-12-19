package com.demo.mobildevice.device;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Device {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message = "{mobildevice.constraints.brand.NotEmpty.message}")
	private String brand;
	
	@NotEmpty(message = "{mobildevice.constraints.model.NotEmpty.message}")
	private String model;

	@NotEmpty(message = "{mobildevice.constraints.os.NotEmpty.message}")
	@OsOption(message = "{mobildevice.constraints.os.OsOption.message}")
	private String os;
	
	@NotEmpty(message = "{mobildevice.constraints.osVersion.NotEmpty.message}")
	private String osVersion;
}
