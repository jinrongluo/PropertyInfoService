package com.huawei.servicestage.sample.springcloud.propertyinfo.dao;

import org.springframework.data.repository.CrudRepository;
import com.huawei.servicestage.sample.springcloud.propertyinfo.model.Property;

public interface PropertyDao extends CrudRepository<Property, String> {

}
