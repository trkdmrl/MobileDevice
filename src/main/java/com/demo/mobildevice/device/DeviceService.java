package com.demo.mobildevice.device;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DeviceService {

	DeviceRepository deviceRepository;

	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}
	
	public Device save(Device device) {
		Device temp = saveControl(device);
		if(temp != null) {
		    return deviceRepository.save(device);
		}
		return null;
	}

	public Device saveControl(Device device) {
		List<Device> devices = deviceRepository.findAll();
		for(Device dev : devices) {
			if(dev.getBrand().equals(device.getBrand()) && dev.getModel().equals(device.getModel()) 
					&& dev.getOsVersion().equals(device.getOsVersion())) {
				return null;
			}
		}
		return device;
			
	}
	
	public Iterable<Device> save(List<Device> devices) {
		return deviceRepository.saveAll(devices);
	}
	
	
}
