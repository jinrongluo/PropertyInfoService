package com.huawei.servicestage.sample.springcloud.propertyinfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.servicestage.sample.springcloud.propertyinfo.dao.PropertyDao;
import com.huawei.servicestage.sample.springcloud.propertyinfo.model.Property;

@RestController
public class PropertyService {

	@Autowired
	private PropertyDao propertyDao;
	
    @RequestMapping(value="/properties", produces = { "application/json" }, 
            method = RequestMethod.GET)
    public Iterable<Property> getAllProperty() {
        return propertyDao.findAll();
    }
    
    @RequestMapping(value="/properties/{id}", produces = { "application/json" }, 
            method = RequestMethod.GET)
    public Property getPropertyById(@PathVariable("id") String id) {
    	Optional<Property> prop = propertyDao.findById(id);
    	if(prop.isPresent()) {
    		return prop.get();
    	}else {
    		return null;
    	}
    }
    
    @RequestMapping(value="/properties", produces = { "application/json" },
    		method = RequestMethod.POST)
    public Property newProperty(@RequestBody Property aProperty) {
    	return propertyDao.save(aProperty);
    }
    
    @RequestMapping(value="/properties/{id}", produces = { "application/json" },
    		method = RequestMethod.PUT)
    public Property updateProperty(@RequestBody Property aProperty, @PathVariable("id") String id) {
    	return propertyDao.findById(id).map(property ->{
    		property.setArea(aProperty.getArea());
    		property.setBuildingType(aProperty.getBuildingType());
    		property.setFeatures(aProperty.getFeatures());
    		property.setMgtFee(aProperty.getMgtFee());
    		property.setYear(aProperty.getYear());
    		
    		return propertyDao.save(property);
    	}).orElse(null);
    }
    
    @RequestMapping(value="/properties/{id}", method = RequestMethod.DELETE)
    public void deleteProperty(@PathVariable String id) {
    	 propertyDao.deleteById(id);
    }
}
